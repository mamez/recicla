package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.recicla.app.entity.Tip;
import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.TipsModel;
import edu.recicla.app.repository.TipRepository;
import edu.recicla.app.service.DocService;
import edu.recicla.app.service.TipsService;

@Service
public class TipsServiceImpl implements TipsService {
	
	@Autowired
	TipRepository tipRepository;
	
	@Autowired
	DocService docService;

	@Override
	public List<TipsModel> getAllTips() {
		Iterator<Tip> tips= tipRepository.findAll().iterator();
		List<TipsModel> lisResp= new ArrayList<TipsModel>();
		while (tips.hasNext()) {
			Tip tip=tips.next();
			TipsModel resp= new TipsModel();
			resp.setId(tip.getId());
			resp.setTitulo(tip.getTitulo());
			resp.setDescripcion(tip.getDescripcion());
			resp.setImagen(tip.getImagen());
			DocModel model=docService.getImage(tip.getImagen());
    		    resp.setImagenUrl(model.getUrl());
			lisResp.add(resp);
		}
		return lisResp;
	}

	@Override
	public TipsModel getTips(Long id) {
		TipsModel resp=null;
	    Optional<Tip> tipOptional=tipRepository.findById(id);
	    if(tipOptional.isPresent()) {
	    		Tip tip=tipOptional.get();
	    		resp= new TipsModel();
	    		resp.setId(tip.getId());
	    		resp.setTitulo(tip.getTitulo());
	    		resp.setDescripcion(tip.getDescripcion());
	    		resp.setImagen(tip.getImagen());
	    		DocModel model=docService.getImage(tip.getImagen());
	    		resp.setImagenUrl(model.getUrl());
	    }
		return resp;
	}

	@Override
	public TipsModel saveTips(TipsModel model) {
		Tip tip= new Tip();
		tip.setTitulo(model.getTitulo());
		tip.setDescripcion(model.getDescripcion());
		String nombreImagen=docService.getImage(model.getImagen()).getNombre();
		if(nombreImagen.equals(model.getImagen())) {
			tip.setImagen(model.getImagen());
			docService.updateStateImage(model.getImagen());
			tipRepository.save(tip);
		}else {
			throw new IllegalArgumentException("La imagen enviada no existe en el repositorio de imagenes");
		}
		tip=tipRepository.save(tip);
		
		TipsModel resp= new TipsModel();
		resp.setId(tip.getId());
		resp.setTitulo(tip.getTitulo());
		resp.setDescripcion(tip.getDescripcion());
		resp.setImagen(tip.getImagen());
		
		return resp;
	}

	@Override
	public TipsModel updateTips(TipsModel model) {
		Optional<Tip> tipOptional=tipRepository.findById(model.getId());
		if(tipOptional.isPresent()) {
			Tip tip= tipOptional.get();
			tip.setTitulo(model.getTitulo());
			tip.setDescripcion(model.getDescripcion());
			String nombreImagen=docService.getImage(model.getImagen()).getNombre();
			if(nombreImagen.equals(model.getImagen())) {
				tip.setImagen(model.getImagen());
				tipRepository.save(tip);
			}else {
				throw new IllegalArgumentException("La imagen enviada no existe en el repositorio de imagenes");
			}
			
		}
		return model;
	}

	@Override
	public void deleteTips(Long id) {
		Optional<Tip> tipOptional= tipRepository.findById(id);
		if(tipOptional.isPresent()) {
			DocModel dm= docService.getImage(tipOptional.get().getImagen());
			docService.deleteImage(dm.getId());
			tipRepository.delete(tipOptional.get());
		}
		
	}

}
