<%@page import="com.ipartek.formacion.controller.VideoController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Listado Videos</h1>
	
	<a href="videos?op=<%=VideoController.OP_NUEVO%>">Nuevo Video</a>
	
	<ul class="list-group">
	  <c:forEach items="${videos}" var="v">	
	  	<li class="list-group-item"><a href="videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">${v.nombre}</a></li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../includes/footer.jsp"%>