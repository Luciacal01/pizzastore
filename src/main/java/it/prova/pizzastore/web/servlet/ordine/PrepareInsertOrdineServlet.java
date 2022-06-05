package it.prova.pizzastore.web.servlet.ordine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.service.MyServiceFactory;

@WebServlet("/PrepareInsertOrdineServlet")
public class PrepareInsertOrdineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("insert_ordine_attr", new Ordine());
			
			request.setAttribute("clienti_list_attribute",
					MyServiceFactory.getClienteServiceInstance().listAllElements());
			
			request.setAttribute("pizze_list_attribute",
					MyServiceFactory.getPizzaServiceInstance().listAllElements());
			
			//request.setAttribute("fattorini_list_attribute",
					//MyServiceFactory.getUtenteServiceInstance().listAllFattorini());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/Ordine/insert.jsp").forward(request, response);
	}

}
/*
<div class="col-md-6"> 
<label for="utente.id">Fattorino <span class="text-danger">*</span></label>
<select class="form-select" id="utente.id" name="utente.id">
	<option value="" selected> -- Selezionare una voce -- </option>
  	<c:forEach items="${fattorini_list_attribute }" var="utenteItem">
  		<option value="${utenteItem.id}" ${insert_ordine_attr.utente.id == utenteItem.id?'selected':''} >${utenteItem.nome } ${utenteItem.cognome }</option>
  	</c:forEach>
</select>
</div>
*/