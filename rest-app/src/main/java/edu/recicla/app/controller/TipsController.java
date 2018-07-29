package edu.recicla.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.recicla.app.model.TipsModel;
import edu.recicla.app.service.TipsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "Tips",authorizations= @Authorization(value = "Authorization"))
@RestController
@RequestMapping("/tips")
public class TipsController {
	
	@Autowired
	TipsService tipsService;
	

	@GetMapping
	@ApiOperation(value = "Obtener todos los tips",
    notes = "Servicio utilizado para obtener todos los tips de base de datos")
	public ResponseEntity<List<TipsModel>> getAllTips(){
		List<TipsModel> lista=tipsService.getAllTips();
		if(lista.isEmpty()) {
			return new ResponseEntity<List<TipsModel>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<TipsModel>>(lista,HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Obtener tips",
		    notes = "Servicio utilizado para obtener un tips por id")
	@GetMapping(value="/{id}")
	public ResponseEntity<TipsModel> getTip( @PathVariable(name="id") long id){
		TipsModel tip= tipsService.getTips(id);
		if(tip!=null) {
			return new ResponseEntity<TipsModel>(tip,HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Crear tips",
    notes = "Servicio utilizado crear un tips")
	public ResponseEntity<TipsModel> saveTips(@RequestBody @Valid TipsModel tip){
		tip=tipsService.saveTips(tip);
		if(tip!=null) {
			return new ResponseEntity<TipsModel>(tip,HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
