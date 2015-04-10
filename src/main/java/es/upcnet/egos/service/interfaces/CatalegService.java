package es.upcnet.egos.service.interfaces;

import java.util.List;

import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.form.CatalegForm;

public interface CatalegService {

	List<SistemaInformacio> findServeiByCriteriCerca(CatalegForm catalegForm);
		
	void inicialitzarCatalegForm(CatalegForm catalegForm);

	List<SistemaInformacio> findSubscripcioByCriteriCerca(CatalegForm catalegForm);
	
}
