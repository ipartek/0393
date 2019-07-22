<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>>

<h1>Formulario</h1>

<div class="row">
	<div class="col">
	 	<%@include file="../../includes/mensaje.jsp"%>
		<form action="videos" method="post">
			
				<%
					if (YoutubeController.OP_FORM.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=YoutubeController.OP_GUARDAR%>">
				<%
					}
				%>
				<%
					if (YoutubeController.OP_GUARDAR.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=YoutubeController.OP_GUARDAR%>">
				<%
					}
				%>
				<%
					if (YoutubeController.OP_BORRAR.equals(request.getAttribute("op"))) {
				%>
					<input type="hidden" name="op" value="<%=YoutubeController.OP_ELIMINAR%>">
				<%
					}
				%>
			
			<label for="id">Id:</label>
		    <input name="id" value="${video.id}" readonly>
		    
			<div class="form-group row">
				<label for="colFormLabelLg"
					class="col-sm-3 col-form-label col-form-label-lg">Titulo</label>
				<div class="col-sm-4">
					<input type="text" value="${video.nombre}"
						class="form-control form-control-lg" name="nombre" id="nombre"
						placeholder="Mínimo 3 maximo 150">
				</div>
			</div>
			<div class="form-group row">
				<label for="colFormLabelLg"
					class="col-sm-3 col-form-label col-form-label-lg">Codigo</label>
				<div class="col-sm-4">
					<input type="text" value="${video.codigo}"
						class=" form-control
						form-control-lg" name="codigo" id="codigo"
						placeholder="Exactamente 11">
				</div>
			</div>
			
			
		

			<div class="form-group row">
				<%
					if (YoutubeController.OP_FORM.equals(request.getAttribute("op"))) {
				%>
				<button type="submit" class="btn btn-primary mb-2">Guardar</button>
				<%
					}
				%>
				<%
					if (YoutubeController.OP_GUARDAR.equals(request.getAttribute("op"))) {
				%>
				<button type="submit" class="btn btn-primary mb-2">Modificar</button>
				<%
					}
				%>
				<%
					if (YoutubeController.OP_BORRAR.equals(request.getAttribute("op"))) {
				%>
				<c:if test="${video.id != -1}">
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
				        	<form action="videos" method="post">	
								<input type="hidden" name="op" value="<%=YoutubeController.OP_ELIMINAR%>">
								<input type="hidden" name="id" value="${video.id}" readonly>			
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