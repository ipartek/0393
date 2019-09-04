<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%> 

<h1>Formulario de Usuario</h1>
	
	<div class="row">
		<div class="col">
		
			<%@include file="../../includes/mensaje.jsp"%>
			
			<form action="backoffice/usuarios" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
			
				<div class="form-group">	
					<label for="id">Id:</label>
					<input type="text" name="id" value="${usuarioEditar.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuarioEditar.nombre}"
					       placeholder=""
					       class="form-control">
				</div>
				
				<div class="form-group">
					<label for="contrasena">Contraseña:</label>
					<input type="password" name="contrasena" value="${usuarioEditar.contrasena}"
					       placeholder="" 
						   class="form-control">
				</div>	
			
				<input type="submit" value="${(usuarioEditar.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary  btn-block">
			
			</form>
			
			<c:if test="${usuarioEditar.id != -1}">
			
				
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
							<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
							<input type="hidden" name="id" value="${usuarioEditar.id}" readonly>			
							<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
						</form>
				      </div>
				    </div>
				  </div>
				</div>
					
			</c:if>	
				
		</div>
		<div class="col">
		<i class="fas fa-users fa-7x"></i>
		</div>
	</div>
	
<%@include file="../../includes/footer.jsp"%>