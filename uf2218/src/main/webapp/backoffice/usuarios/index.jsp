<%@page import="com.ipartek.formacion.controller.backoffice.Usuarios"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado de Usuarios</h1>
	
	
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
					<td>${u.nombre}</td>
					<td>${u.contrasenya}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<%@include file="../../includes/footer.jsp"%>