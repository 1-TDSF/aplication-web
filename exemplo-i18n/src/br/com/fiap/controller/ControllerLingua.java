package br.com.fiap.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * Servlet implementation class ControllerLingua
 */
@WebServlet("/aux")
public class ControllerLingua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLingua() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Criando a String que vai receber o parâmetro lingua/Locale que é a escolha do usuário.
		String language = req.getParameter("lingua");
		//Intanciar a classe Locale que manipula o tipo Localidade através de Strings
		//E vamos passar a escolha do usuário para este objeto.
		Locale locale = new Locale(language);
		
		//A classe Config vai utilizar de constantes para alterar via sessão os locales tanto na aplicação, quanto do usuário.
		Config.set(req.getSession(), Config.FMT_LOCALE, locale);
		Config.set(req.getSession(), Config.FMT_FALLBACK_LOCALE, locale);
		
		//Redirecionamento para a página que chamou.
		resp.sendRedirect("index.jsp?lingua="+locale);
		
	}

}
