package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.service.MyServiceFactory;
import it.prova.pizzastore.web.utility.UtilityPizzaForm;

@WebServlet("/ExecuteSearchOrdineServlet")
public class ExecuteSearchOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codiceParam = request.getParameter("codice");
		String dataParam = request.getParameter("data");
		String clienteParam = request.getParameter("cliente.id");
		String utenteParam = request.getParameter("utente.id");
		String[] pizzeParam = request.getParameterValues("pizze.ids");
		String closedParam = request.getParameter("closed");

		Ordine ordineInstance = new Ordine();
		
		try {
			
			ordineInstance = UtilityPizzaForm.createOrdineFromParams(clienteParam, pizzeParam, dataParam, codiceParam,
					utenteParam, Boolean.parseBoolean(closedParam));
			request.setAttribute("ordini_list_attribute",
					MyServiceFactory.getOrdineServiceInstance().findByExample(ordineInstance));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Ordine/list.jsp").forward(request, response);
	}

}
