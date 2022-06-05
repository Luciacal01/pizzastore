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

@WebServlet("/ExecuteInsertPizzaServlet")
public class ExecuteInsertPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descrizioneParam = request.getParameter("descrizione");
		String ingredientiParam = request.getParameter("ingredienti");
		String prezzoBaseParam = request.getParameter("prezzobase");
		boolean attivoParam = true;

		Pizza pizzaInstance = UtilityPizzaForm.createPizzaFromParams(descrizioneParam, ingredientiParam,
				Integer.parseInt(prezzoBaseParam), attivoParam);
		try {
			if(!UtilityPizzaForm.validatePizzaBean(pizzaInstance)) {
				request.setAttribute("insert_pizza_attr", pizzaInstance);
				request.setAttribute("pizza_list_attribute", MyServiceFactory.getPizzaServiceInstance().listAllElements());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/Pizza/insert.jsp").forward(request, response);
				return;
			}
			MyServiceFactory.getPizzaServiceInstance().inserisciNuovo(pizzaInstance);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Pizza/insert.jsp").forward(request, response);
			return;
		}
		
		response.sendRedirect("ExecuteListPizzaServlet?operationResult=SUCCESS");
	}

}
