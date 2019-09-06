USE videos;

-- numero de likes
SELECT COUNT(*) FROM likes WHERE video_id =4;

-- INNER JOIN explicita
-- mostrar los videos del usuario 'soso' por su id
SELECT u.nombre AS 'usuario',
		v.nombre AS 'video',
        c.nombre AS 'categoria'
FROM (usuario AS u INNER JOIN video AS v ON u.id = v.usuario_id) 
		INNER JOIN categoria AS c ON v.categoria_id=c.id
WHERE u.id=3;
 
-- INNER JOIN implicita
-- mostrar los videos del usuario 'soso' por su id
SELECT u.nombre AS 'usuario',
		v.nombre AS 'video',
        c.nombre AS 'categoria'
FROM usuario AS u,
	 video AS v, 
	 categoria AS c
WHERE u.id = v.usuario_id AND v.categoria_id=c.id AND u.id=3;







USE `v2019`;
-- select * from video;

-- UPDATE video SET id_usuario = 1 WHERE id_usuario = 0;

-- Select de video mostrando el nombre del usuario
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