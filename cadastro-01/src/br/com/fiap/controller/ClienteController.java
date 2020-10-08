package br.com.fiap.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet(urlPatterns = {"/cliente","/listagem", "/del-cli", "/list-cli", "/update", "/paginas"} )
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
		
		
		switch (request.getRequestURI()) {
			case "/cadastro-01/cliente":
				inserirCliente(request, response);
				break;
			case "/cadastro-01/listagem":
				listarCliente(request, response);
				break;
			case "/cadastro-01/list-cli":
				listarCliente(request, response, Integer.parseInt(request.getParameter("id-cli")));
				break;
			case "/cadastro-01/update":
				atualizarCliente(request, response);
				break;
			case "/cadastro-01/paginas":
				paginacao(request, response);
				break;
			case "/cadastro-01/del-cli":
				excluirCliente(request, response, Integer.parseInt(request.getParameter("id-cli")));
				break;

			default:
				response.sendRedirect("index.jsp");
				break;
		}
		
	}
	
	public void excluirCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws IOException, ServletException {
		//Instanciando a classe BO
		ClienteBO cb =  new ClienteBO();
		
		//Recuperando o resultado da operação, passando o parâmetro para a exclusão do Cliente.
		int status = cb.apagarCliente(idCli);
		
		//Verificando o status.
		if(status > 0) {
			// Criando uma mensagem de SUCESSO no atributo e enviando para a página index.JSP.
			request.setAttribute("msgStatus", "Os dados foram EXCLUIDOS com SUCESSO!");
			request.getRequestDispatcher("WEB-INF/paginas/inicio.jsp").forward(request, response);
		}else {
			// Criando uma mensagem de ERRO no atributo e enviando para a página index.JSP.
			request.setAttribute("msgStatus", "Ocorreu um problema com a exclusão dos dados");
			request.getRequestDispatcher("WEB-INF/error_page/erroPaginas.jsp").forward(request, response);
		}
	}

	//PAGINAÇÃO
	public void paginacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("WEB-INF/paginas/"+request.getParameter("pag")).forward(request, response);;
	}

	//ATUALIZANDO O CLIENTE
	public void atualizarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		
		//Instanciar a classe ClienteBEAN com os dados atualizados da página atualiza.jsp.
		ClienteBEAN cliB = new ClienteBEAN();
		cliB.setId(Integer.parseInt(request.getParameter("txtIdCli")));
		cliB.setNome(request.getParameter("txtNm"));
		cliB.setSobrenome(request.getParameter("txtSnm"));
		cliB.setDataNasc(request.getParameter("txtDtNasc"));
		cliB.setGenero(request.getParameter("txtGen"));
		cliB.setTelefone(request.getParameter("txtTel"));
		
		//Recuperando o status da operação e passando o objeto para o BO.
		int status = cb.atualizacaoCadastral(cliB);
		
		if(status > 0) {
			//Criando uma mensagem de SUCESSO por parâmetro e enviando para a página index.jsp
			response.sendRedirect("index.jsp?msgStatus=Os dados foram ATUALIZADOS com sucesso!");
		}else {
			//Criando uma mensagem de ERRO por parâmetro e enviando para a página index.jsp
			response.sendRedirect("index.jsp?msgStatus=Ocorreu um erro ao tentar ATUALIZAR os dados!!");
		}
			
	}

	//INSERE CLIENTE
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
	
	//LISTA TODOS OS CLIENTES
	public void listarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instanciar a classe BO
		ClienteBO cb = new ClienteBO();
		List<ClienteBEAN> lista = cb.listagemCliente();
		
		//Validação para verificar se a lista está nula.
		if(lista != null) {
			//Criamos um atributo no request para enviar a lista para a página JSP.
			//Por se tratar de um Objeto no caso uma lista de Objetos, precisamos fazer um encaminhamento.
			request.setAttribute("listaCliente", lista);
			
			//Agora criamos o encaminhamento para a página JSP.
			request.getRequestDispatcher("WEB-INF/lista.jsp").forward(request, response);
		}
		
	}
	
	//LISTA CLIENTE BY ID
	public void listarCliente(HttpServletRequest request, HttpServletResponse response, int idCli) throws ServletException, IOException {
		
		//Instanciar a classe BO.
		ClienteBO cb = new ClienteBO();
		
		//Criando o objeto de Retorno
		ClienteBEAN cli = cb.listagemCliente(idCli);
		
		//Realizando uma validação com o objeto.
		if(cli != null) {
			//Criar um atributo e inserir o objeto cli para retornar para uma página JSP.
			request.setAttribute("objCli", cli);
			
			//Criar um atributo e inserir o ID do cliente
			request.setAttribute("objIdCli", idCli);
			
			//Encaminhamento para a página atualiza.jsp
			request.getRequestDispatcher("WEB-INF/atualiza.jsp").forward(request, response);
		}
		
	}



}











