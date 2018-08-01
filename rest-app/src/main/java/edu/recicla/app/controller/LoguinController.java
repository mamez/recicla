package edu.recicla.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recicla.app.security.JobGreenSecurityExeption;

import edu.recicla.app.model.LoguinModel;
import edu.recicla.app.model.TokenModel;
import edu.recicla.app.service.LoguinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/oauth/token")
@Api(description="Puntos de recoleccion")
public class LoguinController {
	
	private static final Logger log = LoggerFactory.getLogger(LoguinController.class);


	@Autowired
	LoguinService loguinService;
	
	@PostMapping
	@ApiOperation(value = "Autenticacion",
    notes = "Metodo para atenticar usuarios")
	public TokenModel loguin(@RequestBody @Valid LoguinModel loguinModel) throws JobGreenSecurityExeption {
		log.debug("Ingreso al metodo tal las variables"+loguinModel.toString());
		TokenModel tokenModel=null;
		try {
			tokenModel=loguinService.autenticar(loguinModel.getUser(), loguinModel.getPassword());
		} catch (JobGreenSecurityExeption e) {
			throw e;
		}
		return tokenModel;
	}
	
}
