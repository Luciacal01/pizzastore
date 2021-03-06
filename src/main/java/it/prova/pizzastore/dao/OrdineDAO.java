package it.prova.pizzastore.dao;

import java.util.List;
import java.util.Optional;

import it.prova.pizzastore.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	public List<Ordine> findByExample(Ordine example) throws Exception;
	
	public Ordine findOneEager(Long id) throws Exception;
	
	public Integer price(Ordine ordineInstance) throws Exception;
	
	public List<Ordine> listOrdiniByFattorino(Long idFattorino) throws Exception;
	

}
