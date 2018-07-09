package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the promocion database table.
 * 
 */
@Entity
public class Promocion implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String descripcion;

	@Column(name="factor_puntos")
	private Long factorPuntos;

	private String imagen;

	private String titulo;

	//bi-directional many-to-one association to NewTable
	@OneToMany(mappedBy="promocionBean")
	private List<SolicitudCanje> solicitudCanje;

	public Promocion() {
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

	public Long getFactorPuntos() {
		return this.factorPuntos;
	}

	public void setFactorPuntos(Long factorPuntos) {
		this.factorPuntos = factorPuntos;
	}

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<SolicitudCanje> getNewTables() {
		return this.solicitudCanje;
	}

	public void setNewTables(List<SolicitudCanje> newTables) {
		this.solicitudCanje = newTables;
	}

	public SolicitudCanje addNewTable(SolicitudCanje newTable) {
		getNewTables().add(newTable);
		newTable.setPromocionBean(this);

		return newTable;
	}

	public SolicitudCanje removeNewTable(SolicitudCanje newTable) {
		getNewTables().remove(newTable);
		newTable.setPromocionBean(null);

		return newTable;
	}

}