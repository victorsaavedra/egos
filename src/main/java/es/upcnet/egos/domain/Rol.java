package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "rol")
@Getter
@Setter
@EqualsAndHashCode(of = {"idRol"})
public class Rol implements Serializable {
	private static final long serialVersionUID = -6152602031591875019L;

	@Id
//	@SequenceGenerator(name = "rolGenerator", sequenceName = "sequence_rol")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "rolGenerator")
	@Column(name = "id_rol")
	private Integer idRol;

	@NotNull
	@Column(name = "nom")
	private String nom;

	@OneToMany(mappedBy="rol")
	private List<Responsable> responsables;

	public Rol() {
	}

}