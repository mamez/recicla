package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.PrUsuario;

@Repository
public interface PrUsuarioRepository extends CrudRepository< PrUsuario, Long>{

}
