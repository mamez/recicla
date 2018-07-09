package edu.recicla.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long>{
	List<Usuario> findByCorreo(String correo);
}
