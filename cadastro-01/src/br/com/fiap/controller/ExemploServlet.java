package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExemploServlet
 */
@WebServlet( urlPatterns =  {"/pesquisa", "/valores","/exemplo" })
public class ExemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExemploServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getRequestURI().equals("/cadastro-01/pesquisa")) {
			//Identificando a URI que originou o request!
			System.out.println("A ORIGEM REQUEST FOI O FORM");
			
		}else if(request.getRequestURI().equals("/cadastro-01/valores")) {
			//Identificando a URI que originou o request!
			System.out.println("A ORIGEM REQUEST FOI O LINK");
		}else {
			//Identificando a URI que originou o request!
			System.out.println("A ORIGEM DO REQUEST É DESCONHECIDA");
		}
		
	}

}
