<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	<%@include file="includes/mensaje.jsp"%>
   	
   	<form action="login" method="post">
   	
   		<input type="text" name="nombre" autofocus placeholder="Tu Nombre Usuario">
   		<br>
   		<input type="password" name="contrasenya" placeholder="Contraseña">
   		<br>
   		<input type="submit" value="Entrar">
   	
   	</form>
    	    	
<%@include file="includes/footer.jsp"%>   