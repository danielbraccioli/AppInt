package com.session.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entities.Agencia;

import com.dto.*;

/**
 * Session Bean implementation class AdmAgencias
 */
@Stateless
@LocalBean
public class AdmAgencias implements AdmAgenciasRemote {

	@PersistenceContext(unitName="MyPU")
	   private EntityManager manager;
	
	
    public AdmAgencias() {
        // TODO Auto-generated constructor stub
    }

    public void altaAgencia(Agencia agencia){
    	try{
    		manager.persist(agencia);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<AgenciaDTO> recuperarAgencias() {
		try {
			Query q = manager.createQuery("Select a from Agencia a");
			List<Agencia> agencia = (List<Agencia>) q.getResultList();
			ArrayList<AgenciaDTO> agencias = new ArrayList<AgenciaDTO>();

			for (Agencia a : agencia) {
				AgenciaDTO agenciaD = new AgenciaDTO();
				agenciaD.setDireccion(a.getDireccion());
				agenciaD.setEstado(a.getEstado());
				agenciaD.setId(a.getId());
				agenciaD.setMail(a.getMail());
				agenciaD.setNombre(a.getNombre());
				agencias.add(agenciaD);
			}
			
			return agencias;
		} catch (Exception e) {
			e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
		}
		return null;
	}
    
}
