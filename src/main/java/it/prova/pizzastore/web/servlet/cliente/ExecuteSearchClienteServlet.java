package it.prova.pizzastore.web.servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.service.MyServiceFactory;
import it.prova.pizzastore.web.utility.UtilityPizzaForm;

@WebServlet("/ExecuteSearchClienteServlet")
public class ExecuteSearchClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String indirizzoParam = request.getParameter("indirizzo");
		String attivoParam = request.getParameter("attivo");

		Cliente clienteInstance = UtilityPizzaForm.createClienteFromParams(nomeParam, cognomeParam, indirizzoParam,
				Boolean.parseBoolean(attivoParam));

		try {
			request.setAttribute("clienti_list_attribute",
					MyServiceFactory.getClienteServiceInstance().findByExample(clienteInstance));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Cliente/list.jsp").forward(request, response);
	}

}
