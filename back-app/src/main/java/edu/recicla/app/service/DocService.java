package edu.recicla.app.service;

import edu.recicla.app.model.DocModel;

public interface DocService {
	
	public DocModel saveImage(DocModel model);
	public void deleteImage(long id);
	public void deleteImagenByName(String name);
	public DocModel getImage(long id);
	public DocModel getImage(String name);
	public void updateStateImage(String name);
	public void deleteIsEstateInit();

}
