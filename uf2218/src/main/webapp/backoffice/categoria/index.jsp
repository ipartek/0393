<%@page import="com.ipartek.formacion.controller.backoffice.CategoriaController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>


<h1>CATEGOR�AS PARA LOS V�DEOS</h1>

<a href="backoffice/categorias?op=1111111111111111111" class="mb-3 btn btn-outline-primary">Nueva Categoria</a>


<div class="row d-flex justify-content-center">
	<div class="col-9">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorias}" var="cat">
					<tr>
					<th scope="row">${cat.id }</th>
					<td>
						<a href="backoffice/usuarios?op=1111111111111111111&id=${cat.id}">${cat.nombre }</a>

					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</div>

<%@include file="../../includes/footer.jsp"%>