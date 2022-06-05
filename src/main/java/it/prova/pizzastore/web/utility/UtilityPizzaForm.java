package it.prova.pizzastore.web.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.MyServiceFactory;

public class UtilityPizzaForm {
	public static Ordine createOrdineFromParams(String codiceParams, Date dateParams) {
		Ordine result= new Ordine(codiceParams);
		result.setData(dateParams);
		return result;
	}
	
	public static boolean validateOrdineBean(Ordine ordineToBeValidate) {
		if(StringUtils.isBlank(ordineToBeValidate.getCodice()) || ordineToBeValidate.getData()==null)
			return false;
		return true;
	}
	
	public static Pizza createPizzaFromParams(String descrizioneParams, String ingredientiParams, Integer prezzoBaseParam, boolean attivoParam) {
		Pizza result= new Pizza(descrizioneParams, ingredientiParams, prezzoBaseParam, attivoParam);
		return result;
	}
	
	public static Pizza createPizzaFromParams(String descrizioneParams, String ingredientiParams, String prezzoBaseParam, boolean attivoParam) {
		Pizza result= new Pizza(descrizioneParams, ingredientiParams, attivoParam);
		if(NumberUtils.isCreatable(prezzoBaseParam)) {
			result.setPrezzoBase(Integer.parseInt(prezzoBaseParam));
		}
		return result;
	}
	
	public static boolean validatePizzaBean(Pizza pizzaToBeValidate) {
		if(StringUtils.isBlank(pizzaToBeValidate.getDescrizione()) || StringUtils.isBlank(pizzaToBeValidate.getIngredienti()) || pizzaToBeValidate.getPrezzoBase()==0)
			return false;
		return true;
	}
	
	public static Cliente createClienteFromParams(String nomeParams, String cognomeParams, String indirizzoParams, boolean attivoParam) {
		Cliente result = new Cliente(nomeParams, cognomeParams);
		result.setIndirizzo(indirizzoParams);
		result.setAttivo(attivoParam);
		return result;
	}
	
	public static boolean validateClienteBean(Cliente clienteToBeValidate) {
		if(StringUtils.isBlank(clienteToBeValidate.getNome())|| StringUtils.isBlank(clienteToBeValidate.getCognome())|| StringUtils.isBlank(clienteToBeValidate.getIndirizzo()))
			return false;
		return true;
	}
	
	public static Date parseDateArrivoToString(String dateStringParams) {
		if(StringUtils.isBlank(dateStringParams))
			return null;
		
		try {
			return new SimpleDateFormat("dd-MM-yy").parse(dateStringParams);
		} catch (Exception e) {
			return null;
		}
	}

	public static Ordine createOrdineFromParams(String clienteParam, String[] pizzeParam, String dataParam,
			String codiceParam, String utenteParam) throws Exception, Exception {
		Ordine result = new Ordine(codiceParam);
		if (NumberUtils.isCreatable(clienteParam)) {
			Cliente cliente = new Cliente();
			cliente.setId(Long.parseLong(clienteParam));
			result.setCliente(cliente);
		}
		Set<Pizza> elencoPizze = new HashSet<Pizza>();
		if (pizzeParam == null || pizzeParam.length == 0) {
			result.setPizze(null);
		} else {
			for (String pizzaItem : pizzeParam) {
				if (NumberUtils.isCreatable(pizzaItem)) {
					elencoPizze.add(MyServiceFactory.getPizzaServiceInstance()
							.caricaSingoloElemento(Long.parseLong(pizzaItem)));
				}
			}
		}
		result.setPizze(elencoPizze);
		result.setData(parseDateArrivoToString(dataParam));
		if (NumberUtils.isCreatable(utenteParam)) {
			Utente utente = new Utente();
			utente.setId(Long.parseLong(utenteParam));
			result.setUtente(utente);
		}
		return result;
	}
}
