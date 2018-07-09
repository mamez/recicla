package com.recicla.app.security;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.recicla.app.enums.TipoUsuario;

import edu.recicla.app.model.UsuarioModel;

@Component
public class JwtConfig {
	
	@Autowired
	private Environment env;
	private Algorithm algorithmHS = null;
	private int minutos=0;
	
	@PostConstruct
	public void init() {
		this.minutos=Integer.parseInt(env.getProperty("edu.recicla.env.timeToken", "30"));
		String secret= env.getProperty("edu.recicla.env.secretKey","jobgreen");
		this.algorithmHS=Algorithm.HMAC256(secret);
	}
	
	
	
	public String getToken(UsuarioModel usuario)  throws SecurityException {
		String token=null;
		try {
			token = JWT.create()
				        .withIssuer("auth0")
				        .withExpiresAt(ObtenerFechaExp(this.minutos))
				        .withClaim("nombre", usuario.getNombre())
				        .withClaim("apellidos", usuario.getApellidos())
				        .withClaim("id", usuario.getId())
				        .withClaim("correo", usuario.getCorreo())
				        .withClaim("tipo", usuario.getTipoUsuario().name())
				        .sign(this.algorithmHS);
		} catch (JWTCreationException exception){
		    throw new SecurityException("Error de autenticacion");
		}
		return token;
	}
	
	public UsuarioModel verificarToken(String token) throws SecurityException{
		UsuarioModel usuario;
		try {
		    JWTVerifier verifier = JWT.require(this.algorithmHS)
		        .withIssuer("auth0")
		        .build();
		    DecodedJWT jwt = verifier.verify(token);
		    usuario= new UsuarioModel();
		    Map<String, Claim> mapUser=jwt.getClaims();
		    usuario.setNombre(mapUser.get("nombre").asString());
		    usuario.setApellidos(mapUser.get("apellidos").asString());
		    usuario.setId(mapUser.get("id").asLong());
		    usuario.setCorreo(mapUser.get("correo").asString());
		    TipoUsuario tipo=TipoUsuario.valueOf(mapUser.get("tipo").asString());
		    usuario.setTipoUsuario(tipo);
		    return usuario;
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
