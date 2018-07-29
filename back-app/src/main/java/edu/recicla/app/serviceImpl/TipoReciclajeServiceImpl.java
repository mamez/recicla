package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.recicla.app.entity.TipoReciclaje;
import edu.recicla.app.model.TipoReciclajeModel;
import edu.recicla.app.repository.TipoReciclajeRepository;
import edu.recicla.app.service.TipoReciclajeService;


@Service
public class TipoReciclajeServiceImpl implements TipoReciclajeService {
	
	@Autowired
	TipoReciclajeRepository tipoReciclajeRepository;
	
	@Override
	public List<TipoReciclajeModel> getAllTipoReciclaje() {	
		List<TipoReciclajeModel> resp = new ArrayList<TipoReciclajeModel>();
		Iterator<TipoReciclaje> listTipoReciclaje = tipoReciclajeRepository.findAll().iterator();
		
		while(listTipoReciclaje.hasNext()) {
			TipoReciclaje in = listTipoReciclaje.next();
			TipoReciclajeModel tipoReciclajeModel = new TipoReciclajeModel();
			tipoReciclajeModel.setId(in.getId());
			tipoReciclajeModel.setDescripcion(in.getDescripcion());
			tipoReciclajeModel.setFactorPeso(in.getFactorPeso());
			tipoReciclajeModel.setFactorPuntos(in.getFactorPuntos());
			tipoReciclajeModel.setNombre(in.getNombre());
			resp.add(tipoReciclajeModel);
		}
		return resp;
	}

	@Override
	public TipoReciclajeModel getTipoReciclaje(Long id) {
		TipoReciclajeModel resp = null;
		Optional<TipoReciclaje> tipoReciclaje = tipoReciclajeRepository.findById(id);
		if(tipoReciclaje.isPresent()) {
			resp= new TipoReciclajeModel() ;
			TipoReciclaje in = tipoReciclaje.get();
			resp.setId(in.getId());
			resp.setNombre(in.getNombre());
			resp.setDescripcion(in.getDescripcion());
			resp.setFactorPuntos(in.getFactorPuntos());
			resp.setFactorPeso(in.getFactorPeso());
		}
		return resp;
	}

	@Override
	public TipoReciclajeModel updateTipoReciclaje(TipoReciclajeModel tipoReciclajeModel) {
		TipoReciclaje tipoReciclaje = new TipoReciclaje();
		tipoReciclaje.setId(tipoReciclajeModel.getId());
		tipoReciclaje.setNombre(tipoReciclajeModel.getNombre());
		tipoReciclaje.setDescripcion(tipoReciclajeModel.getDescripcion());
		tipoReciclaje.setFactorPuntos(tipoReciclajeModel.getFactorPuntos());
		tipoReciclaje.setFactorPeso(tipoReciclajeModel.getFactorPeso());
		tipoReciclajeRepository.save(tipoReciclaje);
		
		return tipoReciclajeModel;
	}

	@Override
	public boolean deleteTipoReciclaje(Long id) {
		if(tipoReciclajeRepository.existsById(id)) {
			tipoReciclajeRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public TipoReciclajeModel saveTipoReciclaje(TipoReciclajeModel tipoReciclajeModel) {
		TipoReciclaje tipoReciclaje = new TipoReciclaje();
		tipoReciclaje.setNombre(tipoReciclajeModel.getNombre());
		tipoReciclaje.setDescripcion(tipoReciclajeModel.getDescripcion());
		tipoReciclaje.setFactorPuntos(tipoReciclajeModel.getFactorPuntos());
		tipoReciclaje.setFactorPeso(tipoReciclajeModel.getFactorPeso());
		tipoReciclajeRepository.save(tipoReciclaje);
		
		return tipoReciclajeModel;
	}

}
