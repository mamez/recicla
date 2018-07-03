package edu.recicla.app.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.recicla.app.entity.Usuario;
import edu.recicla.app.repository.UserRepository;
import edu.recicla.app.service.UserService;

@Service
public class UserServicesImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	
	public void getUsuario() {
		Usuario u= new Usuario();
		u.setName("mario");
		u.setEmail("sss");
		userRepository.save(u);
	}

}
