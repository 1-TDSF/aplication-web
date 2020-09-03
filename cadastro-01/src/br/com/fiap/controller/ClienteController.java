package br.com.fiap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.bean.ClienteBEAN;

/**
 * Servlet implementation class ClienteController
 */
@WebServlet(
		description = "Controlar o Fluxo de Informações dentro do sistema de cadastro.", 
		urlPatterns = { 
				"/cliente", 
				"/listagem"
		})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<ClienteBEAN> lista = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteController() {
        super();
        //Criando a verificação da lista
        if(lista == null) {
        	lista = new ArrayList<ClienteBEAN>();
        	//Criando a instância da classe ClienteBEAN
        	ClienteBEAN cli = new ClienteBEAN();
        	cli.setNome("Alexandre");
        	cli.setSobrenome("Carlos");
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//INICIO
        	Calendar c = Calendar.getInstance();
        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        	try {
				c.setTime(sf.parse("21/12/1975"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	cli.setDataNasc(c.getTime());
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//FIM
        	cli.setGenero("m");
        	cli.setTelefone("11-978568945");
        	//Adicionando na lista
        	lista.add(cli);
        	
        	//ADICIONANDO NOVO REGISTRO
        	//Criando a instância da classe ClienteBEAN
        	cli = new ClienteBEAN();
        	cli.setNome("Julia");
        	cli.setSobrenome("Scarpato");
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//INICIO
        	c = Calendar.getInstance();
        	sf = new SimpleDateFormat("dd/MM/yyyy");
        	try {
				c.setTime(sf.parse("12/03/1985"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	cli.setDataNasc(c.getTime());
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//FIM
        	cli.setGenero("f");
        	cli.setTelefone("48-995862356");
        	//Adicionando na lista
        	lista.add(cli);

        	//ADICIONANDO NOVO REGISTRO
        	//Criando a instância da classe ClienteBEAN
        	cli = new ClienteBEAN();
        	cli.setNome("Marcos");
        	cli.setSobrenome("Costa");
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//INICIO
        	c = Calendar.getInstance();
        	sf = new SimpleDateFormat("dd/MM/yyyy");
        	try {
				c.setTime(sf.parse("01/09/1956"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	cli.setDataNasc(c.getTime());
        	//REALIZANDO O PARSE DA DATA DE NASCIMENTO//FIM
        	cli.setGenero("m");
        	cli.setTelefone("12-989562314");
        	//Adicionando na lista
        	lista.add(cli);

        }
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		//RECEPÇÃO DOS DADOS QUE CHEGAM NO REQUEST = INÍCIO
		//Criar uma instância da classe da ClienteBEAN.
		ClienteBEAN cli = null;
		
		//Criar o objeto ClienteBEAN
		cli = new ClienteBEAN();
		//Populando o objeto com os dados do request utilizando 
		// o método getParameter(nomeDoCampo)
		cli.setNome(request.getParameter("txtNm"));
		cli.setSobrenome(request.getParameter("txtSnm"));
		
		//***PARSE DA DATA DE NASCIMENTO***// INÍCIO
		//Calendar c = Calendar.getInstance();
		//SimpleDateFormat sf = new SimpleDateFormat();
		//c.setTime(sf.parse(request.getParameter("txtDtNasc")));
		//cli.setDataNasc(c.getTime());
		cli.setDataNasc(request.getParameter("txtDtNasc"));
		//***PARSE DA DATA DE NASCIMENTO***// FIM
		
		cli.setGenero(request.getParameter("txtGen"));
		cli.setTelefone(request.getParameter("txtTel"));
		
		//RECEPÇÃO DOS DADOS QUE CHEGAM NO REQUEST = FIM
		
		//Adiciona na lista
		lista.add(cli);
		
		//ENCAMINHAMENTO DOS DADOS ATRAVÉS DO REQUEST = INÍCIO
		
		//Adicinar a lista ou objeto no atributo do request utilizando
		// o método setAttribute(nomeDoAtributo, Objeto)
		request.setAttribute("listaCliente", lista);
		
		//Criar o dispatcher utilizando a Interface RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("lista.jsp");
		
		//ENCAMINHAMENTO DOS DADOS ATRAVÉS DO REQUEST = FIM
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

















