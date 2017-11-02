package com.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dto.AgenciaDTO;
import com.dto.DestinoDTO;
import com.dto.MedioDePagoDTO;
import com.dto.OfertaPaqueteDTO;
import com.dto.ServicioDTO;
import com.entities.Agencia;
import com.entities.Destino;

import com.entities.MedioDePago;
import com.entities.OfertaPaquete;
import com.entities.Servicio;
import com.entities.Ubicacion;
import com.google.gson.Gson;
import com.mensajeria.OfertasProductor;
import com.session.beans.AdmAgenciasRemote;
import com.session.beans.AdmOfertasRemote;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
public class OfertaPaqueteFacade implements OfertaPaqueteFacadeRemote {

	@EJB
	AdmAgenciasRemote admAgencia;
	@EJB
	AdmOfertasRemote admOfertas;
	
	@EJB
	OfertasProductor ofertaProductor;

	@Override
	public void altaAgencia(AgenciaDTO agencia) {
		Agencia agenciaN = new Agencia();
		
		agenciaN.setDireccion(agencia.getDireccion());
		agenciaN.setEstado(agencia.getEstado());
		agenciaN.setId(agencia.getId());
		agenciaN.setMail(agencia.getMail());
		agenciaN.setNombre(agencia.getNombre());
		
		admAgencia.altaAgencia(agenciaN);
		
		Gson gson = new Gson();
	//	ofertaProductor.sendMessage(gson.toJson(agencia));
		
		
	}

	@Override
	public ArrayList<AgenciaDTO> recuperarAgencias() {
		
		return admAgencia.recuperarAgencias();
	}

	@Override
	public void altaPaquete(OfertaPaqueteDTO oferta) {
		
		OfertaPaquete ofertaN = new OfertaPaquete();
		
		ofertaN.setCantidadPersonas(oferta.getCantidadPersonas());
		ofertaN.setCupo(oferta.getCupo());
		ofertaN.setDescripcion(oferta.getDescripcion());
		
		Destino destinoN = admOfertas.recuperarDestino(oferta.getDestino().getIdDestino());
		ofertaN.setDestino(destinoN);
		
		ofertaN.setEstado(oferta.getEstado());
		ofertaN.setFechaRegreso(oferta.getFechaRegreso());
		ofertaN.setFechaSalida(oferta.getFechaSalida());
		
	
		ofertaN.setFoto(oferta.getFoto());
		
		ofertaN.setIdPaquete(oferta.getIdPaquete());
	
		
	//  buscar medios de pago
		ArrayList<MedioDePago> medioPagoN = new ArrayList<MedioDePago>();
		for(MedioDePagoDTO m: oferta.getMediosDePagos()){
			MedioDePago mN = admOfertas.recuperarMedio(m.getIdMP());
			medioPagoN.add(mN);
		}
		
		ofertaN.setMediosDePagos(medioPagoN);
		ofertaN.setNombre(oferta.getNombre());
		ofertaN.setPoliticaCancelacion(oferta.getPoliticaCancelacion());
		ofertaN.setPrecioXPersona(oferta.getPrecioXPersona());
		
	//  buscar servicios
		ArrayList<Servicio> serviciosN = new ArrayList<Servicio>();
		for(ServicioDTO s: oferta.getServicios()){
			Servicio sN = admOfertas.recuperarServicio(s.getIdServicio());
			serviciosN.add(sN);
		}
		
		
		ofertaN.setServicios(serviciosN);
		
		Agencia agenciaN = admAgencia.recuperarAgencia(oferta.getAgencia().getId());
		
		ofertaN.setAgencia(agenciaN);
		
		
		admOfertas.altaPaquete(ofertaN);
	//	ofertaProductor.sendMessage("Prueba");
		
	}

	@Override
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes() {
		return admOfertas.recuperarPaquetes();
	}

	@Override
	public void altaMedios(List<MedioDePagoDTO> medios) {
		for (MedioDePagoDTO m : medios){
			MedioDePago medioN = new MedioDePago();
			medioN.setNombre(m.getNombre());
			admOfertas.altaMedios(medioN);
		}
	}

	@Override
	public void altaServicios(List<ServicioDTO> servicios) {
		for (ServicioDTO s : servicios){
			Servicio servicioN = new Servicio();
			servicioN.setDescripcion(s.getDescripcion());
			admOfertas.altaServicio(servicioN);
		}
	}

	@Override
	public void altaDestinos(List<DestinoDTO> destinos) {
		for (DestinoDTO d : destinos){
			Destino destinoN = new Destino();
			destinoN.setNombre(d.getNombre());
			Ubicacion ubicacionN = new Ubicacion();
			ubicacionN.setLatitud(d.getUbicacion().getLatitud());
			ubicacionN.setLogitud(d.getUbicacion().getLogitud());
			destinoN.setUbicacion(ubicacionN);
			admOfertas.altaDestino(destinoN);
		}
		
	}

	@Override
	public List<MedioDePagoDTO> recuperarMedios() {
		return admOfertas.recuperarMedios();
	}

	@Override
	public List<ServicioDTO> recuperarServicios() {
		return admOfertas.recuperarServicios();
	}

	@Override
	public List<DestinoDTO> recuperarDestinos() {
		return admOfertas.recuperarDestinos();
	}
     
}
