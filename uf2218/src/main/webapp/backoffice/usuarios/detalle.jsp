<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Detalle Usuario</h1>
	<%@include file="../../includes/mensaje.jsp"%>
	 
		<div class="row">
		<div class="col-12 col-md-3"></div>
		<div class="col-12 col-md-3">
		
			
			
			<form action="backoffice/usuarios" method="post" class="mb-2">
			
				<input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
			
				<div class="form-group">	
					<label for="id">Id:</label>
					<input type="text" name="id" value="${usua.id}" readonly class="form-control">
				</div>
				
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usua.nombre}"
					       placeholder=""
					       class="form-control">
				</div>
				
				<div class="form-group">
					<label for="codigo">Contrase�a:</label>
					<input type="password" name="contrasenya" value="${usua.contrasenya}"
					       placeholder="" 
						   class="form-control">
				</div>	
			
				<input type="submit" value="${(usua.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary  btn-block">
			
			</form>
	<c:if test="${usua.id != -1}">
	
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
							<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
							<input type="hidden" name="id" value="${usua.id}" readonly>			
							<input type="submit" value="Eliminar" class="btn btn-danger btn-block">	
						</form>
				      </div>
				    </div>
				  </div>
				</div>
				
				
			</c:if>	
			<a href="backoffice/usuarios" class="btn btn-outline-secondary btn-block mt-3">Volver</a>	
			</div>
			
		<div class="col-12 col-md-3"></div>
			</div>
	
<%@include file="../../includes/footer.jsp"%>