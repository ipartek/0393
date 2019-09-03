<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<h1>Login</h1>

<%@include file="includes/mensaje.jsp"%>

<form action="login" method="post">
	<div class="form-group row">
		<label for="nombre" class="col-md-4 col-form-label text-md-right">Usuario</label>
		<div class="col-md-6">
			<input type="text" id="nombre" class="form-control"
				placeholder="Tu Nombre Usuario" name="nombre" required autofocus>
		</div>
	</div>

	<div class="form-group row">
		<label for="contrasenya" class="col-md-4 col-form-label text-md-right">Contraseña</label>
		<div class="col-md-6">
			<input type="password" id="contrasenya" class="form-control"
				placeholder="Contraseña" name="contrasenya" required>
		</div>
	</div>
 
 

	<div class="col-md-6 offset-md-4">
		<input type="submit" class="btn btn-primary" value="Entrar">

	</div>
</form>

<%@include file="includes/footer.jsp"%>
