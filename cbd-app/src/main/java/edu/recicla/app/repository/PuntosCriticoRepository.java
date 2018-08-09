package edu.recicla.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.recicla.app.entity.PuntosCritico;
import edu.recicla.app.entity.Usuario;

@Repository
public interface PuntosCriticoRepository extends CrudRepository<PuntosCritico, Long>{
public List<PuntosCritico> findByUsuario(Usuario usuario);
}
