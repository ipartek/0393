<%@include file="../includes/header.jsp" %>
	
	<h1>5.1 Tipo de Elementos</h1>
	
	<p>El est�ndar HTML clasifica a todos sus elementos en dos grandes grupos: elementos en l�nea y elementos de bloque.</p>
	<p>Los elementos de bloque ("block elements" en ingl�s) siempre empiezan en una nueva l�nea y ocupan todo el espacio disponible hasta el final de la l�nea. Por su parte, los elementos en l�nea ("inline elements" en ingl�s) no empiezan necesariamente en nueva l�nea y s�lo ocupan el espacio necesario para mostrar sus contenidos.</p>
	<p>Debido a este comportamiento, el tipo de un elemento influye de forma decisiva en la caja que el navegador crea para mostrarlo. La siguiente imagen muestra las cajas que crea el navegador para representar los diferentes elementos que forman una p�gina HTML:</p>	
		
		
	<style>
		
		.content-ejemplo p{
			border: 4px solid #000; 
		}
		
		.content-ejemplo a{
			border: 4px dotted red; 
		}
	
	</style>	
		
	<div class="content-ejemplo">
		
		<p>Lorem Imspum - Elemento en BLOQUE</p>
		<a href="#">Elemento Inline</a>	
		<p>Lorem Imspum - Elemento en BLOQUE <a href="#">Elemento Inline</a> Sigue parrafo</p>
		
	</div>
	
		
		


<%@include file="../includes/footer.jsp" %>