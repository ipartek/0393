<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Transacciones</h1>
	<p>Transacciones

¿Que es un DAO?
         Cuando se pretende modelar con objetos de un modelo de datos, es decir las tablas y sus relaciones, es muy común utilizar una propuesta simple que consiste en armar una clase por cada tabla existente.
         Dicha clase tendrá los métodos de acceso a la tabla correspondiente, entre ellos la inserción, modificación y la eliminación. Este tipo de clases suelen conocerse como DAOs, ya que objetos de esta clase se utilizaran para realizar operaciones de datos.
         De esta forma, si existe la tabla autos, es posible construir una clase denominada Auto, que siguiendo la especificación de un DAO, se debería tener los métodos insertar, modificar, eliminar y métodos con las consultas que resulten necesarias.

¿Qué es una transacción?
         Una transacción en SQL es una colección de sentencias DML que forman una unidad lógica de trabajo o procesamiento, con propiedades bien definidas. De esta manera será un conjunto de operaciones sobre los datos en una base de datos que o se ejecuta entera o no se ejecuta ninguna de sus sentencias.
         JDBC permite que las declaraciones de SQL sean agrupadas juntas en una sola transacción. De esta manera, es posible asegurar la atomicidad y consistencia de datos, usando características transaccionales de JDBC.

El método setAutoCommit()
         El control de la transacción es realizado por el objeto de la conexión. Cunado se crea una conexión, por defecto esta en el modo activado. Esto significa que cada declaración individual de SQL es tratada como transacción por sí
 mismo, y será comprometida tan pronto como finalice la ejecución.
         El método setAutoCommit es el encargado de establecer si se trabajara agrupando varias sentencias en una transacción, o por el contrario cada sentencia SQL será una transacción independiente.
         Para trabajar con varaias sentencias SQL y ejecutarlas como una transacción es necesario establecer el atuo-commit en false:
        
         unaConexion.setAutoCommit(false);

         Si no es necesario trabajar con transacciones, por defecto el auto-commit esta seteado en true.

El método commit
         Cuanto el auto-commit esta en false, para poder comprometer o impactar los cambios en la base de datos, es necesario llamar al método commit(). Si no se llama al método commit(), los cambios no serán reflejados en la base de datos aun cuando se hayan ejecutadas una o más sentencias SQL.
         El método commit() pertenece a la conexión, y la forma de invocarlo es la siguiente:
        
         unaConexion.commit();

El método rollback()
         Si en algún punto antes de invocar el método commit(), el método rollback() es invocado, todas las  sentencias que se hayan ejecutado quedaran sin efecto, es decir que el rollback() vuelve atrás todos los cambios realizados sobre los datos desde el ultimo commit() realizado.
         El método rollback() también pertenece a la conexión, y la forma de invocarlo es la siguiente:
        
         una Conexión.rollback()</p>
	
	<h3>Ejemplo de transacciones</h3>
	<a class="btn btn-primary btn-block mb-2" href="backoffice/transacciones">TRANSACCIONES</a>
	
	<a href="http://labojava.blogspot.com/2012/05/jdbc-conexion-con-base-de-datos.html">Enlace</a>
	

<%@include file="../includes/footer.jsp"%>