package it.prova.pizzastore.web.servlet.cliente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/PrepareUpdateClienteServlet")
public class PrepareUpdateClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clienteDaModificare= request.getParameter("idCliente");
			
			try {
				if (!NumberUtils.isCreatable(clienteDaModificare)) {
					request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
					request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
					return;
				}
				request.setAttribute("cliente_da_modificare", MyServiceFactory.getClienteServiceInstance()
						.caricaSingoloElemento(Long.parseLong(clienteDaModificare)));
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
				request.getRequestDispatcher("/Utente/indexAdmin.js").forward(request, response);
				return;
			}
			
			request.getRequestDispatcher("/Cliente/edit.jsp").forward(request, response);
		}

}
