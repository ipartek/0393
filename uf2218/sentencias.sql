-- Listar todos los usuarios
SELECT id,nombre,contrasenya FROM usuario

-- Crear un Usuario nuevo
INSERT INTO usuario (nombre, contrasenya) VALUES (?,?);

-- Modificar un usuario
UPDATE usuario SET nombre = ?, contrasenya = ? WHERE  id = ?;
-- Eliminar usuario por Id
DELETE FROM usuario WHERE id = ?;
-- Busqueda por nombre
SELECT id, nombre, contrasenya FROM usuario WHERE nombre  LIKE '%?%' ORDER BY id ASC LIMIT 500

-- Select de video mostrando nombre de usuario
SELECT  v.id, v.nombre, v.codigo, u.nombre FROM video v INNER JOIN usuario u ON v.id_usuario = u .id