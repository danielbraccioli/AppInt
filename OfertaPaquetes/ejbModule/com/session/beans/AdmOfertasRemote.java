package com.session.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.dto.*;
import com.entities.*;


@Remote
public interface AdmOfertasRemote {
	
	 public void altaPaquete(OfertaPaquete oferta);
	 public ArrayList<OfertaPaqueteDTO> recuperarPaquetes();


}
