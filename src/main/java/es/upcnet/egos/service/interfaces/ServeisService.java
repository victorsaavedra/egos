package es.upcnet.egos.service.interfaces;

import java.util.List;

import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.form.ServeisForm;

public interface ServeisService {

	List<SistemaInformacio> findServeisByCriteriCerca(ServeisForm serveisForm);
	
	void inicialitzarCatalegForm(ServeisForm serveisForm);

	List<SistemaInformacio> findSubscripcioByCriteriCerca(ServeisForm serveisForm);
	
	void inicialitzarRegistresNouServei(ServeisForm serveisForm);
	
	void inicialitzarRegistresEdicio(ServeisForm serveisForm);

	Servei save(ServeisForm serveisForm);
	
	Servei findServeiById(Integer idServei);
}
