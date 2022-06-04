<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.pizzastore.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<head>

	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Cancella Cliente</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="/Utente/navbaradmin.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Cancella Cliente</h5>
					    </div>
					     
					    	<c:set var="clienteInPagina" value="${cliente_da_eliminare }"/>
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Nome</dt>
							  <dd class="col-sm-9">${clienteInPagina.nome }</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Cognome:</dt>
							  <dd class="col-sm-9">${clienteInPagina.cognome }</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Indirizzo:</dt>
							  <dd class="col-sm-9">${clienteInPagina.indirizzo }</dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    	<form method="post" action="ExecuteDeleteClienteServlet" >
								<input type="hidden" name="idCliente" value="${clienteInPagina.id }"> 
						        <a href="ExecuteListClienteServlet" class='btn btn-outline-secondary' style='width:80px'>
						            <i class='fa fa-chevron-left'></i> Back
						        </a>
						        <button type="submit" name="deleteSubmiut" value="deleteSubmiut" id="deleteSubmiut" class="btn btn-primary">Conferma</button>
						        
					        </form>
					       
					    </div>
					<!-- end card -->
					</div>	
			  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>