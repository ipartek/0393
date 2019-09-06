<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Videos</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	<ul class="list-group">
	  <c:forEach items="${videos}" var="v">	
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
	  			<iframe class="embed-responsive-item-1by1" src="https://www.youtube.com/embed/${v.getCodigo()}?rel=0" allowfullscreen></iframe></li>
	  			<p class="h3"><i class="fas fa-user mr-1"></i>${v.nombre}</p>
	  		</a>
	  		<a href="backoffice/usuario?op=<%=UsuariosController.OP_DETALLE%>&id=${v.usuario.id}">	
	  			<p>${v.usuario.nombre}</p>
	  		</a>
	  		
	  		<p><i class="fas fa-tag mr-1"></i>${v.categoria.nombre}</p>
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>