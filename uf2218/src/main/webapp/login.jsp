<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>
    
   	<h1>Login</h1>
   	
   	${mensaje}
   	
   	<form action="login" method="post">
   	
   		<input type="text" name="usuario" placeholder="Tu Nombre Usuario">
   		<br>
   		<input type="password" name="pass" placeholder="Contraseña">
   		<br>
   		<input type="submit" value="Entrar">
   	
   	</form>
    	    	
<%@include file="includes/footer.jsp"%>   