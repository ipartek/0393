<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%> 

<h1>Listado de Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
	
	<a href="backoffice/usuarios?op=<%=UsuarioController.OP_NUEVO%>" class="mb-3 mr-2 btn btn-outline-primary">Nuevo Usuario</a>
			
	<form action="backoffice/usuarios" method="post" class="mb-2 form-inline">
			<label class="mr-2" for="nombreBuscar">Busqueda:</label>
			<input type="text" name="nombreBuscar" placeholder="" class="form-control mr-2">
			<input type="hidden" name="op" value="<%=UsuarioController.OP_BUSCAR%>">
			<input type="submit" value="Search">	
	</form>
	
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  		<i class="fas fa-users"></i>
	  		<a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${u.id}">${u.nombre}</a>
	  	</li>
	  </c:forEach>	  	  
	</ul>



<%@include file="../../includes/footer.jsp"%>