<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

${param.videos}

<ul class="list-group">
	  <c:forEach items="${param.videos}" var="v" >	  
	  
	  	${v} 
	  	
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
	  			<li class="list-group-item">
	  			<iframe class="embed-responsive-item-1by1" src="https://www.youtube.com/embed/${video.getCodigo()}?rel=0" allowfullscreen></iframe></li>
	  			<p class="h3">${v.nombre}</p>
	  		</a>
	  		<a href="backoffice/usuario?op=<%=UsuariosController.OP_DETALLE%>&id=${v.usuario.id}">	
	  			<p><i class="fas fa-user mr-1"></i>${v.usuario.nombre}</p>
	  		</a>
	  			
	  		<p><i class="fas fa-tag mr-1"></i>${v.categoria.nombre}</p>
	  		
	  	</li>
	  </c:forEach>	  	  
	</ul>