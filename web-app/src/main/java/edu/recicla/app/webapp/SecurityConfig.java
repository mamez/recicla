package edu.recicla.app.webapp;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class SecurityConfig {

	Algorithm algorithmHS = Algorithm.HMAC256("secret");
	int minutos=1;
	
	public String getToken() {
		String token=null;
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
			token = JWT.create()
				        .withIssuer("auth0")
				        .withExpiresAt(ObtenerFechaExp(minutos))
				        .withClaim("Nombre", "mario")
				        .sign(algorithm);
		} catch (JWTCreationException exception){
		    throw new SecurityException("Error de autenticacion");
		}
		return token;
	}
	
	public void verificarToken(String token) {
		try {
		    JWTVerifier verifier = JWT.require(algorithmHS)
		        .withIssuer("auth0")
		        .build(); //Reusable verifier instance
		    DecodedJWT jwt = verifier.verify(token);
		    
		} catch (JWTVerificationException exception){
			throw new SecurityException("Error de autenticacion");
		}
	}
	
	private Date ObtenerFechaExp(int minutos){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, minutos);	
		return calendar.getTime();    		
	 }
}
