<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.pizzastore.model.Ordine"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Elimina Ordine</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="/Utente/navbarpizzaiolo.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Elimina ordine</h5>
					    </div>
					    
						<c:set var="ordineInPagina" value="${delete_ordine_attr}"/>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Codice</dt>
							  <dd class="col-sm-9"><c:out value="${ordineInPagina.codice
							  }"/></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data:</dt>
							  <dd class="col-sm-9"><fmt:formatDate type = "date" value = "${ordineInPagina.data}" /></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Costo totale:</dt>
							  <dd class="col-sm-9"><c:out value="${ordineInPagina.costoTotaleOrdine
							  }"/></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Cliente:</dt>
							  <dd class="col-sm-9"><c:out value="${ordineInPagina.cliente.nome
							  }"/> <c:out value="${ordineInPagina.cliente.cognome
							  }"/> </dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Fattorino:</dt>
							  <dd class="col-sm-9"><c:out value="${ordineInPagina.utente.nome
							  }"/> <c:out value="${ordineInPagina.utente.cognome
							  }"/> </dd>
					    	</dl>
					    						
					    	
					    </div>
					    
					    <div class='card-footer'>
					        
					        <form method="post" action="ExecuteDeleteOrdiniAttiviServlet">
								<input type="hidden" name="idOrdine" value="${ordineInPagina.id}"> 
						        <a href="ExecuteListOrdiniAttiviServlet" class='btn btn-outline-secondary' style='width:80px'>
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