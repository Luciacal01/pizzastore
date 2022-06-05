package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaPizzaServlet")
public class ExecuteVisualizzaPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPizzaParam = request.getParameter("idPizza");

		if (!NumberUtils.isCreatable(idPizzaParam)) {

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/indexpizzaiolo.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_pizza_attr",
					MyServiceFactory.getPizzaServiceInstance().caricaSingoloElemento(Long.parseLong(idPizzaParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/indexpizzaiolo.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Pizza/show.jsp").forward(request, response);
	}

}
