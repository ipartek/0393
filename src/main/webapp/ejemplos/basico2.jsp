<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<h1>Ejemplo Servlet Basico con JSP</h1>
<p>Hacemos una peticion GET a traes del enlace (botón) de abajo</p>
<p>Cuando recibe la peticion el servlet realizar una request interna a esta misma jsp, pasandole 2 atributos</p>

<a href="useragent" class="btn btn-outline-primary">Detectar navegador que estas usando</a>
<h2>Respuesta</h2>
<p>${navegador}</p>
<p>${movil}</p>

<%@include file="../includes/footer.jsp" %>