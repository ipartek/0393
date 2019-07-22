<%@page import="com.ipartek.formacion.controller.YoutubeController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>Formulario</h1>

<div class="row">
	<div class="col">
	
		<c:if test="${mensaje != null}">
			<div class="alert alert-${mensaje.tipo} alert-dismissible fade show"
				role="alert">
				<p>${mensaje.texto}</p>
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
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
						placeholder="Introduce el título del video">
				</div>
			</div>
			<div class="form-group row">
				<label for="colFormLabelLg"
					class="col-sm-3 col-form-label col-form-label-lg">Codigo</label>
				<div class="col-sm-4">
					<input type="text" value="${video.codigo}"
						class=" form-control
						form-control-lg" name="codigo" id="codigo"
						placeholder="Introduce el código del video">
				</div>
			</div>
			
			
			<!--  
		      <div class="form-group row">
		        <label for="colFormLabelLg" class="col-sm-3 col-form-label col-form-label-lg">Reproducciones</label>
		        <div class="col-sm-4">
		          <input type="number" class="form-control form-control-lg" min="0" id="reproducciones" placeholder="Introduce número de reproducciones">
		        </div>
		      </div>
		 		-->

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
				<button type="submit" class="btn btn-primary mb-2">Borrar</button>
				<%
					}
				%>

			</div>
		</form>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>