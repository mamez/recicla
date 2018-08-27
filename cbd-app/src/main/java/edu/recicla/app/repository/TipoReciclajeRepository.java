package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.TipoReciclaje;

@RepositoryRestResource(collectionResourceRel = "tipoReciclaje", path = "tipoReciclaje")
public interface TipoReciclajeRepository extends PagingAndSortingRepository<TipoReciclaje, Long>{

}
