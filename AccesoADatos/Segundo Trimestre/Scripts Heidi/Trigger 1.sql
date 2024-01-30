-- trigger --
CREATE TABLE replica_ventas AS
SELECT * FROM ventas WHERE 1=0;

-- ahora crearemos el trigger --
DELIMITER $$
CREATE TRIGGER TRIGGER2
BEFORE INSERT ON ventas
FOR EACH ROW
BEGIN
	INSERT INTO replica_ventas (id_ventas, id_clientes, id_productos, fecha_de_venta)
    VALUES (NEW.id_ventas, NEW.id_clientes, NEW.id_productos, NEW.fecha_de_venta);
END$$
DELIMITER ;

INSERT INTO ventas(id_ventas, id_clientes, id_productos, fecha_de_venta)
VALUES (17,1,2,'2023-01-01');

SELECT * FROM replica_ventas;