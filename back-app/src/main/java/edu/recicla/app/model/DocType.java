package edu.recicla.app.model;

public enum DocType {
	TIPS_MODEL("TM"),
	PUNTOS_CRITICOS_MODEL("PCM"),
	PUNTOS_RECOLECCION_MODEL("PRM"),
	PUNTOS_RECOLECCION_PUBLICO_MODEL("PRPM");
	
	private String tipo;
	
	DocType(String tipo){
		this.tipo=tipo;
	}
	public String getTipo() {
		return this.tipo;
	}

}
