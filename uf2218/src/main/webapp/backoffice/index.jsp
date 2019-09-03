<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>


 <h1>BACKOFFICE</h1>


<div class="row">
	<div class="col-3 bg-primary m-2 p-2 border rounded shadow-sm">
		<h3 class="text-white text-center"><i class="fas fa-video"></i> ${numeroVideos } videos </h3>
		<a href="backoffice/videos" class="btn btn-success d-block">Ver videos</a>	
	</div>
	
	<div class="d-flex align-items-center justify-content-center col-3 bg-warning m-2 p-2 border rounded shadow-sm">
		<h3 class="text-center"><i class="fas fa-users"></i> ${numeroUsuarios } usuarios</h3>
			
	</div>

</div>

<%@include file="../includes/footer.jsp"%>