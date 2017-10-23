package Servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.*;

import BD.Controlador;

/**
 * Servlet implementation class Agencia
 */
@WebServlet("/AgenciaAlta")
public class AgenciaAlta extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgenciaAlta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AgenciaDTO agencia = new AgenciaDTO();
		
		agencia.setEstado("Pendiente");
		agencia.setMail("UAgency@agencia.com.ar");
		agencia.setNombre("UADE Agency");
		agencia.setDireccion("Independencia 1234");
		
		try {
			Controlador.getInstancia().agregarAgencia(agencia);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
