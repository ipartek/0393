<%@page import="com.ipartek.formacion.controller.backoffice.VideoController"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">JEE</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="index.jsp">
					<fmt:message key="menu.inicio" />
				</a>
			</li>
			<c:if test="${usuario == null}">
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Login</a>
				</li>
			</c:if>

			<c:if test="${usuario != null}">
				<li class="nav-item">
					<a class="nav-link" href="backoffice/inicio">
						<i class="fas fa-user"></i>${sessionScope.usuario.nombre}
					</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="logout">
						<i class="fas fa-sign-out-alt"></i> Salir
					</a>
				</li>
			</c:if>
			<li class="nav-item">
				<a class="nav-link" href="backoffice/usuarios">
					<fmt:message key="menu.usuarios" />
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="backoffice/videos">
					<fmt:message key="menu.videos" />
				</a>
			</li>
			<li class="nav-item">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">
						<fmt:message key="menu.videosvistos" />
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<c:forEach items="${videosVistos}" var="vv">
							<a class="dropdown-item"
								href="backoffice/videos?op=<%=VideoController.OP_DETALLE%>&id=${vv.value.id}">(${vv.key})
								${vv.value.nombre}</a>
						</c:forEach>
					</div>
				</div>
			</li>
		</ul>
	</div>
</nav>
<!-- end navar -->

<nav class="bg-dark">
	<a href="i18n?idiomaSeleccionado=en_EN">
		<img src="resources/img/british.png" alt="" class="${sessionScope.idiomaSeleccionado != 'en_EN' ? 'inactive': ''  }">
	</a>
	<a href="i18n?idiomaSeleccionado=eu_ES">
		<img src="resources/img/euskadi.png" alt="" class="${sessionScope.idiomaSeleccionado != 'eu_ES' ? 'inactive': ''  }">
	</a>
	<a href="i18n?idiomaSeleccionado=es_ES">
		<img src="resources/img/Spain.png" alt="" class="${sessionScope.idiomaSeleccionado != 'es_ES' ? 'inactive': ''  }">
	</a>
</nav>


<main class="container">