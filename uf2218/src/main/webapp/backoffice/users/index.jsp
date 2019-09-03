<%@page import="com.ipartek.formacion.controller.backoffice.UserController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Listado Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  		
	  			<p class="d-inline">${u.id}</p>
	  			<p class="d-inline">${u.nombre}</p>
	  			<p class="d-inline">${u.contrasena}</p>
	  		
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>