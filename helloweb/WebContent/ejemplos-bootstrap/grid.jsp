<%@include file="../includes/header-bootstrap.jsp" %>


	<h1>GRID 12 Columnas</h1>
		
	<div class="row">	
		<div class="col-12 col-md-3 p-2 text-center border">
			<div class="d-block d-md-none bg-success">12</div>
			<div class="d-none d-md-block bg-danger">3</div>
		</div>
		<div class="col-12 col-md-8 p-2 text-center border">
			<div class="d-block d-sm-block d-md-none bg-success">12</div>
			<div class="d-none d-md-block bg-danger">8</div>		
		</div>
		<div class="col-12 col-md-1 p-2 text-center border">
			<div class="d-block d-sm-block d-md-none bg-success">12</div>
			<div class="d-none d-md-block bg-danger">1</div>		
		</div>	
	</div>
	
	<div class="row">
		<% for(int i=0; i < 12; i++) { %>
			<div class="col-1 p-2 text-center border">1</div>
		<% } %>	
	</div>
	
	<div class="row">
		<div class="col p-2 text-center border">col sin numero</div>
		<div class="col p-2 text-center border">col sin numero</div>
		<div class="col p-2 text-center border">col sin numero</div>
		<div class="col p-2 text-center border">col sin numero</div>
		<div class="col p-2 text-center border">col sin numero</div>
	</div>
	
	
	<div class="row">	
		<div class="col-4 p-2 text-center border">4</div>
		<div class="col-4 p-2 text-center border">4</div>
		<div class="col-2 offset-2 p-2 text-center border">2 offset</div>	
	</div>
	
	
	
	
<%@include file="../includes/footer-bootstrap.jsp" %>
	