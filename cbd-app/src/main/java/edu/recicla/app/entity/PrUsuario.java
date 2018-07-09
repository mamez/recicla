package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pr_usuario database table.
 * 
 */
@Entity
@Table(name="pr_usuario")
public class PrUsuario implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String lat;

	private String lng;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to SolicitudRecoleccion
	@OneToMany(mappedBy="prUsuario")
	private List<SolicitudRecoleccion> solicitudRecoleccions;

	public PrUsuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<SolicitudRecoleccion> getSolicitudRecoleccions() {
		return this.solicitudRecoleccions;
	}

	public void setSolicitudRecoleccions(List<SolicitudRecoleccion> solicitudRecoleccions) {
		this.solicitudRecoleccions = solicitudRecoleccions;
	}

	public SolicitudRecoleccion addSolicitudRecoleccion(SolicitudRecoleccion solicitudRecoleccion) {
		getSolicitudRecoleccions().add(solicitudRecoleccion);
		solicitudRecoleccion.setPrUsuario(this);

		return solicitudRecoleccion;
	}

	public SolicitudRecoleccion removeSolicitudRecoleccion(SolicitudRecoleccion solicitudRecoleccion) {
		getSolicitudRecoleccions().remove(solicitudRecoleccion);
		solicitudRecoleccion.setPrUsuario(null);

		return solicitudRecoleccion;
	}

}