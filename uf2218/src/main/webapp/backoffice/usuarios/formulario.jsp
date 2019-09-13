<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Detalle Usuario</h1>
	
	<a href="backoffice/usuarios" class="btn btn-outline-primary">Ver usuarios</a>

	<div class="row">
		<div class="col">
		
			<%@include file="../../includes/mensaje.jsp"%>

			<form action="backoffice/usuarios" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=UsuariosController.OP_GUARDAR%>">
			
				<div class="form-group">	
					<label for="id">Id:</label>
					<input class="form-control" type="text" name="id" value="${usuario.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuario.nombre}"
					       placeholder="Mínimio 3 máximo 45"
					       class="form-control">
				</div>
				
				<div class="form-group">
					<label for="contrasenya">Password:</label>
					<input type="password" name="contrasenya" value="${usuario.contrasenya}"
					       placeholder="Mínimio 3 máximo 45" 
						   class="form-control">
				</div>	
				
				<div class="form-group">
					<label for="idRol">Rol:</label>
					<select name="idRol" class="form-control">
						<c:forEach items="${roles}" var="r">
							<option value="${r.id}" ${(r.id==usuario.rol)?"selected":""}>${r.nombre}</option>
						</c:forEach>
					</select>
				</div>	
				
				<div class="form-group">
					<label for="fechaCreacion">Fecha creación:</label>
					<fmt:formatDate value="${usuario.fechaCreacion}" var="fecha1" pattern="dd-MM-yyyy HH:mm:ss"/>
					<input type="text" name="fechaCreacion" value="${fecha1}"
					       placeholder="Mínimio 3 máximo 45" 
						   class="form-control" disabled>
				</div>
				
				<div class="form-group">
					<label for="fechaEliminacion">Fecha eliminación:</label>
					<fmt:formatDate value="${usuario.fechaEliminacion}" var="fecha2" pattern="dd-MM-yyyy HH:mm:ss"/>
					<input type="text" name="fechaEliminacion" value="${fecha2}"
					       placeholder="Mínimio 3 máximo 45" 
						   class="form-control" disabled>
				</div>
			
				<input type="submit" value="${(usuario.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary  btn-block">
			
			</form>
			
			<c:if test="${usuario.id != -1}">
			
				
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#exampleModal">
				  Eliminar
				</button>
		
				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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
			        	<form action="backoffice/usuarios" method="post">	
							<input type="hidden" name="op" value="<%=UsuariosController.OP_ELIMINAR%>">
							<input type="hidden" name="id" value="${usuario.id}" readonly>			
							<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
						</form>
				      </div>
				    </div>
				  </div>
				</div>
				
				
			</c:if>	
			
			
			
			
			
			
			
			
		</div>
		
	</div>
	
<%@include file="../../includes/footer.jsp"%>