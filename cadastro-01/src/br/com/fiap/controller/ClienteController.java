package br.com.fiap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.ClienteBEAN;
import br.com.fiap.bo.ClienteBO;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet("/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getRequestURI().equals("/cadastro-01/cliente")) {
			
			inserirCliente(request, response);
			
		}
		
	}
	
	public void inserirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recepcão dos dados do formulário da página index.jsp.
		ClienteBEAN cliB = null;
		cliB = new ClienteBEAN();
		cliB.setNome(request.getParameter("txtNm"));
		cliB.setSobrenome(request.getParameter("txtSnm"));
		cliB.setDataNasc(request.getParameter("txtDtNasc"));
		cliB.setGenero(request.getParameter("txtGen"));
		cliB.setTelefone(request.getParameter("txtTel"));
		
		//Adicionando o objeto ao BO.
		ClienteBO cb = new ClienteBO();
		
		//Criando um estrutura de decisão para verificar se os dados foram
		//inseridos corretamente.
		int resultado = cb.cadastroCliente(cliB);
		
		if(resultado == 1) {
			//Se o valor retornado for true quer dizer que tudo
			//correu bem e os dados foram inseridos corretamente.
			//Então podemos criar um atributo no request e devolver para a página index.jsp.
			// com uma mensagem de sucesso.
			//request.setAttribute("msgStatus", "Os dados foram gravados com SUCESSO!");
			
			//Realizar um redirecionamento com parâmetros, para ser recuperados no JSP
			// com o escopo param. Ex: Se eu enviar um parametro de nome banana tenho que recuperar
			// param.banana
			response.sendRedirect("index.jsp?msgStatus=Os dados foram gravados com SUCESSO!");
			
		}else if(resultado == 0) {
			//Se o valor retornado for false quer dizer que algo saiu errado
			//Então podemos criar um atributo no request e devolver para a página index.jsp.
			// com uma mensagem de erro.
			//request.setAttribute("msgStatus", "Ocorreu um ERRO!");
			
			//Realizar um redirecionamento com parâmetros, para ser recuperados no JSP
			// com o escopo param. Ex: Se eu enviar um parametro de nome banana tenho que recuperar
			// param.banana
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um ERRO!");

		}
		
	}

}
