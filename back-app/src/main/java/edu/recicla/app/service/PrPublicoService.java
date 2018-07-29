package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.PrPublicoModel;

public interface PrPublicoService {
	
	/**
	 * Metodo para obetener todos los puntos de recoleccion publicos
	 * @return
	 */
 public List<PrPublicoModel> getAllPrPublico();
 
 /**
  * Metodo para obtener un punto de recoleccion publico por id
  * @param id
  * @return
  */
 public PrPublicoModel getPrPublico(Long id);
 
 /**
  * Metodo para crear un punto de recoleccion publico
  * @param prPublicoModel
  * @return
  */
 public PrPublicoModel savePrPublico(PrPublicoModel prPublicoModel);
 
 
 /**
  * Metodo para actualizar un punto de recoleccion public
  * @param PrPublicoModel
  * @return
  */
 public PrPublicoModel updatePrPublico(PrPublicoModel prPublicoModel);
 
 /**
  * Metodo para eliminar un punto de recoleccion
  * @param id
  * @return
  */
 public boolean deletePrPublico(Long id);
 
}
