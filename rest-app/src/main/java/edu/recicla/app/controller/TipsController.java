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

import edu.recicla.app.model.TipsModel;
import edu.recicla.app.service.TipsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="Tips")
@RestController
@RequestMapping("/tips")
public class TipsController {
	
	@Autowired
	TipsService tipsService;
	
	@GetMapping
	@ApiOperation(value = "Tips",
		    notes = "Metodo para obtener todos los tips")
	public ResponseEntity<List<TipsModel>> grtAll() throws JobGreenExeption{
		try {
			List<TipsModel> resp=tipsService.getAllTips();
			if(resp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<TipsModel>>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al listar Tips");
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Obtener Tips",
		    notes = "Metodo para obtener un tips")
	public ResponseEntity<TipsModel> getSingle(@PathVariable(name="id", required=true) Long id)
			throws JobGreenExeption{
		try {
			TipsModel resp=tipsService.getTips(id);
			if(resp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<TipsModel>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al obtener tl tips");
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Crear un tips",
    notes = "Metodo para Crear un tips")
	public ResponseEntity<TipsModel> save(@RequestBody @Valid TipsModel model)
			throws JobGreenExeption{
		try {
			TipsModel resp=tipsService.saveTips(model);
			if(resp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<TipsModel>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al crear el tips");
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar tips",
    notes = "Metodo para Crear un tips")
	public ResponseEntity<TipsModel> update(@RequestBody @Valid TipsModel model,
			@PathVariable(name="id", required=true) Long id) throws JobGreenExeption{
		try {
			model.setId(id);
			TipsModel resp=tipsService.updateTips(model);
			return new ResponseEntity<TipsModel>(resp,HttpStatus.OK);
		}catch (Exception e) {
			throw new JobGreenExeption("Error al actualizar tips");
		}
	}

	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar tips",
    notes = "Metodo para eliminar un tips")
	public ResponseEntity<?> delete(@PathVariable(name="id", required=true) Long id) 
			throws JobGreenExeption{
		try {
			tipsService.deleteTips(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			throw new JobGreenExeption("Error al eliminar tips");
		}
	}

}
