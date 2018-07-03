package edu.recicla.app.service;

import edu.recicla.app.model.DocModel;

public interface DocService {
	
	public long saveImage(DocModel model);
	public void delateImage(long id);
	public DocModel getImage(long id);

}
