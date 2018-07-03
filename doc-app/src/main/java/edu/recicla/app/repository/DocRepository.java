package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.ImagenRepositoy;

@Repository
public interface DocRepository extends CrudRepository<ImagenRepositoy, String>{

}
