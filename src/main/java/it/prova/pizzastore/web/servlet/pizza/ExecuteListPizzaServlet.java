package it.prova.pizzastore.web.servlet.pizza;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/ExecuteListPizzaServlet")
public class ExecuteListPizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String operationResult = request.getParameter("operationResult");
			if (StringUtils.isNotBlank(operationResult) && operationResult.equalsIgnoreCase("SUCCESS"))
				request.setAttribute("successMessage", "Operazione effettuata con successo");
			
			request.setAttribute("pizza_list_attribute", MyServiceFactory.getPizzaServiceInstance().listAllElements());
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "attenzione si è verificato un errore");
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("/Pizza/list.jsp").forward(request, response);
	}
		

}
