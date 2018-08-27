package edu.recicla.app.model;

public enum EstadoPc {
	PUNTO_CRITICO_REPORTADO("1"),
	PUNTO_CRITICO_ATENDIDO("2");
	
	private String estado;
	
	EstadoPc(String estado){
		this.estado=estado;
	}
	
	public String getEstado() {
		return this.estado;
	}

}
