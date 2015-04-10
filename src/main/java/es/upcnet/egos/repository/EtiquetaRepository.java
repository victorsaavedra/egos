package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Integer> {

	@Transactional(readOnly = true)
	List<Etiqueta>findAll();
	
	@Query(	  " SELECT etiqueta, count(servEti.etiqueta) "
			+ " FROM Etiqueta AS etiqueta "
			+ " INNER JOIN etiqueta.serveiEtiquetes AS servEti "
			+ " GROUP BY etiqueta.idEtiqueta "
			+ " ORDER BY count(servEti.etiqueta) DESC")
	@Transactional(readOnly = true)
	List<Etiqueta>findAllWithCount();

	
}
