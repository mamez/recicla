package edu.recicla.app.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loguin")
public class Loguin {

	@Autowired
	SecurityConfig securityConfig;
	
	@RequestMapping("/loguin")
	public String loguin() {
		return securityConfig.getToken();
	}
	
	
	@RequestMapping("/verificar/{token}")
	public void loguin2(@PathVariable("token") String id) {
		try {
		 securityConfig.verificarToken(id);
		}catch (SecurityException e) {
		 throw e;
		}
	}
}
