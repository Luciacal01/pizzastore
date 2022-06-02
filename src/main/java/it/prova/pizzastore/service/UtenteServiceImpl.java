package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.UtenteDAO;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;

public class UtenteServiceImpl implements UtenteService {
	
	private UtenteDAO utenteDAO;

	@Override
	public List<Utente> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Utente utenteInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Utente findByUsernameAndPassword(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente accedi(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO=utenteDAO;

	}

}
