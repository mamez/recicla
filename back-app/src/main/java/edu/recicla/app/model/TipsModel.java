package edu.recicla.app.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TipsModel {
	
	@ApiModelProperty(notes="Codigo del tips",required=false)
	private Long id;
	
	@NotNull(message="El campo descripcion no puede ser nulo")
	@ApiModelProperty(notes="Descripcion del tips",required=true)
	private String descripcion;
	
	@ApiModelProperty(notes="Nombre de la imagen guardada",required=true)
	private String imagen;
	
	@NotNull(message="El campo titulo no puede ser nulo")
	@ApiModelProperty(notes="Titulo del tips",required=true)
	private String titulo;
	
	@ApiModelProperty(notes="Url de la imagen para consultar desde navegador",required=false)
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
