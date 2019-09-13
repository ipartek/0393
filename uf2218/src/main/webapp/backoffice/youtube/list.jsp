<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
<div class="row">
		<div class="col">
			<h1>Videos Publicados</h1>
			<ul class="list-group">
	  			<c:forEach items="${videosVisibles}" var="visible" >	  
  				  	<li class="list-group-item">
				  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${visible.idvideo}">
				  				<iframe class="embed-responsive-item-1by1" src="https://www.youtube.com/embed/${visible.getCodigo()}?rel=0" allowfullscreen></iframe></li>
				  			<p class="h3">${visible.nombre}</p>
				  		</a>
				  		<a href="backoffice/usuarios?op=<%=UsuariosController.OP_DETALLE%>&id=${v.usuario.idsuario}">	
				  			<p><i class="fas fa-user mr-1"></i>${visible.usuario.nombre}</p>
				  		</a>				  			
				  		<p><i class="fas fa-tag mr-1"></i>${visible.categoria.nombre}</p>						  		
				  	</li>					
				</c:forEach>
			</ul>		
		</div>
		
		<div class="col">
			<h1>Videos Ocultos</h1>
			<ul class="list-group">
	  			<c:forEach items="${videosNoVisibles}" var="novisible" >	  
  				  	<li class="list-group-item">
				  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${novisible.idvideo}">
				  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${novisible.codigo}/default.jpg" alt="Imagen destacda del video ${novisible.nombre}"/>
				  			<p class="h3">${novisible.nombre}</p>
				  		</a>
				  		<a href="backoffice/usuarios?op=<%=UsuariosController.OP_DETALLE%>&id=${novisible.usuario.idusuario}">	
				  			<p><i class="fas fa-user mr-1"></i>${novisible.usuario.nombre}</p>
				  		</a>				  			
				  		<p><i class="fas fa-tag mr-1"></i>${novisible.categoria.nombre}</p>						  		
				  	</li>					
				</c:forEach>
			</ul>		
		</div>
		
		
	</div>
	
	
<%@include file="../../includes/footer.jsp"%>
	