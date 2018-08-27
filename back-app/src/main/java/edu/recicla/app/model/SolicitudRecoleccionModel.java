package edu.recicla.app.model;

import java.util.Date;
import java.util.List;

public class SolicitudRecoleccionModel {
	private Long id;

	private String detalleUser;

	private String estadoRecoleccion;

	private Date fechaRecoleccion;

	private Date fechaSolicitud;

	private String observacionAdmin;

	private String pesoAprox;

	private List<DetalleSolicitudModel> detalleSolicituds;

	
	private PrUsuarioModel prUsuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDetalleUser() {
		return detalleUser;
	}


	public void setDetalleUser(String detalleUser) {
		this.detalleUser = detalleUser;
	}


	public String getEstadoRecoleccion() {
		return estadoRecoleccion;
	}


	public void setEstadoRecoleccion(String estadoRecoleccion) {
		this.estadoRecoleccion = estadoRecoleccion;
	}


	public Date getFechaRecoleccion() {
		return fechaRecoleccion;
	}


	public void setFechaRecoleccion(Date fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}


	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}


	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}


	public String getObservacionAdmin() {
		return observacionAdmin;
	}


	public void setObservacionAdmin(String observacionAdmin) {
		this.observacionAdmin = observacionAdmin;
	}


	public String getPesoAprox() {
		return pesoAprox;
	}


	public void setPesoAprox(String pesoAprox) {
		this.pesoAprox = pesoAprox;
	}


	public List<DetalleSolicitudModel> getDetalleSolicituds() {
		return detalleSolicituds;
	}


	public void setDetalleSolicituds(List<DetalleSolicitudModel> detalleSolicituds) {
		this.detalleSolicituds = detalleSolicituds;
	}


	public PrUsuarioModel getPrUsuario() {
		return prUsuario;
	}


	public void setPrUsuario(PrUsuarioModel prUsuario) {
		this.prUsuario = prUsuario;
	}
}
