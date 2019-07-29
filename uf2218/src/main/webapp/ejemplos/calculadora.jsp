<%@page import="com.ipartek.formacion.controller.CalculadoraController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>
<%@include file="../includes/mensaje.jsp"%>



	<h1>Calculadora</h1>
	
	
	<form action="calcular" method="get" class="col-4">
	
		<input type="text" name="num1" value="${num1}" placeholder="Escribe numero 1" class="form-control">
		<br>
		<input type="text" name="num2" value="${num2}" placeholder="Escribe numero 2" class="form-control">
		<br>
		<select name="op" class="custom-select">
			<option value="">-- selecciona opcion --</option>
			<c:forEach items="<%=CalculadoraController.OPERACIONES%>" var="operacion">
				<option value="${operacion[0]}"  ${(operacion[0]==op)?"selected":""}  >${operacion[1]}</option>				
			</c:forEach>
		</select>
		<br>
			
		<input type="submit" class="btn btn-block btn-outline-primary mt-3" value="Calcular">
	
	</form>

	<p>Resultado <span class="h1 text-primary">${resultado}</span></p>

<%@include file="../includes/footer.jsp"%>