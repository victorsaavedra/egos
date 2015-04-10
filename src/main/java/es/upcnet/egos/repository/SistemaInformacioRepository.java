package es.upcnet.egos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.upcnet.egos.domain.Servei;
import es.upcnet.egos.domain.SistemaInformacio;

@Repository
public interface SistemaInformacioRepository extends JpaRepository<SistemaInformacio, Integer> {
	
	@Query(	"SELECT DISTINCT sistemaInformacio FROM SistemaInformacio AS sistemaInformacio " +
			" INNER JOIN FETCH sistemaInformacio.serveis AS serveis "+ 
			" INNER JOIN serveis.serveiEtiquetes AS servEt " +
			" INNER JOIN servEt.etiqueta AS et " +
			" INNER JOIN serveis.metamodel AS metamodel " +
			" INNER JOIN serveis.tecnologia AS tecnologia " +
			" INNER JOIN serveis.serveiResponsables AS servRes" +
			" INNER JOIN servRes.responsable AS responsable " +
			" INNER JOIN serveis.estat AS estat " +
			" INNER JOIN responsable.rol AS rol " +
			" WHERE (serveis.nom LIKE ('%'||:nom||'%') " +
			" OR serveis.descripcio LIKE ('%'||:descripcio||'%') )" +
			" AND (et.idEtiqueta = :idEtiqueta OR :idEtiqueta IS null)" +
			" AND (metamodel.idMetamodel = :idMetamodel OR :idMetamodel IS null)" +
			" AND (estat.idEstat = :idEstat OR :idEstat IS null)" +
			" AND (tecnologia.idTecnologia = :idTecnologia OR :idTecnologia IS null)")	
	@Transactional(readOnly = true)
	List<SistemaInformacio>findServeiByCriteriCerca(
			@Param("nom") String nom,
			@Param("descripcio") String descripcio,
			@Param("idEtiqueta") Integer idEtiqueta,
			@Param("idMetamodel") Integer idMetamodel,
			@Param("idTecnologia") Integer idTecnologia,
			@Param("idEstat") Integer idEstat);
	
	@Query(	"SELECT sistemaInformacio FROM SistemaInformacio AS sistemaInformacio " +
			" LEFT JOIN sistemaInformacio.subscripcions AS subscripcions " +
			" WHERE sistemaInformacio.nom LIKE ('%'||:nom||'%') ")
	@Transactional(readOnly = true)
	List<SistemaInformacio>findSubscripcioByCriteriCerca(
			@Param("nom") String nom);
		
	@Query(	"SELECT DISTINCT sistemaInformacio FROM SistemaInformacio AS sistemaInformacio " +
			" INNER JOIN FETCH sistemaInformacio.serveis AS serveis "+ 
			" INNER JOIN serveis.serveiEtiquetes AS servEt " +
			" INNER JOIN serveis.serveiResponsables AS servRes" +
			" INNER JOIN servRes.responsable AS responsable " +
			" INNER JOIN serveis.estat AS estat " +
			" INNER JOIN responsable.rol AS rol " +
			" WHERE serveis.nom LIKE ('%'||:nom||'%') " +
			" AND sistemaInformacio.nom LIKE ('%'||:sistemaInformacioNom||'%')" +
			" AND (estat.idEstat = :idEstat OR :idEstat IS null)")
	@Transactional(readOnly = true)
	List<SistemaInformacio>findServeisByCriteriCerca(
			@Param("sistemaInformacioNom") String sistemaInformacioNom,
			@Param("nom") String nom,
			@Param("idEstat") Integer idEstat);
	
	@Query(	"SELECT DISTINCT sistemaInformacio FROM SistemaInformacio AS sistemaInformacio " +
			" INNER JOIN FETCH sistemaInformacio.serveis AS serveis "+ 
			" INNER JOIN serveis.serveiEtiquetes AS servEt " +
			" INNER JOIN serveis.serveiResponsables AS servRes" +
			" INNER JOIN servRes.responsable AS responsable " +
			" INNER JOIN serveis.estat AS estat " +
			" INNER JOIN responsable.rol AS rol " +
			" INNER JOIN serveis.comentaris AS comentari " +
			" WHERE serveis.nom LIKE ('%'||:nomCerca||'%') " +
			" AND sistemaInformacio.nom LIKE ('%'||:sistemaInformacioCerca||'%')" +
			" AND (estat.idEstat = :idEstatCerca OR :idEstatCerca IS null) " +
			" AND serveis NOT IN( "
			+ "		SELECT servei "
			+ "		FROM Servei AS servei "
			+ "		INNER JOIN servei.comentaris as comentari "
			+ "		WHERE comentari.vist = :idComentariVistCerca "
			+ "		GROUP BY servei"
			+ ")" )
	List<SistemaInformacio> findServeisByCriteriCercaAmbComentarisPendents(
			@Param("sistemaInformacioCerca") String sistemaInformacioCerca, 
			@Param("nomCerca") String nomCerca, 
			@Param("idEstatCerca") Integer idEstatCerca,
			@Param("idComentariVistCerca") Integer idComentariVistCerca);
	
	@Query(	"SELECT servei "
			+ "FROM Servei AS servei "
			+ "INNER JOIN servei.comentaris as comentari "
			+ "WHERE comentari.vist = 0 "
			+ "GROUP BY servei")
	List<Servei> findServeisMissatgesPendents();

}
