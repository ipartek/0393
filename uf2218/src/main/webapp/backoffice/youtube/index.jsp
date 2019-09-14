<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.UserController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.CategoriaController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Videos</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	<!-- TODO importar la lista -->
	
	<div class="row">
		<div class="col">
			<h2>Videos visibles</h2>
			<ul class="list-group">
			<c:forEach items="${videosVisibles }" var="v">	
			  	<li class="list-group-item">
			  		<div class="row">
			  			<div class="col-3">
			  				<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
			  			</div>
			  			<div class="col-9">
					  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
					  			
					  			<p class="h3">${v.nombre}</p>
					  		</a>
					  		<a href="backoffice/users?op=<%=UserController.OP_DETALLE%>&id=${v.usuario.id }">
					  			<p><i class="fas fa-user"></i> ${v.usuario.nombre }</p>
					  		</a>
					  		<a href="backoffice/categorias?op=<%=CategoriaController.OP_IR_FORMULARIO%>&id=${v.categoria.id }">
					  			<p><i class="fas fa-tag"></i> ${v.categoria.nombre }</p>
					  		</a>
					  		<p class="text-danger"><i class="fas fa-heart"></i> ${v.likes }</p>
				  		</div>
			  		</div>
			  	</li>
	  		</c:forEach>
	  		</ul>
		</div>
		
		<div class="col">
			<h2>Videos no visibles</h2>
			<ul class="list-group">
			<c:forEach items="${videosNoVisibles }" var="v">	
			  	<li class="list-group-item">
			  		<div class="row">
			  			<div class="col-3">
			  				<img class="float-left mr-3" src="https://img.youtube.com/vi/${v.codigo}/default.jpg" alt="Imagen destacda del video ${v.nombre}"/>
			  			</div>
			  			<div class="col-9">
					  		<a href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${v.id}">
					  			
					  			<p class="h3">${v.nombre}</p>
					  		</a>
					  		<a href="backoffice/users?op=<%=UserController.OP_DETALLE%>&id=${v.usuario.id }">
					  			<p><i class="fas fa-user"></i> ${v.usuario.nombre }</p>
					  		</a>
					  		<a href="backoffice/categorias?op=<%=CategoriaController.OP_IR_FORMULARIO%>&id=${v.categoria.id }">
					  			<p><i class="fas fa-tag"></i> ${v.categoria.nombre }</p>
					  		</a>
					  		<p class="text-danger"><i class="fas fa-heart"></i> ${v.likes }</p>
				  		</div>
			  		</div>
			  	</li>
	  		</c:forEach>
	  		</ul>
		</div>
	</div>
	

	
<%@include file="../../includes/footer.jsp"%>