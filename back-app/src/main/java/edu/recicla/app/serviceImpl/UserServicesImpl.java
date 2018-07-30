package edu.recicla.app.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recicla.app.enums.EstadoUsuario;
import com.recicla.app.enums.TipoUsuario;
import edu.recicla.app.entity.Usuario;
import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.repository.UsuarioRepository;
import edu.recicla.app.service.UserService;

@Service
public class UserServicesImpl implements UserService{
	
	@Autowired
	UsuarioRepository userRepository;

	


	@Override
	public UsuarioModel saveUsuario(UsuarioModel usuarioModel, TipoUsuario tipo){
		Usuario u= new Usuario();
		u.setNombre(usuarioModel.getNombre());
		u.setApellidos(usuarioModel.getApellidos());
		u.setCorreo(usuarioModel.getCorreo());
		String pass=DigestUtils.md5Hex(usuarioModel.getPassword());
		u.setPassword(pass);
		u.setPuntos(Long.valueOf("0"));
		u.setEstadoUsuario(EstadoUsuario.ACTIVE);
		u.setTipoUsuario(tipo);
		 List<Usuario> listaCoreos=  userRepository.findByCorreo(u.getCorreo());
		 if(!listaCoreos.isEmpty()) {
			 u= userRepository.save(u);
		     usuarioModel.setId(u.getId());
		 }else {
			 throw new 	IllegalArgumentException("Existe un usuario con el mismo correo");
		 }
		return usuarioModel;
	}




	@Override
	public List<UsuarioModel> getAllUsuario() {
	Iterator<Usuario> usuarios= userRepository.findAll().iterator();
	List<UsuarioModel> lisUsuarioModel= new ArrayList<UsuarioModel>();
	 while(usuarios.hasNext()) {
		 Usuario usuario=usuarios.next();
		 UsuarioModel usuarioModel= new UsuarioModel();
		 usuarioModel.setNombre(usuario.getNombre());
		 usuarioModel.setApellidos(usuario.getApellidos());
		 usuarioModel.setCorreo(usuario.getCorreo());
		 usuarioModel.setId(usuario.getId());
		 usuarioModel.setPuntos(usuario.getPuntos());
		 usuarioModel.setTipoUsuario(usuario.getTipoUsuario());
		 lisUsuarioModel.add(usuarioModel);
     }
		return lisUsuarioModel;
	}




	@Override
	public UsuarioModel getUsuario(Long id) {
		 Optional<Usuario> listUsuario= userRepository.findById(id);
		 UsuarioModel  usuarioModel=null;
		  if(listUsuario.isPresent()){
			 usuarioModel= new UsuarioModel();
			 Usuario usuario=listUsuario.get();
			 usuarioModel.setApellidos(usuario.getApellidos());
			 usuarioModel.setCorreo(usuario.getCorreo());
			 usuarioModel.setId(usuario.getId());
			 usuarioModel.setNombre(usuario.getNombre());
			 usuarioModel.setPuntos(usuario.getPuntos());
			 usuarioModel.setTipoUsuario(usuario.getTipoUsuario());
		 }
		return usuarioModel;
	}




	@Override
	public UsuarioModel getUsuario(String correo) {
		 List<Usuario> listUsuario= userRepository.findByCorreo(correo);
		 UsuarioModel  usuarioModel=null;
		 if(listUsuario.size()==1) {
			 usuarioModel= new UsuarioModel();
			 Usuario usuario=listUsuario.get(0);
			 usuarioModel.setApellidos(usuario.getApellidos());
			 usuarioModel.setCorreo(usuario.getCorreo());
			 usuarioModel.setId(usuario.getId());
			 usuarioModel.setNombre(usuario.getNombre());
			 usuarioModel.setPuntos(usuario.getPuntos());
			 usuarioModel.setTipoUsuario(usuario.getTipoUsuario());
		 }
		return usuarioModel;
	}




	@Override
	public UsuarioModel updateUsuario(UsuarioModel usuarioModel) {
		UsuarioModel usuarioModelResponse= null;
		 Optional<Usuario> listUsuario= userRepository.findById(usuarioModel.getId());
		 if(listUsuario.isPresent()){
			 Usuario usuario=listUsuario.get();
			 usuario.setNombre(usuarioModel.getNombre());
			 usuario.setApellidos(usuarioModel.getApellidos());
			 List<Usuario> listaCoreos=  userRepository.findByCorreo(usuario.getCorreo());
			 if(!listaCoreos.isEmpty()) {
				 usuario= userRepository.save(usuario);
				 usuarioModelResponse = new UsuarioModel();
				 usuarioModelResponse.setApellidos(usuario.getApellidos());
				 usuarioModelResponse.setCorreo(usuario.getCorreo());
				 usuarioModelResponse.setId(usuario.getId());
				 usuarioModelResponse.setNombre(usuario.getNombre());
				 usuarioModelResponse.setPuntos(usuario.getPuntos());
			 }else {
				 throw new 	IllegalArgumentException("Existe un usuario con el mismo correo");
			 }
		 }
		return usuarioModelResponse;
	}




	@Override
	public boolean deleteUsuario(Long id) {
		 Optional<Usuario> listUsuario= userRepository.findById(id);
		 if(listUsuario.isPresent()){
			 Usuario usuario=listUsuario.get();
		 }
		return false;
	}




	@Override
	public boolean activateUsuario(Long id, String accion) {
		 Optional<Usuario> listUsuario= userRepository.findById(id);
		 if(listUsuario.isPresent()){
			 Usuario usuario=listUsuario.get();
		 }
		return false;
	}
	
	
	
	
	

}
