<%@page import="com.ipartek.formacion.controller.VideoController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Detalle Video</h1>
	
	<div class="row">
		<div class="col">
		
			<%@include file="../includes/mensaje.jsp"%>
			
			<form action="videos" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=VideoController.OP_GUARDAR%>">
			
				<div class="form-group">	
					<label for="id">Id:</label>
					<input type="text" name="id" value="${video.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${video.nombre}"
					       placeholder="Mínimio 3 máximo 150"
					       class="form-control">
				</div>
				
				<div class="form-group">
					<label for="codigo">Codigo:</label>
					<input type="text" name="codigo" value="${video.codigo}"
					       placeholder="Exactamente 11" 
						   class="form-control">
				</div>	
			
				<input type="submit" value="${(video.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary  btn-block">
			
			</form>
			
			<c:if test="${video.id != -1}">
				<form action="videos" method="post">	
					<input type="hidden" name="op" value="<%=VideoController.OP_ELIMINAR%>">
					<input type="hidden" name="id" value="${video.id}" readonly>			
					<input type="submit" value="Eliminar" class="btn btn-outline-danger btn-block">	
				</form>
			</c:if>	
		</div>
		<div class="col">	
		
			<div class="embed-responsive embed-responsive-16by9">
		
				<iframe class="embed-responsive-item"
				        src="https://www.youtube.com/embed/${video.codigo}" 
				        frameborder="0" 
				        allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" 
				        allowfullscreen></iframe>
			</div>        
		</div>
	</div>
	
<%@include file="../includes/footer.jsp"%>