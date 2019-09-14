
-- listar todos

SELECT id, nombre, contrasena FROM usuario ORDER BY id DESC LIMIT 500;

-- busqueda por nombre

SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE '%?%' ORDER BY nombre ASC LIMIT 500;

-- crear usuario

INSERT INTO usuario (nombre, contrasena) VALUES (?,?);

-- modificar usuario

UPDATE usuario SET nombre = ?, contrasena = ? WHERE id = ?; 

-- eliminar usuario 

DELETE FROM usuario WHERE id = ?; 

-- getall videos, con likes (HACE FALTA VERSION EXPLICITA para sacar los videos sin likes)

SELECT v.id as 'video_id',   v.nombre as 'video_nombre',
			  codigo, u.id as 'usuario_id',   u.nombre as 'usuario_nombre',   c.id as 'categoria_id', COUNT(v.id) as 'likes',
			  c.nombre as 'categoria_nombre', u.fecha_eliminacion as 'usuario_eliminacion', u.fecha_creacion as 'usuario_creacion' 
              FROM video as v, usuario as u, categoria as c, likes
			  WHERE v.usuario_id = u.id   AND c.id = v.categoria_id AND likes.id_video = v.id
              GROUP BY v.id;
              
-- getall videos con likes, version explicita

SELECT v.id as video_id, v.nombre as video_nombre, v.codigo as codigo,
 u.id as usuario_id, u.nombre as usuario_nombre, u.fecha_creacion as usuario_creacion, u.fecha_eliminacion as usuario_eliminacion,
 c.id as categoria_id, c.nombre as categoria_nombre, COUNT(l.id_video) as megusta
 FROM video as v
 INNER JOIN usuario as u ON v.usuario_id = u.id 
 INNER JOIN categoria as c ON v.categoria_id = c.id
 LEFT JOIN likes as l ON v.id = l.id_video
 GROUP BY v.id LIMIT 500;              
