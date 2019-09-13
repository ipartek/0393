<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>



	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<div class="row mt-4 ml-1">

<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>

</div>
	
	<div class="row">
		<div class="col">
			<h1>Videos Publicados</h1>
			<ul class="list-group">
	  <c:forEach items="${videosVisible}" var="v">	  
	  
		
			
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
	  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
	  			<p class="h3">${v.nombre}</p>
	  		</a>
	  		<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=${v.usuario.id}">	
	  			<p><i class="fas fa-user mr-1"></i>${v.usuario.nombre}</p>
	  		</a>
	  			
	  		<p><i class="fas fa-tag mr-1"></i>${v.categoria.nombre}</p>
	  		
	  	</li>
	  </c:forEach>	  	  
	</ul>
	</div>
	<div class="col">
	<h1>Videos Eliminados</h1>
	 <c:forEach items="${videosEliminados}" var="ve">	  
	  
	 
			
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${ve.id}">
	  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${ve.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
	  			<p class="h3">${ve.nombre}</p>
	  		</a>
	  		<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=${ve.usuario.id}">	
	  			<p><i class="fas fa-user mr-1"></i>${ve.usuario.nombre}</p>
	  		</a>
	  			
	  		<p><i class="fas fa-tag mr-1"></i>${ve.categoria.nombre}</p>
	  		
	  	</li>
	  </c:forEach>
					
		</div>
		
	</div>
	
<%@include file="../../includes/footer.jsp"%>