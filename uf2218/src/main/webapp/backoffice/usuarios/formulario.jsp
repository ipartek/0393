<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>

<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Detalle Usuarios</h1>
	
	<div class="row">
		<div class="col">
		
			<%@include file="../../includes/mensaje.jsp"%>
			
			<form action="backoffice/usuarios" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=UsuariosController.OP_UPDATE%>">
			
				<div class="form-group">	
					<label for="id">Id:</label>
					<input type="text" name="id" value="${usuarioEditar.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuarioEditar.nombre}"
					       placeholder="M�nimio 3 m�ximo 150"
					       class="form-control">
				</div>
				
				<div class="form-group">
					<label for="codigo">Contrase�a:</label>
					<input type="text" name="contra" value="${usuarioEditar.contra}"
					       placeholder="Exactamente 11" 
						   class="form-control">
				</div>	
								<div class="form-group">
					<label for="codigo">Fecha creaci�n:</label>
					<input type="text" name="fecha_creacion" value="${usuarioEditar.fechaCreacion}"
					       placeholder="" 
						   class="form-control">
				</div>	
								<div class="form-group">
					<label for="codigo">Fecha eliminaci�n:</label>
					<input type="text" name="fecha_eliminacion" value="${usuarioEditar.fechaEliminacion}"
					       placeholder="" 
						   class="form-control">
				</div>	
				<div class="form-group">
					<label for="categoria_id">Rol:</label>
					<select name="rol_id" id="rol_id">
					  <c:forEach items="${roles}" var="r">				  
					  	<option value="${r.id}" ${(r.id == usuarioEditar.id_rol)?"selected":"" }> ${r.nombre}</option>
					  </c:forEach>				  
					</select>
				</div>	
			
				<input type="submit" value="${(usuarioEditar.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary  btn-block">
			
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
				        <h5 class="modal-title" id="exampleModalLabel">�Estas Seguro de ELIMINAR el registro?</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        <p>Cuidado porque operaci�n no es reversible</p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        	<form action="backoffice/usuarios" method="post">	
							<input type="hidden" name="op" value="<%=UsuariosController.OP_DELETE%>">
							<input type="hidden" name="id" value="${usuarioEditar.id}" readonly>			
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