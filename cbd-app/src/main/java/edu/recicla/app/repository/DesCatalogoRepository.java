package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.DesCatalogo;

@Repository
public interface DesCatalogoRepository   extends CrudRepository< DesCatalogo, Long>{

}
