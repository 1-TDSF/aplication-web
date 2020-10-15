package br.com.fiap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerLingua
 */
@WebServlet("/change")
public class ControllerLingua_ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLingua_() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<String> nomes = new ArrayList<String>();
		nomes.add("Thiago");
		nomes.add("Yamamoto");
		nomes.add("Alexandre");
		nomes.add("Carlos");
		nomes.add("Carla");
		nomes.add("Gabriel");
		nomes.add("Hellen");
		nomes.add("Larissa");
		nomes.add("João");
		nomes.add("João");
		
		request.setAttribute("lista", nomes);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
