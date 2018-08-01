package edu.recicla.app.controller;
import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.recicla.app.security.JobGreenExeption;

import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.DocType;
import edu.recicla.app.service.DocService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/resourcess/images")
@Api(description="Upload images")
public class UploadImagesController {
	
	@Autowired
	DocService docService;
	
	@RequestMapping(value="/upload/{tipo}", method=RequestMethod.POST)
	@ApiOperation(value = "Upload",
    notes = "Metodo para Guardar una imagen")
	public ResponseEntity<DocModel> uploadImage(@RequestPart(value="file", required=true) MultipartFile file,
			@PathVariable @NotNull DocType tipo) throws JobGreenExeption {
		if(file != null) {
			try {
				DocModel dm= new DocModel();
				dm.setTipo(file.getContentType());
				dm.setLength(file.getSize());
				dm.setImagen(file.getBytes());
				dm.setTipoDocumento(tipo);
				DocModel resp=docService.saveImage(dm);
				return new ResponseEntity<DocModel>(resp,HttpStatus.CREATED);
			} catch (IOException e) {
				throw new JobGreenExeption("Error crear la imaegen");
			}
		}
		
		
	return null;
	}
	
	@ApiOperation(value = "Upload",
		    notes = "Metodo para obtener una imagen",produces="image/jpeg")
	@GetMapping(value="/{name}", produces= MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImagen(@PathVariable @NotNull String name) throws JobGreenExeption{
		try {
		return docService.getImage(name).getImagen();
		} catch (Exception e) {
			throw new JobGreenExeption("Error crear la imaegen");
		}
	}
	
	
	

}
