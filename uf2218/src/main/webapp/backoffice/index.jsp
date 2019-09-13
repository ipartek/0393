<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3">  -->

 <h1>BACKOFFICE</h1>

	<div class="row d-flex justify-content-between text-info">
	
		<div class="col bg-dark text-center p-2">
			<a href="backoffice/videos"><i class="fab fa-youtube fa-5x"></i></a>
			<h3>${ totalVideos } Vídeos</h3>
		</div>
		
		<div class="col bg-dark text-center p-2">
			<a href="backoffice/usuarios?activo=1"><i class="fas fa-users fa-5x"></i></a>
			<h3>${ totalUsuariosVisibles } Usuarios Activos</h3>
		</div>
		
		<div class="col bg-dark text-center p-2">
			<a href="backoffice/usuarios?activo=0"><i class="fas fa-users fa-5x"></i></a>
			<h3>${ totalUsuariosEliminados } Usuarios Desactivados</h3>
		</div>
		
		<div class="col bg-dark text-center p-2">
			<a href="backoffice/categorias"><i class="fas fa-users fa-5x"></i></a>
			<h3>${ totalUsuariosEliminados } Categorías</h3>
		</div>
		
		<div class="col bg-dark text-center p-2">
			<a href="backoffice/roles"><i class="fas fa-users fa-5x"></i></a>
			<h3>${ totalRoles } Roles</h3>
		</div>
	</div>

<%@include file="../includes/footer.jsp"%>