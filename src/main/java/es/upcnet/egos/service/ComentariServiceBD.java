package es.upcnet.egos.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Comentari;
import es.upcnet.egos.form.ServeisForm;
import es.upcnet.egos.repository.ComentariRepository;
import es.upcnet.egos.service.interfaces.ComentariService;

@Service
public class ComentariServiceBD implements ComentariService {

	@Autowired
	private ComentariRepository comentariRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=false)
	public void save(ServeisForm serveisForm) throws JpaSystemException{
		final Date dataComentari = Calendar.getInstance().getTime();
		Comentari comentariPersisted;
		Comentari comentari = serveisForm.getComentari();
		
		comentari.setVist(1);
		comentari.setDataComentari( dataComentari );
		comentari.setServei( serveisForm.getServei() );

		comentariPersisted = comentariRepository.saveAndFlush( serveisForm.getComentari() );
		entityManager.refresh( comentariPersisted );
	}

}
