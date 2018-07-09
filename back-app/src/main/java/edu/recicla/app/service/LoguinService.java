package edu.recicla.app.service;

import edu.recicla.app.response.model.TokenModel;

public interface LoguinService {
	public TokenModel autenticar(String user, String pass) throws SecurityException;
	public String verificar(String token) throws SecurityException;
}
