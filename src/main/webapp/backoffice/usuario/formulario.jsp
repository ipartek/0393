<%@page import="com.ipartek.formacion.controller.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Formulario</h1>

<div class="row">
	<div class="col">
	 	<%@include file="../../includes/mensaje.jsp"%>
		<form action="backoffice/usuario" method="post">
			
				<%
					if (UsuarioController.OP_FORM.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
				<%
					}
				%>
				<%
					if (UsuarioController.OP_GUARDAR.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
				<%
					}
				%>
				<%
					if (UsuarioController.OP_BORRAR.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
				<%
					}
				%>
				
				${usuario }
				${roles }
			
  			 <input type="hidden" class="form-control" name="op" id="op" value="6">
   			
   			<div class="form-group">
   			 	<label for="inputId" class="col-sm-3 col-form-label col-form-label-lg">Id</label>
   				<input type="text" readonly class="form-control" name="id" id="id" placeholder="" value="${usuario.id}">
  			</div>
   			
			<div class="form-group">
			    <label for="inputTitulo" class="col-sm-3 col-form-label col-form-label-lg">Nombre</label>
			    <input type="text" class="form-control" name="nombre" id="inputTitulo" placeholder="" value="${usuario.nombre}">
			 </div>
		    
		    <div class="form-group">
			    <label for="inputCodigo" class="col-sm-3 col-form-label col-form-label-lg">Contraseña</label>
			    <input type="password" class="form-control" name="contrasenya" id="inputTitulo" placeholder="" value="${usuario.contrasenya}">
			 </div>
			 
			<div class="form-group">
			    <label for="inputRol" class="col-sm-3 col-form-label col-form-label-lg">Rol</label>
			    <select class="form-control" name="id_rol">
  					<c:forEach items="${roles}" var="r">
				 		<option value="${r.id}" ${(r.id==usuario.rol.id)?'selected':''}>${r.nombre}</option>
				 	</c:forEach>
				</select>
			 </div>
			 
			 <div class="form-group">
			    <label for="inputFechaCreacion" class="col-sm-3 col-form-label col-form-label-lg">Fecha Creacion</label>
			    <input type="text" readonly class="form-control" name="fechaCreacion" id="inputFechaCreacion" value="<fmt:formatDate value="${usuario.fechaCreacion}" pattern="dd-MM-yyyy HH:mm:ss"/>">
			 </div>
			 
			 <div class="form-group">
			   <label for="inputFechaEliminacion" class="col-sm-3 col-form-label col-form-label-lg">Fecha Eliminacion</label>
			    <input type="text" readonly class="form-control" name="fechaEliminacion" id="inputFechaEliminacion" value="<fmt:formatDate value="${usuario.fechaEliminacion}" pattern="dd-MM-yyyy HH:mm:ss"/>">
			 </div>
			 
			 
		    
			<div class="form-group row">
				<%
					if (UsuarioController.OP_FORM.equals(request.getAttribute("op"))) {
				%>
				<button type="submit" class="btn btn-primary mb-2 btn-block">Guardar</button>
				<a type="button" href="backoffice/usuario" class="btn btn-danger mb-2 btn-block">Volver</a>
				
				<%
					}
				%>
				<%
					if (UsuarioController.OP_GUARDAR.equals(request.getAttribute("op"))) {
				%>
				<button type="submit" class="btn btn-primary mb-2">Modificar</button>
				<a type="button" href="backoffice/usuario" class="btn btn-danger mb-2 btn-block">Volver</a>
				<%
					}
				%>
				<%
					if (UsuarioController.OP_BORRAR.equals(request.getAttribute("op"))) {
				%>
				<c:if test="${usuario.id != -1}">
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#eliminar">
					  Eliminar
					</button>
			
					<!-- Modal -->
					<div class="modal fade" id="eliminar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">¿Estas Seguro de ELIMINAR el registro?</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        <p>Cuidado porque operación no es reversible</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				        	<form action="backoffice/usuario" method="post">	
								<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
								<input type="hidden" name="id" value="${usuario.id}" readonly>			
								<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
							</form>
					      </div>
					    </div>
					  </div>
					</div>		
				</c:if>	
				<%
					}
				%>

			</div>
			
			
			
		</form>
	</div>
</div>

<%@include file="../../includes/footer.jsp"%>