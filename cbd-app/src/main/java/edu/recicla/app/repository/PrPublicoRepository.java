package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.PrPublico;

@Repository
public interface PrPublicoRepository extends CrudRepository<PrPublico, Long>{

}
