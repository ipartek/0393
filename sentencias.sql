USE `v2019`;
-- select * from video;

-- UPDATE video SET id_usuario = 1 WHERE id_usuario = 0;

-- Unir video con usuario
SELECT video.id, video.nombre, usuario.nombre FROM video INNER JOIN usuario ON video.id_usuario = usuario.id;

-- buscar por nombre
-- los % significan cualquier cadena cuyos primer y segundo caracter sean cualquier cosa y tercero a quinto sean 'cas'
SELECT id,nombre,contrasenya FROM usuario WHERE nombre LIKE '%__cas%' ORDER BY id ASC LIMIT 500;

-- listar todos
SELECT id,nombre,contrasenya FROM usuario ORDER BY id ASC LIMIT 500;
-- Crear nuevo usuario
INSERT INTO usuario (nombre, contrasenya) VALUES (?,?);
-- Modificar usuario
UPDATE usuario SET nombre = ?, contrasenya = ? WHERE  id = ?;
-- Eliminar usuario
DELETE FROM usuario WHERE id = ?;