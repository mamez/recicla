package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.UsuarioModel;

public interface UserService {
	public List<UsuarioModel> getAllUsuario();
	public UsuarioModel saveUsuario(UsuarioModel usuarioModel, String tipo);
	public UsuarioModel getUsuario(Long id);
	public UsuarioModel getUsuario(String correo);
	public UsuarioModel updateUsuario(UsuarioModel usuarioModel);
	public boolean deleteUsuario(Long usuario);
	public boolean activateUsuario(Long usuario,String accion);
}
