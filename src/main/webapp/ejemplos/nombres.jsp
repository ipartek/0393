<%@page import="java.util.ArrayList"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Listado Nombres</h1>
	
	<div class="row">
	 ${mensaje}
	</div>	
<div class="row">	
	<div class="col-8">
		<h2>Buscar Nombre</h2>
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
			 	 ArrayList<String> listaNombres = (ArrayList<String>)request.getAttribute("listaNombres");
			     for( String nombre : listaNombres ){
			  %>	
			  		<li class="list-group-item"><%=nombre%></li>
			  <%
			     } // end for
			  %>
		</ul>
	</div>
	<div class="col-4">
		<h2>Nuevo Nombre</h2>
		<form action="getpost" method="post">
			<input type="text" name="nombre" placeholder="Dime tu nombre" required>
			<br> <input type="submit" value="Enviar">
		</form>
	</div>

</div>



<%@include file="../includes/footer.jsp"%>