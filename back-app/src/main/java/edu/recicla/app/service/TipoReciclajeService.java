package edu.recicla.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.recicla.app.model.TipoReciclajeModel;

public interface TipoReciclajeService {
	
	/**
	 * Metodo para obtener todos los tipos de reciclaje
	 * @return
	 */
	public List<TipoReciclajeModel> getAllTipoReciclaje();
	
	/**
	 * Metodo para obtener un tipo de reciclaje por id
	 * @param id
	 * @return
	 */
	public TipoReciclajeModel getTipoReciclaje (Long id);
	
	/**
	 * Metodo para actualizar un tipo de reciclaje
	 * @param TipoReciclajeModel
	 * @return
	 */
	public TipoReciclajeModel updateTipoReciclaje (TipoReciclajeModel tipoReciclajeModel);
	

	/**
	 * Metodo para crear un tipo de reciclaje
	 */
	public TipoReciclajeModel saveTipoReciclaje(TipoReciclajeModel tipoReciclajeModel);
	
	/**
	 * Metodo para eliminar un tipo de reciclaje
	 * @param id
	 * @return
	 */
	public boolean deleteTipoReciclaje(Long id); 
	
}
