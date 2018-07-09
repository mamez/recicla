package edu.recicla.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioModel>> getAllUser(){
		List<UsuarioModel> listaUsuario=userService.getAllUsuario();
		return new ResponseEntity<List<UsuarioModel>>(listaUsuario,HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/{tipo}" ,method = RequestMethod.POST)
	public ResponseEntity<UsuarioModel> saveUser(@RequestBody @Valid UsuarioModel usuarioModel,@PathVariable String tipo ){
		UsuarioModel UsuarioModel=userService.saveUsuario(usuarioModel, tipo);
		return new ResponseEntity<UsuarioModel>(UsuarioModel,HttpStatus.OK);	
	}
}
