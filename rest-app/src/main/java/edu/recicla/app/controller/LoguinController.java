package edu.recicla.app.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.recicla.app.request.model.UsuarioModel;

@RestController
@RequestMapping("/oauth/token")
public class LoguinController {

	
	
	@PostMapping
	public String loguin(@RequestBody @Valid UsuarioModel usuarioModel) {
		return "";
	}
	
}
