package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.ClienteDAO;
import it.prova.pizzastore.model.Cliente;

public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> listAllElements() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente caricaSingoloElementoEager(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Cliente clienteInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Cliente clienteInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Long idClienteToRemove) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> findByExample(Cliente example) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO= clienteDAO;

	}

}
