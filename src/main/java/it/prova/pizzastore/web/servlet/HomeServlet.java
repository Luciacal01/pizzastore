package it.prova.pizzastore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Utente;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//questa servlet risulta utile quando ho qualcosa (una lista, un oggetto) che va preparato prima di mostrare la pagina che segue
		Utente utenteInstance= (Utente) request.getSession().getAttribute("userInfo");
		
		if (utenteInstance.isAdmin()) {
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
		} else if (utenteInstance.isPizzaiolo()) {
			request.getRequestDispatcher("/Utente/indexPizzaiolo.jsp").forward(request, response);
		} else if (utenteInstance.isFattorino()) {
			request.getRequestDispatcher("/Utente/indexFattorino.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Utente utenteInstance = (Utente) request.getSession().getAttribute("userInfo");

		if (utenteInstance.isAdmin()) {
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
		} else if (utenteInstance.isPizzaiolo()) {
			request.getRequestDispatcher("/Utente/indexPizzaiolo.jsp").forward(request, response);
		} else if (utenteInstance.isFattorino()) {
			request.getRequestDispatcher("/Utente/indexFattorino.jsp").forward(request, response);
		}

	}
}
