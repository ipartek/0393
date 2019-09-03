<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>


<h1>USUARIOS REGISTRADOS</h1>

<a href="backoffice/usuarios?op=<%=VideoController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>

<div class="row d-flex justify-content-center">
	<table class="table table-striped w-75">
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
					<c:if test="${lu.nombre=='admin' }">
						<i class="fas fa-users-cog fa-2x text-success"></i>
					</c:if>
					<c:if test="${lu.nombre!='admin' }">
						<i class="fas fa-user-edit fa-2x text-success"></i>&emsp;
						<i class="fas fa-user-times fa-2x text-danger"></i>
					</c:if>
					
				</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>

<%@include file="../../includes/footer.jsp"%>