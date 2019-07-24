<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<!-- cada 3 segundos refresca, asi podremos ver la lista de usuarios actualizada -->
<meta http-equiv="refresh" content="3" />
<h1>BACKOFFICE</h1>

<%=UsuariosLogeadosListener.nombre %>
<%=UsuariosLogeadosListener.usuariosLogeados%>

<ul>
<c:forEach items="${UsuariosLogeadosListener.usuariosLogeados}" var="v">
				<li>${v}</li>
</c:forEach>
</ul>


<%@include file="../includes/footer.jsp"%>