<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>

<h1>Ejemplo Servlet Content Type</h1>
<p>Un servlet de Java siempre responde por defecto con <code>text/html</code></p>
<p><a href="https://developer.mozilla.org/es/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Lista_completa_de_tipos_MIME" target="_blank"></a>Listado de los content-type que soporta un navegador</p>
<p>Vamos a responder desde el servlet los mismos datos, pero con diferente content-type</p>
<p>DATOS: perro[ nombre= 'bubba', raza = 'boxer']</p>

<a href="servlet3?p=1" class="btn btn-outline-primary">Respuesta texto plano</a>
<a href="servlet3?p=2" class="btn btn-outline-primary">Respuesta texto html</a>
<a href="servlet3?p=3" class="btn btn-outline-primary">Respuesta texto JSON</a>
<a href="servlet3?p=4" class="btn btn-outline-primary">Respuesta texto PDF</a>


<%@include file="../includes/footer.jsp" %>