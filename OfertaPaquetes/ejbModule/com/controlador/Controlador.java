package com.controlador;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entities.Agencia;
import com.entities.OfertaPaquete;

/**
 * Session Bean implementation class Controlador
 */
@Stateless
@LocalBean
public class Controlador implements ControladorRemote, ControladorLocal {

	@PersistenceContext(unitName="MyPU")
	   private EntityManager manager;

    public Controlador() {
        // TODO Auto-generated constructor stub
    }

    public String sayHello(String name) {
    	return "Hello " + name;
    }
    
    public void altaAgencia(){
    	Agencia agencia = new Agencia();
    	
    	agencia.setDireccion("Indep 1234");
    	agencia.setEstado("inactiva");
    	agencia.setMail("mail@prueba.com");
    	agencia.setNombre("Prueba");
    	
    	try{
    		manager.persist(agencia);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
    }
    
    public void altaPaquete(){
    	OfertaPaquete oferta = new OfertaPaquete();
    	
       	
    	try{
    		manager.persist(oferta);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		System.out.println("Conectando a " + e.getMessage());
    	}
    }
    
}
