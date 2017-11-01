package Servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MedioDePagoDTO;
import com.dto.OfertaPaqueteDTO;
import com.dto.ServicioDTO;

import BD.Controlador;

/**
 * Servlet implementation class Paquete
 */
@WebServlet("/Paquete")
public class Paquete extends BaseController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paquete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			List<OfertaPaqueteDTO> ofertas;
		
	 	try {
			
			ofertas = Controlador.getInstancia().recuperarOfertas();
			request.setAttribute("ofertas", ofertas);
			Dispatch("paquetes.jsp", request, response);
			
 		} catch (NamingException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/OfertaPaqueteWeb/AltaPaquete");
	}

}
