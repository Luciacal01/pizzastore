<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.pizzastore.model.Pizza"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Pizza</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="/Utente/navbarpizzaiolo.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					
					
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica pizza</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="ExecuteUpdatePizzaServlet" class="row g-3" novalidate="novalidate">
							
								<c:set var="pizzaInPagina" value="${update_pizza_attr}"/>
							
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Descrizione</label>
									<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"  
										value="${pizzaInPagina.descrizione}" required>
								</div>
								
								<div class="col-md-6">
									<label for="ingredienti" class="form-label">Ingredienti</label>
									<input type="text" name="ingredienti" id="ingredienti" class="form-control" placeholder="Inserire gli ingredienti"  
										value="${pizzaInPagina.ingredienti}" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzobase" class="form-label">Prezzo Base</label>
									<input type="number" class="form-control" name="prezzobase" id="prezzobase" placeholder="Inserire il prezzo base" 
									value="${pizzaInPagina.prezzoBase}" required>
								</div>
								
								<div class="col-md-6">
									<label for="attivo" class="form-label">Attivo</label>
								    <select class="form-select" id="attivo" name="attivo">
								    	<option value="" selected> -- Selezionare una voce -- </option>
								    	<option value="true">true</option>
								    	<option value="false">false</option>
								    </select>
								</div>
								
								<input type="hidden" name="idPizza" value="${pizzaInPagina.id}">
								
								
							<div class="col-12">
								<a href="ExecuteListPizzaServlet" class='btn btn-outline-secondary' style='width:80px'>
					           		<i class='fa fa-chevron-left'></i> Back
					        	</a>
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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