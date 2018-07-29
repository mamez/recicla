package edu.recicla.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class PrPublicoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes="Codigo del punto de recoleccion",required=false)
	private Long id;
	
	@NotNull
	@ApiModelProperty(notes="Descripcion de el punto de recoleccion",required=true)
	private String descripcion;
	
	@NotNull
	@ApiModelProperty(notes="Latitud de el punto de recoleccion",required=true)
	private String lat;
	
	@NotNull
	@ApiModelProperty(notes="Longitud de el punto de recoleccion",required=true)
	private String lng;
	
	@NotNull
	@ApiModelProperty(notes="Nombre de el punto de recoleccion",required=true)
	private String nombre;
	
	
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
}
