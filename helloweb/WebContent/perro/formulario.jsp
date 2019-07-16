<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Hello</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/estilos.css">
		<base href="/helloweb/">
	</head>
	<body>

		<p class="text-danger">${mensaje}</p>

		<form action="perros" method="post">
		
			
			<input type="text"			       
			       name="nombre"
			       placeholder="Nombre">
			<br>
			
			<select name="raza">
				<option value="cruce">Cruce</option>
				<option value="San Bernardo">San Bernardo</option>
				<option value="presa" selected>Presa</option>
				<option value="boxer">Boxer</option>
			</select>
			<br>
			
			<input type="number"			       
			       name="edad"
			       value="1"
			       placeholder="Años del Perro">
			<br>
			
			<label for="vacunado">¿Esta Vacunado?</label>
			<input type="checkbox" id="vacunado" name="vacunado">
			<br>
						
			
			<input type="submit" value="Crear Perro">
		
		</form>
	</body>
</html>		