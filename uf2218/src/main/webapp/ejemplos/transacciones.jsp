<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

	<h1>Transacciones</h1>
	<p>Transacciones

�Que es un DAO?
         Cuando se pretende modelar con objetos de un modelo de datos, es decir las tablas y sus relaciones, es muy com�n utilizar una propuesta simple que consiste en armar una clase por cada tabla existente.
         Dicha clase tendr� los m�todos de acceso a la tabla correspondiente, entre ellos la inserci�n, modificaci�n y la eliminaci�n. Este tipo de clases suelen conocerse como DAOs, ya que objetos de esta clase se utilizaran para realizar operaciones de datos.
         De esta forma, si existe la tabla autos, es posible construir una clase denominada Auto, que siguiendo la especificaci�n de un DAO, se deber�a tener los m�todos insertar, modificar, eliminar y m�todos con las consultas que resulten necesarias.

�Qu� es una transacci�n?
         Una transacci�n en SQL es una colecci�n de sentencias DML que forman una unidad l�gica de trabajo o procesamiento, con propiedades bien definidas. De esta manera ser� un conjunto de operaciones sobre los datos en una base de datos que o se ejecuta entera o no se ejecuta ninguna de sus sentencias.
         JDBC permite que las declaraciones de SQL sean agrupadas juntas en una sola transacci�n. De esta manera, es posible asegurar la atomicidad y consistencia de datos, usando caracter�sticas transaccionales de JDBC.

El m�todo setAutoCommit()
         El control de la transacci�n es realizado por el objeto de la conexi�n. Cunado se crea una conexi�n, por defecto esta en el modo activado. Esto significa que cada declaraci�n individual de SQL es tratada como transacci�n por s�
 mismo, y ser� comprometida tan pronto como finalice la ejecuci�n.
         El m�todo setAutoCommit es el encargado de establecer si se trabajara agrupando varias sentencias en una transacci�n, o por el contrario cada sentencia SQL ser� una transacci�n independiente.
         Para trabajar con varaias sentencias SQL y ejecutarlas como una transacci�n es necesario establecer el atuo-commit en false:
        
         unaConexion.setAutoCommit(false);

         Si no es necesario trabajar con transacciones, por defecto el auto-commit esta seteado en true.

El m�todo commit
         Cuanto el auto-commit esta en false, para poder comprometer o impactar los cambios en la base de datos, es necesario llamar al m�todo commit(). Si no se llama al m�todo commit(), los cambios no ser�n reflejados en la base de datos aun cuando se hayan ejecutadas una o m�s sentencias SQL.
         El m�todo commit() pertenece a la conexi�n, y la forma de invocarlo es la siguiente:
        
         unaConexion.commit();

El m�todo rollback()
         Si en alg�n punto antes de invocar el m�todo commit(), el m�todo rollback() es invocado, todas las  sentencias que se hayan ejecutado quedaran sin efecto, es decir que el rollback() vuelve atr�s todos los cambios realizados sobre los datos desde el ultimo commit() realizado.
         El m�todo rollback() tambi�n pertenece a la conexi�n, y la forma de invocarlo es la siguiente:
        
         una Conexi�n.rollback()</p>
	
	<h3>Ejemplo de transacciones</h3>
	<a class="btn btn-primary btn-block mb-2" href="backoffice/transacciones">TRANSACCIONES</a>
	
	<a href="http://labojava.blogspot.com/2012/05/jdbc-conexion-con-base-de-datos.html">Enlace</a>
	

<%@include file="../includes/footer.jsp"%>