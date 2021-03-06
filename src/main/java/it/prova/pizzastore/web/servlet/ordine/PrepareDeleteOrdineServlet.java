package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/PrepareDeleteOrdineServlet")
public class PrepareDeleteOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ordine ordineInstance = new Ordine();
		String idOrdineParam = request.getParameter("idOrdine");

		try {
			if (!NumberUtils.isCreatable(idOrdineParam)) {
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/HomeServlet").forward(request, response);
				return;
			}
			ordineInstance = MyServiceFactory.getOrdineServiceInstance()
					.caricaSingoloElementoEager(Long.parseLong(idOrdineParam));
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("delete_ordine_attr", ordineInstance);
		request.getRequestDispatcher("/Ordine/delete.jsp").forward(request, response);

	}

}
