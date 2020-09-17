package br.com.fiap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExemploServlet
 */
@WebServlet("/exemplo")
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
		
		//Criando a Sessão do usuário
		HttpSession sessao = request.getSession(false);
		
		//Verificando a existência da sessão
		if(sessao != null) {
			
			if(request.getParameter("userLogin").equals("1")) {
				//Criar um atributo na sessão
				sessao.setAttribute("login", "aljesu");
				sessao.setAttribute("idSession", sessao.getId());
				
				//Configurando o TIMEOUT da sessão do usuário
				//sessao.setMaxInactiveInterval(10);
				
			}else if(request.getParameter("userLogin").equals("0")) {
				sessao.invalidate();
			}
		}
		
				
		//Recuperando o contexto da Servlet/Aplicação
		ServletContext ctx = request.getServletContext();
		
		//Criaando um atributo no contexto da Servlet/Aplicação
		ctx.setAttribute("ctxLocalDate", Calendar.getInstance().getTime());
		
		//Recuperando os parâmetros do HTML início e já adicionar ele em variáveis
		String nome = request.getParameter("nome");
		String user = request.getParameter("userName");

		
		
		//Agora podemos fazer o que quisermos com essas variáveis
		//Por exemplo podemos adicionar em atributos no request e enviar para outra página nesse caso JSP.
		request.setAttribute("attrNome", nome);
		request.setAttribute("attrUser", user);
		
		//Para poder enviar estes dados, somente com o forward ou seja encaminhando e não redirecionando.
		request.getRequestDispatcher("principal.jsp").forward(request, response);
		
		//Criando o response para o usuário
//		PrintWriter pw = response.getWriter();
//		pw.println("<html>");
//		pw.println("<head>");
//		pw.println("<title>SERVLET RESPONSE</title>");
//		pw.println("</head>");
//		pw.println("<body>");

		//Recuperando os parâmetros do HTML início
//		pw.println("<h2> Nome : "+ request.getParameter("nome") +"</h2>");
//		pw.println("<h2> Username : "+ request.getParameter("userName") +"</h2>");
		
		//Criando um link para o JSP
//		pw.println("<p><a href='principal.jsp'>LINK-TO-JSP</a></p>");
//		
//		pw.println("</body>");
//		pw.println("</html>");
//		
//		pw.close();
//		
	}

}















