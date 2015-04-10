package es.upcnet.egos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "subscripcio_responsable")
@Getter
@Setter
@EqualsAndHashCode(of = {"idSubscripcioResponsable"})
public class SubscripcioResponsable implements Serializable {
	private static final long serialVersionUID = -3577699823886347041L;

	@Id
//	@SequenceGenerator(name="subscripcioResponsableGenerator", sequenceName="sequence_subscripcio_responsable")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subscripcioResponsableGenerator")
	@Column(name="id_subscripcio_responsable")
	private Integer idSubscripcioResponsable;

	@ManyToOne
	@JoinColumn(name="id_responsable", referencedColumnName = "id_responsable")
	private Responsable responsable;

	@ManyToOne
	@JoinColumn(name="id_subscripcio", referencedColumnName = "id_subscripcio")
	private Subscripcio subscripcio;

	public SubscripcioResponsable() {
	}
}