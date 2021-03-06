package it.prova.pizzastore.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.pizzastore.Exception.ElementNotFoundException;
import it.prova.pizzastore.dao.PizzaDAO;
import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.web.listener.LocalEntityManagerFactoryListener;

public class PizzaServiceImpl implements PizzaService {
	
	private PizzaDAO pizzaDAO;

	@Override
	public List<Pizza> listAllElements() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			pizzaDAO.setEntityManager(entityManager);

			return pizzaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Pizza caricaSingoloElemento(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			pizzaDAO.setEntityManager(entityManager);

			return pizzaDAO.findOne(id).orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Pizza caricaSingoloElementoEager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Pizza pizzaInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			pizzaDAO.setEntityManager(entityManager);

			pizzaDAO.update(pizzaInstance);

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
	public void inserisciNuovo(Pizza pizzaInstance) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			pizzaDAO.setEntityManager(entityManager);

			pizzaDAO.insert(pizzaInstance);;

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
	public void rimuovi(Long idPizzaToRemove) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			pizzaDAO.setEntityManager(entityManager);
			
			Pizza pizzaDaRimuovere= pizzaDAO.findOne(idPizzaToRemove).orElse(null);
			if(pizzaDaRimuovere==null) throw new ElementNotFoundException("La pizza cercata non ?? stata trovata");
			
			pizzaDAO.delete(pizzaDaRimuovere);

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
	public List<Pizza> findByExample(Pizza example) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			pizzaDAO.setEntityManager(entityManager);

			return pizzaDAO.findByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void setPizzaDAO(PizzaDAO pizzaDAO) {
		this.pizzaDAO=pizzaDAO;

	}

}
