package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puntos_criticos database table.
 * 
 */
@Entity
@Table(name="puntos_criticos")
public class PuntosCritico implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String estado;

	@Column(name="fecha_recoleccion")
	private String fechaRecoleccion;

	@Column(name="fecha_reporte")
	private String fechaReporte;

	private String imagen;

	private String lat;

	private String lng;

	@Column(name="observacion_admin")
	private String observacionAdmin;

	@Column(name="observacion_user")
	private String observacionUser;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	public PuntosCritico() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaRecoleccion() {
		return this.fechaRecoleccion;
	}

	public void setFechaRecoleccion(String fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public String getFechaReporte() {
		return this.fechaReporte;
	}

	public void setFechaReporte(String fechaReporte) {
		this.fechaReporte = fechaReporte;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
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

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}