<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>${video.nombre}</h1>

<!-- 16:9 aspect ratio -->
<div class="row">
	<div class="col-2"></div>
	<div class="col-8">
		<div class="embed-responsive embed-responsive-16by9">
			<iframe class="embed-responsive-item "
				src="https://www.youtube.com/embed/${video.codigo}?rel=0"></iframe>
		</div>
	</div>
	<div class="col-2"></div>
</div>
<hr class="my-2">
<h1>Ultimos videos visualizados</h1>
<hr class="my-2">
<div class="row mb-2">
	<c:forEach items="${videosVistos}" var="vv">
	<div class="col-2">
		<a href="backoffice/videos?op=<%=YoutubeController.OP_DETALLE%>&id=${vv.value.id}">
			<img alt="${vv.value.nombre}" title="${vv.value.nombre}" class="rounded" src="https://img.youtube.com/vi/${vv.value.codigo}/default.jpg">
		</a>
	</div>
	</c:forEach>	
</div>

<%@include file="../../includes/footer.jsp"%>






