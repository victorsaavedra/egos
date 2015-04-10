package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Getter
@Setter
@Table(schema = "public", name = "sistema_informacio")
@EqualsAndHashCode(of = {"idSistemaInformacio"})
public class SistemaInformacio implements Serializable {
	private static final long serialVersionUID = 6433310118299763914L;

	@Id
	@SequenceGenerator(name="sistemaInformacioGenerator", sequenceName="sequence_sistema_informacio")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="sistemaInformacioGenerator")
	@Column(name="id_sistema_informacio", unique=true, nullable=false)
	private Integer idSistemaInformacio;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy="sistemaInformacio", fetch = FetchType.LAZY)
	private List<Servei> serveis;

	@OneToMany(mappedBy="sistemaInformacio", fetch = FetchType.LAZY)
	private List<Subscripcio> subscripcions;

	public SistemaInformacio() {
	}
}