package edu.recicla.app.controller;
import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.DocType;
import edu.recicla.app.service.DocService;
@RestController
@RequestMapping("/resource/images")
public class UploadImagesController {
	
	@Autowired
	DocService docService;
	
	@RequestMapping(value="/upload/{tipo}", method=RequestMethod.POST)
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,@PathVariable @NotNull String tipo) {
		if(file != null) {
			try {
				DocModel dm= new DocModel();
				dm.setTipo(file.getContentType());
				dm.setLength(file.getSize());
				dm.setImagen(file.getBytes());
				dm.setTipoDocumento(DocType.TIPS_MODEL);
				docService.saveImage(dm);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	return null;
	}
	
	@GetMapping(value="/{name}", produces=MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImagen(@PathVariable @NotNull String name) throws IOException{
		String nameOriginal=name.split("\\.")[0];
		return docService.getImage(nameOriginal).getImagen();
	}
	
	
	

}
