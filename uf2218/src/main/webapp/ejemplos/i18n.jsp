<%@page import="com.ipartek.formacion.controller.CalculadoraController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<%@include file="../includes/mensaje.jsp"%>



	<h1>Idiomas</h1>
	
	${mensajeIdioma}
	
	
	<ol>
		<li><a href="i18n?idiomaSeleccionado=es_ES">IMAGEN BANDERA EGPAÑA</a></li>
		<li><a href="i18n?idiomaSeleccionado=en_EN">IMAGEN BANDERA EEUU</a></li>
		<li><a href="i18n?idiomaSeleccionado=eu_ES">IMAGEN IKURRINA</a></li>
	</ol>
	

<%@include file="../includes/footer.jsp"%>