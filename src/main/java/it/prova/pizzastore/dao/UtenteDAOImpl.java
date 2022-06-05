package it.prova.pizzastore.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
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
	
	public List<Utente> findByRuolo(Ruolo ruoloInstance) throws Exception{
		TypedQuery<Utente> results= entityManager.createQuery("select u FROM Utente u join u.ruoli r where r = :ruolo", Utente.class);
		results.setParameter("ruolo", ruoloInstance);
		return results.getResultList();
	}

	@Override
	public Optional<Utente> findByUsernameAndPassword(String username, String password) throws Exception {
		TypedQuery<Utente> results= entityManager.createQuery("select u FROM Utente u where u.username = :username and u.password=:password ", Utente.class);
		results.setParameter("username", username);
		results.setParameter("password", password);
		return results.getResultStream().findFirst();
	}

	@Override
	public Optional<Utente> login(String username, String password) throws Exception {
		TypedQuery<Utente> results= entityManager.createQuery("select u FROM Utente u join fetch u.ruoli r where u.username = :username and u.password=:password and u.stato=:statoUtente", Utente.class);
		results.setParameter("username", username);
		results.setParameter("password", password);
		results.setParameter("statoUtente", StatoUtente.ATTIVO);
		return results.getResultStream().findFirst();
	}

	@Override
	public List<Utente> listFattorini() throws Exception {
		return entityManager
				.createQuery("select u FROM Utente u join fetch u.ruoli r where r.descrizione = 'Fattorino User'",
						Utente.class)
				.getResultList();
	}

}
