package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Tecnologia;

@Repository
public interface TecnologiaRepository extends JpaRepository<Tecnologia, Integer> {
	
	@Transactional(readOnly = true)
	List<Tecnologia>findAll();

}
