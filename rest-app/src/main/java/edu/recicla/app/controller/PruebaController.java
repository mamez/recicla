package edu.recicla.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.recicla.app.service.UserService;

@RestController
@RequestMapping("/loguin2")
public class PruebaController {
	
	@Autowired
	UserService user;
	
	

}
