package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.recicla.app.entity.PrPublico;
import edu.recicla.app.entity.PrUsuario;
import edu.recicla.app.entity.Usuario;
import edu.recicla.app.model.PrPublicoModel;
import edu.recicla.app.model.PrUsuarioModel;
import edu.recicla.app.model.UsuarioModel;
import edu.recicla.app.repository.PrUsuarioRepository;
import edu.recicla.app.service.PrUsuarioService;

public class PrUsuarioServiceImpl implements PrUsuarioService {
	
	@Autowired
	PrUsuarioRepository prUsuarioRepository;

	@Override
	public List<PrUsuarioModel> getAllPrUsuario() {
		List<PrUsuarioModel> resp= new ArrayList<PrUsuarioModel>();
		Iterator<PrUsuario> listPrUsuario=prUsuarioRepository.findAll().iterator();
		while(listPrUsuario.hasNext()){
			PrUsuario in=listPrUsuario.next();
			PrUsuarioModel prPublicoModel=new PrUsuarioModel();
			prPublicoModel.setId(in.getId());
			prPublicoModel.setNombre(in.getNombre());
			prPublicoModel.setLat(in.getLat());
			prPublicoModel.setLng(in.getLng());
				UsuarioModel usuariomodel=new UsuarioModel();
			    usuariomodel.setId(in.getUsuario().getId());
			    usuariomodel.setNombre(in.getUsuario().getNombre());
			    usuariomodel.setApellidos(in.getUsuario().getApellidos());
		    prPublicoModel.setUsuario( usuariomodel);
			resp.add(prPublicoModel);
		}
		return resp;
	}

	@Override
	public PrUsuarioModel getPrUsuario(Long id) {
		 PrUsuarioModel prPublicoModel=null;
		Optional<PrUsuario> prUsuario= prUsuarioRepository.findById(id);
		if(prUsuario.isPresent()) {
			PrUsuario in=prUsuario.get();
			prPublicoModel= new PrUsuarioModel();
			prPublicoModel.setId(in.getId());
			prPublicoModel.setNombre(in.getNombre());
			prPublicoModel.setLat(in.getLat());
			prPublicoModel.setLng(in.getLng());
				UsuarioModel usuariomodel=new UsuarioModel();
			    usuariomodel.setId(in.getUsuario().getId());
			    usuariomodel.setNombre(in.getUsuario().getNombre());
			    usuariomodel.setApellidos(in.getUsuario().getApellidos());
		    prPublicoModel.setUsuario( usuariomodel);			
		}
		return prPublicoModel;
	}

	@Override
	public PrUsuarioModel savePrUsuario(PrUsuarioModel prUsuarioModel) {
		PrUsuario prUsuario= new PrUsuario();
		prUsuario.setLat(prUsuarioModel.getLat());
		prUsuario.setLng(prUsuarioModel.getLng());
		prUsuario.setNombre(prUsuarioModel.getNombre());
		Usuario usuario= new Usuario();
		usuario.setId(prUsuarioModel.getUsuario().getId());
		prUsuario.setUsuario(usuario);
		prUsuario=prUsuarioRepository.save(prUsuario);
		prUsuarioModel.setId(prUsuario.getId());
		return prUsuarioModel;
	}

	@Override
	public PrUsuarioModel updatePrUsuario(PrUsuarioModel PrUsuarioModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePrUsuario(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
