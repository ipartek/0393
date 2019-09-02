<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	<form action="login" method="post" class="col-4">
   	<div class="form-group">
   		<input type="text" name="nombre" autofocus placeholder="Tu Nombre Usuario">
   	</div>
   		<br>
   	<div class="form-group">
   		<input type="password" name="contrasenya" placeholder="Contraseña">
   	</div>
   		<br>
   		<input type="submit" value="Entrar" class="btn btn-block btn-primary">
   	
   	</form>
    	    	
<%@include file="includes/footer.jsp"%>   