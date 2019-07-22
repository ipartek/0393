<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@page import="com.ipartek.formacion.model.pojo.Youtube"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<div class="row">
    <div class="col-10">
      <h1>Youtube</h1>
      
      <c:if test="${mensaje != null}">
			<div class="alert alert-${mensaje.tipo} alert-dismissible fade show"
				role="alert">
				<p>${mensaje.texto}</p>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
      
    </div>
    <div class="col">
     <a class="btn btn-primary mt-2" href="videos?op=<%=YoutubeController.OP_FORM%>" role="button" title="anadir"><i class="fas fa-plus"></i> Añadir</a>

    </div>
</div>

<%
		ArrayList<Youtube> videos = (ArrayList<Youtube>) request.getAttribute("videos");

		if (videos.isEmpty()) {
	%>
	<li class="list-group-item text-danger">Lo Sentimos pero no hay
		videos</li>
	<%
		}
	%>
<table class="table">
<thead>
	<tr class="text-center">
		<th scope="col">Video</th>
		<th scope="col">Título</th>
		<th scope="col">Operación</th>
	</tr>
</thead>
<tbody class="text-center">
	
	<%
		for (Youtube video : videos) {
	%>
	<tr>
		<td class="video">
			<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/<%=video.getCodigo()%>?rel=0"
						allowfullscreen>
					</iframe>
			</div>
		</td>
		<td class="align-middle">
			<a href="videos?op=<%=YoutubeController.OP_DETALLE%>&id=<%=video.getId()%>"><span class=""><%=video.getNombre()%></span></a>
		</td>	
		<td class="align-middle">
		<a class="btn btn-success" href="videos?op=<%=YoutubeController.OP_FORM%>&id=<%=video.getId()%>" role="button" title="editar"><i class="fas fa-edit"></i> Editar</a>
		<a class="btn btn-danger" href="videos?op=<%=YoutubeController.OP_BORRAR%>&id=<%=video.getId()%>" role="button" title="eliminar"><i class="fas fa-trash-alt"></i> Borrar</a>
		</td>
	</tr>	
		<%
			} // end for
		%>
	
</tbody>
</table>

<%@include file="../includes/footer.jsp"%>