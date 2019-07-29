<%@page import="com.ipartek.formacion.controller.CalculadoraController"%>
<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<%@include file="../includes/mensaje.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  <!-- el import para que formatee el resultado con comas -->

<h1>Calculadora</h1>
<form action="calculadora" method="post">
	<div class="form-group">
		<label for="inputNum1"
			class="col-sm-3 col-form-label col-form-label-lg">Número 1</label>
			 <input
			type="number" step="0.001" class="form-control" name="numero1" id="inputNum1"
			placeholder="Introduce un número" value="${numero1}">
	</div>
	
	<div class="form-group">
		<label for="inputNum2"
			class="col-sm-3 col-form-label col-form-label-lg">Número 2</label> 
			<input
			type="number" step="0.001" class="form-control" name="numero2" id="inputNum2"
			placeholder="Introduce un número" value="${numero2}">
	</div>
	<select name="op" class="form-control" value="${op}">
		<option value="0">Selecciona una operación</option>
 		<option value="<%= CalculadoraController.OP_SUMAR %>" ${(op==CalculadoraController.OP_SUMAR)?'selected':''}>Sumar</option>
 		<option value="<%= CalculadoraController.OP_RESTAR %>" ${(op==CalculadoraController.OP_RESTAR)?'selected':''}>Restar</option>
 		<option value="<%= CalculadoraController.OP_MULTIPLICAR %>" ${(op==CalculadoraController.OP_MULTIPLICAR)?'selected':''}>Multiplicar</option>
 		<option value="<%= CalculadoraController.OP_DIVIDIR %>" ${(op==CalculadoraController.OP_DIVIDIR)?'selected':''}>Dividir</option>
	</select>


	<button type="submit" class="btn btn-primary mt-2 mb-2 btn-block">Calcular</button>
</form>	
	<div class="resultado">
		<label for="resultado"
			class="col-sm-3 col-form-label col-form-label-lg">Resultado: 
			<fmt:formatNumber type ="number" pattern="#,###.##" value="${resultado}"/>
		</label>
	</div>

<%@include file="../includes/footer.jsp"%>