package BD;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.controlador.OfertaPaqueteFacadeRemote;
import com.dto.*;

public class Controlador {
	
	
	@EJB
	private OfertaPaqueteFacadeRemote ofertaFacade;
	private static Controlador instancia;

	public static Controlador getInstancia() throws NamingException {
		if (instancia == null) {
			instancia = new Controlador();
		}
		return instancia;
	}

	public Controlador() throws NamingException {
		InitialContext initialContext = new InitialContext();
		ofertaFacade = (OfertaPaqueteFacadeRemote) initialContext
				.lookup("java:global/OfertaPaqueteWeb/OfertaPaqueteFacade!com.controlador.OfertaPaqueteFacadeRemote");
	
		altaMedios();
		altaServicios();
		altaDestinos();
	
	
	}
	
	
	public void agregarAgencia(AgenciaDTO agencia) {
		ofertaFacade.altaAgencia(agencia);
	}

	public void agregarOferta(OfertaPaqueteDTO oferta) {
		ofertaFacade.altaPaquete(oferta);
	}
	
	
	public List<AgenciaDTO> recuperarAgencias() {
		return ofertaFacade.recuperarAgencias();
	}

	public List<OfertaPaqueteDTO> recuperarOfertas() {
		return ofertaFacade.recuperarPaquetes();
	}
	
	public void altaMedios(){
		
		List<MedioDePagoDTO> medios = new ArrayList<MedioDePagoDTO>();
		MedioDePagoDTO medio1 = new MedioDePagoDTO();
			medio1.setNombre("EFECTIVO");
		medios.add(medio1);
		
		MedioDePagoDTO medio2 = new MedioDePagoDTO();
			medio2.setNombre("VISA");
		medios.add(medio2);
		
		MedioDePagoDTO medio3 = new MedioDePagoDTO();
			medio3.setNombre("MASTER");
		medios.add(medio3);
		
		ofertaFacade.altaMedios(medios);
	}
	
	public void altaServicios(){
		
		List<ServicioDTO> servicios = new ArrayList<ServicioDTO>();
		ServicioDTO servicio1 = new ServicioDTO();
			servicio1.setDescripcion("Wifi");
		servicios.add(servicio1);
		
		ServicioDTO servicio2 = new ServicioDTO();
			servicio2.setDescripcion("Pisina");
		servicios.add(servicio2);
		
		ServicioDTO servicio3 = new ServicioDTO();
			servicio3.setDescripcion("Gimnasio");
		servicios.add(servicio3);
		
		ServicioDTO servicio4 = new ServicioDTO();
			servicio4.setDescripcion("Spa");
		servicios.add(servicio4);
		
		ofertaFacade.altaServicios(servicios);
	}
	
	public void altaDestinos(){
		
		List<DestinoDTO> destinos = new ArrayList<DestinoDTO>();
		DestinoDTO destino = new DestinoDTO();
			destino.setNombre("Camboriu");
			UbicacionDTO ubicacion = new UbicacionDTO();
			ubicacion.setLatitud(-26.9905600);
			ubicacion.setLogitud(-48.6347200);
			destino.setUbicacion(ubicacion);
		destinos.add(destino);
		
		DestinoDTO destino2 = new DestinoDTO();
		destino2.setNombre("Cancun");
			UbicacionDTO ubicacion2 = new UbicacionDTO();
			ubicacion2.setLatitud(21.1742900);
			ubicacion2.setLogitud(-86.8465600);
		destino2.setUbicacion(ubicacion2);
		destinos.add(destino2);

		
		ofertaFacade.altaDestinos(destinos);
	}

	public List<MedioDePagoDTO> recuperarMedios() {
		// TODO Auto-generated method stub
		return ofertaFacade.recuperarMedios();
	}

	public List<ServicioDTO> recuperarServicios() {
		// TODO Auto-generated method stub
		return ofertaFacade.recuperarServicios();
	}

	public List<DestinoDTO> recuperarDestinos() {
		// TODO Auto-generated method stub
		return ofertaFacade.recuperarDestinos();
	}



}
