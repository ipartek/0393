<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	<form action="login" method="post">
   	
   		<input type="text" name="nombre" placeholder="Tu Nombre Usuario">
   		<br>
   		<input type="password" name="contrasena" placeholder="Contraseña">
   		<br>
   		<input type="submit" value="Entrar">
   	
   	</form>
    	    	
<%@include file="includes/footer.jsp"%>   