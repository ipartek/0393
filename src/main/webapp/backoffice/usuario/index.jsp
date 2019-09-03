<%@page import="com.ipartek.formacion.controller.UsuarioController"%>
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<div class="row">
    <div class="col-10">
      <h1>Usuarios</h1>
      <%@include file="../../includes/mensaje.jsp"%> 
    </div> 
    <div class="col">
     <a class="btn btn-primary mt-2" href="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>" role="button" title="anadir"><i class="fas fa-plus"></i> Añadir</a>
    </div>
</div>

<%
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");

		if (usuarios.isEmpty()) {
	%>
	<li class="list-group-item text-danger">Lo Sentimos pero no hay
		usuarios</li>
	<%
		}
	%>

<table class="table">
<thead>
	<tr class="text-center">
		<th scope="col">Id</th>
		<th scope="col">Usuario</th>
		<th scope="col">Contraseña</th>
		<th scope="col">Opciones</th>
	</tr>
</thead>

<tbody class="text-center">
	
	<%
		for (Usuario usuario : usuarios) {
	%>
	<tr>
		<td class="align-middle">
			<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=<%=usuario.getId()%>"><span class=""><%=usuario.getId()%></span></a>
		</td>
		<td class="align-middle">
			<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=<%=usuario.getId()%>"><span class=""><%=usuario.getNombre()%></span></a>
		</td>
		<td class="align-middle">
			<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=<%=usuario.getId()%>"><span class=""><%=usuario.getContrasenya()%></span></a>
		</td>	
		<td class="align-middle">
		<a class="btn btn-success" href="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>&id=<%=usuario.getId()%>" role="button" title="editar"><i class="fas fa-edit"></i> Editar</a>
		<!-- 
		<a class="btn btn-danger" href="backoffice/videos?op=<%=UsuarioController.OP_BORRAR%>&id=<%=usuario.getId()%>" role="button" title="eliminar"><i class="fas fa-trash-alt"></i> Borrar</a>
		 -->
		<a class="btn btn-danger text-light" role="button" title="eliminar" data-toggle="modal" data-target="#eliminar"><i class="fas fa-trash-alt"></i> Borrar</a>
		
		<!-- Modal -->
					<div class="modal fade" id="eliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
								<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
								<input type="hidden" name="id" value="<%=usuario.getId()%>" readonly>			
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