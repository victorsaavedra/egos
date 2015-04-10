package es.upcnet.egos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "subscripcio_operacio")
@Getter
@Setter
@EqualsAndHashCode(of = {"idSubscripcioOperacio"})
public class SubscripcioOperacio implements Serializable {
	private static final long serialVersionUID = 6447325882827740257L;

	@Id
//	@SequenceGenerator(name="subscripcioOperacioGenerator", sequenceName="sequence_subscripcio_operacio")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subscripcioOperacioGenerator")
	@Column(name="id_subscripcio_operacio")
	private Integer idSubscripcioOperacio;

	@ManyToOne
	@JoinColumn(name="id_operacio", referencedColumnName = "id_operacio")
	private Operacio operacio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_subscripcio", referencedColumnName = "id_subscripcio")
	private Subscripcio subscripcio;

	public SubscripcioOperacio() {
	}
}