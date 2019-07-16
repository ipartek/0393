<%@include file="../includes/header.jsp" %>


<main class="content">

	<h1>Selectores Básicos</h1>
	
	<% for(int i=0; i < 300; i++){ 
		
		if ( i % 5 == 0 ){
			out.print("<h2 class=\"postit\">Titulo " + i + "</h2>");		
		}
	%>
		
		<p>Lorem Ipsum</p>
	<%} %>
	
</main>	


	
<%@include file="../includes/footer.jsp" %>	