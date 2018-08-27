package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the tipo_reciclaje database table.
 * 
 */
@Entity
@Table(name="tipo_reciclaje")
public class TipoReciclaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String descripcion;

	@Column(name="factor_peso")
	private Long factorPeso;

	@Column(name="factor_puntos")
	private Long factorPuntos;

	private String nombre;

	//bi-directional many-to-one association to DetalleSolicitud
	@OneToMany(mappedBy="tipoReciclaje")
	private List<DetalleSolicitud> detalleSolicitud;

	public TipoReciclaje() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getFactorPeso() {
		return this.factorPeso;
	}

	public void setFactorPeso(Long factorPeso) {
		this.factorPeso = factorPeso;
	}

	public Long getFactorPuntos() {
		return this.factorPuntos;
	}

	public void setFactorPuntos(Long factorPuntos) {
		this.factorPuntos = factorPuntos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetalleSolicitud> getDetalleSolicitud() {
		return this.detalleSolicitud;
	}

	public void setDetalleSolicitud(List<DetalleSolicitud> detalleSolicitud) {
		this.detalleSolicitud = detalleSolicitud;
	}

	public DetalleSolicitud addDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		getDetalleSolicitud().add(detalleSolicitud);
		detalleSolicitud.setTipoReciclaje(this);

		return detalleSolicitud;
	}

	public DetalleSolicitud removeDetalleSolicitud(DetalleSolicitud detalleSolicitud) {
		getDetalleSolicitud().remove(detalleSolicitud);
		detalleSolicitud.setTipoReciclaje(null);

		return detalleSolicitud;
	}

}