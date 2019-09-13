<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

		
	<%@include file="../../includes/mensaje.jsp"%>
			
	
	<a href="backoffice/videos?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Video</a>
	
	
	<div class="row">
		<div class="col">
			<h1>Videos Publicados</h1>
			<ul class="list-group">
	  			<c:forEach items="${videosVisibles}" var="video" >	  
	  				<jsp:include page="list-item.jsp">
	  					<jsp:param value="${video}" name="v"/>
	  				</jsp:include>						
				</c:forEach>
			</ul>		
		</div>
		
		
	</div>
	
	
<%@include file="../../includes/footer.jsp"%>