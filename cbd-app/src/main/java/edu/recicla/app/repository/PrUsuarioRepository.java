package edu.recicla.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.recicla.app.entity.PrUsuario;

@RepositoryRestResource(collectionResourceRel = "puntosUsuarios", path = "puntosUsuarios")
public interface PrUsuarioRepository extends PagingAndSortingRepository< PrUsuario, Long>{

}
