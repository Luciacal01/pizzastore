package it.prova.pizzastore.dao;

import java.util.List;

import it.prova.pizzastore.model.Ruolo;

public interface RuoloDAO extends IBaseDAO<Ruolo> {
	public List<Ruolo> findByExample(Ruolo example) throws Exception;
}
