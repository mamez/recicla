package edu.recicla.app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.recicla.app.entity.ImagenRepositoy;
import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.DocType;
import edu.recicla.app.repository.DocRepository;
import edu.recicla.app.service.DocService;

@Service
public class DocServiceImpl implements DocService {
	
	@Autowired
	DocRepository imagen;
	
	/* Metodo para obtener una imagen por id 
	 * (non-Javadoc)
	 * @see edu.recicla.app.service.DocService#getImage(long)
	 */
	@Override
	public DocModel getImage(long id) {
		DocModel model= null;
		Optional<ImagenRepositoy> optionalImage =imagen.findById(id);
		if(optionalImage.isPresent()){
			ImagenRepositoy img=optionalImage.get();
			model=new DocModel();
			model.setId(img.getId());
			model.setNombre(img.getNombre());
			model.setImagen(img.getImagen());
			model.setTipo(img.getTipo());
			model.setUrl(img.getUrl());
		}
		return model;
	}
	
	
    /*Metodo para obtener una imagen por el nombre
     * (non-Javadoc)
     * @see edu.recicla.app.service.DocService#getImage(java.lang.String)
     */
	@Override
	public DocModel getImage(String name) {
		DocModel model=null;
		List<ImagenRepositoy> imagenres =imagen.findByNombre(name);
		if(imagenres.size() > 0) {
			model= new DocModel();
			ImagenRepositoy img=imagenres.get(0);
			model.setId(img.getId());
			model.setNombre(img.getNombre());
			model.setImagen(img.getImagen());
			model.setTipo(img.getTipo());
			model.setUrl(img.getUrl());
		}
		return model;
	}
	
	/*
	 * Metodo para eliminar una imageb
	 */
	@Override
	public void deleteImage(long id) {
		try {
		boolean existe=imagen.existsById(id);
		if(existe) {
			imagen.deleteById(id);
		}
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void deleteIsEstateInit() {
		imagen.deleteAllEstateInit(Long.valueOf(0));
		
	}


	/*Merodo para guardar una imagen
	 * (non-Javadoc)
	 * @see edu.recicla.app.service.DocService#saveImage(edu.recicla.app.model.DocModel)
	 */
	@Override
	public DocModel saveImage(DocModel model) {
		ImagenRepositoy img= new ImagenRepositoy();
		img.setImagen(model.getImagen());
		img.setTipo(model.getTipo());
		img.setLength(model.getLength());
		String nombre=getNombre(model.getTipoDocumento());
		String extencion=getExtencion(model.getTipo());
		img.setNombre(nombre+"."+extencion);
		img.setUrl("/resourcess/images/"+img.getNombre());
		img.setEstado(Long.valueOf("0"));
		img=imagen.save(img);
		model.setImagen(new byte[] {});
		model.setNombre(img.getNombre());
		model.setUrl(img.getUrl());
		model.setId(img.getId());
		return model;
	}
	
	/*Metodo para actualizar el estado de una imagen a el de asociado
	 * (non-Javadoc)
	 * @see edu.recicla.app.service.DocService#updateStateImage(java.lang.String)
	 */
	@Override
	public void updateStateImage(String name) {
		List<ImagenRepositoy> imagenres =imagen.findByNombre(name);
		if(imagenres.size() > 0) {
			ImagenRepositoy img=imagenres.get(0);
			img.setEstado(Long.valueOf(1));
			imagen.save(img);
		}
	}
	
	/*Eliminar imagen por nombre
	 * (non-Javadoc)
	 * @see edu.recicla.app.service.DocService#deleteImagenByName(java.lang.String)
	 */
	@Override
	public void deleteImagenByName(String name) {
		imagen.deleteImagenByNombre(name);
	}

	
	
   private String getExtencion(String tipo) {
	   String[] arrString=tipo.split("/");
	   return arrString[1];
   }
	
	
	private String getNombre(DocType tipo) {
		String pattern = "ssmmMMddyyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		String nombre=format.format(new Date());
		return tipo.getTipo()+nombre;
	}


	

}
