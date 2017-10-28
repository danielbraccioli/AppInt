package com.session.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dto.DestinoDTO;
import com.dto.FotoDTO;
import com.dto.MedioDePagoDTO;
import com.dto.OfertaPaqueteDTO;
import com.dto.ServicioDTO;
import com.dto.UbicacionDTO;
import com.entities.Foto;
import com.entities.MedioDePago;
import com.entities.OfertaPaquete;
import com.entities.Servicio;

/**
 * Session Bean implementation class AdmOfertas
 */
@Stateless
@LocalBean
public class AdmOfertas implements AdmOfertasRemote {

	@PersistenceContext(unitName="MyPU")
	   private EntityManager manager;
	
    public AdmOfertas() {
        // TODO Auto-generated constructor stub
    }
    
    public void altaPaquete(OfertaPaquete oferta){

       	
    	try{
    		manager.persist(oferta);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes() {
		try {
			Query q = manager.createQuery("Select o from OfertaPaquete o");
			List<OfertaPaquete> oferta = (List<OfertaPaquete>) q.getResultList();
			ArrayList<OfertaPaqueteDTO> ofertasD = new ArrayList<OfertaPaqueteDTO>();

			for (OfertaPaquete o : oferta) {
				OfertaPaqueteDTO ofertaD = new OfertaPaqueteDTO();
				ofertaD.setCantidadPersonas(o.getCantidadPersonas());
				ofertaD.setCupo(o.getCupo());
				ofertaD.setDescripcion(o.getDescripcion());
				
				DestinoDTO destinoD = new DestinoDTO();
				destinoD.setIdDestino(o.getDestino().getIdDestino());
				destinoD.setNombre(o.getDestino().getNombre());
				
				UbicacionDTO ubicacionD = new UbicacionDTO();
				ubicacionD.setCalle(o.getDestino().getUbicacion().getCalle());
				ubicacionD.setLatitud(o.getDestino().getUbicacion().getLatitud());
				ubicacionD.setLogitud(o.getDestino().getUbicacion().getLatitud());
				ubicacionD.setNro(o.getDestino().getUbicacion().getNro());
				
				destinoD.setUbicacion(ubicacionD);
															
				ofertaD.setDestino(destinoD);
				
				ofertaD.setEstado(o.getEstado());
				ofertaD.setFechaRegreso(o.getFechaRegreso());
				ofertaD.setFechaSalida(o.getFechaSalida());
				
				ArrayList<FotoDTO> fotosD = new ArrayList<FotoDTO>();
				for (Foto f: o.getFotos()){
					FotoDTO fotoD = new FotoDTO();
					fotoD.setIdFoto(f.getIdFoto());
					fotosD.add(fotoD);
				}
				ofertaD.setFotos(fotosD);
				
				ofertaD.setIdPaquete(o.getIdPaquete());
				
				
				ArrayList<MedioDePagoDTO> mediosD = new ArrayList<MedioDePagoDTO>();
				for(MedioDePago m: o.getMediosDePagos()){
					MedioDePagoDTO medioD = new MedioDePagoDTO();
					medioD.setIdMP(m.getIdMP());
					medioD.setNombre(m.getNombre());
					mediosD.add(medioD);
					
				}
				ofertaD.setMediosDePagos(mediosD);
				
				ofertaD.setNombre(o.getNombre());
				
				ofertaD.setPoliticaCancelacion(o.getPoliticaCancelacion());
				ofertaD.setPrecioXPersona(o.getPrecioXPersona());
				
				
				ArrayList<ServicioDTO> serviciosD = new ArrayList<ServicioDTO>();
				for(Servicio s: o.getServicios()){
					ServicioDTO servicioD = new ServicioDTO();
					servicioD.setDescripcion(s.getDescripcion());
					servicioD.setIdServicio(s.getIdServicio());
					serviciosD.add(servicioD);
					
					
				}
				ofertaD.setServicios(serviciosD);
				
				ofertasD.add(ofertaD);
			}
			
			return ofertasD;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}
    

}
