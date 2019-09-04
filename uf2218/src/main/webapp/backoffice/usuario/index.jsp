<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Listado Usuario</h1>


<%@include file="../../includes/mensaje.jsp"%>
<div class="row">
<div class="col-9">
<a href="backoffice/usuario?op=<%=UsuarioController.OP_NUEVO%>"
	class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>
</div>
<div class="col-3">
 <form action="backoffice/usuario" class="form-inline my-2 my-lg-0 ">
	 <input type="hidden" name="op" value="<%=UsuarioController.OP_BUSCAR%>">
      <input class="form-control mr-sm-2" name ="buscar" type="search" placeholder="Buscar" aria-label="Buscar">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search"></i></button>
    </form>
    </div>
</div>	
<div class="card"> 
	<h5 class="card-header">Listado Usuario</h5>
	
	<div class="card-body">

		<ul class="list-group">
			<c:forEach items="${usuarios}" var="u">
			<a href="backoffice/usuario?op=<%=UsuarioController.OP_DETALLE%>&id=${u.id}"><li class="list-group-item">${u.nombre}</li></a>
		</c:forEach>
			
		</ul>
	</div>
</div>





<%@include file="../../includes/footer.jsp"%>