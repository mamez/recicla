package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.UsuarioModel;

public interface UserService {
	public List<UsuarioModel> getAllUsuario();
	public UsuarioModel saveUsuario(UsuarioModel usuarioModel, String tipo);
}
