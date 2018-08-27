package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.SolicitudCanje;

@RepositoryRestResource(collectionResourceRel = "solicitudCanje", path = "solicitudCanje")
public interface SolicitudCanjeRepository extends PagingAndSortingRepository<SolicitudCanje, Long> {

}
