DELIMITER $$
CREATE TRIGGER TRIGGER_UPDATE_CLIENTES2
AFTER UPDATE ON clientes
FOR EACH ROW
BEGIN
-- Actualizar en replica_ventas después de una actualización
UPDATE clientes_copia
SET nombre=NEW.nombre
WHERE id=NEW.id_clientes;
END $$
DELIMITER ;

UPDATE clientes SET nombre='Alberto' WHERE id_clientes=121;
SELECT * FROM clientes_copia;


DELIMITER $$
CREATE TRIGGER TRIGGER_UPDATE_PRODUCTOS2
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN
	-- Actualizar en replica_ventas después de una actualización
    UPDATE replica_productos
    SET id_proveedor=NEW.id_proveedor,
		nombre=NEW.nombre,
        fabricante=NEW.fabricante
	WHERE id_producto=NEW.id_producto;
END $$
DELIMITER ;

UPDATE productos SET nombre='ordenador y' WHERE id_producto=21;
SELECT * FROM replica_productos;