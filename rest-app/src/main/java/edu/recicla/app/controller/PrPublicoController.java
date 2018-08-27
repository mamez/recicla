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

import edu.recicla.app.model.PrPublicoModel;
import edu.recicla.app.service.PrPublicoService;

@RestController
@RequestMapping("/prPublico")
public class PrPublicoController {
	
	@Autowired
	PrPublicoService prPublicoService;
	
	@GetMapping
	public ResponseEntity<List<PrPublicoModel>> grtAll() throws JobGreenExeption{
		try {
			List<PrPublicoModel> resp=prPublicoService.getAllPrPublico();
			if(resp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<PrPublicoModel>>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al listar los puntos de recoleccion");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrPublicoModel> getSingle(@PathVariable(name="id", required=true) Long id)
			throws JobGreenExeption{
		try {
			PrPublicoModel resp=prPublicoService.getPrPublico(id);
			if(resp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<PrPublicoModel>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al listar los puntos de recoleccion");
		}
	}
	
	@PostMapping
	public ResponseEntity<PrPublicoModel> save(@RequestBody @Valid PrPublicoModel model)
			throws JobGreenExeption{
		try {
			PrPublicoModel resp=prPublicoService.savePrPublico(model);
			if(resp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<PrPublicoModel>(resp,HttpStatus.CREATED);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al crear punto de recoleccion");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PrPublicoModel> update(@RequestBody @Valid PrPublicoModel model,
			@PathVariable(name="id", required=true) Long id) throws JobGreenExeption{
		try {
			model.setId(id);
			PrPublicoModel resp=prPublicoService.updatePrPublico(model);
			return new ResponseEntity<PrPublicoModel>(resp,HttpStatus.OK);
		}catch (Exception e) {
			throw new JobGreenExeption("Error al actualizar punto de recoleccion");
		}
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id", required=true) Long id) 
			throws JobGreenExeption{
		try {
			prPublicoService.deletePrPublico(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			throw new JobGreenExeption("Error al eliminar punto de recoleccion");
		}
	}
}
