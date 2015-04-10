package es.upcnet.egos.form;

import java.io.Serializable;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import es.upcnet.egos.domain.SistemaInformacio;

@Getter
@Setter
@ToString
public class SistemaInformacioForm extends BaseForm implements Serializable {
	private static final long serialVersionUID = 9182623554710967785L;
	
	private String nom;
	
	@Valid
	private SistemaInformacio sistemaInformacio;
	
}
