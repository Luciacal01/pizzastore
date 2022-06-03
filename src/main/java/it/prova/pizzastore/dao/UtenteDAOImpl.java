package it.prova.pizzastore.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Utente;

public class UtenteDAOImpl implements UtenteDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Utente> list() throws Exception {
		return entityManager.createQuery("From Utente", Utente.class).getResultList();
	}

	@Override
	public Optional<Utente> findOne(Long id) throws Exception {
		Utente result= entityManager.find(Utente.class, id);
		return result!= null ? Optional.of(result): Optional.empty();
	}

	@Override
	public void update(Utente input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		input=entityManager.merge(input);
	}

	@Override
	public void insert(Utente input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Utente input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;

	}
	
	public List<Utente> findByExample(Utente example) throws Exception{
		return null;
	}

}
