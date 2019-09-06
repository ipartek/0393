USE v2019;

-- Listar todos los usuarios
SELECT id, nombre, contrasena FROM usuario ORDER BY id DESC LIMIT 500;

-- Eliminar un usuario por ID.
DELETE FROM usuario WHERE id = ?;

-- Crear un usuario nuevo.
INSERT INTO usuario (nombre, contrasena) VALUES (?, ?);

-- Modificar un usuario.
UPDATE usuario SET nombre = ?, contrasena = ? WHERE  id = ?;

-- Buscar un usuario por nombre.
SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE '%a%' ORDER BY nombre DESC LIMIT 500; -- '%' n caracteres
			-- Así es en SQL normal.
			-- Pero para usarlo en JAVA, hay que poner LIKE ?.
			-- Y luego pst.setString(1, "%" + nombre + "%"); 

SELECT id, nombre, contrasena FROM usuario WHERE nombre LIKE '__cas' ORDER BY nombre DESC LIMIT 500; -- '_' sólo 1 caracter.

-- INNER JOIN
SELECT u.nombre AS 'usuario', v.nombre AS 'video', c.nombre AS 'categoria'
	FROM usuario AS u INNER JOIN video AS v ON u.id = v.id_usuario 
		INNER JOIN categoria AS c ON v.id_categoria = c.id
	WHERE u.id=3;