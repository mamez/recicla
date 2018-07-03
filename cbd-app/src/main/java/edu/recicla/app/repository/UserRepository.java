package edu.recicla.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer>{

}
