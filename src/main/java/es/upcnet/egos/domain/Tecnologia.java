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
@Table(schema = "public", name = "tecnologia")
@Getter
@Setter
@EqualsAndHashCode(of = {"idTecnologia"})
public class Tecnologia implements Serializable {
	private static final long serialVersionUID = 8623972510420674158L;

	@Id
	@SequenceGenerator(name="tecnologiaGenerator", sequenceName="sequence_tecnologia")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="tecnologiaGenerator")
	@Column(name="id_tecnologia")
	private Integer idTecnologia;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy="tecnologia", fetch = FetchType.LAZY)
	private List<Servei> serveis;

	public Tecnologia() {
	}
}