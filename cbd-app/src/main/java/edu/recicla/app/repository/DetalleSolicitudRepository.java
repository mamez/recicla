package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.DetalleSolicitud;

@Repository
public interface DetalleSolicitudRepository extends CrudRepository< DetalleSolicitud, Long>{

}
