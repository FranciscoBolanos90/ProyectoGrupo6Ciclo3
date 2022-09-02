-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.10.1-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para viajes
CREATE DATABASE IF NOT EXISTS `viajes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `viajes`;

-- Volcando estructura para tabla viajes.compra
CREATE TABLE IF NOT EXISTS `compra` (
  `factura` varchar(100) NOT NULL,
  `ruta` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`factura`) USING BTREE,
  KEY `FK_usuario` (`username`),
  KEY `FK_servicio` (`ruta`),
  CONSTRAINT `FK_servicio` FOREIGN KEY (`ruta`) REFERENCES `servicio` (`ruta`),
  CONSTRAINT `FK_usuario` FOREIGN KEY (`username`) REFERENCES `usuario` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla viajes.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `ruta` varchar(100) NOT NULL,
  `placa` varchar(100) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `hora` datetime DEFAULT NULL,
  `valor` double(22,2) DEFAULT NULL,
  `puestos` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla viajes.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `username` varchar(100) NOT NULL,
  `clave` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `saldo` double(22,2) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
