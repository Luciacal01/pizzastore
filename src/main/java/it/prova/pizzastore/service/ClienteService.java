package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.ClienteDAO;
import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;

public interface ClienteService {
	public List<Cliente> listAllElements() throws Exception;

	public Cliente caricaSingoloElemento(Long id) throws Exception;
	
	public Cliente caricaSingoloElementoEager(Long id) throws Exception;

	public void aggiorna(Cliente clienteInstance) throws Exception;

	public void inserisciNuovo(Cliente clienteInstance) throws Exception;

	//novità rispetto al passato: rimuoviamo per id così faccio tutto nel service e risparimio 
	public void rimuovi(Long idClienteToRemove) throws Exception;

	public List<Cliente> findByExample(Cliente example) throws Exception;
	
	public int calcolaPrezzoOrdine(Ordine ordineInstance) throws Exception;

	// per injection
	public void setClienteDAO(ClienteDAO clienteDAO);
}
