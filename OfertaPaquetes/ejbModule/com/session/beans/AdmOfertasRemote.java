package com.session.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.dto.OfertaPaqueteDTO;
import com.entities.OfertaPaquete;

@Remote
public interface AdmOfertasRemote {
	
	 public void altaPaquete(OfertaPaquete oferta);
	 public ArrayList<OfertaPaqueteDTO> recuperarPaquetes();

}
