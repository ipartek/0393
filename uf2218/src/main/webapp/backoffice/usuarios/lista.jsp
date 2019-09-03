<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1 class="text-info h3">Lista de usuarios</h1>

<a class="btn btn-sucess" href="">Nuevo Usuario</a>

<ul class="list-group">
	<c:forEach items="${usuarios}" var="usuarios">
		<li class="list-group-item">
			<a class="h3" href="#"><i class="fas fa-user"></i>${usuarios.nombre}</a>
		</li>
	</c:forEach>
			
</ul>


<%@include file="../../includes/footer.jsp"%>
