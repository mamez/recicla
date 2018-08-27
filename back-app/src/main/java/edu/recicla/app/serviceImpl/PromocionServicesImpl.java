package edu.recicla.app.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.recicla.app.entity.Promocion;
import edu.recicla.app.model.DocModel;
import edu.recicla.app.model.PromocionModel;
import edu.recicla.app.repository.PromocionRepository;
import edu.recicla.app.service.DocService;
import edu.recicla.app.service.PromocionServices;

public class PromocionServicesImpl implements PromocionServices {
	
	@Autowired
	PromocionRepository promocionRepository;
	

	@Autowired
	DocService docService;

	@Override
	public List<PromocionModel> getAllPromociones() {
		List<PromocionModel> listResp= new ArrayList<PromocionModel>();
		Iterator<Promocion> listPromocion= promocionRepository.findAll().iterator();
		while(listPromocion.hasNext()) {
			Promocion promocion=listPromocion.next();
			PromocionModel model= new PromocionModel();
			model.setId(promocion.getId());
			model.setTitulo(promocion.getTitulo());
			model.setDescripcion(promocion.getDescripcion());
			model.setFactorPuntos(promocion.getFactorPuntos());
			model.setImagen(promocion.getImagen());
			try {
				String url=docService.getImage(model.getImagen()).getUrl();
				model.setImagenUrl(url);
			}catch (Exception e) {
				model.setImagenUrl("imagen no encontrada");
			}
			listResp.add(model);
		}
		return listResp;
	}

	@Override
	public PromocionModel getPromocion(Long id) {
		PromocionModel resp=null;
		Optional<Promocion> optionalpromocion= promocionRepository.findById(id);
		if(optionalpromocion.isPresent()) {
			Promocion promocion= optionalpromocion.get();
			resp=new PromocionModel();
			resp.setId(promocion.getId());
			resp.setTitulo(promocion.getTitulo());
			resp.setDescripcion(promocion.getDescripcion());
			resp.setFactorPuntos(promocion.getFactorPuntos());
			resp.setImagen(promocion.getImagen());
			try {
				String url=docService.getImage(resp.getImagen()).getUrl();
				resp.setImagenUrl(url);
			}catch (Exception e) {
				resp.setImagenUrl("imagen no encontrada");
			}
		
		}
		return resp;
	}

	@Override
	public PromocionModel updatePromocion(PromocionModel promocionModel) {
		Optional<Promocion> optionalpromocion= promocionRepository.findById(promocionModel.getId());
		if(optionalpromocion.isPresent()) {
			Promocion promocion= optionalpromocion.get();
			promocion.setTitulo(promocionModel.getTitulo());
			promocion.setDescripcion(promocionModel.getDescripcion());
			promocion.setFactorPuntos(promocionModel.getFactorPuntos());
			promocionRepository.save(promocion);
		}
		return promocionModel;
	}

	@Override
	public PromocionModel savePromocion(PromocionModel promocionModel) {
		Promocion promocion= new Promocion();
		promocion.setTitulo(promocionModel.getTitulo());
		promocion.setDescripcion(promocionModel.getDescripcion());
		promocion.setFactorPuntos(promocionModel.getFactorPuntos());
		promocion.setImagen(promocionModel.getImagen());
		try {
			DocModel doc=docService.getImage(promocionModel.getImagen());
			docService.updateStateImage(doc.getNombre());
			promocionModel.setImagenUrl(doc.getUrl());
		}catch (Exception e) {
			promocionModel.setImagenUrl("imagen no encontrada");
		}
		promocion=promocionRepository.save(promocion);
		promocionModel.setId(promocion.getId());
		return promocionModel;
	}

	@Override
	public boolean deletePromocion(Long id) {
		Optional<Promocion> optionalpromocion= promocionRepository.findById(id);
		if(optionalpromocion.isPresent()) {
			Promocion promocion=optionalpromocion.get();
			try {
			docService.deleteImagenByName(promocion.getImagen());
			}catch (Exception e) {
				System.out.println("no se pudo borrar la imagen");
			}
			promocionRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
