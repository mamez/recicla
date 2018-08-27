package edu.recicla.app.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class PuntoCriticoModel {
	
	private Long id;

	
	private String estado;

	
	private Date fechaRecoleccion;

	private Date fechaReporte;

	@NotNull(message="El campo imagen es requerido")
	private String imagen;

	@NotNull(message="El campo lat es requerido")
	private double lat;

	@NotNull(message="El campo lng es equerido")
	private double lng;
	
	@NotNull(message="El campo usuario es equerido")
	private UsuarioModel usuario;
	
	
	private String UrlImagen;
	
	private String observacionAdmin;

	@NotNull(message="El campo observacionUser es equerido")
	private String observacionUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public String getUrlImagen() {
		return UrlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		UrlImagen = urlImagen;
	}

	public String getObservacionAdmin() {
		return observacionAdmin;
	}

	public void setObservacionAdmin(String observacionAdmin) {
		this.observacionAdmin = observacionAdmin;
	}

	public String getObservacionUser() {
		return observacionUser;
	}

	public void setObservacionUser(String observacionUser) {
		this.observacionUser = observacionUser;
	}

	public Date getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public void setFechaRecoleccion(Date fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public Date getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	

}
