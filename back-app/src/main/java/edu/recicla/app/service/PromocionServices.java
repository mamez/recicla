package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.PromocionModel;

public interface PromocionServices {
	/**
	 * Metodo para obtener todas las promociones
	 * @return
	 */
	public List<PromocionModel> getAllPromociones();
	
	/**
	 * Metodo para obtener una promocion por id
	 * @param id
	 * @return
	 */
	public PromocionModel getPromocion (Long id);
	
	/**
	 * Metodo para actualizar una promocion
	 * @param PromocionModel
	 * @return
	 */
	public PromocionModel updatePromocion (PromocionModel promocionModel);
	

	/**
	 * Metodo para crear una promocion
	 */
	public PromocionModel savePromocion(PromocionModel promocionModel);
	
	/**
	 * Metodo para eliminar una promocion
	 * @param id
	 * @return
	 */
	public boolean deletePromocion(Long id); 
}
