<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	
	
	
	<%@include file="../../includes/mensaje.jsp"%>
	<br>
	<a href="backoffice/usuarios?op=<%=UsuarioController.OP_NUEVO%>" class="mb-3 btn btn-outline-primary">Nuevo Usuario</a>		
	
	<div class="row justify-content-md-center">
		<div class="col-md-6 mb-3">
		<div class="row justify-content-md-center">
			<div class="col-md-3"></div>
			<div class="col-md-6">
		<h2 class="font-italic">Listado Usuarios:</h2>
			<table class="table table-striped">
  				<thead>
    				<tr>
      					<th scope="col" class="text-center">Nombre</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach items="${usuarios}" var="usuario">
	  	           		<tr>
	  	           		   <td class="text-center">
	  	           		      ${usuario.nombre}
	  	           			  <a href="backoffice/usuarios?op=<%=UsuarioController.OP_DETALLE%>&id=${usuario.id}">
	  	           			      <i class="ml-3 fas fa-wrench"></i>
	  	           			  </a>
	  	           		  </td>
	  	           		</tr>
	            	</c:forEach>
   
  				</tbody>
			</table>
			</div>
			<div class="col-md-3"></div>
			
		</div>	
      </div>
	 
<div class="col-md-6 mb-3">
<div class="row justify-content-md-center">
			<div class="col-md-3"></div>
			<div class="col-md-6">
<h2 class="font-italic">Buscar Usuario:</h2>	
	 
		

	
	<form action="backoffice/usuarios" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=UsuarioController.OP_BUSCAR%>">
			
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${uBuscar.nombre}"
					       placeholder=""
					       class="form-control">
				</div>	
			
				<input type="submit" value="Buscar" class="btn btn-outline-primary  btn-block">
			
			</form>
			<!--  -->
			<c:if test="${usuariosB != null}">
			<table class="table table-striped">
  				<thead>
    				<tr>
      					<th scope="col" class="text-center">Nombre</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach items="${usuariosB}" var="usuarioB">
	  	           		<tr>
	  	           		   <td class="text-center">
	  	           		      ${usuarioB.nombre}
	  	           			  <a href="backoffice/usuarios?op=5&id=${usuarioB.id}">
	  	           			      <i class="ml-3 fas fa-wrench"></i>
	  	           			  </a>
	  	           		  </td>
	  	           		</tr>
	            	</c:forEach>
   
  				</tbody>
			</table>
			</c:if>
			<!--  -->
			<div class="col-md-3"></div>
	 </div>
	</div></div></div></div>
	
<%@include file="../../includes/footer.jsp"%>