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
@Table(schema = "public", name="tipus_ip")
@Getter
@Setter
@EqualsAndHashCode(of = {"idTipusIp"})

public class TipusIp implements Serializable {
	private static final long serialVersionUID = -9144990838843220640L;

	@Id
	@SequenceGenerator(name="tipusIpGenerator", sequenceName="sequence_tipus_ip")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="tipusIpGenerator")
	@Column(name="id_tipus_ip")
	private Integer idTipusIp;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy="tipusIp")
	private List<ServeiIp> serveiIps;

	@OneToMany(mappedBy="tipusIp")
	private List<SubscripcioIp> subscripcioIps;

	public TipusIp() {
	}
}