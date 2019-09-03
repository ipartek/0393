<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3">  -->

 <h1>BACKOFFICE</h1>

	<div class="row d-flex justify-content-between text-info">
	
		<div class="col-3 bg-dark text-center p-2">
			<a href="backoffice/usuarios"><i class="fas fa-users fa-10x"></i></a>
			<h2>${ totalUsuarios } Usuarios</h2>
		</div>
		<div class="col-3 bg-dark text-center p-2">
			<a href="backoffice/videos"><i class="fab fa-youtube fa-10x"></i></a>
			<h2>${ totalVideos } V�deos</h2>
			
		</div>		
		<div class="col-3 bg-dark text-center p-2">
			<a href="backoffice/videos"><i class="fas fa-times-circle fa-10x"></i></a>
			<h2>Pr�ximamente</h2>
			
		</div>
	</div>

 
 


<%@include file="../includes/footer.jsp"%>