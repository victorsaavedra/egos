package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Estat;

@Repository
public interface EstatRepository extends JpaRepository<Estat, Integer> {

	@Transactional(readOnly = true)
	List<Estat>findAll();
	
	@Query("SELECT estat FROM Estat AS estat " +
			" LEFT JOIN estat.serveis AS serveis " +
			" WHERE serveis.idServei = :idServei ")
	@Transactional(readOnly = true)
	Estat findEstatByServei(@Param("idServei") Integer idServei);

	
}
