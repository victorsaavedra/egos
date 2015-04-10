package es.upcnet.egos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "subscripcio_ip")
@Getter
@Setter
@EqualsAndHashCode(of = {"idSubscripcioIp"})
public class SubscripcioIp implements Serializable {
	private static final long serialVersionUID = -3372301360840060675L;

	@Id
//	@SequenceGenerator(name="subscripcioIpGenerator", sequenceName="sequence_subscripcio_ip")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subscripcioIpGenerator")
	@Column(name="id_subscripcio_ip")
	private Integer idSubscripcioIp;

	@NotNull
	@Column(name = "ip")
	private String ip;

	@ManyToOne
	@JoinColumn(name="id_subscripcio", referencedColumnName = "id_subscripcio")
	private Subscripcio subscripcio;

	@ManyToOne
	@JoinColumn(name="id_tipus_ip", referencedColumnName = "id_tipus_ip")
	private TipusIp tipusIp;

	public SubscripcioIp() {
	}
}