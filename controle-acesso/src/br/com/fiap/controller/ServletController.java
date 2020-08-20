package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/validacao")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//verificando o request...
		System.out.println("Ol� Mundo!");
		
		/***
		 * Bloco de processamento
		 */
		
		//Vari�veis para o armazenamento dos par�metros que v�o vir atrav�s do request.
		String nomeUsuario  = "";
		String senhaUsuario = "";
		
		//Atribuir os par�metros que est�o no request para as var�aveis, utilizando o m�todo do request que �
		// o getParameter(nomeDoCampo).
		nomeUsuario  = request.getParameter("User");
		senhaUsuario = request.getParameter("Pass");
		
		//Imprimindo os valores recuperados do request.
		System.out.println("Nome do usu�rio  : " + nomeUsuario);
		System.out.println("Senha do usu�rio : " + senhaUsuario);
		 
		/***
		 * Bloco de processamento
		 */
		
		//Criando um redirecionamento com o response, utilizando um dos seus m�todos que se chama
		// sendRedirect(Aqui passamos Path ou caminho ou nome do recurso(URI) que ser� carregado).
		response.sendRedirect("sucesso.html");
	
	}
	
}
