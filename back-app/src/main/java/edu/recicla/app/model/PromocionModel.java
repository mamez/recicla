package edu.recicla.app.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class PromocionModel {
	
	@ApiModelProperty(notes="Codigo del tipo de promocion",required=false)
	private Long id;
	
	@NotNull(message="El campo descripcion es requerido")
	@ApiModelProperty(notes="Descripción del tipo de la promocion",required=true)
	private String descripcion;
	
	@NotNull(message="El campo factor puntos es requerido")
	@ApiModelProperty(notes="Cantidad de puntos a cambiar",required=true)
	private Long factorPuntos;
	
	@NotNull(message="La imagen de la promocion es requerida")
	@ApiModelProperty(notes="imagen de la promocion ",required=true)
	private String imagen;
	
	@NotNull(message="El titulo es requerido")
	@ApiModelProperty(notes="Titulo de la promocion ",required=true)	
	private String titulo;
	
	
	@ApiModelProperty(notes="url de la imagen",required=false)
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

	public Long getFactorPuntos() {
		return factorPuntos;
	}

	public void setFactorPuntos(Long factorPuntos) {
		this.factorPuntos = factorPuntos;
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
