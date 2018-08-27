package edu.recicla.app.model;

import javax.validation.constraints.NotNull;

public class TipsModel {
	
	private Long id;
	
	@NotNull(message="El campo descripcion no puede ser nulo")
	private String descripcion;
	
	private String imagen;
	
	@NotNull(message="El campo titulo no puede ser nulo")
	private String titulo;
	
	private String imagenUrl;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagenUrl() {
		return imagenUrl;
	}
	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}
	
}
