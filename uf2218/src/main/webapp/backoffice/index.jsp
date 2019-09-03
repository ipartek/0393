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
                  <i class="fas fa-video"></i>
                </div>
                 <div class="mr-5">${numeroVideos} videos</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/videos">
                <span class="float-left">Listado de Videos</span>
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
                  <i class="fas fa-users"></i>
                </div>
                <div class="mr-5">${numeroUsuarios} usuarios registrados</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="backoffice/usuarios">
                <span class="float-left">Listado de usuarios</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
        </div>


<%@include file="../includes/footer.jsp"%>