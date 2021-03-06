package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/ExecuteDeletePizzaServlet")
public class ExecuteDeletePizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String idPizzaParam = request.getParameter("idPizza");

	try {
		if (!NumberUtils.isCreatable(idPizzaParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexpizzaiolo.jsp").forward(request, response);
			return;
		}

		MyServiceFactory.getPizzaServiceInstance().rimuovi(Long.parseLong(idPizzaParam));
		request.setAttribute("pizza_list_attribute",
				MyServiceFactory.getPizzaServiceInstance().listAllElements());
		request.setAttribute("successMessage", "Operazione effettuata con successo");
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
		request.getRequestDispatcher("/Utente/indexpizzaiolo.jsp").forward(request, response);
		return;
	}

	request.getRequestDispatcher("/Pizza/list.jsp").forward(request, response);
}

}
