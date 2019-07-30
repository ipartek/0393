<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<%@include file="../includes/mensaje.jsp"%>

<h1>Calculadora</h1>
<h2>Recuperar properties desde Servlet/Controlador</h2>
${mensajeIdioma}
${mensajeInicio}
<ol>
  <li><a href="i18n?idiomaSeleccionado=es_ES"><img alt="Imagen bandera españa" src="http://www.euskalak.com/imagenes/Spain.png" width=128px></a></li>
  <li><a href="i18n?idiomaSeleccionado=en_EN"><img alt="Imagen bandera uk" src="http://www.euskalak.com/imagenes/british.png" width=128px></a></li>
  <li><a href="i18n?idiomaSeleccionado=eu_ES"><img alt="Imagen bandera ikurrina" src="http://www.euskalak.com/imagenes/euskadi.png" width=128px></a></li>
</ol>

<h2>Recuperar properties desde JSP</h2>

<% //@see mirar la jsp header.jsp para la gestion de idioma %>

<p>idiomaSeleccionado: ${idiomaSeleccionado }</p> 

<p class="h3 text-danger"><fmt:message key="menu.ejemplo" /></p>
<p class="h3 text-danger"><fmt:message key="menu.inicio" /></p>

<%@include file="../includes/footer.jsp"%>