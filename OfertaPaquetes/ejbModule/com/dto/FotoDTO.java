package com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


public class FotoDTO implements Serializable{
	
	private Integer IdFoto;

	public Integer getIdFoto() {
		return IdFoto;
	}

	public void setIdFoto(Integer idFoto) {
		IdFoto = idFoto;
	}
	
	//ha y que definir el tipo de objeto Foto
	
	
}
