package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Comentari;

public interface ComentariRepository extends JpaRepository<Comentari, Integer> {
	
	@Query(	" SELECT servei.idServei, count(comentari) " +
			" FROM Comentari AS comentari " +
			" INNER JOIN comentari.servei as servei " +
			" WHERE comentari.vist = 0 " +
			" GROUP BY servei.idServei")
	@Transactional(readOnly = true)
	List<Object[]> findNumeroVistByServei();
	
	@Query(	" SELECT subscripcio.idSubscripcio, count(comentari) " +
			" FROM Comentari AS comentari " +
			" INNER JOIN comentari.subscripcio as subscripcio " +
			" WHERE comentari.vist = 0 " +
			" GROUP BY subscripcio.idSubscripcio")
	@Transactional(readOnly = true)
	List<Object[]> findNumeroVistBySubscripcio();

	@Query(	" SELECT comentari FROM Comentari AS comentari " +
			" INNER JOIN comentari.servei AS servei " +
			" WHERE servei.idServei = :idServei ")
	@Transactional(readOnly = true)
	List<Comentari> findComentarisByServei(@Param("idServei")Integer idServei);
}
