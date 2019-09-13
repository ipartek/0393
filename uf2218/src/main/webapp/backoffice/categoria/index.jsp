<%@page import="com.ipartek.formacion.controller.backoffice.CategoriaController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Listado de Categorias</h1>
	
	<a href="backoffice/categoria?op=<%=CategoriaController.OP_MOSTRAR_FORMULARIO%>" class="mb-3 btn btn-outline-primary">Nueva Categoria</a>
	
	<form action="backoffice/categoria" method="post">
		<input type="hidden" name="op" value="<%=CategoriaController.OP_BUSCAR_POR_NOMBRE%>">
		<input type="search" class="form-control" name="nombre" placeholder="Buscar por nombre">
		<input class="btn btn-outline-primary btn-block" type="submit" value="Buscar">
	</form>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#ID</th>
				<th scope="col">Categoría</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorias}" var="c">
				<tr>
					<th scope="row">${c.id}</th>
					<td><a href="backoffice/categoria?id=${c.id}&op=<%=CategoriaController.OP_DETALLE%>">${c.nombre}</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


<%@include file="../../includes/footer.jsp"%>