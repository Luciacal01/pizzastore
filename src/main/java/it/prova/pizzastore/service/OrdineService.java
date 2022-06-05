package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.OrdineDAO;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Pizza;

public interface OrdineService {
	public List<Ordine> listAllElements() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;
	
	public Ordine caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	//novità rispetto al passato: rimuoviamo per id così faccio tutto nel service e risparimio 
	public void rimuovi(Long idOrdineToRemove) throws Exception;

	public List<Ordine> findByExample(Ordine example) throws Exception;
	
	public Integer calcolaPrezzoTotaleOrdine(Ordine ordineInstance) throws Exception;
	
	public List<Ordine> listAllOrdiniAttiviFattorino(Long idFattorino) throws Exception;
	
	public void aggiungiPizza(Ordine ordineInstance, Pizza pizza) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
}
