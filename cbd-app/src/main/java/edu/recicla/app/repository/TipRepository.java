package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.Tip;

@Repository
public interface TipRepository extends CrudRepository<Tip, Long>{

}
