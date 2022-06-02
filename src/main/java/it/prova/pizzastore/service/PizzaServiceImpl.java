package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.PizzaDAO;
import it.prova.pizzastore.model.Pizza;

public class PizzaServiceImpl implements PizzaService {
	
	private PizzaDAO pizzaDAO;

	@Override
	public List<Pizza> listAllElements() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza caricaSingoloElementoEager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Pizza filmInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Pizza filmInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idFilmToRemove) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pizza> findByExample(Pizza example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPizzaDAO(PizzaDAO pizzaDAO) {
		this.pizzaDAO=pizzaDAO;

	}

}
