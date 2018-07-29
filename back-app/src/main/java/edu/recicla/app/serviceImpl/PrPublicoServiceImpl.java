package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.recicla.app.entity.PrPublico;
import edu.recicla.app.model.PrPublicoModel;
import edu.recicla.app.repository.PrPublicoRepository;
import edu.recicla.app.service.PrPublicoService;

@Service
public class PrPublicoServiceImpl implements PrPublicoService {
	
	@Autowired
	PrPublicoRepository prPublicoRepository; 
	

	@Override
	public List<PrPublicoModel> getAllPrPublico() {
		List<PrPublicoModel> resp= new ArrayList<PrPublicoModel>();
		Iterator<PrPublico> listPrPublico=prPublicoRepository.findAll().iterator();
		while(listPrPublico.hasNext()){
			PrPublico in=listPrPublico.next();
			PrPublicoModel prPublicoModel=new PrPublicoModel();
			prPublicoModel.setId(in.getId());
			prPublicoModel.setNombre(in.getNombre());
			prPublicoModel.setDescripcion(in.getDescripcion());
			prPublicoModel.setLat(in.getLat());
			prPublicoModel.setLng(in.getLng());
			resp.add(prPublicoModel);
		}
		return resp;
	}

	@Override
	public PrPublicoModel getPrPublico(Long id) {
		PrPublicoModel resp=null;
		Optional<PrPublico> prPublico= prPublicoRepository.findById(id);
		if(prPublico.isPresent()) {
			resp= new PrPublicoModel();
			PrPublico in=prPublico.get();
			resp.setId(in.getId());
			resp.setNombre(in.getNombre());
			resp.setDescripcion(in.getDescripcion());
			resp.setLat(in.getLat());
			resp.setLng(in.getLng());
		}
		return resp;
	}

	@Override
	public PrPublicoModel updatePrPublico(PrPublicoModel prPublicoModel) {
		PrPublico prPublico= new PrPublico();
		prPublico.setId(prPublicoModel.getId());
		prPublico.setNombre(prPublicoModel.getNombre());
		prPublico.setDescripcion(prPublicoModel.getDescripcion());
		prPublico.setLat(prPublicoModel.getLat());
		prPublico.setLng(prPublicoModel.getLng());
		prPublicoRepository.save(prPublico);
		return prPublicoModel;
	}

	@Override
	public boolean deletePrPublico(Long id) {
		if(prPublicoRepository.existsById(id)) {
			prPublicoRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public PrPublicoModel savePrPublico(PrPublicoModel prPublicoModel) {
		PrPublico prPublico= new PrPublico();
		prPublico.setNombre(prPublicoModel.getNombre());
		prPublico.setDescripcion(prPublicoModel.getDescripcion());
		prPublico.setLat(prPublicoModel.getLat());
		prPublico.setLng(prPublicoModel.getLng());
		prPublico=prPublicoRepository.save(prPublico);
		prPublicoModel.setId(prPublico.getId());
		return prPublicoModel;
	}

}
