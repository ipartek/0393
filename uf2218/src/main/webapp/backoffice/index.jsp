<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>


 <h1>BACKOFFICE</h1>
 
 
<!-- VIDEOS ${numeroVideos }  -->

<div class="row rounded">
	<div class="col-3 bg-primary m-2">
		<span class="d-block text-white"><i class="fas fa-video"></i> ${numeroVideos } videos </span>
		<a href="backoffice/videos" class="btn btn-success d-block">Ver videos</a>	
	</div>
	
	<div class="col-3 bg-warning m-2">
		<span class="d-block"><i class="fas fa-users"></i> ${numeroUsuarios } usuarios</span>
		<!--  <a href="backoffice/videos" class="btn btn-success d-block">Ver videos</a>  -->	
	</div>

</div>

<br>




<%@include file="../includes/footer.jsp"%>