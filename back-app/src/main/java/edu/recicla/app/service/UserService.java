package edu.recicla.app.service;

import java.util.List;

import com.recicla.app.enums.TipoUsuario;

import edu.recicla.app.model.UsuarioModel;

public interface UserService {
	public List<UsuarioModel> getAllUsuario();
	public UsuarioModel saveUsuario(UsuarioModel usuarioModel, TipoUsuario tipo);
	public UsuarioModel getUsuario(Long id);
	public UsuarioModel getUsuario(String correo);
	public UsuarioModel updateUsuario(UsuarioModel usuarioModel);
	public boolean deleteUsuario(Long usuario);
	public boolean activateUsuario(Long usuario,String accion);
}
