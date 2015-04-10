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
@Table(schema = "public", name = "estat")
@Getter
@Setter
@EqualsAndHashCode(of = {"idEstat"})
public class Estat implements Serializable {
	private static final long serialVersionUID = -5792214234573440463L;

	@Id
	@SequenceGenerator(name="comentariGenerator", sequenceName="sequence_comentari")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="comentariGenerator")
	@Column(name = "id_estat")
	private Integer idEstat;

	@NotNull
	@Column(name = "nom")
	private String nom;
	
	@OneToMany(mappedBy="estat", fetch = FetchType.LAZY)
	private List<Servei> serveis;

	public Estat() {
	}

}
