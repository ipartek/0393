<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<%//@page errorPage="error.jsp" %>

<% //Gestion de idioma %>

<c:set var="idiomaSeleccionado" 
		value="${not empty sessionScope.idiomaSeleccionado ? sessionScope.idiomaSeleccionado : 'es_ES'}"
		scope="session" />
<fmt:setLocale value="${idiomaSeleccionado}" />
<fmt:setBundle basename="i18n.i18nmessages" />

<% //fin gestion de idioma %>




<!doctype html>
<html lang="es">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- fontAwesome -->	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css"/>

<base href="${pageContext.request.contextPath}/"></base>
<!-- Nuestro CSS -->
<link rel="stylesheet" type="text/css" href="resources/css/estilos.css">
<title>JEE</title>
</head>
<body>