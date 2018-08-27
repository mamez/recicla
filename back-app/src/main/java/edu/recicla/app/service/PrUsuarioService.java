package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.PrUsuarioModel;

public interface PrUsuarioService {

	/**
	 * Metodo para obetener todos los puntos de recoleccion usuario
	 * @return
	 */
 public List<PrUsuarioModel> getAllPrUsuario();
 
 /**
  * Metodo para obtener un punto de punto de recoleccion usuario publico por id
  * @param id
  * @return
  */
 public PrUsuarioModel getPrUsuario(Long id);
 
 /**
  * Metodo para crear un punto de recoleccion usuario
  * @param PrUsuarioModel
  * @return
  */
 public PrUsuarioModel savePrUsuario(PrUsuarioModel PrUsuarioModel);
 
 
 /**
  * Metodo para actualizar un punto de recoleccion usuario
  * @param PrUsuarioModel
  * @return
  */
 public PrUsuarioModel updatePrUsuario(PrUsuarioModel PrUsuarioModel);
 
 /**
  * Metodo para eliminar un punto de recoleccion usuario
  * @param id
  * @return
  */
 public boolean deletePrUsuario(Long id);
}
