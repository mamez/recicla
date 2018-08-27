package edu.recicla.app.model;

import java.util.Date;

public class DetalleSolicitudModel {
	
	private Long id;

	
	private Long factorPeso;

	
	private Long factorPunto;

	
	private Date fecha;

	
	private Long totalPuntos;

	
	private SolicitudRecoleccionModel solicitudRecoleccion;

	
	private TipoReciclajeModel tipoReciclaje;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getFactorPeso() {
		return factorPeso;
	}


	public void setFactorPeso(Long factorPeso) {
		this.factorPeso = factorPeso;
	}


	public Long getFactorPunto() {
		return factorPunto;
	}


	public void setFactorPunto(Long factorPunto) {
		this.factorPunto = factorPunto;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Long getTotalPuntos() {
		return totalPuntos;
	}


	public void setTotalPuntos(Long totalPuntos) {
		this.totalPuntos = totalPuntos;
	}


	public SolicitudRecoleccionModel getSolicitudRecoleccion() {
		return solicitudRecoleccion;
	}


	public void setSolicitudRecoleccion(SolicitudRecoleccionModel solicitudRecoleccion) {
		this.solicitudRecoleccion = solicitudRecoleccion;
	}


	public TipoReciclajeModel getTipoReciclaje() {
		return tipoReciclaje;
	}


	public void setTipoReciclaje(TipoReciclajeModel tipoReciclaje) {
		this.tipoReciclaje = tipoReciclaje;
	}

}
