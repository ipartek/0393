<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<hr>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	<form action="login" method="post">
   		<div class="form-group">
   			<label for="nombre">Usuario:</label>
   			<input class="form-control mb-2 w-25" type="text" name="nombre" autofocus placeholder="Usuario">
   		</div>
   		<div class="form-group">
   			<label for="contrasenya">Contraseña:</label>
   			<input class="form-control mb-2 w-25" type="password" name="contrasenya" placeholder="Contraseña">
   		</div>
	   	<input class="btn btn-primary" type="submit" value="Entrar">
   	</form>
    	    	
<%@include file="includes/footer.jsp"%>   