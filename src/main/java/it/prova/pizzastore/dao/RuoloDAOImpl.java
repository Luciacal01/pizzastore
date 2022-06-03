package it.prova.pizzastore.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.pizzastore.model.Ruolo;

public class RuoloDAOImpl implements RuoloDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Ruolo> list() throws Exception {
		return entityManager.createQuery("from Ruolo", Ruolo.class).getResultList();
	}

	@Override
	public Optional<Ruolo> findOne(Long id) throws Exception {
		Ruolo result= entityManager.find(Ruolo.class, id);
		return result!= null ? Optional.of(result):Optional.empty();
	}

	@Override
	public void update(Ruolo input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		input=entityManager.merge(input);
	}

	@Override
	public void insert(Ruolo input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Ruolo input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	public List<Ruolo> findByExample(Ruolo example) throws Exception{
		return null;
	}

}
