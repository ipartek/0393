USE v2019;


-- SELECT id,nombre,contrasenya FROM usuario ORDER BY id DESC LIMIT 500;

-- busqueda por nombre
SELECT id,nombre,contrasenya FROM usuario WHERE nombre LIKE '%cas%' ORDER BY nombre ASC LIMIT 500;