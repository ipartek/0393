<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1><fmt:message key="index.title" /></h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
	
	<!-- <c:if test="${(sessionScope.usuario.id_rol == 1)}"> -->
		<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
		<div class="row">
			<div class="col">
				<h2>Videos Publicados</h2>
				<jsp:include page="list.jsp">
					<jsp:param value="${videosVisibles}" name="videos"/>
				</jsp:include>
			</div>
			<div class="col">
				<h2>Videos Eliminados</h2>
				<jsp:include page="list.jsp">
					<jsp:param value="${videosEliminados}" name="videos"/>
				</jsp:include>
			</div>
		</div>		
	<!-- </c:if>
	<c:if test="${(sessionScope.usuario.id_rol != 1)}">
		<h2>Videos Publicados</h2>
			<jsp:include page="list.jsp">
				<jsp:param value="${videosVisibles}" name="videos"/>
			</jsp:include>
	</c:if>-->
	
	
	

	
	
<%@include file="../../includes/footer.jsp"%>