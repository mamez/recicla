package edu.recicla.app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.recicla.app.enums.TipoUsuario;
@JsonInclude(Include.NON_NULL)
public class UsuarioModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellidos;
	
	@NotNull
	private String correo;
	
	private String password;
	
	private Long puntos;
	
	
	private TipoUsuario tipoUsuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Long getPuntos() {
		return puntos;
	}
	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}
	
	
}
