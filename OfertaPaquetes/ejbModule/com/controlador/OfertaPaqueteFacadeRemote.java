package com.controlador;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.dto.AgenciaDTO;
import com.dto.OfertaPaqueteDTO;

@Remote
public interface OfertaPaqueteFacadeRemote {
	
	public void altaAgencia(AgenciaDTO agencia);
	public ArrayList<AgenciaDTO> recuperarAgencias();
	public void altaPaquete(OfertaPaqueteDTO oferta);
	public ArrayList<OfertaPaqueteDTO> recuperarPaquetes();

}
