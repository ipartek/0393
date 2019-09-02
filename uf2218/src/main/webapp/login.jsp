<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	<div class="d-flex align-content-center">
	   	<form action="login" method="post" class="col-4">
	   		<div class="form-group">
	   			<input class="form-control" type="text" name="nombre" autofocus placeholder="Tu Nombre Usuario">
	   		</div>
	   		<div class="form-group">
	   			<input class="form-control" type="password" name="contrasena" placeholder="Contraseña">
	   		</div>
	   		<input type="submit" value="Entrar" class="btn btn-block btn-primary">
	   	</form>
   	</div>
    	    	
<%@include file="includes/footer.jsp"%>   