<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>


<h1>USUARIOS REGISTRADOS</h1>

<a href="backoffice/usuarios?op=<%=UsuarioController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>


<div class="row d-flex justify-content-center">
	<div class="col-9">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Usuario</th>
					<th scope="col">Contraseña</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaUsuarios}" var="lu">
					<tr>
					<th scope="row">${lu.id }</th>
					<td>		
						<a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${lu.id}">${lu.nombre }</a>
					</td>
					<td>${lu.contrasena }</td>
					<td>
						<a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${lu.id}"><i class="fas fa-user-edit fa-2x text-success"></i></a>
						&emsp;
						<i class="fas fa-user-times fa-2x text-danger"></i>
						
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="col-3 bg-dark">
		<form action="backoffice/usuarios" method="post" class="mb-2">
		
			<input type="hidden" name="op" value="<%=UsuarioController.OP_BUSCAR%>">
			
			<div class="form-group">	
				<h3 class="text-info">Buscador usuarios</h3><hr>
				<input type="text" name="nombre" placeholder="Usuario a buscar" required class="form-control">
			</div>
			
			<input type="submit" value="Buscar Usuario" class="btn btn-outline-primary  btn-block">
			
			<a href="backoffice/usuarios?op=<%=UsuarioController.OP_LISTAR%>" class="mb-3 btn btn-outline-primary btn-block">Volver a ver todos los usuarios</a>
		
		</form>
		
	</div>
	
</div>

<%@include file="../../includes/footer.jsp"%>