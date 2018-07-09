package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.PuntosCritico;

@Repository
public interface PuntosCriticoRepository extends CrudRepository<PuntosCritico, Long>{

}
