<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Detalle</h1>
<h2>${video.nombre}</h2>


<div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/${video.codigo}?rel=0" allowfullscreen></iframe>
</div>

<%@include file="../../includes/footer.jsp"%>