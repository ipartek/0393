<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.UserController"%>

<ul class="list-group">
	  <c:forEach items="${param.videos}" var="v">	
	  	<li class="list-group-item">
	  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
	  			<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
	  			<p class="h3">${v.nombre}</p>
	  		</a>
	  		<a href="backoffice/users?op=<%=UserController.OP_DETALLE%>&id=${v.usuario.id }">
	  			<p><i class="fas fa-user"></i> ${v.usuario.nombre }</p>
	  		</a>
	  		<p><i class="fas fa-tag"></i> ${v.categoria.nombre }</p>
	  	</li>
	  </c:forEach>	  	  
	</ul>