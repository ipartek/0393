<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<div class="container">
	<a class="navbar-brand" href="#">UF2218</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio
					<span class="sr-only">(current)</span></a>
			</li>
			<c:if test="${usuario != null}">
	        	<li class="nav-item active"><a class="nav-link" href="backoffice/index.jsp">Backoffice</a>
			</li>
	        </c:if>
	        <li class="nav-item active"><a class="nav-link" href="backoffice/videos">Videos</a>
	        <!-- 
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Youtube </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="backoffice/videos">Listado</a>	
					<a class="dropdown-item" href="backoffice/videos?op=1">Formulario</a>
					<a class="dropdown-item" href="backoffice/videos?op=13">Detalle</a>
					-->
				</div>
			</li>	
		</ul>
		<ul class="navbar-nav mr-aut">
		 
	       	<c:if test="${usuario == null}">
	        	<a class="nav-link" href="login.jsp">Login</a>
	        </c:if>
	        <c:if test="${usuario != null}">
	        	<span class="nav-link text-light"><i class="fas fa-user"></i> Hola ${usuario}</span>
	        	<a class="nav-link" href="logout">Logout</a>
	        </c:if>		       
	      
		</ul>
	</div> 
	</div> <!-- end container -->
</nav>
<!-- end navbar -->
<main class="container pt-2 mb-5">