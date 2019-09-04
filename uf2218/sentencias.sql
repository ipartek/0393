
-- listar todos

SELECT id, nombre, contrasena FROM usuario ORDER BY id DESC LIMIT 500;

-- busqueda por nombre

SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE '%e%' ORDER BY nombre ASC LIMIT 500;

-- crear usuario

INSERT INTO usuario (nombre, contrasena) VALUES (?,?);

-- modificar usuario

UPDATE usuario SET nombre = ?, contrasena = ? WHERE id = ?; 

-- eliminar usuario 

DELETE FROM usuario WHERE id = ?; 
