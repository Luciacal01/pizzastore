package it.prova.pizzastore.web.servlet.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.MyServiceFactory;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginInput = request.getParameter("inputUsername");
		String passwordInput = request.getParameter("inputPassword");
		
		if(StringUtils.isEmpty(loginInput) || StringUtils.isEmpty(passwordInput)) {
			request.setAttribute("errorMessage", "E' necessario riempire tutti i campi.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		
		/*
		String destinazione=null;
		
		try {
			Utente utenteInstance=MyServiceFactory.getUtenteServiceInstance().accedi(loginInput, passwordInput);
			if(utenteInstance==null) {
				request.setAttribute("errorMessage", "Utente non trovato.");
				destinazione = "login.jsp";
			}else {
				request.setAttribute("userInfo", utenteInstance);
				destinazione="HomeServlet";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			destinazione = "login.jsp";
			request.setAttribute("errorMessage", "Attenzione! Si è verificato un errore.");
		}
		
		request.getRequestDispatcher(destinazione).forward(request, response);
	*/
		try {
			if(loginInput.equals("admin") && passwordInput.equals("admin")) {
				Utente res= new Utente(loginInput, passwordInput, "Admin", "User",new Date());
				res.getRuoli().add(new Ruolo(Ruolo.ADMIN_ROLE));
				request.getSession().setAttribute("userInfo", res);
				request.getRequestDispatcher("/Utente/indexAdmin.jsp").forward(request, response);
				return;
			}
			
			if(loginInput.equals("pizzaiolo") && passwordInput.equals("pizzaiolo")) {
				Utente res= new Utente(loginInput, passwordInput, "Pizzaiolo", "User",new Date());
				res.getRuoli().add(new Ruolo(Ruolo.PIZZAIOLO_ROLE));
				request.getSession().setAttribute("userInfo", res);
				request.getRequestDispatcher("/Utente/indexpizzaiolo.jsp").forward(request, response);
				return;
			}
			
			if(loginInput.equals("fattorino") && passwordInput.equals("fattorino")) {
				Utente res= new Utente(loginInput, passwordInput, "Fattorino", "User",new Date());
				res.getRuoli().add(new Ruolo(Ruolo.FATTORINO_ROLE));
				request.getSession().setAttribute("userInfo", res);
				request.getRequestDispatcher("/Utente/indexfattorino.jsp").forward(request, response);
				return;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione! Si è verificato un errore.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
