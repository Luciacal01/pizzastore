<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
	
		<jsp:include page="../header.jsp"/>
		
		<title>Cerca Ordine</title>
	
	</head>
	<body>
		<jsp:include page="/Utente/navbarpizzaiolo.jsp"></jsp:include>
		
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
				        <h5>Cerca ordine</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="ExecuteSearchOrdineServlet" class="row g-3" novalidate="novalidate">
							
								<div class="col-md-6">
									<label for="codice" class="form-label">Codice</label>
									<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice">
								</div>
								
								<div class="col-md-6">
									<label for="data" class="form-label">Data</label>
	                        		<input class="form-control" id="data" type="date" placeholder="dd/MM/yy" 
	                        				title="formato : gg/mm/aaaa"  name="data" >
								</div>
								
								<div class="col-md-6">
									<label for="cliente.id">Cliente</label>
								    <select class="form-select" id="cliente.id" name="cliente.id">
								    	<option value="" selected> -- Selezionare una voce -- </option>
								      	<c:forEach items="${clienti_list_attribute }" var="clienteItem">
								      		<option value="${clienteItem.id}">${clienteItem.nome } ${clienteItem.cognome }</option>
								      	</c:forEach>
								    </select>
								</div>
								
								<div class="col-md-6">
									<label for="utente.id">Utente</label>
								    <select class="form-select" id="utente.id" name="utente.id">
								    	<option value="" selected> -- Selezionare una voce -- </option>
								      	<c:forEach items="${fattorini_list_attribute }" var="utenteItem">
								      		<option value="${utenteItem.id}">${utenteItem.nome } ${utenteItem.cognome }</option>
								      	</c:forEach>
								    </select>
								</div>
								
								<div class="col-md-6">
									<label for="closed" class="form-label">Closed</label>
									<select class="form-select" id="closed" name="closed">
								    	<option value="" selected> -- Selezionare una voce -- </option>
								    	<option value="true" selected> true </option>
								    	<option value="false" selected> false </option>
								    </select>
								</div>
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Cerca</button>
							</div>
		
						</form>
  
					<!-- end card-body -->			   
				    </div>
				<!-- end card -->
				</div>		
					  
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
		
		<jsp:include page="../footer.jsp"/>
	</body>
</html>