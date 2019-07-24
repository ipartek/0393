<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>

<h1>Formulario</h1>

<div class="row">
	<div class="col">
	 	<%@include file="../../includes/mensaje.jsp"%>
		<form action="backoffice/videos" method="post">
			
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
			
  			 <input type="hidden" class="form-control" name="op" id="op" value="6">
   			
   			<div class="form-group">
   				<input type="text" readonly="" class="form-control" name="id" id="id" placeholder="" value="${video.id}">
  			</div>
   			
			<div class="form-group">
			    <label for="inputTitulo" class="col-sm-3 col-form-label col-form-label-lg">Título</label>
			    <input type="text" class="form-control" name="nombre" id="inputTitulo" placeholder="Mínimo 3 maximo 150" value="${video.nombre}">
			 </div>
		    
		    <div class="form-group">
			    <label for="inputCodigo" class="col-sm-3 col-form-label col-form-label-lg">Código</label>
			    <input type="text" class="form-control" name="codigo" id="inputTitulo" placeholder="Exactamente 11" value="${video.codigo}">
			 </div>
		    
			<div class="form-group row">
				<%
					if (YoutubeController.OP_FORM.equals(request.getAttribute("op"))) {
				%>
				<button type="submit" class="btn btn-primary mb-2 btn-block">Guardar</button>
				
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