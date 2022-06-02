package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.dao.RuoloDAO;
import it.prova.pizzastore.model.Ruolo;

public class RuoloServiceImpl implements RuoloService {
	
	private RuoloDAO ruoloDAO;

	@Override
	public List<Ruolo> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ruolo caricaSingoloElemento(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aggiorna(Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void inserisciNuovo(Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void rimuovi(Ruolo ruoloInstance) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRuoloDAO(RuoloDAO ruoloDAO) {
		this.ruoloDAO= ruoloDAO;

	}

}
