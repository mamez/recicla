package edu.recicla.app.service;

import java.util.List;

import edu.recicla.app.model.TipsModel;

public interface TipsService {

	public List<TipsModel> getAllTips();
	public TipsModel getTips(Long id);
	public TipsModel saveTips(TipsModel model);
	public TipsModel updateTips(TipsModel model);
	public void deleteTips(Long id);
}
