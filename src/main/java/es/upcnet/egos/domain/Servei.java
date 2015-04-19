package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(schema = "public", name = "servei")
@Getter
@Setter
@EqualsAndHashCode(of = {"idServei"})
public class Servei implements Serializable {
	private static final long serialVersionUID = -6954325157610942887L;

	@Id
	@SequenceGenerator(name="serveiGenerator", sequenceName="sequence_servei")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="serveiGenerator")
	@Column(name="id_servei", unique=true, nullable=false)
	private Integer idServei;

	@Column(name="acces_internet")
	private Integer accesInternet;

	@Column(name="acces_intranet")
	private Integer accesIntranet;

	@Column(name="concurrencia_internet")
	private Integer concurrenciaInternet;

	@Column(name="concurrencia_intranet")
	private Integer concurrenciaIntranet;

	@Column(name="cua_internet")
	private Integer cuaInternet;

	@Column(name="cua_intranet")
	private Integer cuaIntranet;

	@Column(name="dades_personals")
	private Integer dadesPersonals;

	@Column(name = "descripcio")
	private String descripcio;

	@Column(name="grup_gauss")
	private String grupGauss;

	@Column(name="nivell_seguretat")
	private Integer nivellSeguretat;

	@Column(name="temps_internet")
	private Integer tempsInternet;

	@Column(name="temps_intranet")
	private Integer tempsIntranet;

	@Column(name="url_explotacio")
	private String urlExplotacio;

	@Column(name="url_proves")
	private String urlProves;

	@Column(name = "validacio")
	private Integer validacio;
	
	@NotNull
	@Column(name = "nom")
	@NotEmpty(message="{validation_servei_nomEmpty}")
    @Size(max=20, message="{validation_servei_nomLenght}")
	private String nom;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_alta")
	private Date dataAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="data_baixa")
	private Date dataBaixa;

	@OneToMany(mappedBy="servei")
	private List<Comentari> comentaris;

	@OneToMany(mappedBy="servei", fetch = FetchType.EAGER)
	private List<Operacio> operacions;
	
	@ManyToOne
	@JoinColumn(name = "id_estat", referencedColumnName = "id_estat")
	private Estat estat;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnologia", referencedColumnName = "id_tecnologia")
	private Tecnologia tecnologia;

	@ManyToOne
	@JoinColumn(name = "id_sistema_informacio", referencedColumnName = "id_sistema_informacio")
	private SistemaInformacio sistemaInformacio;
	
	@ManyToOne
	@JoinColumn(name = "id_metamodel", referencedColumnName = "id_metamodel")
	private Metamodel metamodel;

	@OneToMany(mappedBy="servei", cascade= CascadeType.ALL)
	private List<ServeiIp> serveiIps;
	
	@OneToMany(mappedBy="servei", cascade= CascadeType.ALL)
	private List<ServeiEtiqueta> serveiEtiquetes;

	@OneToMany(mappedBy="servei", fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private List<ServeiResponsable> serveiResponsables;

	public Servei() {
	}
}