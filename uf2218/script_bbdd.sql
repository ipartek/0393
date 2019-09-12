-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         10.3.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para v2019
DROP DATABASE IF EXISTS `v2019`;
CREATE DATABASE IF NOT EXISTS `v2019` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `v2019`;

-- Volcando estructura para tabla v2019.categoria
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla v2019.categoria: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(1, 'Música'),
	(2, 'Bromas'),
	(3, 'Surf');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla v2019.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='1- Administrador\n2- Usuario';

-- Volcando datos para la tabla v2019.rol: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(1, 'Administrador'),
	(2, 'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla v2019.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `id_rol` int(11) NOT NULL DEFAULT 2 COMMENT 'Por defecto es USUARIO y no ADMINISTRADOR.',
  `fecha_creacion` datetime NOT NULL DEFAULT current_timestamp(),
  `fecha_eliminacion` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_usuario_rol_idx` (`id_rol`),
  CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla v2019.usuario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `contrasena`, `id_rol`, `fecha_creacion`, `fecha_eliminacion`) VALUES
	(1, 'admin', 'admin', 1, '2019-09-12 08:46:02', NULL),
	(2, 'pepe', 'pepe', 2, '2019-09-12 08:46:02', NULL),
	(3, 'soso', 'soso', 2, '2019-09-12 08:46:02', NULL),
	(4, 'eder', 'eder', 2, '2019-09-12 08:51:21', NULL),
	(6, 'eliminado', '123', 2, '2019-09-11 09:02:14', '2019-09-12 08:51:21');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla v2019.video
DROP TABLE IF EXISTS `video`;
CREATE TABLE IF NOT EXISTS `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `codigo` varchar(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_video_usuario_idx` (`id_usuario`),
  KEY `fk_video_categoria1_idx` (`id_categoria`),
  CONSTRAINT `fk_video_categoria1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_video_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla v2019.video: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` (`id`, `nombre`, `codigo`, `id_usuario`, `id_categoria`) VALUES
	(3, 'Red Hot Chili Peppers - Dark Necessities [OFFICIAL VIDEO]', 'Q0oIoR9mLwc', 1, 1),
	(4, 'El Fary - Carabirubi, Carabiruba', 'Gu0i_6wAouA', 1, 3),
	(5, 'Best Fails of the Year in 2019 (So Far) | FailArmy', 'wZ_9KTAg1Yo', 1, 2),
	(11, 'Eder', 'PesNLikDiVw', 6, 3),
	(12, 'eawrtfghjnk', '12345678909', 6, 3);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;

-- Volcando estructura para tabla v2019.likes
DROP TABLE IF EXISTS `likes`;
CREATE TABLE IF NOT EXISTS `likes` (
  `usuario_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`usuario_id`,`video_id`),
  KEY `fk_usuario_has_video_video1_idx` (`video_id`),
  KEY `fk_usuario_has_video_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_usuario_likes_video` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_video_likes_usuario` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla v2019.likes: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` (`usuario_id`, `video_id`, `fecha`) VALUES
	(1, 4, '2019-09-05 09:46:22'),
	(2, 3, '2019-09-05 09:46:22'),
	(2, 4, '2019-09-05 09:46:22');
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
