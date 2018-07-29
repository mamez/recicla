package edu.recicla.app.model;

import java.io.Serializable;


public class DocModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String url;
	private String nombre;
	private String tipo;
	private byte[] imagen;
	private Long length;
	private DocType tipoDocumento;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public DocType getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(DocType tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
