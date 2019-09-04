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
</div>
<div class="row">
	<div class="col-9">
		<a class="btn btn-primary mt-2 mb-2"
			href="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>"
			role="button" title="anadir"><i class="fas fa-plus"></i> Añadir</a>
	</div>
	<div class="col-3">
		<!-- Search form -->
		<form action="backoffice/usuario" class="form-inline my-2 my-lg-0 ">
			<input type="hidden" name="op"
				value="<%=UsuarioController.OP_BUSCAR%>"> <input
				class="form-control mr-sm-2" name="buscar" type="search"
				placeholder="Buscar" aria-label="Buscar">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
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
			<!-- 
			<th scope="col">Contraseña</th>
			 -->
			<th scope="col">Opciones</th>
		</tr>
	</thead>

	<tbody class="text-center">

		<%
			for (Usuario user : usuarios) {
		%>
		<tr>
			<td class="align-middle"><span class=""><%=user.getId()%></span></td>
			<td class="align-middle"><span class=""><%=user.getNombre()%></span></td>
			<!-- 
			<td class="align-middle"><span
					class=""><%=user.getContrasenya()%></span></td>
			 -->		
			<td class="align-middle"><a class="btn btn-success"
				href="backoffice/usuario?op=<%=UsuarioController.OP_FORM%>&id=<%=user.getId()%>"
				role="button" title="editar"><i class="fas fa-edit"></i> Editar</a>

				<a class="btn btn-danger text-light" role="button" title="eliminar"
				data-toggle="modal" data-target="#eliminar<%=user.getId()%>"><i
					class="fas fa-trash-alt"></i> Borrar</a> <!-- Modal -->
				<div class="modal fade" id="eliminar<%=user.getId()%>" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">¿Estas
									Seguro de ELIMINAR el registro?</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<p>Cuidado porque operación no es reversible</p>
							</div>
							<div class="modal-footer">
								<form action="backoffice/usuario" method="post">
									<input type="hidden" name="op"
										value="<%=UsuarioController.OP_ELIMINAR%>"> <input
										type="hidden" name="id" value="<%=user.getId()%>" readonly>
									<input type="submit" value="Eliminar"
										class="btn btn-danger btn-block">
								</form>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div></td>
		</tr>
		<%
			} // end for
		%>

	</tbody>
</table>

<%@include file="../../includes/footer.jsp"%>