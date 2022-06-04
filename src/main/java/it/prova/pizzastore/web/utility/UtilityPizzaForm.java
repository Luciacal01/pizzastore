package it.prova.pizzastore.web.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Cliente;
import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.model.Pizza;

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
	
	public static Pizza createPizzaFromParams(String descrizioneParams, String ingredientiParams, Integer prezzoBaseParam) {
		Pizza result= new Pizza(descrizioneParams, ingredientiParams, prezzoBaseParam);
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
}
