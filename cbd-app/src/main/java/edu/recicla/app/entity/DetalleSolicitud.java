package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the detalle_solicitud database table.
 * 
 */
@Entity
@Table(name="detalle_solicitud")
public class DetalleSolicitud implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="factor_peso")
	private Long factorPeso;

	@Column(name="factor_punto")
	private Long factorPunto;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="total_puntos")
	private Long totalPuntos;

	//bi-directional many-to-one association to SolicitudRecoleccion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="solicitud")
	private SolicitudRecoleccion solicitudRecoleccion;

	//bi-directional many-to-one association to TipoReciclaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_reciclaje")
	private TipoReciclaje tipoReciclajeBean;

	public DetalleSolicitud() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFactorPeso() {
		return this.factorPeso;
	}

	public void setFactorPeso(Long factorPeso) {
		this.factorPeso = factorPeso;
	}

	public Long getFactorPunto() {
		return this.factorPunto;
	}

	public void setFactorPunto(Long factorPunto) {
		this.factorPunto = factorPunto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getTotalPuntos() {
		return this.totalPuntos;
	}

	public void setTotalPuntos(Long totalPuntos) {
		this.totalPuntos = totalPuntos;
	}

	public SolicitudRecoleccion getSolicitudRecoleccion() {
		return this.solicitudRecoleccion;
	}

	public void setSolicitudRecoleccion(SolicitudRecoleccion solicitudRecoleccion) {
		this.solicitudRecoleccion = solicitudRecoleccion;
	}

	public TipoReciclaje getTipoReciclajeBean() {
		return this.tipoReciclajeBean;
	}

	public void setTipoReciclajeBean(TipoReciclaje tipoReciclajeBean) {
		this.tipoReciclajeBean = tipoReciclajeBean;
	}

}