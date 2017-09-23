package com.controlador;

import javax.ejb.Remote;

@Remote
public interface ControladorRemote {

	public String sayHello(String name);
	public void altaAgencia();
	public void altaPaquete();
}
