<%

	String title = request.getParameter("title");
	if ( title == null ){
		title = "";
	}else{
		title = " | " + title;
	}
	
%>


<!DOCTYPE>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>HelloWeb <%=title%></title>
		<base href="${pageContext.request.contextPath}/">
		
		<!-- favicon -->
		<link rel="apple-touch-icon" sizes="57x57" href="images/favicon/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="images/favicon/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="images/favicon/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="images/favicon/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="images/favicon/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="images/favicon/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="images/favicon/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="images/favicon/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="images/favicon/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="images/favicon/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="images/favicon/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="images/favicon/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="images/favicon/favicon-16x16.png">
		<link rel="manifest" href="images/favicon/manifest.json">
		
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
		
		<!-- RWD -->
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
			
		
		<!--  librerias de otros  -->
		<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="vendors/fontawesome-free-5.9.0-web/css/all.min.css"  />
		<link rel="stylesheet" href="https://highlightjs.org/static/demo/styles/a11y-dark.css">
		
		<!-- Nuestro CSS -->
		<link rel="stylesheet" type="text/css" href="css/estilos.css" media="screen" />		
		
	</head>
	
	<body id="top" onload="init()">
	
	
	<header id="principal">
	
		<div class="content">		
			<h1>
				<a href="index.jsp">
					<i class="fas fa-university"></i> IparWeb
				</a>
			</h1>			
		</div>
		
		<div id="wrapper-menu">
			<nav id="menu" class="content">
				<ul>
					<li><a href="ejemplos-html/index.jsp?title=HTML">HTML</a></li>
					<li><a href="ejemplos-css/index.jsp?title=CSS" >CSS</a></li>
					<li><a href="ejemplos-js/index.jsp?title=JS" >JS</a></li>
					<li><a href="ejemplos-bootstrap/index.jsp?title=Boostrap4" >Bootstrap4</a></li>
					<li><a href="ejemplos-servlet/index.jsp?title=SERVLET" >SERVLETS</a></li>
				</ul>
			</nav>
		</div>	
		
	</header>
	
	<main class="content">
		