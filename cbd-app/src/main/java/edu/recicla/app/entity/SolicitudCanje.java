package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the NewTable database table.
 * 
 */
@Entity
@Table(name="solicitud_canje")
public class SolicitudCanje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Long estado;

	@Column(name="factor_puntos")
	private Long factorPuntos;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="observacion_admin")
	private String observacionAdmin;

	@Column(name="punto_recoleccion")
	private Long puntoRecoleccion;

	//bi-directional many-to-one association to Promocion
	@ManyToOne()
	@JoinColumn(name="promocion")
	private Promocion promocion;

	//bi-directional many-to-one association to Usuario
	@ManyToOne()
	@JoinColumn(name="usuario")
	private Usuario usuario;

	public SolicitudCanje() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Long getFactorPuntos() {
		return this.factorPuntos;
	}

	public void setFactorPuntos(Long factorPuntos) {
		this.factorPuntos = factorPuntos;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacionAdmin() {
		return this.observacionAdmin;
	}

	public void setObservacionAdmin(String observacionAdmin) {
		this.observacionAdmin = observacionAdmin;
	}

	public Long getPuntoRecoleccion() {
		return this.puntoRecoleccion;
	}

	public void setPuntoRecoleccion(Long puntoRecoleccion) {
		this.puntoRecoleccion = puntoRecoleccion;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}