package es.upcnet.egos.form;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import es.upcnet.egos.domain.Metamodel;
import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.SistemaInformacio;

@Getter
@Setter
@ToString
public class CatalegForm extends BaseForm implements Serializable {
	private static final long serialVersionUID = 5411454138094366843L;

	private String nomCerca;
	
	private String descripcioCerca;
	
	private Integer tipusVistaCataleg;
		
	private Integer metamodelCerca;
	
	private Integer estatCerca;
	
	private Integer tecnologiaCerca;
	
	private Integer etiquetaCerca;
	
	private List<SistemaInformacio> registresSubscripcionsCataleg;
	
	private List<SistemaInformacio> registresServeisCataleg;
	
	private List<Object[]> registresServeisSubscripcions;
	
	private List<Servei> registresServeiMesNous;
		
	private Servei servei;
	
	private List<Metamodel> registresMetamodelJumbotron;

}
