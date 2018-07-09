package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitud_recoleccion database table.
 * 
 */
@Entity
@Table(name="solicitud_recoleccion")
public class SolicitudRecoleccion implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="detalle_user")
	private String detalleUser;

	@Column(name="estado_recoleccion")
	private String estadoRecoleccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_recoleccion")
	private Date fechaRecoleccion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;

	@Column(name="observacion_admin")
	private String observacionAdmin;

	@Column(name="peso_aprox")
	private String pesoAprox;

	//bi-directional many-to-one association to DetalleSolicitud
	@OneToMany(mappedBy="solicitudRecoleccion")
	private List<DetalleSolicitud> detalleSolicituds;

	//bi-directional many-to-one association to PrUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="punto_recoleccion")
	private PrUsuario prUsuario;

	public SolicitudRecoleccion() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetalleUser() {
		return this.detalleUser;
	}

	public void setDetalleUser(String detalleUser) {
		this.detalleUser = detalleUser;
	}

	public String getEstadoRecoleccion() {
		return this.estadoRecoleccion;
	}

	public void setEstadoRecoleccion(String estadoRecoleccion) {
		this.estadoRecoleccion = estadoRecoleccion;
	}

	public Date getFechaRecoleccion() {
		return this.fechaRecoleccion;
	}

	public void setFechaRecoleccion(Date fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getObservacionAdmin() {
		return this.observacionAdmin;
	}

	public void setObservacionAdmin(String observacionAdmin) {
		this.observacionAdmin = observacionAdmin;
	}

	public String getPesoAprox() {
		return this.pesoAprox;
	}

	public void setPesoAprox(String pesoAprox) {
		this.pesoAprox = pesoAprox;
	}

	public List<DetalleSolicitud> getDetalleSolicituds() {
		return this.detalleSolicituds;
	}

	public void setDetalleSolicituds(List<DetalleSolicitud> detalleSolicituds) {
		this.detalleSolicituds = detalleSolicituds;
	}

	public DetalleSolicitud addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		getDetalleSolicituds().add(detalleSolicitud);
		detalleSolicitud.setSolicitudRecoleccion(this);

		return detalleSolicitud;
	}

	public DetalleSolicitud removeDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		getDetalleSolicituds().remove(detalleSolicitud);
		detalleSolicitud.setSolicitudRecoleccion(null);

		return detalleSolicitud;
	}

	public PrUsuario getPrUsuario() {
		return this.prUsuario;
	}

	public void setPrUsuario(PrUsuario prUsuario) {
		this.prUsuario = prUsuario;
	}

}