<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3"> -->

	<h1>BACKOFFICE</h1>
	 
	<hr>
	
	<div class="row">
		<div class="col">
			<div class="jumbotron bg-danger p-4">
				<h3 class="text-light">${nVideos} <fmt:message key="menu.videos" /></h3>
				<br>
				<a class="text-light" href="backoffice/videos?op=<%=VideoController.OP_LISTAR%>"><fmt:message key="backoffice.detalles" /> >></a>
			</div>
		</div>
		<div class="col">
			<div class="jumbotron bg-primary p-4">
				<h3 class="text-light">${nUsuariosActivos} <fmt:message key="menu.usuariosactivos" /></h3>
				<br>
				<a class="text-light" href="backoffice/usuarios?op=<%=UsuarioController.OP_LISTAR%>&visible=true"><fmt:message key="backoffice.detalles" /> >></a>
			</div>
		</div>
		<div class="col">
			<div class="jumbotron bg-warning p-4">
				<h3 class="text-light mb-1">${nUsuariosEliminados} <fmt:message key="menu.usuarioseliminados" /></h3>
				<br>
				<a class="text-light" href="backoffice/usuarios?op=<%=UsuarioController.OP_LISTAR%>&visible=false"><fmt:message key="backoffice.detalles" /> >></a>
			</div>
		</div>
	</div>
	
	<!-- 
	<a href="backoffice/videos?op=<%=VideoController.OP_LISTAR%>" class="mb-3 mr-5 btn btn-outline-primary">${nVideos} Videos <i class="fab fa-youtube"></i></a>
	 
	<a href="backoffice/usuarios?op=<%=UsuarioController.OP_LISTAR%>" class="mb-3 mr-5 btn btn-outline-primary">${nUsuarios} Usuarios <i class="fas fa-user"></i></a>
	-->
<%@include file="../includes/footer.jsp"%>