package es.upcnet.egos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upcnet.egos.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}
