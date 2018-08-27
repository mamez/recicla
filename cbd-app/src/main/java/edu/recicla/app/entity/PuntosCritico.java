package edu.recicla.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.recicla.app.enums.EstadoPuntoRecoleccion;

import edu.recicla.app.repository.JsonDateSerializer;


/**
 * The persistent class for the puntos_criticos database table.
 * 
 */
@Entity
@Table(name="puntos_criticos")
public class PuntosCritico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private EstadoPuntoRecoleccion estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recoleccion")
	@JsonSerialize(using=JsonDateSerializer.class) 
	private java.util.Date fechaRecoleccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reporte")
	@JsonSerialize(using=JsonDateSerializer.class) 
	private java.util.Date fechaReporte;

	private String imagen;

	private String lat;

	private String lng;
	
	private String direccion;

	@Column(name="observacion_admin")
	private String observacionAdmin;

	@Column(name="observacion_user")
	private String observacionUser;

	//bi-directional many-to-one association to Usuario
	@ManyToOne()
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	@PrePersist
    public void prePersist() {
        this.estado= EstadoPuntoRecoleccion.EN_PROCESO;
        this.fechaReporte = new Date();
    }
	
	@PreUpdate()
	public void preUpdate() {
		this.fechaRecoleccion= new Date();
	}

	public PuntosCritico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	

	public String getObservacionAdmin() {
		return this.observacionAdmin;
	}

	public void setObservacionAdmin(String observacionAdmin) {
		this.observacionAdmin = observacionAdmin;
	}

	public String getObservacionUser() {
		return this.observacionUser;
	}

	public void setObservacionUser(String observacionUser) {
		this.observacionUser = observacionUser;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	
	public java.util.Date getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public void setFechaRecoleccion(java.util.Date fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public java.util.Date getFechaReporte() {
		return fechaReporte;
	}

	public void setFechaReporte(java.util.Date fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public EstadoPuntoRecoleccion getEstado() {
		return estado;
	}

	public void setEstado(EstadoPuntoRecoleccion estado) {
		this.estado = estado;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	

}