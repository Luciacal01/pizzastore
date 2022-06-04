<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.pizzastore.model.Cliente"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Pagina dei Risultati</title>
	 </head>
	 
	<body class="d-flex flex-column h-100">
	 
		<!-- Fixed navbar -->
		<jsp:include page="/Utente/navbaradmin.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
				  ${errorMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
		  
		  
		  
		  		<div class='card'>
				    <div class='card-header'>
				        <h5>Lista dei risultati</h5> 
				    </div>
				    <div class='card-body'>
				    	<a class="btn btn-primary " href="PrepareInsertClienteServlet">Add New</a>
				    
				        <div class='table-responsive'>
				            <table class='table table-striped ' >
				                <thead>
				                    <tr>
			                         	<th>Nome</th>
				                        <th>Cognome</th>
				                        <th>Indirizzo</th>
				                        <th>Attivo</th>
				                        <th>Azioni</th>
				                    </tr>
				                </thead>
				                <tbody>
				                	<c:forEach items="${clienti_list_attribute }" var="clientiItem">
										<tr>
											<td>${clientiItem.nome }</td>
											<td>${clientiItem.cognome }</td>
											<td>${clientiItem.indirizzo } </td>
											<td>${clientiItem.attivo }</td>
											<td>
												<a class="btn  btn-sm btn-outline-secondary" href="ExecuteListClienteServlet?idCliente=${clientiItem.id }">Visualizza</a>
												<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateClienteServlet?idCliente=${clientiItem.id }">Edit</a>
												<a class="btn btn-outline-danger btn-sm" href="PrepareDeleteClienteServlet?idCliente=${clientiItem.id }">Delete</a>
											</td>
										</tr>
									</c:forEach>
				                </tbody>
				            </table>
				            	 <a href="HomeServlet" class='btn btn-outline-secondary' style='width:150px'>
					            	<i class='fa fa-chevron-left'></i> Torna alla home
					        		</a>
				        </div>
				   
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