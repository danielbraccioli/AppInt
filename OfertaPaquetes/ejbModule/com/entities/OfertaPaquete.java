package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="OfertaPaquete")
public class OfertaPaquete implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer IdPaquete;
	private String Nombre;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Destino",referencedColumnName="IdDestino")
	private Destino Destino;
	private Date FechaSalida;
	private Date FechaRegreso;
	private Float PrecioXPersona;
	private String PoliticaCancelacion;
	
 	@OneToMany
 	@JoinColumn(name="IdFoto")
 	private List<Foto> Fotos;
	
	private String Descripcion;
	
	@OneToMany
	@JoinColumn(name="IdServicio")
	private List<Servicio> Servicios;

	@OneToMany
	@JoinColumn(name="IdMP")
	private List<MedioDePago> MediosDePagos;
	
	private String Estado;
	private Integer Cupo;
	private Integer CantidadPersonas;
	
	public Integer getIdPaquete() {
		return IdPaquete;
	}
	public void setIdPaquete(Integer idPaquete) {
		IdPaquete = idPaquete;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Destino getDestino() {
		return Destino;
	}
	public void setDestino(Destino destino) {
		Destino = destino;
	}
	public Date getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public Date getFechaRegreso() {
		return FechaRegreso;
	}
	public void setFechaRegreso(Date fechaRegreso) {
		FechaRegreso = fechaRegreso;
	}
	public Float getPrecioXPersona() {
		return PrecioXPersona;
	}
	public void setPrecioXPersona(Float precioXPersona) {
		PrecioXPersona = precioXPersona;
	}
	public String getPoliticaCancelacion() {
		return PoliticaCancelacion;
	}
	public void setPoliticaCancelacion(String politicaCancelacion) {
		PoliticaCancelacion = politicaCancelacion;
	}
 	public List<Foto> getFotos() {
 		return Fotos;
 	}
 	public void setFotos(List<Foto> fotos) {
 		Fotos = fotos;
 	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
 	public List<Servicio> getServicios() {
 		return Servicios;
 	}
 	public void setServicios(List<Servicio> servicios) {
 		Servicios = servicios;
 	}
	public List<MedioDePago> getMediosDePagos() {
		return MediosDePagos;
	}
	public void setMediosDePagos(List<MedioDePago> mediosDePagos) {
		MediosDePagos = mediosDePagos;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public Integer getCupo() {
		return Cupo;
	}
	public void setCupo(Integer cupo) {
		Cupo = cupo;
	}
	public Integer getCantidadPersonas() {
		return CantidadPersonas;
	}
	public void setCantidadPersonas(Integer cantidadPersonas) {
		CantidadPersonas = cantidadPersonas;
	}
	
	
	
}
