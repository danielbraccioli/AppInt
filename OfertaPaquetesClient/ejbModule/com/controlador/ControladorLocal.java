package com.controlador;

import javax.ejb.Local;

@Local
public interface ControladorLocal {

	public String sayHello(String name);
	public void altaAgencia();
	public void altaPaquete();
}
