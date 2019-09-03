<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/usuarios" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
	
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="v">	
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=UsuarioController.OP_DETALLE%>&id=${u.id}">
	  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${u.codigo}/default.jpg" alt="Imagen destacda del video ${u.nombre}"/>
	  			<p class="h3">${u.nombre}</p>
	  		</a>
	  	</li>
	  </c:forEach>	  	  
	</ul>
	
<%@include file="../../includes/footer.jsp"%>