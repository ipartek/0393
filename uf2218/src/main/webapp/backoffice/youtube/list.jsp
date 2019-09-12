<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<ul class="list-group">
	<c:forEach items="${param.videos}" var="v">	
	  	<li class="list-group-item">
	  		<p class="h3">
	  			<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
	  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacada del video ${v.nombre}"/>
	  			${v.nombre}
	  			</a>
	  		</p>
	  		<p>
	  			<a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${v.usuario.id}">
	  			<i class="fas fa-users"></i> ${v.usuario.nombre}
	 			</a>
	 		</p>
	  		<p><i class="fas fa-tag"></i> ${v.categoria.nombre}</p>
	  	</li>
	  </c:forEach>	  	  
	</ul>