package es.upcnet.egos.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Operacio;

@Repository
public interface OperacioRepository extends JpaRepository<Operacio, Integer> {

	@Query( " SELECT serv.idServei, subsOp.subscripcio " +
			" FROM Servei AS serv " +
			" INNER JOIN serv.operacions AS op " +
			" INNER JOIN op.subscripcioOperacions AS subsOp " +
			" INNER JOIN subsOp.subscripcio as Subs " +
			" ORDER BY serv.idServei")
	@Transactional(readOnly = true)
	ArrayList<Object[]> findSubscripcioByOperacio();
	
}
