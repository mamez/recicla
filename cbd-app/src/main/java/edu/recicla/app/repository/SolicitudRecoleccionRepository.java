package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.SolicitudRecoleccion;

@Repository
public interface SolicitudRecoleccionRepository extends CrudRepository<SolicitudRecoleccion, Long>{

}
