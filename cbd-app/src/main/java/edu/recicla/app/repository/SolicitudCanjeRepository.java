package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.SolicitudCanje;

@Repository
public interface SolicitudCanjeRepository extends CrudRepository<SolicitudCanje, Long> {

}
