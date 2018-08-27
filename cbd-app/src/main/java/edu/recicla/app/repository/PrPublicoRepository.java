package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.PrPublico;

@RepositoryRestResource(collectionResourceRel = "puntosPublicos", path = "puntosPublicos")
public interface PrPublicoRepository extends CrudRepository<PrPublico, Long>{

}
