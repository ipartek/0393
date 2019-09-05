USE empadronamiento_jon;

-- PRIMERA CONSULTA
-- Queremos poder consultar las direcciones y números de las viviendas propiedad de una persona según su DNI.

-- Forma IMPLICITA

/*
SELECT p.nombre as nombre, p.dni as dni, v.calle as calle, v.numero as num
FROM persona as p, vivienda as v, persona_tiene_vivienda as t
WHERE p.id = t.persona_id AND v.id = t.vivienda_id AND p.dni = '14836291M'; 
*/

-- Forma EXPLICITA

/*
SELECT p.nombre as nombre, p.dni as dni, v.calle as calle, v.numero as num
FROM persona as p
INNER JOIN persona_tiene_vivienda as t ON p.id = t.persona_id
INNER JOIN vivienda as v ON v.id = t.vivienda_id
WHERE p.dni = '14836291M';
*/

-- SEGUNDA CONSULTA
-- Necesitamos los nombres y apellidos de los propietarios de un municipio determinado.

-- Forma IMPLICITA 

/*
SELECT DISTINCT p.nombre as nombre, p.apellidos as apellidos, m.nombre as municipio
FROM persona as p, persona_tiene_vivienda as t, vivienda as v, municipio as m
WHERE p.id = t.persona_id AND v.id = t.vivienda_id AND m.id = v.municipio_id AND m.nombre = "Sopela"; 
*/

-- Forma EXPLICITA

/*
SELECT DISTINCT p.nombre as nombre, p.apellidos as apellidos, m.nombre as municipio
FROM persona as p
INNER JOIN persona_tiene_vivienda as t ON p.id = t.persona_id
INNER JOIN vivienda as v ON v.id = t.vivienda_id
INNER JOIN municipio as m ON m.id = v.municipio_id
WHERE m.nombre = "Sopela";
*/

-- TERCERA CONSULTA
-- Queremos saber quién está empadronado en una vivienda según su dirección y número.

-- el municipio de la vivienda donde habita alguien es donde este está empadronado

-- Forma IMPLICTA

/*
SELECT p.nombre as nombre, p.apellidos as apellidos, v.calle as calle, v.numero as num
FROM persona as p, vivienda as v
WHERE p.vivienda_id = v.id AND v.calle = 'Mendieta' AND v.numero = '18';
*/

-- Forma EXPLICITA

/*
SELECT p.nombre as nombre, p.apellidos as apellidos, v.calle as calle, v.numero as num
FROM persona as p
INNER JOIN vivienda as v ON p.vivienda_id = v.id
WHERE v.calle = 'Mendieta' AND v.numero = '18';
*/

-- CUARTA CONSULTA
-- Queremos saber los propietarios de una vivienda según su dirección y número.

-- Forma IMPLICITA

/*
SELECT p.nombre as nombre, p.apellidos as apellidos, v.calle as calle, v.numero as num
FROM persona as p, vivienda as v, persona_tiene_vivienda as t
WHERE p.id = t.persona_id AND v.id = t.vivienda_id AND v.calle = 'Mendieta' AND v.numero = '18'; 
*/

-- Forma EXPLICITA

/*
SELECT p.nombre as nombre, p.apellidos as apellidos, v.calle as calle, v.numero as num
FROM persona as p
INNER JOIN persona_tiene_vivienda as t ON p.id = t.persona_id
INNER JOIN vivienda as v ON v.id = t.vivienda_id
WHERE v.calle = 'Mendieta' AND v.numero = '18';
*/






