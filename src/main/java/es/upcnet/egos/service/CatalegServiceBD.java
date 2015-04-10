package es.upcnet.egos.service;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.upcnet.egos.domain.Etiqueta;
import es.upcnet.egos.domain.Metamodel;
import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.domain.Tecnologia;
import es.upcnet.egos.form.CatalegForm;
import es.upcnet.egos.repository.EtiquetaRepository;
import es.upcnet.egos.repository.MetamodelRepository;
import es.upcnet.egos.repository.OperacioRepository;
import es.upcnet.egos.repository.ServeiRepository;
import es.upcnet.egos.repository.SistemaInformacioRepository;
import es.upcnet.egos.repository.TecnologiaRepository;
import es.upcnet.egos.service.interfaces.CatalegService;

@Service
public class CatalegServiceBD implements CatalegService {
	
	@Autowired
	private OperacioRepository operacioRepository;
	
	@Autowired
	private MetamodelRepository metamodelRepository;
	
	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	@Autowired
	private SistemaInformacioRepository sistemaInformacioRepository;
	
	@Autowired
	private EtiquetaRepository etiquetaRepository;
	
	@Autowired
	private ServeiRepository serveiRepository;
	
	@Override
	public List<SistemaInformacio> findServeiByCriteriCerca(CatalegForm catalegForm) {
		
		final String nomCerca = ObjectUtils.defaultIfNull(catalegForm.getNomCerca(), "");
		final String descripcioCerca = ObjectUtils.defaultIfNull(catalegForm.getNomCerca(), "");
		final Integer idMetamodelCerca  = catalegForm.getMetamodelCerca();
		final Integer idEtiquetaCerca  = catalegForm.getEtiquetaCerca();
		final Integer idTecnologiaCerca  = catalegForm.getTecnologiaCerca();
		final Integer idEstatCerca  = catalegForm.getEstatCerca();
		
		List<SistemaInformacio> registresServeiCerca = sistemaInformacioRepository.findServeiByCriteriCerca(nomCerca, descripcioCerca, idEtiquetaCerca, idMetamodelCerca, idTecnologiaCerca, idEstatCerca);
		
		return registresServeiCerca;
	}
	
	@Override
	public List<SistemaInformacio> findSubscripcioByCriteriCerca(CatalegForm catalegForm) {
		
		final String nom = ObjectUtils.defaultIfNull(catalegForm.getNomCerca(), "");

		List<SistemaInformacio> registresSubscripcioCerca = sistemaInformacioRepository.findSubscripcioByCriteriCerca(nom);
		
		return registresSubscripcioCerca;
	}

	@Override
	public void inicialitzarCatalegForm(CatalegForm catalegForm) {
		final List<Metamodel> registresMestresMetamodel = metamodelRepository.findAll();
		final List<Tecnologia> registresMestresTecnologia = tecnologiaRepository.findAll();
		final List<Object[]> registresServeisSubscripcions = operacioRepository.findSubscripcioByOperacio();
		final List<Etiqueta> registresMestresEtiqueta = etiquetaRepository.findAllWithCount();
		final List<Servei> registresServeiMesNous = serveiRepository.findAll();
		final List<Metamodel> registresMetamodelJumbotron = metamodelRepository.findMetamodelJumbotron();
		
		catalegForm.setRegistresMestresMetamodel(registresMestresMetamodel);
		catalegForm.setRegistresMestresTecnologia(registresMestresTecnologia);
		catalegForm.setRegistresServeisSubscripcions(registresServeisSubscripcions);
		catalegForm.setRegistresMestresEtiqueta(registresMestresEtiqueta);
		catalegForm.setRegistresServeiMesNous(registresServeiMesNous);
		catalegForm.setRegistresMetamodelJumbotron(registresMetamodelJumbotron);
	}

}
