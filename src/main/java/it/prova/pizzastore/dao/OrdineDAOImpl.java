package it.prova.pizzastore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.StatoUtente;

public class OrdineDAOImpl implements OrdineDAO {
	
	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("From Ordine", Ordine.class).getResultList();
	}

	@Override
	public Optional<Ordine> findOne(Long id) throws Exception {
		Ordine result= entityManager.find(Ordine.class, id);
		return result!= null ? Optional.of(result): Optional.empty();
	}

	@Override
	public void update(Ordine input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		input= entityManager.merge(input);

	}

	@Override
	public void insert(Ordine input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);

	}

	@Override
	public void delete(Ordine input) throws Exception {
		if(input== null) {
			throw new Exception("Problema valore in input");
		}
		input.setClosed(true);
		entityManager.merge(input);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager=entityManager;

	}
	
	public List<Ordine> findByExample(Ordine example) throws Exception{
		Map<String, Object> parameterMap= new HashMap<String, Object>();
		List<String> whereClauses= new ArrayList<String>();
		
		StringBuilder queryBuilder= new StringBuilder("select o from Ordine o where o.id=o.id");
		
		if(StringUtils.isNotEmpty(example.getCodice())) {
			whereClauses.add("o.codice like :codice");
			parameterMap.put("codice", "%"+ example.getCodice()+"%");
		}
		if(example.getCostoTotaleOrdine()>0) {
			whereClauses.add("o.costoTotaleOrdine like :costo");
			parameterMap.put("costo", "%"+example.getCostoTotaleOrdine()+"%");
		}
		if(example.getData()!= null) {
			whereClauses.add("a.data=:data");
			parameterMap.put("o.data", example.getData());
		}
		
		if(example.getCliente()!=null && example.getCliente().getId()!=null && example.getCliente().getId()>0 && example.getCliente().isAttivo()) {
			whereClauses.add("o.cliente_id=:cliente_id");
			parameterMap.put("cliente_id", example.getCliente().getId());
		}
		
		if(example.getUtente() != null && example.getUtente().getId()!=null && example.getUtente().getId()>0 && example.getUtente().getStato()== StatoUtente.ATTIVO) {
			whereClauses.add("o.utente_id=:utente_id");
			parameterMap.put("utente_id", example.getUtente().getId());
		}
		
		if(example.isClosed()) {
			whereClauses.add("o.closed=true");
		}else {
			whereClauses.add("o.closed=false");
		}
		
		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Ordine> typedQuery= entityManager.createNamedQuery(queryBuilder.toString(), Ordine.class);
		
		for (String key : parameterMap.keySet()) {
			typedQuery.setParameter(key, parameterMap.get(key));
		}

		return typedQuery.getResultList();
	}
	
	public Integer price(Ordine ordineInstance) throws Exception{
		return  entityManager
				.createQuery("select distinct sum(p.prezzoBase) from Ordine o join o.pizze p where o.id = :id", Long.class)
				.setParameter("id", ordineInstance.getId()).getFirstResult();
		
	}

	@Override
	public Ordine findOneEager(Long id) throws Exception {
		TypedQuery<Ordine> query= entityManager.createQuery("select o from Ordine o left join fetch o.cliente left join fetch o.utente left join fetch o.pizze where o.id = :idOrdine", Ordine.class);
		query.setParameter("idOrdine", id);
		return query.getResultStream().findFirst().orElse(null);
	}

	@Override
	public List<Ordine> listOrdiniByFattorino(Long idFattorino) throws Exception {
		return entityManager
				.createQuery("select o FROM Ordine o where o.closed = 'false' and o.utente.id = :idUtente", Ordine.class)
				.setParameter("idUtente", idFattorino).getResultList();
	}

}
