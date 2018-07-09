package edu.recicla.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recicla.app.security.JobGreenSecurityExeption;

import edu.recicla.app.model.LoguinModel;
import edu.recicla.app.model.TokenModel;
import edu.recicla.app.service.LoguinService;

@RestController
@RequestMapping("/oauth/token")
public class LoguinController {

	@Autowired
	LoguinService loguinService;
	
	@PostMapping
	public TokenModel loguin(@RequestBody @Valid LoguinModel loguinModel) throws JobGreenSecurityExeption {
		TokenModel tokenModel=null;
		try {
			tokenModel=loguinService.autenticar(loguinModel.getUser(), loguinModel.getPassword());
		} catch (JobGreenSecurityExeption e) {
			throw e;
		}
		return tokenModel;
	}
	
}
