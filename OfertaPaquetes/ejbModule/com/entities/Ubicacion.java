package com.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion implements Serializable {
	
	private String Calle;
	private Integer Nro;
	private Float Logitud;
	private Float Latitud;
	
	//ver si necesitamos mas datos de la ubicacion o con esto es suficiente

	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public Integer getNro() {
		return Nro;
	}
	public void setNro(Integer nro) {
		Nro = nro;
	}
	public Float getLogitud() {
		return Logitud;
	}
	public void setLogitud(Float logitud) {
		Logitud = logitud;
	}
	public Float getLatitud() {
		return Latitud;
	}
	public void setLatitud(Float latitud) {
		Latitud = latitud;
	}
	
	
	
}
