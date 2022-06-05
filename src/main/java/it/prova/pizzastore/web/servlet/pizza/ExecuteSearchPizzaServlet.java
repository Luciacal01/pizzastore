package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.service.MyServiceFactory;
import it.prova.pizzastore.web.utility.UtilityPizzaForm;

@WebServlet("/ExecuteSearchPizzaServlet")
public class ExecuteSearchPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String ingredientiParam = request.getParameter("ingredienti");
		String prezzoBaseParam = request.getParameter("prezzobase");
		String attivoParam = request.getParameter("attivo");

		Pizza pizzaInstance = UtilityPizzaForm.createPizzaFromParams(descrizioneParam, ingredientiParam, prezzoBaseParam,
				Boolean.parseBoolean(attivoParam));

		try {
			request.setAttribute("pizza_list_attribute",
					MyServiceFactory.getPizzaServiceInstance().findByExample(pizzaInstance));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Pizza/list.jsp").forward(request, response);
	}

}
