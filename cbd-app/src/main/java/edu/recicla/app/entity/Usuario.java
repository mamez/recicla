package edu.recicla.app.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.recicla.app.enums.EstadoUsuario;
import com.recicla.app.enums.TipoUsuario;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
public class Usuario implements Serializable {
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String apellidos;

	private String correo;

	private String nombre;

	private String password;

	private Long puntos;

	//bi-directional many-to-one association to NewTable
	@OneToMany(mappedBy="usuarioBean")
	private List<SolicitudCanje> solicitudCanje;

	//bi-directional many-to-one association to PrUsuario
	@OneToMany(mappedBy="usuarioBean")
	private List<PrUsuario> prUsuarios;

	//bi-directional many-to-one association to PuntosCritico
	@OneToMany(mappedBy="usuarioBean")
	private List<PuntosCritico> puntosCriticos;

	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_usuario")
	private EstadoUsuario estadoUsuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	public Usuario() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<SolicitudCanje> getNewTables() {
		return this.solicitudCanje;
	}

	public void setNewTables(List<SolicitudCanje> newTables) {
		this.solicitudCanje = newTables;
	}

	public SolicitudCanje addNewTable(SolicitudCanje newTable) {
		getNewTables().add(newTable);
		newTable.setUsuarioBean(this);

		return newTable;
	}

	public SolicitudCanje removeNewTable(SolicitudCanje newTable) {
		getNewTables().remove(newTable);
		newTable.setUsuarioBean(null);

		return newTable;
	}

	public List<PrUsuario> getPrUsuarios() {
		return this.prUsuarios;
	}

	public void setPrUsuarios(List<PrUsuario> prUsuarios) {
		this.prUsuarios = prUsuarios;
	}

	public PrUsuario addPrUsuario(PrUsuario prUsuario) {
		getPrUsuarios().add(prUsuario);
		prUsuario.setUsuarioBean(this);

		return prUsuario;
	}

	public PrUsuario removePrUsuario(PrUsuario prUsuario) {
		getPrUsuarios().remove(prUsuario);
		prUsuario.setUsuarioBean(null);

		return prUsuario;
	}

	public List<PuntosCritico> getPuntosCriticos() {
		return this.puntosCriticos;
	}

	public void setPuntosCriticos(List<PuntosCritico> puntosCriticos) {
		this.puntosCriticos = puntosCriticos;
	}

	public PuntosCritico addPuntosCritico(PuntosCritico puntosCritico) {
		getPuntosCriticos().add(puntosCritico);
		puntosCritico.setUsuarioBean(this);

		return puntosCritico;
	}

	public PuntosCritico removePuntosCritico(PuntosCritico puntosCritico) {
		getPuntosCriticos().remove(puntosCritico);
		puntosCritico.setUsuarioBean(null);

		return puntosCritico;
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Long getPuntos() {
		return puntos;
	}

	public void setPuntos(Long puntos) {
		this.puntos = puntos;
	}

	public EstadoUsuario getEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}



}