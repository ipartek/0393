<%@page import="com.ipartek.formacion.controller.backoffice.UsuarioController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3"> -->

 <h1>BACKOFFICE</h1>
 
 <a href="backoffice/videos?op=<%=VideoController.OP_LISTAR%>" class="mb-3 mr-5 btn btn-outline-primary">${nVideos} Videos <i class="fab fa-youtube"></i></a>
 
 <a href="backoffice/usuarios?op=<%=UsuarioController.OP_LISTAR%>" class="mb-3 mr-5 btn btn-outline-primary">${nUsuarios} Usuario <i class="fas fa-user"></i></a>
 
<%@include file="../includes/footer.jsp"%>