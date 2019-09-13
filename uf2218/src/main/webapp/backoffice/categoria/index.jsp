<%@page import="com.ipartek.formacion.controller.CategoriaController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/mensaje.jsp"%>


<h1>CATEGORÍAS PARA LOS VÍDEOS</h1>

<a href="backoffice/categorias?" class="mb-3 btn btn-outline-primary">Nueva Categoria</a>


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
						${cat.nombre }
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
</div>

<%@include file="../../includes/footer.jsp"%>