<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado de Usuarios</h1>
	
	<a href="backoffice/usuarios?op=<%=UsuariosController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
	
	<form action="backoffice/usuarios" method="post">
		<input type="hidden" name="op" value="<%=UsuariosController.OP_BUSCAR_POR_NOMBRE%>">
		<input type="search" class="form-control" name="nombre" placeholder="Buscar por nombre">
		<input class="btn btn-outline-primary btn-block" type="submit" value="Buscar">
	</form>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Usuario</th>
				<th scope="col">Contraseña</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="u">
				<tr>
					<th scope="row">${u.id}</th>
					<td><a href="backoffice/usuarios?id=${u.id}&op=<%=UsuariosController.OP_DETALLE%>">${u.nombre}</a></td>
					<td>${u.contrasenya}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<%@include file="../../includes/footer.jsp"%>