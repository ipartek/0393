<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@page import="com.ipartek.formacion.controller.UsuarioController"%>
<%@page import="com.ipartek.formacion.model.pojo.Youtube"%>
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<div class="row">
    <div class="col-10">
      <h1>Videos visibles</h1>
      <%@include file="../../includes/mensaje.jsp"%>
  
    </div>
    <div class="col">
     <a class="btn btn-primary mt-2" href="backoffice/videos?op=<%=YoutubeController.OP_FORM%>" role="button" title="anadir"><i class="fas fa-plus"></i> Añadir</a>

    </div>
</div>

<%
		ArrayList<Youtube> videosVisibles = (ArrayList<Youtube>) request.getAttribute("videosVisibles");

		if (videosVisibles.isEmpty()) {
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
		for (Youtube video : videosVisibles) {
	%>
	<tr>
		<td class="video">
			<div class="embed-responsive">
					<img alt="" class="rounded" src="https://img.youtube.com/vi/<%=video.getCodigo()%>/default.jpg">
					<!-- 
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/<%=video.getCodigo()%>?rel=0"
						allowfullscreen>
					</iframe>
					 -->
			</div>
		</td>
		<td class="align-middle">
			<a href="backoffice/videos?op=<%=YoutubeController.OP_DETALLE%>&id=<%=video.getId()%>"><span class="h3"><%=video.getNombre()%></span></a>	
			<p><i class="fas fa-user mr-1"></i><a href ="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>&id=<%=video.getUsuario().getId()%>"><%=video.getUsuario().getNombre()%></p></a>	
			<p><i class="fas fa-tag mr-1"></i> <%=video.getCategoria().getNombre()%></p>	
		</td>
		
			
		<td class="align-middle">
		<a class="btn btn-success" href="backoffice/videos?op=<%=YoutubeController.OP_FORM%>&id=<%=video.getId()%>" role="button" title="editar"><i class="fas fa-edit"></i> Editar</a>
		<!-- 
		<a class="btn btn-danger" href="backoffice/videos?op=<%=YoutubeController.OP_BORRAR%>&id=<%=video.getId()%>" role="button" title="eliminar"><i class="fas fa-trash-alt"></i> Borrar</a>
		 -->
		<a class="btn btn-danger text-light" role="button" title="eliminar" data-toggle="modal" data-target="#eliminar<%=video.getId()%>"><i class="fas fa-trash-alt"></i> Borrar</a>
		
		<!-- Modal -->
					<div class="modal fade" id="eliminar<%=video.getId()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">¿Estas Seguro de ELIMINAR el registro?</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <p>Cuidado porque operación no es reversible</p>
					      </div>
					      <div class="modal-footer">
				        	<form action="backoffice/videos" method="post">					 
								<input type="hidden" name="op" value="<%=YoutubeController.OP_ELIMINAR%>">
								<input type="hidden" name="id" value="<%=video.getId()%>" readonly>			
								<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
							</form>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					      </div>
					    </div>
					  </div>
					</div>	

		</td>
	</tr>	
		<%
			} // end for
		%>
	
</tbody>
</table>


<h1>Videos Eliminados</h1>

<%
		ArrayList<Youtube> videosEliminados = (ArrayList<Youtube>) request.getAttribute("videosEliminados");

		if (videosEliminados.isEmpty()) {
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
		for (Youtube video : videosEliminados) {
	%>
	<tr>
		<td class="video">
			<div class="embed-responsive">
					<img alt="" class="rounded" src="https://img.youtube.com/vi/<%=video.getCodigo()%>/default.jpg">
					<!-- 
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/<%=video.getCodigo()%>?rel=0"
						allowfullscreen>
					</iframe>
					 -->
			</div>
		</td>
		<td class="align-middle">
			<a href="backoffice/videos?op=<%=YoutubeController.OP_DETALLE%>&id=<%=video.getId()%>"><span class="h3"><%=video.getNombre()%></span></a>	
			<p><i class="fas fa-user mr-1"></i><a href ="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>&id=<%=video.getUsuario().getId()%>"><%=video.getUsuario().getNombre()%></p></a>	
			<p><i class="fas fa-tag mr-1"></i> <%=video.getCategoria().getNombre()%></p>	
		</td>
		
			
		<td class="align-middle">
		<a class="btn btn-success" href="backoffice/videos?op=<%=YoutubeController.OP_FORM%>&id=<%=video.getId()%>" role="button" title="editar"><i class="fas fa-edit"></i> Editar</a>
		<!-- 
		<a class="btn btn-danger" href="backoffice/videos?op=<%=YoutubeController.OP_BORRAR%>&id=<%=video.getId()%>" role="button" title="eliminar"><i class="fas fa-trash-alt"></i> Borrar</a>
		 -->
		<a class="btn btn-danger text-light" role="button" title="eliminar" data-toggle="modal" data-target="#eliminar<%=video.getId()%>"><i class="fas fa-trash-alt"></i> Borrar</a>
		
		<!-- Modal -->
					<div class="modal fade" id="eliminar<%=video.getId()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">¿Estas Seguro de ELIMINAR el registro?</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <p>Cuidado porque operación no es reversible</p>
					      </div>
					      <div class="modal-footer">
				        	<form action="backoffice/videos" method="post">					 
								<input type="hidden" name="op" value="<%=YoutubeController.OP_ELIMINAR%>">
								<input type="hidden" name="id" value="<%=video.getId()%>" readonly>			
								<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
							</form>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					      </div>
					    </div>
					  </div>
					</div>	

		</td>
	</tr>	
		<%
			} // end for
		%>
	
</tbody>
</table>

<%@include file="../../includes/footer.jsp"%>