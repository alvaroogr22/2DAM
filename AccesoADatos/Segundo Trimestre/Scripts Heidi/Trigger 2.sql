--
-- Disparadores clientes
--
DELIMITER $$
CREATE TRIGGER TRIGGER1 BEFORE INSERT ON clientes FOR EACH ROW BEGIN
    INSERT INTO clientes_copia  VALUES (NEW.id_clientes,NEW.nombre);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla clientes_copia
--

-- Volcado de datos para la tabla clientes_copia
--

INSERT INTO clientes_copia (id, nombre) VALUES
(120, 'Sam'), (16, 'Frodo'),(69,'Galleta'),(88,'Hitler'),(22,'Fuck');

SELECT * FROM clientes_copia;