-- 1. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT *
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Lenovo');

-- 2. Devuelve todos los datos de los productos que tienen el mismo precio que el producto
-- más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT *
FROM productos
WHERE precio = (
    SELECT MAX(precio)
    FROM productos
    WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Lenovo')
);

-- 3. Lista el nombre del producto más caro del fabricante Lenovo
SELECT nombre
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Lenovo')
ORDER BY precio DESC
LIMIT 1;

-- 4. Lista el nombre del producto más barato del fabricante Hewlett-Packard
SELECT nombre
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Hewlett-Packard')
ORDER BY precio
LIMIT 1;

-- 5. Devuelve todos los productos de la base de datos que tienen un precio mayor o igual
-- al producto más caro del fabricante Lenovo.
SELECT *
FROM productos
WHERE precio >= (
    SELECT MAX(precio)
    FROM productos
    WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Lenovo')
);

-- 6. Lista todos los productos del fabricante Asus que tienen un precio superior al precio
-- medio de todos sus productos.
SELECT *
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus')
AND precio > (
    SELECT AVG(precio)
    FROM productos
    WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus')
);
