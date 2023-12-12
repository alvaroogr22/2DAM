-- Realice las siguientes operaciones sobre la base de datos tienda.
-- 1. Inserta un nuevo fabricante indicando su código y su nombre
INSERT INTO fabricante (codigo_fabricante, nombre) VALUES (nuevo_codigo, 'Nuevo Fabricante');

-- 2. Inserta un nuevo fabricante indicando solamente su nombre.
INSERT INTO fabricante (nombre) VALUES ('Nuevo Fabricante');

-- 3. Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de
-- inserción debe incluir: código, nombre, precio y código_fabricante.
INSERT INTO productos (codigo_producto, nombre, precio, codigo_fabricante) VALUES (nuevo_codigo_producto, 'Nuevo Producto', precio, codigo_fabricante);

-- 4. Inserta un nuevo producto asociado a uno de los nuevos fabricantes. La sentencia de
-- inserción debe incluir: nombre, precio y código_fabricante.
INSERT INTO productos (nombre, precio, codigo_fabricante) VALUES ('Nuevo Producto', precio, codigo_fabricante);

-- 5. Crea una nueva tabla con el nombre fabricante_productos que tenga las siguientes
-- columnas: nombre_fabricante, nombre_producto y precio. Una vez creada la tabla
-- inserta todos los registros de la base de datos tienda en esta tabla haciendo uso de
-- única operación de inserción.
CREATE TABLE fabricante_productos AS
SELECT f.nombre AS nombre_fabricante, p.nombre AS nombre_producto, p.precio
FROM fabricante f
INNER JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante;

-- 6. Elimina el fabricante Asus. ¿Es posible eliminarlo? Si no fuese posible, ¿qué cambios
-- debería realizar para que fuese posible borrarlo?
DELETE FROM fabricante WHERE nombre = 'Asus';
DELETE FROM productos WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');
DELETE FROM fabricante WHERE nombre = 'Asus';
-- 7. Elimina el fabricante Xiaomi. ¿Es posible eliminarlo? Si no fuese posible, ¿qué
-- cambios debería realizar para que fuese posible borrarlo?

DELETE FROM fabricante WHERE nombre = 'Xiaomi';
DELETE FROM productos WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Xiaomi');
DELETE FROM fabricante WHERE nombre = 'Xiaomi';

-- 8. Actualiza el código del fabricante Lenovo y asígnale el valor 20. ¿Es posible
-- actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese
-- actualizarlo?
UPDATE fabricante SET codigo_fabricante = 20 WHERE nombre = 'Lenovo';



-- 9. Actualiza el código del fabricante Huawei y asígnale el valor 30. ¿Es posible
-- actualizarlo? Si no fuese posible, ¿qué cambios debería realizar para que fuese
-- actualizarlo?
UPDATE fabricante SET codigo_fabricante = 30 WHERE nombre = 'Huawei';

-- 10. Actualiza el precio de todos los productos sumándole 5 € al precio actual.
UPDATE productos SET precio = precio + 5;

-- 11. Elimina todas las impresoras que tienen un precio menor de 200 €.
DELETE FROM productos WHERE nombre = 'Impresora' AND precio < 200;
