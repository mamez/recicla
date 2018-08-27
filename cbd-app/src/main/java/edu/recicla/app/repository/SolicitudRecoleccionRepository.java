package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.SolicitudRecoleccion;

@RepositoryRestResource(collectionResourceRel = "solicitudRecoleccion", path = "solicitudRecoleccion")
public interface SolicitudRecoleccionRepository extends PagingAndSortingRepository<SolicitudRecoleccion, Long>{

}
