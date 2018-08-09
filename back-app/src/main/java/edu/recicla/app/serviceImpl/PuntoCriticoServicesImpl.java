package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.recicla.app.entity.PuntosCritico;
import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.PuntoCriticoModel;
import edu.recicla.app.repository.PuntosCriticoRepository;
import edu.recicla.app.service.DocService;
import edu.recicla.app.service.PuntoCriticoServices;

public class PuntoCriticoServicesImpl implements PuntoCriticoServices {
	
	@Autowired
	PuntosCriticoRepository puntosCriticoRepository; 
	
	@Autowired
	DocService docService;

	@Override
	public List<PuntoCriticoModel> getAllPruntosCriticos() {
		List<PuntoCriticoModel> listResp= new ArrayList<PuntoCriticoModel>();
		Iterator<PuntosCritico> listIterator=puntosCriticoRepository.findAll().iterator();
		while (listIterator.hasNext()) {
			PuntosCritico punto= listIterator.next();
			PuntoCriticoModel model= new PuntoCriticoModel();
			model.setId(punto.getId());
			model.setEstado(punto.getEstado());
			model.setFechaRecoleccion(punto.getFechaRecoleccion());
			model.setFechaReporte(punto.getFechaReporte());
			model.setLat(punto.getLat());
			model.setLng(punto.getLng());
			model.setObservacionUser(punto.getObservacionUser());                                                                                                                    
			model.setObservacionAdmin(punto.getObservacionAdmin());
			model.setImagen(punto.getImagen());
			try {
				DocModel doc=docService.getImage(model.getImagen());
				model.setUrlImagen(doc.getUrl());
			}catch (Exception e) {
				model.setUrlImagen("url no encontrada");
			}
			listResp.add(model);
		}
		return listResp;
	}

	@Override
	public List<PuntoCriticoModel> getAllPruntosCriticosByUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuntoCriticoModel savePuntoCritico(PuntoCriticoModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuntoCriticoModel updatePuntoCritico(PuntoCriticoModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuntoCriticoModel updateEstatePuntoCritico(PuntoCriticoModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateEstatePuntoCritico(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
