package edu.recicla.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recicla.app.security.JobGreenExeption;

import edu.recicla.app.model.TipoReciclajeModel;
import edu.recicla.app.service.TipoReciclajeService;

@RestController
@RequestMapping("/tipoReciclaje")
public class TipoReciclajeController {
	
	@Autowired
	TipoReciclajeService tipoReciclajeService;
	
	@GetMapping /*Mapealo como servicio rest*/
	public ResponseEntity<List<TipoReciclajeModel>> grtAll() throws JobGreenExeption{
		try {
			List<TipoReciclajeModel> resp= tipoReciclajeService.getAllTipoReciclaje();
			if(resp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<TipoReciclajeModel>>(resp,HttpStatus.OK);
			}
		}catch(Exception e){
			throw new JobGreenExeption("Error al listar los tipos de reciclaje");
		}
	}
	
	@GetMapping("/{id}") /*Mapealo como servicio rest*/
	
	public ResponseEntity<TipoReciclajeModel> getSingle(@PathVariable(name="id", required=true) Long id) throws JobGreenExeption{
		try {
			TipoReciclajeModel resp= tipoReciclajeService.getTipoReciclaje(id);
			if(resp == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 no hay contenido
			}else {
				return new ResponseEntity<TipoReciclajeModel>(resp,HttpStatus.OK); //pasa un OK
			}
		}catch(Exception e){
			throw new JobGreenExeption("Error al listar los tipos de reciclaje");
		}
	}
	
	@PostMapping 
	public ResponseEntity<TipoReciclajeModel> save(@RequestBody @Valid TipoReciclajeModel model)
			throws JobGreenExeption{
		try {
			TipoReciclajeModel resp= tipoReciclajeService.saveTipoReciclaje(model);
			if(resp == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 no hay contenido
			}else {
				return new ResponseEntity<TipoReciclajeModel>(resp,HttpStatus.CREATED); //pasa un OK
			}
		}catch(Exception e){
			throw new JobGreenExeption("Error al crear tipo de reciclaje");
		}
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<TipoReciclajeModel> update(@RequestBody @Valid TipoReciclajeModel model,
			@PathVariable(name="id", required=true) Long id)
			throws JobGreenExeption{
		try {
			model.setId(id);
			TipoReciclajeModel resp= tipoReciclajeService.updateTipoReciclaje(model);
			return new ResponseEntity<TipoReciclajeModel>(resp,HttpStatus.OK); //pasa un OK
			
		}catch(Exception e){
			throw new JobGreenExeption("Error al actualizar los tipos de reciclaje");
		}
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable(name="id", required=true) Long id)
			throws JobGreenExeption{
		try {
			tipoReciclajeService.deleteTipoReciclaje(id);
			return new ResponseEntity<>(HttpStatus.OK); //pasa un OK
			
		}catch(Exception e){
			throw new JobGreenExeption("Error al eliminar tipo de reciclaje");
		}
	}
}
