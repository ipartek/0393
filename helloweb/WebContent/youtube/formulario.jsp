<%@include file="../includes/header.jsp" %>	

		<p class="text-danger">${mensaje}</p>

		<form action="crear-video">
		
			
			
			<label for="titulo" class="obligatorio">Titulo</label>
			<input type="text" 
			       id="titulo" 			       
			       name="titulo"
			       required
			       pattern=".{2,150}"
			       title="Minimo 2 letras Maximo 150"
			       placeholder="Minimo 2 letras Maximo 150">
			
			<br>
			
			<label for="codigo" class="obligatorio">Codigo</label>
			<input type="text" 
				   id="codigo"				   
				   name="codigo" 
				   required
			       pattern=".{11,11}"
			       title="Exactamente 11 caracteres"
				   placeholder="Exactamente 11 caracteres">
			
			<br>
		
			<input type="submit" value="Crear Video">
			<input type="reset" value="Limpiar Formulario">
			
		</form>
	
<%@include file="../includes/footer.jsp" %>	