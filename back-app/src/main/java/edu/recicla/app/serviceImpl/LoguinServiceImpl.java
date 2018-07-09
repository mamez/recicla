package edu.recicla.app.serviceImpl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recicla.app.security.JwtConfig;

import edu.recicla.app.entity.Usuario;
import edu.recicla.app.repository.UserRepository;
import edu.recicla.app.request.model.UsuarioModel;
import edu.recicla.app.response.model.TokenModel;
import edu.recicla.app.service.LoguinService;

@Service
public class LoguinServiceImpl implements LoguinService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtConfig jwtConfig;

	@Override
	public TokenModel autenticar(String user, String pass) throws SecurityException{
		TokenModel token=null;
		try {
			List<Usuario> listUsuario=userRepository.findByCorreo(user);
			int cantidadUsuario=listUsuario.size();
			if(cantidadUsuario == 1) {
				Usuario usuario=listUsuario.get(0);
				String encriptMD5=DigestUtils.md5Hex(pass);
				if(usuario.getPassword().equals(encriptMD5)) {
					UsuarioModel u=new UsuarioModel();
					u.setNombre(usuario.getNombre());
					u.setApellidos(usuario.getApellidos());
					u.setCorreo(usuario.getCorreo());
					u.setId(usuario.getId());
					u.setTipoUsuario(usuario.getTipoUsuario());
					String tokenJwt=jwtConfig.getToken(u);
					token= new TokenModel();
					token.setToken(tokenJwt);
				}
			}
		}catch (SecurityException e) {
			throw e;
		}catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return token;
	}

	@Override
	public String verificar(String token) throws SecurityException{
		try {
			UsuarioModel u=new UsuarioModel();
			u=jwtConfig.verificarToken(token);
			token=jwtConfig.getToken(u);
		}catch (SecurityException e) {
			throw e;
		}catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return token;
	}

}
