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
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "public", name = "servei_ip")
@Getter
@Setter
@EqualsAndHashCode(of = {"idServeiIp"})
public class ServeiIp implements Serializable {
	private static final long serialVersionUID = -3557760704940265423L;

	@Id
	@SequenceGenerator(name="serveiIpGenerator", sequenceName="sequence_servei_ip")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="serveiIpGenerator")
	@Column(name="id_servei_ip")
	private Integer idServeiIp;

	@NotNull
	@Column(name = "ip")
	private String ip;

	@ManyToOne
	@JoinColumn(name="id_servei", referencedColumnName = "id_servei")
	private Servei servei;

	@ManyToOne
	@JoinColumn(name="id_tipus_ip", referencedColumnName = "id_tipus_ip")
	private TipusIp tipusIp;

	public ServeiIp() {
	}

}