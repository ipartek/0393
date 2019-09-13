<%@page import="com.ipartek.formacion.controller.listener.UsuariosLogeadosListener"%>

<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%> 
<%@include file="../includes/mensaje.jsp"%>



 <h1>BACKOFFICE</h1>
 
<div class="row">
          <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-primary o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                 <i class="fab fa-youtube"></i>
                </div>
                <div class="mr-4">${numeroVideos} Videos</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/videos">
                <span class="float-left">Ver listado</span>
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
                 <i class="fas fa-user"></i>
                </div>
                <div class="mr-4">${numeroUsuariosV} Usuarios Activos</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/usuario?visible=true">
                <span class="float-left">Ver listado</span>
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
                 <i class="fas fa-user-slash"></i>
                </div>
                <div class="mr-4">${numeroUsuariosE} Usuarios Eliminados</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/usuario?visible=false">
                <span class="float-left">Ver listado</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
           <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-success o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon"> 
                 <i class="fas fa-tags"></i>
                </div>
                <div class="mr-4">${numeroCategorias} Categorias</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/categoria">
                <span class="float-left">Ver listado</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
        </div>

<%@include file="../includes/footer.jsp"%>