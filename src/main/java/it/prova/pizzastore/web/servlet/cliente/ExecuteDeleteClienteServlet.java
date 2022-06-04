package it.prova.pizzastore.web.servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/ExecuteDeleteClienteServlet")
public class ExecuteDeleteClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idClienteDaRimuovere= request.getParameter("idCliente");
		if (!NumberUtils.isCreatable(idClienteDaRimuovere)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
			return;
		}
		
		try {
			MyServiceFactory.getClienteServiceInstance().rimuovi(Long.parseLong(idClienteDaRimuovere));
			request.setAttribute("clienti_list_attribute", MyServiceFactory.getClienteServiceInstance().listAllElements());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/Cliente/list.jsp").forward(request, response);
	}

}
