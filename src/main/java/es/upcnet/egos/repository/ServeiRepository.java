package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Servei;

@Repository
public interface ServeiRepository extends JpaRepository<Servei, Integer> {

	@Query(	" SELECT DISTINCT servei FROM Servei AS servei " +
			" INNER JOIN servei.estat as estat " + 
			" WHERE estat.nom = 'Publicat' " +
			" ORDER BY servei.dataAlta DESC")
	@Transactional(readOnly = true)
	List<Servei> findAll();

	@Query( " SELECT servei FROM Servei AS servei " +
			" WHERE servei.idServei = :idServei")
	@Transactional(readOnly = true)
	Servei findServeiById(@Param("idServei")Integer idServei);
}
