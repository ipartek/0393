<%@include file="../includes/header.jsp" %>


	<h1>5.2 posicionamiento relativo</h1>	
	
	<p>Lorem ipsum.....</p>
	
	
	<style>
		
		.contenedor{
			border: 1px solid #000;
			padding: 20px;
		}
		
		.box{
			background-color: teal;
			color: #FFF;
			margin: 1%;
			width: 31%;
			height: 30%;
			display: inline-block;
		}

		.w100{
			width: 98%;
		}
		
		.relativo{
			background-color: #171740a1;
			position: relative;
			top: 50px;
			right: -75px;
		}
	
	</style>
	
	
	<div class="contenedor">
	
		<div class="box">Caja 1</div>
		<div class="box relativo">Caja 2</div>
		<div class="box">Caja 3</div>
		<div class="box w100">Caja 4</div>
	
	</div>
	

	
<%@include file="../includes/footer.jsp" %>	