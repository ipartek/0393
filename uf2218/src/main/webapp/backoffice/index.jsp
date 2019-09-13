<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>
<%@page import="com.ipartek.formacion.controller.backoffice.UsuariosController"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>


<h1>BACKOFFICE</h1>
 


<div class="row">
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-primary o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-comments"></i>
                </div>
                <div class="mr-5">${numeroUsuarios} usuarios!</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/usuarios?op=${UsuariosController.OP_LISTAR}&visible=1">
                <span class="float-left">Ver Usuarios</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-warning o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-list"></i>
                </div>
                <div class="mr-5">${numeroVideos} videos!</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/videos?visible=1">
                <span class="float-left">Ver Videos</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
          
          <c:if test="${usuario.getRol() == 1}">
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-success o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-fw fa-shopping-cart"></i>
	                </div>
	                <div class="mr-5">${usuariosNoVisibles} Borrados</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="backoffice/usuarios?op=${UsuariosController.OP_LISTAR}&visible=0">
	                <span class="float-left">Ver usuarios borrados</span>
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	          
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-danger o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-fw fa-life-ring"></i>
	                </div>
	                <div class="mr-5">${numeroVideosNoVisibles} Borrados</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="backoffice/videos?visible=0">
	                <span class="float-left">Ver videos borrados</span>
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
	          
	          <div class="col-xl-3 col-sm-6 mb-3">
	            <div class="card text-white bg-danger o-hidden h-100">
	              <div class="card-body">
	                <div class="card-body-icon">
	                  <i class="fas fa-fw fa-life-ring"></i>
	                </div>
	                <div class="mr-5">${numeroCategorias} Categorias</div>
	              </div>
	              <a class="card-footer text-white clearfix small z-1" href="backoffice/categoria">
	                <span class="float-left">Ver categorias</span>
	                <span class="float-right">
	                  <i class="fas fa-angle-right"></i>
	                </span>
	              </a>
	            </div>
	          </div>
          </c:if>
          
        </div>


<%@include file="../includes/footer.jsp"%>