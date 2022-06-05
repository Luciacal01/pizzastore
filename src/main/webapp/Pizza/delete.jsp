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
	   
	   <title>Elimina Pizza</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="/Utente/navbarpizzaiolo.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Elimina pizza</h5>
					    </div>
					    
						<c:set var="pizzaInPagina" value="${delete_pizza_attr}"/>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Descrizione</dt>
							  <dd class="col-sm-9"><c:out value="${pizzaInPagina.descrizione
							  }"/></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Ingredienti:</dt>
							  <dd class="col-sm-9"><c:out value="${pizzaInPagina.ingredienti
							  }"/></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Prezzo Base:</dt>
							  <dd class="col-sm-9"><c:out value="${pizzaInPagina.prezzoBase
							  }"/></dd>
					    	</dl>
					    						
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form method="post" action="ExecuteDeletePizzaServlet">
								<input type="hidden" name="idPizza" value="${pizzaInPagina.id}"> 
						        <a href="ExecuteListPizzaServlet" class='btn btn-outline-secondary' style='width:80px'>
					           		 <i class='fa fa-chevron-left'></i> Back
					        	</a>
					        	
						        <button type="submit" name="deleteSubmit" value="deleteSubmit" id="deleteSubmit" class="btn btn-primary">Conferma</button>
						        
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