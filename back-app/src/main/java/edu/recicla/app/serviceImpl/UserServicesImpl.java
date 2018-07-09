package edu.recicla.app.serviceImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recicla.app.enums.TipoUsuario;
import edu.recicla.app.entity.Usuario;
import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.repository.UserRepository;
import edu.recicla.app.service.UserService;

@Service
public class UserServicesImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	


	@Override
	public UsuarioModel saveUsuario(UsuarioModel usuarioModel, String tipo) {
		Usuario u= new Usuario();
		u.setNombre(usuarioModel.getNombre());
		u.setApellidos(usuarioModel.getApellidos());
		u.setCorreo(usuarioModel.getCorreo());
		String pass=DigestUtils.md5Hex(usuarioModel.getPassword());
		u.setPassword(pass);
		u.setPuntos(Long.valueOf("0"));
		TipoUsuario tipoUsuario= tipo.equals("USER")? TipoUsuario.USER_MOBILE : TipoUsuario.USER_ADMIN;
		u.setTipoUsuario(tipoUsuario);
		u= userRepository.save(u);
		usuarioModel.setId(u.getId());
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
	
	
	
	
	

}
