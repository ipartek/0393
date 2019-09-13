<%@page import="com.ipartek.formacion.controller.backoffice.CategoriaController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%> 

<h1>Listado de Categorias</h1>

 <%@include file="../../includes/mensaje.jsp"%>

	<a href="backoffice/categoria?op=<%=CategoriaController.OP_MOSTRAR_FORMULARIO%>&id=-1" class="mb-3 btn btn-outline-primary">Nueva Categoria</a>
	<a href="backoffice/transaciones" class="mb-3 btn btn-outline-danger">Insert con Atomicidad</a>
	
	
	
	<form action="backoffice/categoria" method="post" class="mb-2 form-inline">
			<label class="mr-2" for="nombreBuscar">Busqueda:</label>
			<input type="text" name="nombreBuscar" placeholder="" class="form-control mr-2">
			<input type="hidden" name="op" value="<%=CategoriaController.OP_BUSCAR%>">
			<input type="submit" value="Search">	
	</form>	
			
	<c:forEach items="${listaCategorias}" var="c">	
	  	<li class="list-group-item">
	  		<p class="h3">
	  			<a href="backoffice/usuarios?op=<%=CategoriaController.OP_MOSTRAR_FORMULARIO%>&id=${c.id}">
	  				<i class="fas fa-tag"></i> ${c.nombre}
	 			</a>
	 		</p>			
	  	</li>
	  </c:forEach>	
	


<%@include file="../../includes/footer.jsp"%>