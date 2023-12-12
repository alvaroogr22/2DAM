-- 1Calcula el número total de productos que hay en la tabla productos.
SELECT COUNT(*) AS Total_Productos
FROM productos;

-- 2. Calcula el número total de fabricantes que hay en la tabla fabricante.
SELECT COUNT(*) AS Total_Fabricantes
FROM fabricante;

-- 3. Calcula el número de valores distintos de código de fabricante aparecen en la tabla
-- productos.
SELECT COUNT(DISTINCT codigo_fabricante) AS Valores_Distintos
FROM productos;

-- 4. Calcula la media del precio de todos los productos.
SELECT AVG(precio) AS Precio_Medio
FROM productos;

-- 5. Calcula el precio más barato de todos los productos.
SELECT MIN(precio) AS Precio_Minimo
FROM productos;

-- 6. Calcula el precio más caro de todos los productos.
SELECT MAX(precio) AS Precio_Maximo
FROM productos;

-- 7. Lista el nombre y el precio del producto más barato.
SELECT nombre, precio
FROM productos
WHERE precio = (SELECT MIN(precio) FROM productos);

-- 8. Lista el nombre y el precio del producto más caro.
SELECT nombre, precio
FROM productos
WHERE precio = (SELECT MAX(precio) FROM productos);

-- 9. Calcula la suma de los precios de todos los productos.
SELECT SUM(precio) AS Suma_Precios
FROM productos;

-- 10. Calcula el número de productos que tiene el fabricante Asus.
SELECT COUNT(*) AS Total_Productos_Asus
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');

-- 11. Calcula la media del precio de todos los productos del fabricante Asus.
SELECT AVG(precio) AS Precio_Medio_Asus
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');

-- 12. Calcula el precio más barato de todos los productos del fabricante Asus.
SELECT MIN(precio) AS Precio_Minimo_Asus
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');

-- 13. Calcula el precio más caro de todos los productos del fabricante Asus.
SELECT MAX(precio) AS Precio_Maximo_Asus
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');

-- 14. Calcula la suma de todos los productos del fabricante Asus.
SELECT SUM(precio) AS Suma_Productos_Asus
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Asus');

-- 15. Muestra el precio máximo, precio mínimo, precio medio y el número total de
-- productos que tiene el fabricante Crucial.
SELECT 
    MAX(precio) AS Precio_Maximo,
    MIN(precio) AS Precio_Minimo,
    AVG(precio) AS Precio_Medio,
    COUNT(*) AS Total_Productos
FROM productos
WHERE codigo_fabricante = (SELECT codigo_fabricante FROM fabricante WHERE nombre = 'Crucial');

-- 16. Muestra el número total de productos que tiene cada uno de los fabricantes. El listado
-- también debe incluir los fabricantes que no tienen ningún producto. El resultado
-- mostrará dos columnas, una con el nombre del fabricante y otra con el número de
-- productos que tiene. Ordene el resultado descendentemente por el número de
-- productos.
SELECT 
    f.nombre AS Nombre_Fabricante,
    COUNT(p.codigo_fabricante) AS Numero_Productos
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.codigo_fabricante
ORDER BY Numero_Productos DESC;

-- 17. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada
-- uno de los fabricantes. El resultado mostrará el nombre del fabricante junto con los
-- datos que se solicitan.
SELECT 
    f.nombre AS Nombre_Fabricante,
    MAX(p.precio) AS Precio_Maximo,
    MIN(p.precio) AS Precio_Minimo,
    AVG(p.precio) AS Precio_Medio
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.codigo_fabricante;

-- 18. Muestra el precio máximo, precio mínimo, precio medio y el número total de
-- productos de los fabricantes que tienen un precio medio superior a 200€. No es
-- necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
SELECT 
    p.codigo_fabricante AS Codigo_Fabricante,
    MAX(p.precio) AS Precio_Maximo,
    MIN(p.precio) AS Precio_Minimo,
    AVG(p.precio) AS Precio_Medio,
    COUNT(*) AS Total_Productos
FROM productos p
GROUP BY p.codigo_fabricante
HAVING AVG(p.precio) > 200;

-- 19. Muestra el nombre de cada fabricante, junto con el precio máximo, precio mínimo,
-- precio medio y el número total de productos de los fabricantes que tienen un precio
-- medio superior a 200€. Es necesario mostrar el nombre del fabricante.
SELECT 
    f.nombre AS Nombre_Fabricante,
    MAX(p.precio) AS Precio_Maximo,
    MIN(p.precio) AS Precio_Minimo,
    AVG(p.precio) AS Precio_Medio,
    COUNT(*) AS Total_Productos
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.codigo_fabricante
HAVING AVG(p.precio) > 200;

-- 20. Calcula el número de productos que tienen un precio mayor o igual a 180€. select
-- count(*) from producto where precio &gt;= 180;
SELECT COUNT(*) AS Total_Productos
FROM productos
WHERE precio >= 180;

-- 21. Calcula el número de productos que tiene cada fabricante con un precio mayor o igual
-- a 180€.
SELECT 
    f.nombre AS Nombre_Fabricante,
    COUNT(p.codigo_producto) AS Total_Productos
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
WHERE p.precio >= 180
GROUP BY f.nombre;

-- 22. Lista el precio medio los productos de cada fabricante, mostrando solamente el código
-- del fabricante.
SELECT 
    codigo_fabricante,
    AVG(precio) AS Precio_Medio
FROM productos
GROUP BY codigo_fabricante;

-- 23. Lista el precio medio los productos de cada fabricante, mostrando solamente el
-- nombre del fabricante.
SELECT 
    f.nombre AS Nombre_Fabricante,
    AVG(p.precio) AS Precio_Medio
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre;

-- 24. Lista los nombres de los fabricantes cuyos productos tienen un precio medio mayor o
-- igual a 150€.
SELECT 
    f.nombre AS Nombre_Fabricante
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre
HAVING AVG(p.precio) >= 150;

-- 25. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
SELECT 
    f.nombre AS Nombre_Fabricante
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre
HAVING COUNT(p.codigo_producto) >= 2;

-- 26. Devuelve un listado con los nombres de los fabricantes y el número de productos que
-- tiene cada uno con un precio superior o igual a 220 €. No es necesario mostrar el
-- nombre de los fabricantes que no tienen productos que cumplan la condición.
SELECT 
    f.nombre AS Nombre_Fabricante,
    COUNT(p.codigo_producto) AS Num_Productos
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
WHERE p.precio >= 220
GROUP BY f.nombre;

-- 27. Devuelve un listado con los nombres de los fabricantes y el número de productos que
-- tiene cada uno con un precio superior o igual a 220 €. El listado debe mostrar el
-- nombre de todos los fabricantes, es decir, si hay algún fabricante que no tiene
-- productos con un precio superior o igual a 220€ deberá aparecer en el listado con un
-- valor igual a 0 en el número de productos.
SELECT 
    f.nombre AS Nombre_Fabricante,
    COUNT(CASE WHEN p.precio >= 220 THEN p.codigo_producto ELSE NULL END) AS Num_Productos
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre;

-- 28. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de
-- todos sus productos es superior a 1000 €.
SELECT 
    f.nombre AS Nombre_Fabricante
FROM fabricante f
LEFT JOIN productos p ON f.codigo_fabricante = p.codigo_fabricante
GROUP BY f.nombre
HAVING SUM(p.precio) > 1000;
