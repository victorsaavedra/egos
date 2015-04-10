package es.upcnet.egos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "servei_etiqueta")
@Getter
@Setter
@EqualsAndHashCode(of = {"idServeiEtiqueta"})
public class ServeiEtiqueta implements Serializable {
	private static final long serialVersionUID = -4330504526215831243L;

	@Id
	@SequenceGenerator(name="serveiEtiquetaGenerator", sequenceName="sequence_servei_etiqueta")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="serveiEtiquetaGenerator")
	@Column(name="id_servei_etiqueta")
	private Integer idServeiEtiqueta;

	@ManyToOne
	@JoinColumn(name="id_servei", referencedColumnName = "id_servei")
	private Servei servei;

	@ManyToOne
	@JoinColumn(name="id_etiqueta", referencedColumnName = "id_etiqueta")
	private Etiqueta etiqueta;

	public ServeiEtiqueta() {
	}
}
