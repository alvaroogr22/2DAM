DELIMITER $$
CREATE TRIGGER TRIGGER_UPDATE_VENTAS2
AFTER UPDATE ON ventas
FOR EACH ROW
BEGIN
	-- Actualizar en replica_ventas después de una actualización
    UPDATE replica_ventas
    SET id_clientes=NEW.id_clientes,
		id_productos=NEW.id_productos,
        fecha_de_venta=NEW.fecha_de_venta
	WHERE id_ventas=NEW.id_ventas;
END $$
DELIMITER ;

UPDATE ventas SET id_clientes=2 WHERE id_ventas=10;

SELECT * FROM replica_ventas;