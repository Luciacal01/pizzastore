package it.prova.pizzastore.web.servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/ExecuteVisualizzaClienteServlet")
public class ExecuteVisualizzaClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClienteDaVisualizzare= request.getParameter("idCliente");
		
		try {
			if (!NumberUtils.isCreatable(idClienteDaVisualizzare)) {
				// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
				return;
			}
			request.setAttribute("visualizza_cliente_attr",
					MyServiceFactory.getClienteServiceInstance().caricaSingoloElemento(Long.parseLong(idClienteDaVisualizzare)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Cliente/show.jsp").forward(request, response);
	}

}
