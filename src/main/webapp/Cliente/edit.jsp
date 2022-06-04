<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.pizzastore.model.Cliente"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Cliente</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="/Utente/navbaradmin.jsp"></jsp:include>
	    
			
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
				        <h5>Modifica cliente</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteUpdateClienteServlet" class="row g-3" novalidate="novalidate">
								
								<c:set var="clienteInPagina" value="${cliente_da_modificare }"/>
							
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome <span class="text-danger">*</span></label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  
										value="${clienteInPagina.nome }" required>
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Cognome <span class="text-danger">*</span></label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome"  
										value="${clienteInPagina.cognome }" required>
								</div>
							
								<div class="col-md-6">
									<label for="indirizzo" class="form-label">Indirizzo <span class="text-danger">*</span></label>
									<input type="text" name="indirizzo" id="indirizzo" placeholder="Inserire indirizzo" 
									value="${clienteInPagina.indirizzo }" required>
								</div>
								
								<div class="col-md-6">
									<label for="attivo" class="form-label">Attivo</label>
								    <select class="form-select" id="attivo" name="attivo">
								    	<option value="" selected> -- Selezionare una voce -- </option>
								    	<option value="true">true</option>
								    	<option value="false">false</option>
								    </select>
								</div>
								
								<input type="hidden" name="idCliente" value="${clienteInPagina.id}">
								
							<div class="col-12">
								<a href="ExecuteListClienteServlet" class='btn btn-outline-secondary' style='width:80px'>
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