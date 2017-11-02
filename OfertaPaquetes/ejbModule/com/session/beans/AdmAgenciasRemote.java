package com.session.beans;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.dto.AgenciaDTO;
import com.entities.Agencia;

@Remote
public interface AdmAgenciasRemote {
	
	public void altaAgencia(Agencia agencia);
	public ArrayList<AgenciaDTO> recuperarAgencias();
	public Agencia recuperarAgencia(int clave);
}
