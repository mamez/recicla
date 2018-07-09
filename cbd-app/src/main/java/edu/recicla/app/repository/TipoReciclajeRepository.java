package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.TipoReciclaje;

@Repository
public interface TipoReciclajeRepository extends CrudRepository<TipoReciclaje, Long>{

}
