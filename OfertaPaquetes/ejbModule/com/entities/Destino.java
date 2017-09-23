package com.entities;

import javax.persistence.*;

@Entity
@Table(name="Destinos")
public class Destino {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdDestino;
	private String Nombre;
	
	@Embedded 
 	private Ubicacion Ubicacion;
 	
	public Integer getIdDestino() {
		return IdDestino;
	}
	public void setIdDestino(Integer idDestino) {
		IdDestino = idDestino;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Ubicacion getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		Ubicacion = ubicacion;
	}
 	
 	
 	
}
