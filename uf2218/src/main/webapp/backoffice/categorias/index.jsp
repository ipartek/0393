<%@page import="com.ipartek.formacion.controller.backoffice.CategoriaController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Listado Categorias</h1>
	
	
	<%@include file="../../includes/mensaje.jsp"%>
	
	<a href="backoffice/categorias?op=<%=CategoriaController.OP_IR_FORMULARIO%>" class="mb-3 btn btn-outline-primary">Nueva Categoria</a>
	
			
	<ul class="list-group">
	  <c:forEach items="${categorias}" var="c">	
	  	<li class="list-group-item">
	  			<a href="backoffice/categorias?op=<%=CategoriaController.OP_IR_FORMULARIO%>&id=${c.id}">
	  			<p class="d-inline">${c.id}</p>
	  			<p class="d-inline">${c.nombre}</p>
	  		
	  	</li>
	  </c:forEach>	  	  
	</ul>

	
	
<%@include file="../../includes/footer.jsp"%>