package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Metamodel;

@Repository
public interface MetamodelRepository extends JpaRepository<Metamodel, Integer> {
	
	@Transactional(readOnly = true)
	List<Metamodel>findAll();
	
	@Query(	" SELECT metamodel FROM Metamodel as metamodel " +
			" WHERE metamodel.jumbo = 1 " +
			" ORDER BY metamodel.ordre")
	@Transactional(readOnly = true)
	List<Metamodel>	findMetamodelJumbotron();


}
