package es.upcnet.egos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Comentari;
import es.upcnet.egos.domain.Estat;
import es.upcnet.egos.domain.Metamodel;
import es.upcnet.egos.domain.Responsable;
import es.upcnet.egos.domain.Rol;
import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.ServeiIp;
import es.upcnet.egos.domain.ServeiResponsable;
import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.domain.Tecnologia;
import es.upcnet.egos.form.ServeisForm;
import es.upcnet.egos.repository.ComentariRepository;
import es.upcnet.egos.repository.EstatRepository;
import es.upcnet.egos.repository.MetamodelRepository;
import es.upcnet.egos.repository.OperacioRepository;
import es.upcnet.egos.repository.ResponsableRepository;
import es.upcnet.egos.repository.RolRepository;
import es.upcnet.egos.repository.ServeiIpRepository;
import es.upcnet.egos.repository.ServeiRepository;
import es.upcnet.egos.repository.ServeiResponsableRepository;
import es.upcnet.egos.repository.SistemaInformacioRepository;
import es.upcnet.egos.repository.TecnologiaRepository;
import es.upcnet.egos.service.interfaces.ServeisService;

@Service
public class ServeisServiceBD implements ServeisService {
	
	@Autowired
	private OperacioRepository operacioRepository;
		
	@Autowired
	private SistemaInformacioRepository sistemaInformacioRepository;
		
	@Autowired
	private ServeiRepository serveiRepository;
	
	@Autowired
	private EstatRepository estatRepository;
	
	@Autowired
	private ComentariRepository comentariRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	@Autowired
	private MetamodelRepository metamodelRepository;
	
	@Autowired
	private ResponsableRepository responsableRepository;
	
	@Autowired
	private ServeiResponsableRepository serveiResponsableRepository;
	
	@Autowired
	private ServeiIpRepository serveiIpRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SistemaInformacio> findServeisByCriteriCerca(ServeisForm serveisForm) {
		final String sistemaInformacioCerca = ObjectUtils.defaultIfNull(serveisForm.getSistemaInformacioNomCerca(), "");
		final String nomCerca = ObjectUtils.defaultIfNull(serveisForm.getNomCerca(), "");
		final Integer idEstatCerca  = serveisForm.getEstatCerca();
		Integer idComentarisPendentsCerca = serveisForm.getIdComentarisPendentsCerca();
		List<SistemaInformacio> registresServeiCerca = null;

		registresServeiCerca = sistemaInformacioRepository.findServeisByCriteriCerca(sistemaInformacioCerca, nomCerca,  idEstatCerca);
		
		if(idComentarisPendentsCerca == null) {
			registresServeiCerca = sistemaInformacioRepository.findServeisByCriteriCerca(sistemaInformacioCerca, nomCerca,  idEstatCerca);
		} else {
			if(idComentarisPendentsCerca == 2) {
				registresServeiCerca = sistemaInformacioRepository.findServeisByCriteriCerca(sistemaInformacioCerca, nomCerca,  idEstatCerca);
			} else if (idComentarisPendentsCerca == 0) {
				registresServeiCerca = sistemaInformacioRepository.findServeisByCriteriCercaAmbComentarisPendents(sistemaInformacioCerca, nomCerca,  idEstatCerca, idComentarisPendentsCerca);
			}
		}
		
		return registresServeiCerca;
	}

	@Override
	public void inicialitzarCatalegForm(ServeisForm serveisForm) {
		final List<Estat> registresMestresEstat = estatRepository.findAll();
		final List<Object[]> registresServeisSubscripcions = operacioRepository.findSubscripcioByOperacio();
		final List<Object[]> registresAlertesComentaris = comentariRepository.findNumeroVistByServei();
		
		serveisForm.setRegistresMestresEstat(registresMestresEstat);
		serveisForm.setRegistresServeisSubscripcions(registresServeisSubscripcions);
		serveisForm.setRegistresAlertesComentaris(registresAlertesComentaris);
	}

	@Override
	public List<SistemaInformacio> findSubscripcioByCriteriCerca(ServeisForm serveisForm) {
		final String nom = ObjectUtils.defaultIfNull(serveisForm.getNomCerca(), "");

		List<SistemaInformacio> registresSubscripcioCerca = sistemaInformacioRepository.findSubscripcioByCriteriCerca(nom);
		
		return registresSubscripcioCerca;
	}

	@Override
	public void inicialitzarRegistresNouServei(ServeisForm serveisForm) {		
		final List<SistemaInformacio> registresSistemesInformacio = sistemaInformacioRepository.findAll();
		final List<Rol> registresRol = rolRepository.findAll();
		final List<Tecnologia> registresTecnologia = tecnologiaRepository.findAll();
		final List<Metamodel> registresMetamodel = metamodelRepository.findAll();
		
		serveisForm.setRegistresSistemesInformacio(registresSistemesInformacio);
		serveisForm.setRegistresRol(registresRol);
		serveisForm.setRegistresTecnologia(registresTecnologia);
		serveisForm.setRegistresMetamodel(registresMetamodel);
	}
	
	@Override
	public void inicialitzarRegistresEdicio(ServeisForm serveisForm) {		
		final List<Rol> registresRol = rolRepository.findAll();
		final List<Tecnologia> registresTecnologia = tecnologiaRepository.findAll();
		final List<Metamodel> registresMetamodel = metamodelRepository.findAll();
		final List<Estat> registresEstat = estatRepository.findAll();
		final List<ServeiIp> registesIpTest = serveiIpRepository.findAllIpByidServeiAndTipus(serveisForm.getServei().getIdServei(), 2);
		final List<ServeiIp> registesIpExplotacio = serveiIpRepository.findAllIpByidServeiAndTipus(serveisForm.getServei().getIdServei(),1);
		final List<Comentari> registresServeiComentaris = comentariRepository.findComentarisByServei(serveisForm.getServei().getIdServei());
		
		serveisForm.setRegistresRol(registresRol);
		serveisForm.setRegistresTecnologia(registresTecnologia);
		serveisForm.setRegistresMetamodel(registresMetamodel);
		serveisForm.setRegistresEstat(registresEstat);
		serveisForm.setRegistresIpTest(registesIpTest);
		serveisForm.setRegistresIpExplotacio(registesIpExplotacio);
		serveisForm.setRegistresServeiComentaris(registresServeiComentaris);
	}

	@Override
	@Transactional(readOnly=false)
	public Servei save(ServeisForm serveisForm) throws JpaSystemException{
		final Servei servei = serveisForm.getServei();
		final List<Responsable> responsables = new ArrayList<Responsable>();
		final List<ServeiResponsable> serveiResponsables = new ArrayList<ServeiResponsable>();
		Servei serveiPersisted;
		
		if( servei.getIdServei() == -1 ) {
			final Estat estat = new Estat();
			
			servei.setIdServei(null);
			estat.setIdEstat(1);
			servei.setEstat(estat);
		}
		
		if( serveisForm.getIdSistemaInformacioNou() == -1 ) {
			SistemaInformacio sistemaInformacio = new SistemaInformacio();
			
			SistemaInformacio sistemaInformacioPersisted;
			sistemaInformacio.setIdSistemaInformacio( null );
			sistemaInformacio.setNom( serveisForm.getNomSistemaInformacioNou() );
			sistemaInformacioPersisted = sistemaInformacioRepository.saveAndFlush( sistemaInformacio );
			entityManager.refresh( sistemaInformacioPersisted );
			servei.setSistemaInformacio(sistemaInformacioPersisted);
		}
		
		for( Responsable responsable : serveisForm.getRegistresResponsable() ) {
			if( responsable.getIdResponsable() == -1 ) {
				Responsable responsablePersisted;
				responsable.setIdResponsable( null );
				responsablePersisted = responsableRepository.saveAndFlush( responsable );
				entityManager.refresh( responsablePersisted );
				responsables.add( responsablePersisted );
			} else {
				//TODO posibilidad de añadir responsables ya existentes (mediante ajax poniendo el nombre y autocompletando).
				responsables.add( responsable );
			}
			ServeiResponsable serveiResponsable = new ServeiResponsable();
			serveiResponsable.setResponsable( responsable );
			serveiResponsable.setServei( servei );
			serveiResponsables.add( serveiResponsable );
		}
		
		servei.setServeiResponsables(serveiResponsables);
		
		serveiPersisted = serveiRepository.saveAndFlush( servei );
		
		entityManager.refresh( serveiPersisted );
		
		return serveiPersisted;
	}

	@Override
	public Servei findServeiById(Integer idServei) {
		Servei servei;
		
		servei = serveiRepository.findServeiById(idServei);
		
		return servei;
	}

}
