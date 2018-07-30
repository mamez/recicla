package edu.recicla.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.recicla.app.enums.TipoUsuario;
import com.recicla.app.security.JobGreenExeption;

import edu.recicla.app.model.DocType;
import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	

	@GetMapping
	@ApiOperation(value = "Users",
		    notes = "Metodo para obtener todos los usuarios")
	public ResponseEntity<List<UsuarioModel>> grtAll() throws JobGreenExeption{
		try {
			List<UsuarioModel> resp=userService.getAllUsuario();
			if(resp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<List<UsuarioModel>>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al listar los usuarios");
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Obtener usuario",
		    notes = "Metodo para obtener un usuario")
	public ResponseEntity<UsuarioModel> getSingle(@PathVariable(name="id", required=true) Long id)
			throws JobGreenExeption{
		try {
			UsuarioModel resp=userService.getUsuario(id);
			if(resp==null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<UsuarioModel>(resp,HttpStatus.OK);
			}
		}catch (Exception e) {
			throw new JobGreenExeption("Error al obtener el usuario");
		}
	}
	
	@PostMapping
	@ApiOperation(value = "Crear un usuario",
    notes = "Metodo para Crear un usuario")
	public ResponseEntity<UsuarioModel> save(@RequestBody @Valid UsuarioModel model,@PathVariable @NotNull TipoUsuario tipo)
			throws JobGreenExeption{
		try {
			UsuarioModel resp=userService.saveUsuario(model, tipo);
			return new ResponseEntity<UsuarioModel>(resp,HttpStatus.CREATED);
		}catch (IllegalArgumentException e) {
			throw e;
		}catch (Exception e) {
			throw new JobGreenExeption("Error al crear el usuario");
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar usuario",
    notes = "Metodo para actualizar un usuario")
	public ResponseEntity<UsuarioModel> update(@RequestBody @Valid UsuarioModel model,
			@PathVariable(name="id", required=true) Long id) throws JobGreenExeption{
		try {
			model.setId(id);
			UsuarioModel resp=userService.updateUsuario(model);
			return new ResponseEntity<UsuarioModel>(resp,HttpStatus.OK);
		}catch (IllegalArgumentException e) {
			throw e;
		}catch (Exception e) {
			throw new JobGreenExeption("Error al actualizar usuario");
		}
	}

	/*
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar usuario",
    notes = "Metodo para eliminar un usuario")
	public ResponseEntity<?> delete(@PathVariable(name="id", required=true) Long id) 
			throws JobGreenExeption{
		try {
			tipsService.deleteTips(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			throw new JobGreenExeption("Error al eliminar tips");
		}
	}*/
}
