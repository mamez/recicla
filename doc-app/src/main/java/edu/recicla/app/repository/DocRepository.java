package edu.recicla.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.ImagenRepositoy;

@Repository
public interface DocRepository extends CrudRepository<ImagenRepositoy, Long>{
	List<ImagenRepositoy> findByNombre(String nombre);
	
	@Modifying
	@Query("delete from ImagenRepositoy i where i.estado = :estado")
	void deleteAllEstateInit(@Param("estado") Long estado);
	
	@Modifying
	@Query("delete from ImagenRepositoy i where i.nombre = :nombre")
	void deleteImagenByNombre(@Param("nombre") String nombre);
}
