package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.Promocion;

@RepositoryRestResource(collectionResourceRel = "pomocion", path = "promocion")
public interface PromocionRepository extends CrudRepository<Promocion, Long> {

}
