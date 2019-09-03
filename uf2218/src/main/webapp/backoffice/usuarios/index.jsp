<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado Usuarios</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
			
	<div class="row justify-content-md-center">
		<div class="col-12 col-md-3 mb-3">
			<ul class="list-group">
	  			<c:forEach items="${usuarios}" var="usuarios">	
	  				<li class="list-group-item">
	  	               <p class="h3">${usuarios.nombre}</p>
	  	           </li>
	            </c:forEach>	  	  
			</ul>
       </div>
	</div>
	
	
<%@include file="../../includes/footer.jsp"%>