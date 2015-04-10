package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "subscripcio")
@Getter
@Setter
@EqualsAndHashCode(of = {"idSubscripcio"})
public class Subscripcio implements Serializable {
	private static final long serialVersionUID = 7947018795993868444L;

	@Id
//	@SequenceGenerator(name="subscripcioGenerator", sequenceName="sequence_subscripcio")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subscripcioGenerator")
	@Column(name="id_subscripcio")
	private Integer idSubscripcio;

	@Column(name = "comentari")
	private String comentari;

	@Temporal(TemporalType.DATE)
	@Column(name="data_alta")
	private Date dataAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_baixa")
	private Date dataBaixa;

	@Column(name = "descripcio")
	private String descripcio;

	@ManyToOne
	@JoinColumn(name = "id_estat", referencedColumnName = "id_estat")
	private Estat estat;

	@Column(name="estimacio_us")
	private String estimacioUs;

	@Column(name = "horari")
	private Integer horari;

	@Column(name = "nom")
	private String nom;

	@Column(name="url_explotacio")
	private String urlExplotacio;

	@Column(name="url_test")
	private String urlTest;

	@OneToMany(mappedBy="subscripcio")
	private List<Comentari> comentaris;

	@ManyToOne
	@JoinColumn(name="id_sistema_informacio", referencedColumnName = "id_sistema_informacio")
	private SistemaInformacio sistemaInformacio;

	@OneToMany(mappedBy="subscripcio")
	private List<SubscripcioIp> subscripcioIps;

	@OneToMany(mappedBy="subscripcio")
	private List<SubscripcioOperacio> subscripcioOperacios;

	@OneToMany(mappedBy="subscripcio")
	private List<SubscripcioResponsable> subscripcioResponsables;

	public Subscripcio() {
	}
}