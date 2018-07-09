package edu.recicla.app.service;

import com.recicla.app.security.JobGreenSecurityExeption;

import edu.recicla.app.model.TokenModel;

public interface LoguinService {
	public TokenModel autenticar(String user, String pass) throws JobGreenSecurityExeption;
	public String verificar(String token) throws JobGreenSecurityExeption;
}
