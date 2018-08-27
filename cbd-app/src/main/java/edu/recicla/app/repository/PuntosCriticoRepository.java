package edu.recicla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.recicla.app.enums.EstadoPuntoRecoleccion;

import edu.recicla.app.entity.PuntosCritico;

@RepositoryRestResource(collectionResourceRel = "puntosCriticos", path = "puntosCriticos")
public interface PuntosCriticoRepository extends CrudRepository<PuntosCritico, Long>{
	
@Query(value="select p from PuntosCritico p where p.usuario.id = ?1 and p.estado = ?2", nativeQuery= false)
public List<PuntosCritico> findUsuario(@Param("usuario.id") Long usuario);

public List<PuntosCritico> findByEstado(@Param("estado")  EstadoPuntoRecoleccion estado);

}
