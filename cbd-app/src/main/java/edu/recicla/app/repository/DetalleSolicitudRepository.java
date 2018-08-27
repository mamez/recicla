package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.DetalleSolicitud;

@RepositoryRestResource(collectionResourceRel = "detalleSolicitud", path = "detalleSolicitud")
public interface DetalleSolicitudRepository extends PagingAndSortingRepository< DetalleSolicitud, Long>{

}
