package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.service.MyServiceFactory;
import it.prova.pizzastore.service.OrdineService;
import it.prova.pizzastore.web.utility.UtilityPizzaForm;

@WebServlet("/ExecuteInsertOrdineServlet")
public class ExecuteInsertOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clienteParam = request.getParameter("cliente.id");
		String[] pizzeParam = request.getParameterValues("pizze.ids");
		String dataParam = request.getParameter("data");
		String codiceParam = request.getParameter("codice");
		String utenteParam = request.getParameter("utente.id");

		Ordine ordineInstance = new Ordine();

		try {

			ordineInstance = UtilityPizzaForm.createOrdineFromParams(clienteParam, pizzeParam, dataParam, codiceParam,
					utenteParam);
			if (!UtilityPizzaForm.validateOrdineBean(ordineInstance)) {
				request.setAttribute("insert_ordine_attr", ordineInstance);
				request.setAttribute("clienti_list_attribute",
						MyServiceFactory.getClienteServiceInstance().listAllElements());

				request.setAttribute("pizze_list_attribute",
						MyServiceFactory.getPizzaServiceInstance().listAllElements());

				//request.setAttribute("fattorini_list_attribute",
						//MyServiceFactory.getUtenteServiceInstance().listAllFattorini());
				request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
				request.getRequestDispatcher("/Ordine/insert.jsp").forward(request, response);
				return;
			}

			OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

			ordineServiceInstance.calcolaPrezzoTotaleOrdine(ordineInstance);

			MyServiceFactory.getOrdineServiceInstance().inserisciNuovo(ordineInstance);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListOrdiniServlet?operationResult=SUCCESS");
	}

}
