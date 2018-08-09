package edu.recicla.app.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class PuntoCriticoModel {
	
	@ApiModelProperty(notes="Id del pinto critoco",required=false)
	private Long id;

	
	@ApiModelProperty(notes="Descripción del tipo de reciclaje",required=false)
	private String estado;

	
	@ApiModelProperty(notes="Fecha de recoleccion puesta por el administrado",required=false)
	private String fechaRecoleccion;

	@ApiModelProperty(notes="Fecha en la que se realizo el reporte",required=false)
	private String fechaReporte;

	@NotNull(message="El campo imagen es requerido")
	@ApiModelProperty(notes="nombre de la imagen del punto critico",required=true)
	private String imagen;

	@NotNull(message="El campo lat es requerido")
	@ApiModelProperty(notes="Latitud del reporte ",required=true)
	private String lat;

	@NotNull(message="El campo lng es equerido")
	@ApiModelProperty(notes="longitud del reporte",required=true)
	private String lng;
	
	@NotNull(message="El campo usuario es equerido")
	@ApiModelProperty(notes="Id del usuario que reporta el punto critico",required=true)
	private Long usuario;
	
	
	@ApiModelProperty(notes="Url de la imagen",required=false)
	private String UrlImagen;
	
	@ApiModelProperty(notes="Obserbacion de administrador",required=false)
	private String observacionAdmin;

	@NotNull(message="El campo observacionUser es equerido")
	@ApiModelProperty(notes="Obserbacion de usuario",required=true)
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

	public String getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public void setFechaRecoleccion(String fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public String getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
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

}
