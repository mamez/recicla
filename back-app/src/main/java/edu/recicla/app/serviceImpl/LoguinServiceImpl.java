package edu.recicla.app.serviceImpl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recicla.app.enums.EstadoUsuario;
import com.recicla.app.security.JobGreenSecurityExeption;
import com.recicla.app.security.JwtConfig;

import edu.recicla.app.entity.Usuario;
import edu.recicla.app.model.TokenModel;
import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.repository.UsuarioRepository;
import edu.recicla.app.service.LoguinService;

@Service
public class LoguinServiceImpl implements LoguinService {
	
	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	JwtConfig jwtConfig;

	@Override
	public TokenModel autenticar(String user, String pass) throws  JobGreenSecurityExeption{
		TokenModel token=null;
		try {
			List<Usuario> listUsuario=userRepository.findByCorreo(user);
			int cantidadUsuario=listUsuario.size();
			if(cantidadUsuario == 1) {
				Usuario usuario=listUsuario.get(0);
				String encriptMD5=DigestUtils.md5Hex(pass);
				if(usuario.getPassword().equals(encriptMD5) && ( usuario.getEstadoUsuario() == EstadoUsuario.ACTIVE)) {
					UsuarioModel u=new UsuarioModel();
					u.setNombre(usuario.getNombre());
					u.setApellidos(usuario.getApellidos());
					u.setCorreo(usuario.getCorreo());
					u.setId(usuario.getId());
					u.setTipoUsuario(usuario.getTipoUsuario());
					String tokenJwt=jwtConfig.getToken(u);
					token= new TokenModel();
					token.setToken(tokenJwt);
				}else if(usuario.getEstadoUsuario() == EstadoUsuario.LOCKED || (usuario.getEstadoUsuario() == EstadoUsuario.LOCKED_TEMPORARY)) {
					throw new JobGreenSecurityExeption("El usuario se encuentra bloqueado consulte el administrador del sistema");
				}else {
					throw new JobGreenSecurityExeption("password no valido");
				}
			}else {
				throw new JobGreenSecurityExeption("Usuario no existe");
			}
		}catch (JobGreenSecurityExeption e) {
			throw e;
		}catch (Exception e) {
			throw new JobGreenSecurityExeption(e.getMessage());
		}
		return token;
	}

	@Override
	public String verificar(String token) throws JobGreenSecurityExeption{
		try {
			UsuarioModel u=new UsuarioModel();
			u=jwtConfig.verificarToken(token);
			token=jwtConfig.getToken(u);
		}catch (NullPointerException e) {
			throw new JobGreenSecurityExeption("Error Authorization es invalido");
		}catch (Exception e) {
			throw new JobGreenSecurityExeption("Error al validar Authorization");
		}
		return token;
	}

}
