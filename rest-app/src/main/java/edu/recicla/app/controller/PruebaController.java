package edu.recicla.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.recicla.app.service.UserService;

@RestController
public class PruebaController {
	
	@Autowired
	UserService user;
	
	@RequestMapping("/save")
	public String process(){
		user.getUsuario();
		return "Done";
	}
	
	@RequestMapping("/prueba")
	public String process1(){
		return "hola mario";
	}

}
