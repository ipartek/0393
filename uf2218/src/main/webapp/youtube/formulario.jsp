<%@page import="com.ipartek.formacion.controller.VideoController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Detalle Video</h1>
	
		
	<form action="videos" method="post">
	
		<input type="hidden" name="op" value="<%=VideoController.OP_GUARDAR%>">
	
		<label for="id">Id:</label>
		<input type="text" name="id" value="${video.id}" readonly>
		<br>
		<label for="nombre">Nombre:</label>
		<input type="text" name="nombre" value="${video.nombre}">
		<br>
		<label for="codigo">Codigo:</label>
		<input type="text" name="codigo" value="${video.codigo}">
		<br>	
	
		<input type="submit" value="${(video.id != -1)?'Modificar':'Crear'}">
	
	</form>
	
	<c:if test="${video.id != -1}">
		<form action="videos" method="post">	
			<input type="hidden" name="op" value="<%=VideoController.OP_ELIMINAR%>">
			<input type="hidden" name="id" value="${video.id}" readonly>			
			<input type="submit" value="Eliminar">	
		</form>
	</c:if>	

	
	
<%@include file="../includes/footer.jsp"%>