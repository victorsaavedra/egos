package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.ServeiIp;

public interface ServeiIpRepository extends JpaRepository<ServeiIp, Integer> {
	

	@Query(	" SELECT serveiIp FROM ServeiIp AS serveiIp " +
			" INNER JOIN serveiIp.servei AS servei " + 
			" INNER JOIN serveiIp.tipusIp AS tipusIp " +
			" WHERE tipusIp.idTipusIp = :idTipusIp " +
			" AND servei.idServei = :idServei ")
	@Transactional(readOnly = true)
	List<ServeiIp> findAllIpByidServeiAndTipus(
			@Param("idServei") Integer idServei,
			@Param("idTipusIp") Integer idTipusIp);

}
