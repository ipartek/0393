<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>

<meta http-equiv="refresh" content="3">

 <h1>BACKOFFICE</h1>
 
 
 <%=UsuariosLogeadosListener.usuariosLogeados%>


<%@include file="../includes/footer.jsp"%>