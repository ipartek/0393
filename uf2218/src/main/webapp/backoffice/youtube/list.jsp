<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<ul class="list-group">
  <c:forEach items="${param.videos}" var="v">	  	
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