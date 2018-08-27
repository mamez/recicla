package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.Tip;


@RepositoryRestResource(collectionResourceRel = "tips", path = "tips")
public interface TipRepository extends PagingAndSortingRepository<Tip, Long>{

}
