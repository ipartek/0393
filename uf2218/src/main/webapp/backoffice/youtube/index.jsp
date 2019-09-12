<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

		
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	
	<div class="row">
		<div class="col">
			<h1>Videos Publicados</h1>
			<jsp:include page="list.jsp">	
				<jsp:param value="${videosVisibles}" name="videos"/>
			</jsp:include>			
		</div>
		<div class="col">
			<h1>Videos Ocultos</h1>
			<jsp:include page="list.jsp">	
				<jsp:param value="${videosNoVisibles}" name="videos"/>
			</jsp:include>			
		</div>
		
	</div>
	
	
<%@include file="../../includes/footer.jsp"%>