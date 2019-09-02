<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3">  -->

 <h1>BACKOFFICE</h1>
 
 <div class="row d-flex justify-content-center">
 	<div class="col-5">
 		<i class="fas fa-users fa-10x"></i>
 		<h2>${ totalUsuarios } Usuarios</h2>
 	</div>
 	<div class="col-5">
 		<a href="backoffice/videos"><i class="fab fa-youtube fa-10x"></i></a>
 		<h2>${ totalVideos } Vídeos</h2>
 		
 	</div>
 </div>

 
 


<%@include file="../includes/footer.jsp"%>