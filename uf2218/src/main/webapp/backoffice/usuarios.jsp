<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 

<h1>Listado de Usuarios</h1>
	
	
	<%@include file="../includes/mensaje.jsp"%>
			
	
	<a href="" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	<ul class="list-group">
	  <c:forEach items="${usuarios}" var="u">	
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${u.id}">
	  			
	  			<p class="h3">${u.nombre}</p>
	  		</a>
	  	</li>
	  </c:forEach>	  	  
	</ul>






<%@include file="../includes/footer.jsp"%>