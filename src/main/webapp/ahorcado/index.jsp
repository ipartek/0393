<%@page import="com.ipartek.formacion.controller.AhorcadoController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<%@include file="../includes/mensaje.jsp"%>

<h1>Ahorcado</h1>

<form action="ahorcado" method="post">
	<input type="hidden" name="op" value="<%=AhorcadoController.OP_CARGAR%>">
	<div class="form-group">
		<label for="palabra"
			class="col-sm-3 col-form-label col-form-label-lg">Palabra a adivinar</label>
			 <input
			type="password" class="form-control" name="palabra" id="palabra"
			placeholder="Introduce la palabra del ahorcado" value="">
	</div>
			
	<button type="submit" class="btn btn-primary mt-2 mb-2">Comenzar el juego</button>
</form>	

<div class="row mt-2">
	${palabra}
	${respuesta}
</div>

<%@include file="../includes/footer.jsp"%>