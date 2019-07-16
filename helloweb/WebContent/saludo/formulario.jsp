<a href="../index.jsp">Volver Inicio</a>


<p style="color:red">${mensaje}</p>

<form action="saludar" method="get">

	<input type="text" name="nombre" autofocus tabindex="1" placeholder="Dime Tu Nombre" />
	<br>
	
	<input type="number" step="1" name="repetir"  value="1" placeholder="Numero Veces que te saludos" />
	<br>
	
	<select name="idioma" >
		<option value="eu">Euskera</option>
		<option value="en">Ingles</option>
		<option value="es">Castellano</option>
	</select>
	
	
	<br>
	<input type="submit" value="Enviar" tabindex="2" />
	
</form>
