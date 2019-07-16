<%@include file="../includes/header.jsp" %>


	<h1>5.5 posicionamiento flotante</h1>	
	
	
	
	
	<style>
		
		article{
			border: 1px solid #000;
			padding: 10px;
			width: 50%;			
		}
		
		article img{
			width: 150px;
			height: auto;
			float: left;
			margin: 0 10px 10px 0;
		}
		
		article p {
			text-align: justify;
		}
		
		
		
		
	</style>
	
	
	<article class="clearfix">
	
		<header>
			<h2>Titular Noticia</h2>
			<time datetime="dd/mm/YYYY" lang="es">05/07/2019</time>
		</header>
		
		<section >
			<img alt="imagen aleatoria" src="http://lorempixel.com/g/200/200/">
			<p>Bacon ipsum dolor amet pancetta meatball hamburger, cupim venison buffalo short ribs salami sausage bacon shank pork belly tenderloin pig chuck. Boudin sirloin pork corned beef, tongue kevin spare ribs cow meatloaf salami cupim flank short loin swine leberkas. Capicola pork belly swine fatback. Frankfurter meatball kevin tail short loin. Turkey jowl chuck tongue, rump pork loin pig shankle ham hock.</p>
			<p>Meatloaf buffalo pastrami shank boudin. Venison ground round jerky hamburger sirloin andouille brisket. Sausage tenderloin pancetta flank. Cupim strip steak swine tongue corned beef flank biltong.</p>
		</section>
		
		<footer>
			<p>Autor: fulanito Perez</p>
		</footer>
		
	</article>
	

	
<%@include file="../includes/footer.jsp" %>	