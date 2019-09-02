<%@include file="includes/header.jsp"%>
<%@include file="includes/navbar.jsp"%>

<%@include file="includes/mensaje.jsp"%>

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="login" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Nombre de usuario:</label><br>
                                <input type="text" name="nombre" autofocus id="usuario" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Contraseña:</label><br>
                                <input type="password" name="contrasenya" id="pass" class="form-control">
                            </div>
                           <div class="form-group">
                                <input type="submit" name="entrar" class="btn btn-info btn-md" value="Entrar">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<%@include file="includes/footer.jsp"%>