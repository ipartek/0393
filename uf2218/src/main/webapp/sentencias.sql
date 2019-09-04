--listar usuarios
SELECT id, nombre, contra FROM usuario ORDER BY nombre ASC LIMIT 500;

--busqueda por nombre
SELECT id, nombre, contra FROM usuario WHERE nombre LIKE '%cas%' ORDER BY nombre ASC LIMIT 500;

--crear un usuario
INSERT INTO usuario (nombre, contra) VALUES (?,?);

--modificar un usuario
UPDATE usuario SET nombre = ?, contra = ? WHERE  id = ?;

--eliminar un usuario por id
DELETE FROM video WHERE id = ?;