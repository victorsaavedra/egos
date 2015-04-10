package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "metamodel")
@Getter
@Setter
@EqualsAndHashCode(of = {"idMetamodel"})
public class Metamodel implements Serializable {
	private static final long serialVersionUID = -7925883662720863633L;

	@Id
//	@SequenceGenerator(name = "metamodelGenerator", sequenceName = "sequence_metamodel")
//   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "metamodelGenerator")
	@Column(name = "id_metamodel")
	private Integer idMetamodel;

	@NotNull
	@Column(name = "nom")
	@Size(max = 100, message = "{validation_metamodel_nomLenght}")
	private String nom;

	@OneToMany(mappedBy="metamodel", fetch = FetchType.LAZY)
	private List<Servei> serveis;
	
	@Column(name="jumbo")
	private Integer jumbo;
	
	@Column(name="ordre")
	private Integer ordre;

	public Metamodel() {
	}
}