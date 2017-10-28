package com.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fotos")
public class Foto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdFoto;

	public Integer getIdFoto() {
		return IdFoto;
	}

	public void setIdFoto(Integer idFoto) {
		IdFoto = idFoto;
	}
	
	//ha y que definir el tipo de objeto Foto
	
	
}
