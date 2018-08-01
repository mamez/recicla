package edu.recicla.app.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class TipoReciclajeModel {
	
	@ApiModelProperty(notes="Codigo del tipo de reciclaje",required=false)
	private Long id;
	
	@NotNull(message="El campo descripcion es requerido")
	@ApiModelProperty(notes="Descripción del tipo de reciclaje",required=true)
	private String descripcion;
	
	@NotNull(message="El campo factor peso es requerido es requerido")
	@ApiModelProperty(notes="Factor peso del tipo de reciclaje",required=true)
	private Long factorPeso;
	
	@NotNull(message="El campo factor punto es requerido es requerido")
	@ApiModelProperty(notes="Factor puntos del tipo de reciclaje",required=true)
	private Long factorPuntos;
	
	@NotNull(message="El campo nombre es requerido es requerido")
	@ApiModelProperty(notes="Factor nombre del tipo de reciclaje",required=true)
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
	public Long getFactorPeso() {
		return factorPeso;
	}
	public void setFactorPeso(Long factorPeso) {
		this.factorPeso = factorPeso;
	}
	public Long getFactorPuntos() {
		return factorPuntos;
	}
	public void setFactorPuntos(Long factorPuntos) {
		this.factorPuntos = factorPuntos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
