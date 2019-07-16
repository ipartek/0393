<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Ejemplo Servlet Basico con JSP</h1>
	
	<a href="useragent" class="btn btn-outline-primary">Detectar Nagevador que estas usando</a>
	
	<h2>Respuesta</h2>
	<p>${navegador}</p>
	<p>${movil}</p>
	

<%@include file="../includes/footer.jsp"%>