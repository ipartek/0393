<%@page import="com.ipartek.formacion.controller.backoffice.UserController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Listado Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
	
	<a href="backoffice/users?op=<%=UserController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
	
	
	<form action="backoffice/users">
		<input type="search" name="nombreBuscar" placeholder="Buscar por Nombre" required>
		<input type="hidden" name="op" value="<%=UserController.OP_BUSCAR%>">
		<input type="submit" value="filtrar">	
	</form>
			
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  			<a href="backoffice/users?op=<%=UserController.OP_DETALLE%>&id=${u.id}">
	  			<p class="d-inline">${u.id}</p>
	  			<p class="d-inline">${u.nombre}</p>
	  			<!--  <p class="d-inline">${u.contrasena}</p>  -->
	  		
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>