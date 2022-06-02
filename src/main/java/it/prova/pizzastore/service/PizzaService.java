package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.PizzaDAO;
import it.prova.pizzastore.model.Pizza;

public interface PizzaService {
	public List<Pizza> listAllElements() throws Exception;

	public Pizza caricaSingoloElemento(Long id) throws Exception;
	
	public Pizza caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Pizza filmInstance) throws Exception;

	public void inserisciNuovo(Pizza filmInstance) throws Exception;

	//novità rispetto al passato: rimuoviamo per id così faccio tutto nel service e risparimio 
	public void rimuovi(Long idFilmToRemove) throws Exception;

	public List<Pizza> findByExample(Pizza example) throws Exception;

	// per injection
	public void setPizzaDAO(PizzaDAO pizzaDAO);
}
