package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/PrepareUpdateOrdineServlet")
public class PrepareUpdateOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idOrdineParam = request.getParameter("idOrdine");

		if (!NumberUtils.isCreatable(idOrdineParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexpizzaiolo.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("clienti_list_attribute",
					MyServiceFactory.getClienteServiceInstance().listAllElements());

			request.setAttribute("pizza_list_attribute", MyServiceFactory.getPizzaServiceInstance().listAllElements());

			request.setAttribute("fattorini_list_attribute",
					MyServiceFactory.getUtenteServiceInstance().listAllFattorini());

			request.setAttribute("update_ordine_attr", MyServiceFactory.getOrdineServiceInstance()
					.caricaSingoloElementoEager(Long.parseLong(idOrdineParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexpizzaiolo.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Ordine/edit.jsp").forward(request, response);
	}


}
