<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	
   	<div class="flex">
   	
   	
   	<form action="login" method="post">
   	
   	
   	<div class="form-group">
   		<input type="text" name="nombre" autofocus placeholder="Tu Nombre Usuario" class="form-control">
   		<br>
   		<input type="password" name="contrasena" placeholder="Contraseña" class="form-control">
   		<br>
   		<input type="submit" value="Entrar" class="btn btn-block btn-primary">
   	</div>
   	</form>
   	</div>
    	    	
<%@include file="includes/footer.jsp"%>   