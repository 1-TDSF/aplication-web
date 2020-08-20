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
		System.out.println("Olá Mundo!");
		
		/***
		 * Bloco de processamento
		 */
		
		//Variáveis para o armazenamento dos parâmetros que vão vir através do request.
		String nomeUsuario  = "";
		String senhaUsuario = "";
		
		//Atribuir os parâmetros que estão no request para as varíaveis, utilizando o método do request que é
		// o getParameter(nomeDoCampo).
		nomeUsuario  = request.getParameter("User");
		senhaUsuario = request.getParameter("Pass");
		
		//Imprimindo os valores recuperados do request.
		System.out.println("Nome do usuário  : " + nomeUsuario);
		System.out.println("Senha do usuário : " + senhaUsuario);
		 
		/***
		 * Bloco de processamento
		 */
		
		//Criando um redirecionamento com o response, utilizando um dos seus métodos que se chama
		// sendRedirect(Aqui passamos Path ou caminho ou nome do recurso(URI) que será carregado).
		response.sendRedirect("sucesso.html");
	
	}
	
}
