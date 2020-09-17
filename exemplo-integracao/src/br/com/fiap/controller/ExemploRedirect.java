package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExemploRedirect
 */
@WebServlet("/enviar")
public class ExemploRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExemploRedirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperando o parâmetro da página HTML arquivo1.html
		String parametro = request.getParameter("msg");
		request.setAttribute("prevTemp", parametro);
		
		//Criar o encaminhamento que é o forward
		//request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
		response.sendRedirect("resultado.jsp");
	}

}
