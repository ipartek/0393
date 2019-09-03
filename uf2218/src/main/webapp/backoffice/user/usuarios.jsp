<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%> 

<h1>Listado de Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/usuarios?op=<%=UsuarioController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
	
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  		<i class="fas fa-users"></i>
	  		<p class="h3">${u.nombre}</p>
	  		<a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${u.id}">
	  	</li>
	  </c:forEach>	  	  
	</ul>



<%@include file="../../includes/footer.jsp"%>