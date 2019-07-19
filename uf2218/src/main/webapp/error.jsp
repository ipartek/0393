<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<%@page isErrorPage="true" %>
    
   	<h1>Error 500</h1>
   	<p>Lo sentimos pero parece que hay algun problema</p>
   	<p>Madanos un <a href="mailto:formacion@ipartek.com">email</a> para que lo solucionemos</p>
    	    	
    <div class="p-2 border border-danger">
    	<h2>Usar solo en Desarrollo</h2>	    	
	    <p class="text-danger"><%=exception%></p>    
	    <!-- Stack trace -->
		<jsp:scriptlet>
		  exception.printStackTrace(new java.io.PrintWriter(out));
		</jsp:scriptlet>
	</div>
    	    	
<%@include file="includes/footer.jsp"%>   