-- CONSULTA 1 --
-- Devuelve los datos del alumno cuyo id=1 --

SELECT * FROM alumno
WHERE id=1;

-- CONSULTA 2 --
-- Devuelve los datos del alumno cuyo telefono sea 692735409 --

SELECT * FROM alumno
WHERE teléfono=692735409;

-- CONSULTA 3 --
-- Devuelve los datos de los alumnos nacidos después del 1 de enero de 1994 --

SELECT * FROM alumno
WHERE fecha_nacimiento>'1994-01-01';

-- CONSULTA 4 --
-- Devuelve los datos de los alumnos repetidores --

SELECT * FROM alumno
WHERE es_repetidor='si';

-- CONSULTA 5 --
-- Devuelve los datos de los alumnos no repetidores --

SELECT * FROM alumno
WHERE es_repetidor='no';

-- CONSULTA 6 --
-- Devuelve los datos de los alumnos nacidos antes del 1 de enero de 1993 --

SELECT * FROM alumno
WHERE fecha_nacimiento<'1993-01-01';

-- CONSULTA 7 --
-- Devuelve los datos de los alumnos nacidos después del 1 de enero de 1994 y no son repetidores --

SELECT * FROM alumno
WHERE fecha_nacimiento>'1994-01-01' AND es_repetidor='no';

-- CONSULTA 8 --
-- Devuelve los datos de los alumnos nacidos en el año 1998 --

SELECT * FROM alumno
WHERE fecha_nacimiento BETWEEN '1998-01-01' AND '1998-12-31';

-- CONSULTA 9 --
-- Devuelve los datos de los alumnos no nacidos en el año 1998 --

SELECT * FROM alumno
WHERE fecha_nacimiento NOT BETWEEN '1998-01-01'AND '1998-12-31';

-- CONSULTA 10 --
-- Devuelve los datos de los alumnos nacidos entre el 1 de enero y el 31 de mayo de 1998 --
SELECT * FROM alumno
WHERE fecha_nacimiento BETWEEN '1998-01-01' AND '1998-05-31';

-- CONSULTA 11--
-- Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los dos apellidos de los alumnos. En la segunda columna se mostrará una dirección de correo electrónico que vamos a calcular para cada alumno. La dirección de correo estará formada por el nombre y el primer apellido, separados por el carácter . y seguidos por el dominio @iescelia.org. Tenga en cuenta que la dirección de correo electrónico debe estar en minúscula. Utilice un alias apropiado para cada columna. --

SELECT CONCAT (nombre,' ', apellido1,' ', apellido2) AS Nombre_Completo,
CONCAT (lower(nombre),'.', lower(apellido1), '@iescelia.org') AS Email
FROM alumno;

-- CONSULTA 12 -- 
-- Devuelve un listado con tres columnas. Las dos primeras serán igual que el ejercicio anterior. La tercera columna será una contraseña que vamos a generar formada por los caracteres invertidos del segundo apellido, seguidos de los cuatro caracteres del año de la fecha de nacimiento. Utilice un alias apropiado para cada columna. --

SELECT CONCAT (nombre,' ', apellido1,' ', apellido2) AS 'Nombre Completo',
CONCAT (lower(nombre),'.', lower(apellido1), '@iescelia.org') AS 'Email',
CONCAT (LOWER (REVERSE(apellido2)),left(fecha_nacimiento,4)) AS 'Contraseña'
FROM alumno;

-- CONSULTA 13--
-- Devuelva un listado con cuatro columnas, donde aparezca en la primera columna la fecha de nacimiento completa de los alumnos, en la segunda columna el día, en la tercera el mes y en la cuarta el año. Utilice las funciones DAY, MONTH y YEAR. --

SELECT
fecha_nacimiento AS 'Fecha de Nacimiento',
DAY (fecha_nacimiento) AS 'Día',
MONTH (fecha_nacimiento) AS 'Mes',
YEAR (fecha_nacimiento) AS 'Año'
FROM alumno;


-- CONSULTA 14 --
-- Devuelva un listado con tres columnas, donde aparezca en la primera columna la fecha de nacimiento de los alumnos, en la segunda el nombre del día de la semana de la fecha de nacimiento y en la tercera el nombre del mes de la fecha de nacimiento.

SELECT
fecha_nacimiento AS 'Fecha de Nacimiento',
weekday(fecha_nacimiento) AS 'Día de la semana',
monthname(fecha_nacimiento) AS 'Nombre del mes'
FROM alumno;

-- CONSULTA 15 --
-- Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre de los alumnos y en la segunda, el nombre con todos los caracteres invertidos. --

SELECT
nombre AS 'Nombre del alumno',
REVERSE(nombre) AS 'Nombre invertido'
FROM alumno;
 
-- CONSULTA 16 --
-- Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los apellidos de los alumnos y en la segunda, el nombre y los apellidos con todos los caracteres invertidos. --

SELECT
CONCAT (nombre,' ', apellido1,' ', apellido2) AS 'Nombre Completo',
CONCAT (REVERSE (nombre),' ', REVERSE(apellido1),' ',REVERSE (apellido2)) AS 'Carácteres invertidos'
FROM alumno;

 
-- CONSULTA 17 --
-- Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los apellidos de los alumnos en mayúscula y en la segunda, el nombre y los apellidos con todos los caracteres invertidos en minúscula. --

SELECT
CONCAT(UPPER(nombre), ' ', UPPER(apellido1), ' ', UPPER(apellido2)) AS 'Nombre Completo',
CONCAT(LOWER(REVERSE(nombre)), ' ', LOWER(REVERSE(apellido1)), ' ', LOWER(REVERSE(apellido2))) AS 'Caracteres invertidos'
FROM alumno;

 
-- CONSULTA 18 --
-- Devuelve un listado con dos columnas, donde aparezca en la primera columna el nombre y los apellidos de los alumnos y en la segunda, el número de caracteres que tiene en total el nombre y los apellidos. --

SELECT
CONCAT (nombre,' ', apellido1,' ', apellido2) AS 'Nombre Completo',
length(CONCAT (nombre,' ', apellido1,' ', apellido2)) AS 'Total de Caracteres'
FROM alumno;

-- CONSULTA 19 --
-- Devuelva un listado con dos columnas, donde aparezca en la primera columna la fecha de nacimiento de los alumnos y en la segunda columna el número de días que han pasado desde la fecha actual hasta la fecha de nacimiento. Utilice las funciones DATEDIFF y NOW. Consulte la documentación oficial de MySQL para DATEDIFF. --

SELECT
fecha_nacimiento AS 'Fecha de Nacimiento',
DATEDIFF (NOW(), fecha_nacimiento) AS 'Diferencia de días'
FROM alumno;

-- CONSULTA 20 --
-- Devuelva un listado con dos columnas, donde aparezca en la primera columna la fecha de nacimiento de los alumnos y en la segunda columna la edad de cada alumno/a. La edad (aproximada) la podemos calcular usando DATEDIFF y TRUNCATE.

SELECT
fecha_nacimiento AS 'Fecha de Nacimiento',
TRUNCATE(DATEDIFF(NOW(), fecha_nacimiento) / 365.25, 0) AS 'Edad del alumno'
FROM alumno;