<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.UserController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Videos</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	<!-- TODO importar la lista -->
	<div class="row">
		<div class="col">
			<h2>Videos visibles</h2>
			<jsp:include page="list.jsp" flush="true">
		    	<jsp:param name="videos" value="${VideosVisibles }"/>
			</jsp:include>
		</div>
		
		<div class="col">
			<h2>Videos no visibles</h2>
			<jsp:include page="list.jsp" flush="true">
		    	<jsp:param name="videos" value="${VideosVisibles }"/>
			</jsp:include>
		</div>
	</div>
	

	
<%@include file="../../includes/footer.jsp"%>