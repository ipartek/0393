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
	  			<p class="h3">${v.nombre}</p>
	  		</a>
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>