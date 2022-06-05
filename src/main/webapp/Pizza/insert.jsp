<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.prova.pizzastore.model.Pizza"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Inserisci Nuova Pizza</title>
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
				        <h5>Inserisci nuova Pizza</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteInsertPizzaServlet" class="row g-3" novalidate="novalidate">
								
								<c:set var="pizzaInPagina" value="${insert_pizza_attr }"/>
							
								<div class="col-md-6">
									<label for="descrizione" class="form-label">descrizione <span class="text-danger">*</span></label>
									<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"  
										value="${pizzaInPagina.descrizione }" required>
								</div>
								
								<div class="col-md-6">
									<label for="ingredienti" class="form-label">ingredienti <span class="text-danger">*</span></label>
									<input type="text" name="ingredienti" id="ingredienti" class="form-control" placeholder="Inserire gli ingredienti"  
										value="${pizzaInPagina.ingredienti }" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzobase" class="form-label">prezzobase <span class="text-danger">*</span></label>
									<input type="text" name="prezzobase" id="prezzobase" placeholder="Inserire il prezzo base" 
									value="${pizzaInPagina.prezzoBase }" required>
								</div>
								
							<div class="col-12">
								<a href="ExecuteInsertPizzaServlet" class='btn btn-outline-secondary' style='width:80px'>
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