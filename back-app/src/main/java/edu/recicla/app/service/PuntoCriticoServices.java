package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.PuntoCriticoModel;

public interface PuntoCriticoServices {
    /**
     * Metodo para obtener todos los puntos criticos
     * @return
     */
	public List<PuntoCriticoModel> getAllPruntosCriticos();
	/**
	 * Metodo para obtener todos los puntos criticos de un suausrios
	 * @param id: ide de usuario
	 * @return
	 */
	public List<PuntoCriticoModel> getAllPruntosCriticosByUser(long id);
	/**
	 * Metodo para guardar un punto critico
	 * @param model
	 * @return
	 */
	public PuntoCriticoModel savePuntoCritico(PuntoCriticoModel model);
	
	/**
	 * Metodo para actualizar un unto critico
	 * @param model
	 * @return
	 */
	public PuntoCriticoModel updatePuntoCritico(PuntoCriticoModel model);
	
	/**
	 * metodo para actualizar el estado de un punto critico
	 * @param model
	 * @return
	 */
	public void updateEstatePuntoCritico(PuntoCriticoModel model);
	
	/**
	 * Metodo para eliminar punto critico
	 * @param id
	 * @return
	 */
	public void delatePuntoCritico(Long id);
	
	
}
