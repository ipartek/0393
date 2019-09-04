<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1 class="text-info h3">Lista de usuarios</h1>

<a class="btn btn-sucess" href="backoffice/usuarios?op=<%=UsuariosController.OP_CREATE%>">Nuevo Usuario</a>

<ul class="list-group">
	<c:forEach items="${usuarios}" var="usuarios">
		<li class="list-group-item">
			<a class="h3" href="backoffice/usuarios?op=<%=UsuariosController.OP_DETALLE%>&id=${usuarios.id}"><i class="fas fa-user"></i>${usuarios.nombre}</a>
		</li>
	</c:forEach>
			
</ul>


<%@include file="../../includes/footer.jsp"%>

