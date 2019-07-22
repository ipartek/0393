    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	  <a class="navbar-brand" href="#">JEE</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" href="index.jsp">Inicio</a>
	      </li>
	       <li class="nav-item active">
	        <a class="nav-link" href="videos">Videos</a>
	      </li>	 	      
	       <li class="nav-item active">
	       	<c:if test="${usuario == null}">
	        	<a class="nav-link" href="login.jsp">Login</a>
	        </c:if>
	        <c:if test="${usuario != null}">
	        	<span>${usuario}</span>
	        	<a class="nav-link" href="logout">Logout</a>
	        </c:if>		       
	      </li>	 	            
	    </ul>	   
	  </div>
	</nav>
    <!-- end navar -->
    
    
    <main class="container">