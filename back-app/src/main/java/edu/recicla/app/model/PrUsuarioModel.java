package edu.recicla.app.model;

import java.util.List;

public class PrUsuarioModel {
	private Long id;

	private String lat;

	private String lng;

	private String nombre;
	private UsuarioModel usuario;
	private List<SolicitudRecoleccionModel> solicitudRecoleccions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<SolicitudRecoleccionModel> getSolicitudRecoleccions() {
		return solicitudRecoleccions;
	}
	public void setSolicitudRecoleccions(List<SolicitudRecoleccionModel> solicitudRecoleccions) {
		this.solicitudRecoleccions = solicitudRecoleccions;
	}
	public UsuarioModel getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
}
