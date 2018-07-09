package edu.recicla.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.recicla.app.entity.ImagenRepositoy;
import edu.recicla.app.model.DocModel;
import edu.recicla.app.repository.DocRepository;
import edu.recicla.app.service.DocService;

public class DocServiceImpl implements DocService {
	
	@Autowired
	DocRepository imagen;

	@Override
	public long saveImage(DocModel model) {
		ImagenRepositoy img= new ImagenRepositoy();
		img.setImagen(model.getImagen());
		img.setUrl(model.getUrl());
		img.setTipo(model.getTipo());
		img.setNombre(model.getNombre());
		img=imagen.save(img);
		return img.getId();
	}

	@Override
	public void delateImage(long id) {
		ImagenRepositoy img= new ImagenRepositoy();
		img.setId(id);
		imagen.delete(img);
	}

	@Override
	public DocModel getImage(long id) {
		Optional<ImagenRepositoy> imagenres =imagen.findById(Long.toString(id));
		ImagenRepositoy img= new ImagenRepositoy();
		img=imagenres.get();
		DocModel model= new DocModel();
		model.setId(img.getId());
		model.setNombre(img.getNombre());
		model.setImagen(img.getImagen());
		model.setTipo(img.getTipo());
		model.setUrl(img.getUrl());
		return model;
	}

}
