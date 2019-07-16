<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Saludo</title>
	</head>
	<body>
	
		<h1>Pagina Saludo</h1>
		<p>${saludo}</p> Expression Lenguage
				
		
		
		<%
			//codigo de JAVA => Scriplet
			String atributoSaludo = (String)request.getAttribute("saludo");			
			int repetir = Integer.parseInt((String)request.getAttribute("repetir"));
			
			for(int i=0; i < repetir; i++){
				%>
					<p><%=atributoSaludo%></p>
				<%
			}
			
		%>
		
		
		<p><%=atributoSaludo%></p>
			
	</body>
</html>