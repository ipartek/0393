<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

		
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	
	<div class="row">
		<div class="col">
			<h1>Videos Publicados</h1>
			${videosVisibles}
			
			<ul class="list-group">
			<c:forEach items="${videosVisibles}" var="v" >
			
			<li class="list-group-item">
				<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
					<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
					<p class="h3">${v.nombre}</p>
				</a>
			</li>
			</c:forEach>
			
			</ul>
			
		
		</div>
			<div class="col">
			<h1>Videos No Publicados</h1>
			${videosNoVisibles}
		
		</div>
		
		
		
	</div>
	
	
<%@include file="../../includes/footer.jsp"%>