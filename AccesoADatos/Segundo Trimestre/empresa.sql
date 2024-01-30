
-- Volcando estructura de base de datos para empresa
CREATE DATABASE IF NOT EXISTS `empresa`;
USE `empresa`;

-- Volcando estructura para tabla empresa.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- Volcando datos para la tabla empresa.clientes: 6 rows
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` (`id`, `nombre`, `ciudad`) VALUES
	(1, 'Alberto', NULL),
	(2, 'Cristina', NULL),
	(3, 'Eva', 'Sevilla'),
	(4, 'Eva', 'Sevilla'),
	(5, 'Eva', 'Sevilla'),
	(6, 'Eva', 'Sevilla');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;

-- Volcando estructura para procedimiento empresa.ObtenerClientes
DELIMITER //
CREATE PROCEDURE `ObtenerClientes`()
BEGIN SELECT * FROM clientes;END//
DELIMITER ;

-- Volcando estructura para tabla empresa.tvideojuegos
CREATE TABLE IF NOT EXISTS `tvideojuegos` (
  `idjuego` int NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `anio` int NOT NULL,
  `empresa` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `sinopsis` varchar(50) DEFAULT NULL,
  `plataforma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idjuego`)
);
