package com.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

public class AgenciaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String Nombre;
	private String Direccion;
	private String Estado;
	private String Mail;
	private List<OfertaPaqueteDTO> Ofertas;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
//	public List<OfertaPaquete> getOfertas() {
//		return Ofertas;
//	}
//	public void setOfertas(List<OfertaPaquete> ofertas) {
//		Ofertas = ofertas;
//	}
	
	
}
