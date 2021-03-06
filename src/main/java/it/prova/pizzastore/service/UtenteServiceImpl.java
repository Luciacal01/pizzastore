package it.prova.pizzastore.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import it.prova.pizzastore.Exception.UtenteConRuoloCollegatoException;
import it.prova.pizzastore.dao.UtenteDAO;
import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.web.listener.LocalEntityManagerFactoryListener;

public class UtenteServiceImpl implements UtenteService {
	
	private UtenteDAO utenteDAO;

	@Override
	public List<Utente> listAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			utenteDAO.setEntityManager(entityManager);

			return utenteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Utente caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			utenteDAO.setEntityManager(entityManager);

			return utenteDAO.findOne(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			utenteDAO.setEntityManager(entityManager);

			utenteDAO.update(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			utenteDAO.setEntityManager(entityManager);

			utenteDAO.insert(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void rimuovi(Utente utenteInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			utenteDAO.setEntityManager(entityManager);
			
			if(utenteInstance==null) throw new UtenteConRuoloCollegatoException("l'utente che sta cercando di cancellare ha un ruolo collegato, disaccoppialo");

			utenteDAO.delete(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			utenteDAO.setEntityManager(entityManager);

			utenteEsistente= entityManager.merge(utenteEsistente);
			
			ruoloInstance= entityManager.merge(ruoloInstance);
			
			utenteEsistente.getRuoli().add(ruoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public Utente findByUsernameAndPassword(String username, String password) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			utenteDAO.setEntityManager(entityManager);
			
			Optional<Utente> results=utenteDAO.findByUsernameAndPassword(username, password);

			return results.isPresent() ?results.get() :null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Utente accedi(String username, String password) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			utenteDAO.setEntityManager(entityManager);
			
			Optional<Utente> results=utenteDAO.login(username, password);

			return results.isPresent() ?results.get() :null;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO=utenteDAO;

	}

	@Override
	public List<Utente> listAllFattorini() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			utenteDAO.setEntityManager(entityManager);

			return utenteDAO.listFattorini();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
