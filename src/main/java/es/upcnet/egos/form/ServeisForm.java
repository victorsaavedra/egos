package es.upcnet.egos.form;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import es.upcnet.egos.domain.Comentari;
import es.upcnet.egos.domain.Estat;
import es.upcnet.egos.domain.Metamodel;
import es.upcnet.egos.domain.Responsable;
import es.upcnet.egos.domain.Rol;
import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.ServeiIp;
import es.upcnet.egos.domain.SistemaInformacio;
import es.upcnet.egos.domain.Tecnologia;

@Getter
@Setter
@ToString
public class ServeisForm extends BaseForm implements Serializable {
	private static final long serialVersionUID = 1878538025286828551L;

	private String sistemaInformacioNomCerca;
	
	private String nomCerca;
	
	private Integer estatCerca;
	
	private Integer tipusCerca;
		
	private Integer idComentarisPendentsCerca;
	
	private List<SistemaInformacio> registresSubscripcionsCataleg;
	
	private List<SistemaInformacio> registresServeisCataleg;
	
	private List<SistemaInformacio> registresSistemesInformacio;
	
	private List<Object[]> registresServeisSubscripcions;
	
	private List<Object[]> registresAlertesComentaris;
	
	private List<Rol> registresRol;
	
	private List<Tecnologia> registresTecnologia;
	
	private List<Metamodel> registresMetamodel;
	
	private List<Responsable> registresResponsable;
	
	private List<Estat> registresEstat;
	
	private List<ServeiIp> registresIpTest;
	
	private List<ServeiIp> registresIpExplotacio;
	
	private boolean showNouSistemaInformacio;
	
	private boolean errorsValidacio;
	
	private Integer idSistemaInformacioNou;
	
	private String nomSistemaInformacioNou;
	
	@Valid
	private Servei servei;
	
	@Valid
	private Comentari comentari;
	
	private List<Comentari> registresServeiComentaris;
}
