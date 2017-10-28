package com.controlador;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dto.AgenciaDTO;
import com.dto.FotoDTO;
import com.dto.MedioDePagoDTO;
import com.dto.OfertaPaqueteDTO;
import com.dto.ServicioDTO;
import com.entities.Agencia;
import com.entities.Destino;
import com.entities.Foto;
import com.entities.MedioDePago;
import com.entities.OfertaPaquete;
import com.entities.Servicio;
import com.entities.Ubicacion;
import com.mensajeria.OfertasProductor;
import com.session.beans.*;

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
		ofertaProductor.sendMessage("Estoy enviando algo");
		
		
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
		
		Destino destinoN = new Destino();
		destinoN.setIdDestino(oferta.getDestino().getIdDestino());
		destinoN.setNombre(oferta.getDestino().getNombre());
		Ubicacion ubicacionN = new Ubicacion();
		ubicacionN.setCalle(oferta.getDestino().getUbicacion().getCalle());
		ubicacionN.setLatitud(oferta.getDestino().getUbicacion().getLatitud());
		ubicacionN.setLogitud(oferta.getDestino().getUbicacion().getLogitud());
		ubicacionN.setNro(oferta.getDestino().getUbicacion().getNro());
		
		destinoN.setUbicacion(ubicacionN);
		
		
		ofertaN.setDestino(destinoN);
		
		ofertaN.setEstado(oferta.getEstado());
		ofertaN.setFechaRegreso(oferta.getFechaRegreso());
		ofertaN.setFechaSalida(oferta.getFechaSalida());
		
		ArrayList<Foto> fotosN = new ArrayList<Foto>();
		
		for(FotoDTO f: oferta.getFotos()){
			Foto fn = new Foto();
			fn.setIdFoto(f.getIdFoto());
			fotosN.add(fn);
		}
		
		ofertaN.setFotos(fotosN);
		
		ofertaN.setIdPaquete(oferta.getIdPaquete());
	
		ArrayList<MedioDePago> medioPagoN = new ArrayList<MedioDePago>();
		for(MedioDePagoDTO m: oferta.getMediosDePagos()){
			MedioDePago mN = new MedioDePago();
			mN.setIdMP(m.getIdMP());
			mN.setNombre(m.getNombre());
			medioPagoN.add(mN);
		}
		
		ofertaN.setMediosDePagos(medioPagoN);
		
		ofertaN.setNombre(oferta.getNombre());
		ofertaN.setPoliticaCancelacion(oferta.getPoliticaCancelacion());
		ofertaN.setPrecioXPersona(oferta.getPrecioXPersona());
		
		ArrayList<Servicio> serviciosN = new ArrayList<Servicio>();
		for(ServicioDTO s: oferta.getServicios()){
			Servicio sN = new Servicio();
			sN.setDescripcion(s.getDescripcion());
			sN.setIdServicio(s.getIdServicio());
			serviciosN.add(sN);
		}
		
		
		ofertaN.setServicios(serviciosN);
		
		admOfertas.altaPaquete(ofertaN);
		ofertaProductor.sendMessage("Prueba");
		
	}

	@Override
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes() {
	
		return admOfertas.recuperarPaquetes();
	}

	
   

    
}
