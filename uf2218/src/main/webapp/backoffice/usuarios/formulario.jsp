<%@page	import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

	<h1>Detalle Usuario</h1>
	
	<hr>
	
	<%@include file="../../includes/mensaje.jsp"%>
	
	<div class="row">
		<div class="col-4">
			<form action="backoffice/usuarios" method="post" class="mb-2">
				<input type="hidden" name="op" value="<%=UsuarioController.OP_GUARDAR%>">
				<div class="form-group">
					<label for="id">Id:</label>
					<input type="text" name="id" value="${usuario.id}" readonly class="form-control">
				</div>
				<div class="form-group">
					<label for="nombre">Nombre:</label>
					<input type="text" name="nombre" value="${usuario.nombre}" placeholder="M�nimio 3 m�ximo 150" class="form-control">
				</div>
				<div class="form-group">
					<label for="contrasenya">Contrase�a:</label>
					<input type="text" name="contrasenya" value="${usuario.contrasenya}" class="form-control">
				</div>
				<label for="categoria">Rol: </label>
				<select class="custom-select mb-3" name="categoria" id="categoria">
					<option value="-1">Elige un rol...</option>
					<c:forEach items="${roles}" var="r">
						<option value="${r.id}" ${(r.id == video.usuario.idRol)?"selected":""}>${r.nombre}</option>
					</c:forEach>
				</select>
				<div class="form-group">
					<label for="fCreacion">Fecha creaci�n del Usuario:</label>
					<input type="text" name="fCreacion" value="${usuario.fCreacion}" readonly class="form-control">
				</div>
				<div class="form-group">
					<label for="fBaja">Fecha baja del Usuario:</label>
					<input type="text" name="fBaja" value="${usuario.fBaja}" readonly class="form-control">
				</div>
			
				<input type="submit" value="${(usuario.id != -1)?'Modificar':'Crear'}" class="btn btn-outline-primary btn-block">
			
			</form>
			<c:if test="${usuario.id != -1}"> <!-- Boton eliminar con confirmaci�n -->
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-outline-danger btn-block" data-toggle="modal" data-target="#exampleModal">
					Eliminar
				</button>
	
				<!-- Modal -->
				<div 	class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">�Estas seguro de eliminar el registro?</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<p>Cuidado porque operaci�n no es reversible</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Cancelar</button>
								<form action="backoffice/usuarios" method="post">
									<input type="hidden" name="op" value="<%=UsuarioController.OP_ELIMINAR%>">
									<input type="hidden" name="id" value="${usuario.id}" readonly>
									<input type="submit" value="Eliminar" class="btn btn-danger btn-block">
								</form>
							</div>
						</div>
					</div>
				</div>
			</c:if>
		</div><!-- End Col -->
	</div><!-- End Row -->

<%@include file="../../includes/footer.jsp"%>