package es.upcnet.egos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(schema="public", name="servei_responsable")
@Getter
@Setter
@EqualsAndHashCode(of = {"idServeiResponsable"})
public class ServeiResponsable implements Serializable {
	private static final long serialVersionUID = 5108002521621061953L;

	@Id
	@SequenceGenerator(name="serveiResponsableGenerator", sequenceName="sequence_servei_responsable")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="serveiResponsableGenerator")
	@Column(name="id_servei_responsable")
	private Integer idServeiResponsable;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_responsable", referencedColumnName = "id_responsable")
	private Responsable responsable;

	@ManyToOne
	@JoinColumn(name="id_servei", referencedColumnName = "id_servei")
	private Servei servei;

	public ServeiResponsable() {}

}