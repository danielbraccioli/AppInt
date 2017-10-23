package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="MediosPagos")
public class MedioDePago implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdMP;
	private String Nombre;
	public Integer getIdMP() {
		return IdMP;
	}
	public void setIdMP(Integer idMP) {
		IdMP = idMP;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	
}
