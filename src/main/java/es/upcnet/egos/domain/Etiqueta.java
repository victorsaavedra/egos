package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "etiqueta")
@Getter
@Setter
@EqualsAndHashCode(of = {"idEtiqueta"})
public class Etiqueta implements Serializable {
	private static final long serialVersionUID = -130585025824864600L;

	@Id
	@SequenceGenerator(name="etiquetaGenerator", sequenceName="sequence_etiqueta")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="etiquetaGenerator")
	@Column(name = "id_etiqueta")
	private Integer idEtiqueta;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy="etiqueta")
	private List<ServeiEtiqueta> serveiEtiquetes;
	
	public Etiqueta() {
	}

}
