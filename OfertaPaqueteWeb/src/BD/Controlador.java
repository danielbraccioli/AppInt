package BD;

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
				.lookup("global/OfertaPaquetesEAR/OfertaPaquetes/OfertaPaqueteFacade!com.controlador.OfertaPaqueteFacadeRemote");
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



}
