package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the des_catalogo database table.
 * 
 */
@Entity
@Table(name="des_catalogo")
public class DesCatalogo implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String descripcion;

	private Long indextabla;

	private String nombre;

	private String tabla;

	public DesCatalogo() {
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

	public Long getIndex() {
		return this.indextabla;
	}

	public void setIndex(Long index) {
		this.indextabla = index;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTable() {
		return this.tabla;
	}

	public void setTable(String table) {
		this.tabla = table;
	}

}