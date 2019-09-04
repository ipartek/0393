<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/usuario?op=<%=UsuariosController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
	
	
	<form action="backoffice/usuario">
		<input type="search" name="nombreBuscar" placeholder="Buscar por Nombre" required>
		<input type="hidden" name="op" value="<%=UsuariosController.OP_BUSCAR%>">
		<input type="submit" value="filtrar">	
	</form>
	
	
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  		<a href="backoffice/usuario?op=<%=UsuariosController.OP_DETALLE%>&id=${u.id}">	  			
	  			<p class="h3">${u.id} ${u.nombre}</p>
	  		</a>
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>