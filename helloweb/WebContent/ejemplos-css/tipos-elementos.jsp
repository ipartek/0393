<%@include file="../includes/header.jsp" %>
	
	<h1>5.1 Tipo de Elementos</h1>
	
	<p>El estándar HTML clasifica a todos sus elementos en dos grandes grupos: elementos en línea y elementos de bloque.</p>
	<p>Los elementos de bloque ("block elements" en inglés) siempre empiezan en una nueva línea y ocupan todo el espacio disponible hasta el final de la línea. Por su parte, los elementos en línea ("inline elements" en inglés) no empiezan necesariamente en nueva línea y sólo ocupan el espacio necesario para mostrar sus contenidos.</p>
	<p>Debido a este comportamiento, el tipo de un elemento influye de forma decisiva en la caja que el navegador crea para mostrarlo. La siguiente imagen muestra las cajas que crea el navegador para representar los diferentes elementos que forman una página HTML:</p>	
		
		
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