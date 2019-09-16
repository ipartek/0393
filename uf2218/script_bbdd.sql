-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 192.168.0.5    Database: videos_vero
-- ------------------------------------------------------
-- Server version	8.0.12


 SET NAMES utf8 ;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;

INSERT INTO `categoria` VALUES (2,'bromas'),(1,'musica'),(3,'surf');

UNLOCK TABLES;


--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='1:administrador\n2:usuario';


--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;

INSERT INTO `rol` VALUES (1,'administrador'),(2,'usuario');

UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contrasenya` varchar(45) NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminacion` datetime DEFAULT NULL,
  `id_rol` int(11) DEFAULT '2',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `FK_usuario_rol_idx` (`id_rol`),
  CONSTRAINT `FK_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;

INSERT INTO `usuario` VALUES (1,'admin','admin','2019-09-12 08:47:19',NULL,NULL),(2,'pepe','pepe','2019-09-12 08:47:19',NULL,NULL),(3,'soso','soso','2019-09-12 08:47:19',NULL,NULL),(4,'Srburn','123','2019-09-12 09:02:32',NULL,1),(5,'eliminado','123','2019-09-12 09:03:20','2019-09-12 09:03:21',2);

UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `codigo` varchar(45) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_video_usuario_idx` (`usuario_id`),
  KEY `fk_video_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_video_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_video_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;

INSERT INTO `video` VALUES (3,'Redhottttt','Q0oIoR9mLwc',2,2),(4,'Fary','NFkI-zxZlHo',1,2),(5,'lost on you','pv8SGsH6Axg',5,1);

UNLOCK TABLES;

--
-- Dumping events for database 'videos_vero'
--

--
-- Dumping routines for database 'videos_vero'
--


-- Dump completed on 2019-09-12  9:34:06


--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `likes` (
  `usuario_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_id`,`video_id`),
  KEY `fk_usuario_has_video_video1_idx` (`video_id`),
  KEY `fk_usuario_has_video_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_usuario_likes_video` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_video_likes_usuario` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;

INSERT INTO `likes` VALUES (2,3,'2019-09-05 11:41:46'),(3,3,'2019-09-05 11:41:46');

UNLOCK TABLES;

