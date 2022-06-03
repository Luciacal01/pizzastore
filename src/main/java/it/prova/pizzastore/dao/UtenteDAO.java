package it.prova.pizzastore.dao;

import java.util.List;

import it.prova.pizzastore.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {
	public List<Utente> findByExample(Utente example) throws Exception;
}
