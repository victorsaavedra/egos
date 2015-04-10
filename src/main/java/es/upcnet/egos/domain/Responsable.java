package es.upcnet.egos.domain;

import java.io.Serializable;
import java.util.List;

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
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(schema = "public", name = "responsable")
@Getter
@Setter
@EqualsAndHashCode(of = {"idResponsable"})
public class Responsable implements Serializable {
	private static final long serialVersionUID = -9099447571037408624L;

	@Id
	@SequenceGenerator(name="responsableGenerator", sequenceName="sequence_responsable")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="responsableGenerator")
	@Column(name="id_responsable")
	private Integer idResponsable;

	@Column(name = "departament")
	private String departament;

	@NotNull
	@Column(name = "mail")
	private String mail;

	@NotNull
	@Column(name = "nom_cognoms")
	private String nomCognoms;
		
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "telefon")
	private String telefon;

	@OneToMany(mappedBy="responsable")
	private List<Comentari> comentaris;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_rol", referencedColumnName = "id_rol", nullable = false)
	private Rol rol;

	@OneToMany(mappedBy="responsable")
	private List<ServeiResponsable> serveiResponsables;

	@OneToMany(mappedBy="responsable")
	private List<SubscripcioResponsable> subscripcioResponsables;

	public Responsable() {
	}

}