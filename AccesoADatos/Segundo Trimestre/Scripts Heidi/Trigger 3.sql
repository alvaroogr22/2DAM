CREATE TABLE replica_productos AS
SELECT * FROM productos WHERE 1=0;

-- ahora crearemos el trigger --
DELIMITER $$
CREATE TRIGGER TRIGGER3
BEFORE INSERT ON productos
FOR EACH ROW
BEGIN
	INSERT INTO replica_productos (id_producto, id_proveedor, nombre, fabricante)
    VALUES (NEW.id_producto, NEW.id_proveedor, NEW.nombre, NEW.fabricante);
END$$
DELIMITER ;

INSERT INTO productos(id_producto, id_proveedor, nombre, fabricante)
VALUES (21,1,'ordenador x','fabricante x');

SELECT * FROM replica_productos;