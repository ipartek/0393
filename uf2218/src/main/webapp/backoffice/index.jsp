<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<!-- <meta http-equiv="refresh" content="3"> -->

 <h1>BACKOFFICE</h1>
 
 <a href="backoffice/videos?op=<%=VideoController.OP_LISTAR%>" class="mb-3 btn btn-outline-primary">${numeroVideos} Videos</a>
 
 <a href="backoffice/usuarios?op=<%=VideoController.OP_LISTAR%>" class="mb-3 btn btn-outline-primary">${numeroUsuarios} Usuario</a>
 
 
 <%=UsuariosLogeadosListener.usuariosLogeados%>


<%@include file="../includes/footer.jsp"%>