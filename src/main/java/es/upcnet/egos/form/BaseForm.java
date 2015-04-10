package es.upcnet.egos.form;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import es.upcnet.egos.domain.Estat;
import es.upcnet.egos.domain.Etiqueta;
import es.upcnet.egos.domain.Metamodel;
import es.upcnet.egos.domain.Tecnologia;

@Getter
@Setter
public class BaseForm implements Serializable{
	private static final long serialVersionUID = -2938454037586663611L;

	private List<Metamodel> registresMestresMetamodel;
	
	private List<Etiqueta> registresMestresEtiqueta;
	
	private List<Tecnologia> registresMestresTecnologia;
	
	private List<Estat> registresMestresEstat;

}
