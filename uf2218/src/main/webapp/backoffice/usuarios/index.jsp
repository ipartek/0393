<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>


<h1>USUARIOS REGISTRADOS</h1>

<p class="bg-success p-2">${listaUsuarios}</p>

<div class="row d-flex justify-content-center">
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Usuario</th>
				<th scope="col">Contraseña</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaUsuarios}" var="lu">
				<tr>
				<th scope="row">${lu.id }</th>
				<td>${lu.nombre }</td>
				<td>${lu.contrasena }</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
</div>









<%@include file="../includes/footer.jsp"%>