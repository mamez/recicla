package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.Promocion;

@Repository
public interface PromocionRepository extends CrudRepository<Promocion, Long> {

}
