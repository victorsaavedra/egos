package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "operacio")
@Getter
@Setter
@EqualsAndHashCode(of = {"idOperacio"})
public class Operacio implements Serializable {
	private static final long serialVersionUID = 934417760428496998L;

	@Id
//	@SequenceGenerator(name="operacioGenerator", sequenceName="sequence_operacio")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="operacioGenerator")
	@Column(name="id_operacio")
	private Integer idOperacio;

	@NotNull
	@Column(name = "descripcio")
	private String descripcio;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@NotNull
	@ManyToOne
	@JoinColumn(name="id_servei", referencedColumnName = "id_servei", nullable = false)
	private Servei servei;

	@OneToMany(mappedBy="operacio", fetch = FetchType.EAGER)
	private List<SubscripcioOperacio> subscripcioOperacions;

	public Operacio() {
	}

}