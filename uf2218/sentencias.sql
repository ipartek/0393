USE v2019;

-- listar todos
-- SELECT id,nombre,contrasenya FROM usuario ORDER BY id DESC LIMIT 500;

-- busqueda por nombre
SELECT id,nombre,contrasenya FROM usuario WHERE nombre LIKE '%cas%' ORDER BY nombre ASC LIMIT 500;


-- eliminar un usuario por id
DELETE FROM usuario WHERE id = ?;

-- crear un usuario nuevo
INSERT INTO usuario ( nombre, contrasenya) VALUES ( ? , ?);

-- modificar un usuario
UPDATE usuario SET nombre= ?, contrasenya= ? WHERE id = ?;
