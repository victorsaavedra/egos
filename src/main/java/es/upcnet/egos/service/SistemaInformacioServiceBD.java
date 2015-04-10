package es.upcnet.egos.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.repository.SistemaInformacioRepository;
import es.upcnet.egos.service.interfaces.SistemaInformacioService;

@Service
@Transactional
public class SistemaInformacioServiceBD implements SistemaInformacioService {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private SistemaInformacioRepository sistemaInformacioRepository;

	@Override
	@Transactional(readOnly=false)
	public SistemaInformacio save(SistemaInformacio sistemaInformacio) throws JpaSystemException {
		SistemaInformacio sistemaInformacioPersisted;
		
		sistemaInformacioPersisted = sistemaInformacioRepository.saveAndFlush(sistemaInformacio);
		
		entityManager.refresh(sistemaInformacioPersisted);
		
		return sistemaInformacioPersisted;
	}
	
}
