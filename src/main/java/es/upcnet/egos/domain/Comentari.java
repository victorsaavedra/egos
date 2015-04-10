package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "comentari")
@Getter
@Setter
@EqualsAndHashCode(of = {"idComentari"})
public class Comentari implements Serializable {
	private static final long serialVersionUID = 1467634203325647512L;

	@Id
	@SequenceGenerator(name="comentariGenerator", sequenceName="sequence_comentari")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="comentariGenerator")
	@Column(name = "id_comentari")
	private Integer idComentari;

	@NotNull
	@Column(name = "comentari")
	private String comentari;

	@Temporal(TemporalType.DATE)
	@Column(name="data_comentari")
	private Date dataComentari;

	@NotNull
	@Column(name = "vist")
	private Integer vist;

	@ManyToOne
	@JoinColumn(name = "id_responsable", referencedColumnName = "id_responsable")
	private Responsable responsable;

	@ManyToOne
	@JoinColumn(name = "id_servei", referencedColumnName = "id_servei")
	private Servei servei;

	@ManyToOne
	@JoinColumn(name = "id_subscripcio", referencedColumnName = "id_subscripcio")
	private Subscripcio subscripcio;

	public Comentari() {
	}
}