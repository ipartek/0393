<%@page import="java.util.ArrayList"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Listado Nombres</h1>
	
	<div class="row">
	 ${mensaje}
	</div>	
	
	<div class="row">	
		<div class="col-8">		
			
			<form method="get" action="nombres" class="form-inline">			  	
			  <label class="sr-only" for="buscar">Name</label>
			  <input type="search"
			  		 name="buscar"
			  		 id="buscar"
			  		 value="${buscar}"
			  		 required
			  		 class="form-control mb-2 mr-sm-2"  
			  		 placeholder="nombre a buscar">			  		 
			  <button type="submit" class="btn btn-primary mb-2">Buscar</button>
			  
			</form>
		
			<% if ( request.getAttribute("buscar") != null ){ %>
				<p class="text-muted">Resultados para la busqueda de <b>${buscar}</b></p>
			<% } %>	
			
			
			
			<ul class="list-group">
			  <%
			 	 ArrayList<String> nombres = (ArrayList<String>)request.getAttribute("nombres");
			     for( String nombre : nombres ){
			  %>	
			  		<li class="list-group-item"><%=nombre%></li>
			  <%
			     } // end for
			  %>
			</ul>		
		</div>
				
		<div class="col-4">
			**FORMLARIO CREAR**			
		</div>	
	</div>
	<!-- .row -->
	


<%@include file="../includes/footer.jsp"%>