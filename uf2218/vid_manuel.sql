CREATE DATABASE  IF NOT EXISTS `videos_manuel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `videos_manuel`;

--
-- table `categoria`
--
DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL COMMENT 'humor, drama, deportes....',
  PRIMARY KEY (`idcategoria`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;




LOCK TABLES `categoria` WRITE;

INSERT INTO `categoria` VALUES (8,'bromas'),(7,'fails'),(2,'musica'),(5,'noticias'),(6,'parodias'),(1,'risas'),(3,'sustos'),(4,'tristeza');

UNLOCK TABLES;

--
--  table `rol`
--

DROP TABLE IF EXISTS `rol`;

CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
INSERT INTO `rol` VALUES (1,'administrador'),(2,'usuario');
UNLOCK TABLES;

--
--table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contra` varchar(45) NOT NULL COMMENT 'tu contraseña pendejo',
  `fecha_creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_eliminacion` datetime DEFAULT NULL,
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `FK_usuario_rol_idx` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;




LOCK TABLES `usuario` WRITE;

INSERT INTO `usuario` VALUES (1,'admin','admin','2019-09-12 09:01:46',NULL,NULL),(2,'juan','juan','2019-09-12 09:01:46',NULL,NULL),(3,'pepe','pepe','2019-09-12 09:01:46',NULL,NULL),(4,'ruben','ruben','2019-09-12 09:01:46',NULL,NULL),(5,'soso','soso','2019-09-12 09:01:46',NULL,NULL),(6,'sr burns','burns','2019-09-12 09:03:56',NULL,1),(7,'eliminado','123','2019-09-12 09:03:56','2019-09-12 09:05:00',2);

UNLOCK TABLES;

--
--  table `video`
--

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `idvideo` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `codigo` varchar(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `categoria_idcategoria` int(11) NOT NULL,
  PRIMARY KEY (`idvideo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_video_usuario_idx` (`usuario_idusuario`),
  KEY `fk_video_categoria1_idx` (`categoria_idcategoria`),
  CONSTRAINT `fk_video_categoria1` FOREIGN KEY (`categoria_idcategoria`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `fk_video_usuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;




LOCK TABLES `video` WRITE;

INSERT INTO `video` VALUES (1,'alesso tomorrowland19','CDhXVGduLr0',2,2),(2,'fails 2019','wZ_9KTAg1Yo',5,7),(3,'broma router Auronplay','VuXsSkjvP0M',1,8),(4,'fail antena3','6xHj1Yjxp0w',4,7),(5,'el risitas','IeKZW66CM2w',3,1),(6,'aaahhh song','yBLdQ1a4-JI',3,2),(7,'memes','NpeIsNPDRcQ',4,1),(8,'tiesto ritual','0s7pKFWLgWk',1,2),(9,'teloresumo','NU0Z5kaB8B8',5,1);

UNLOCK TABLES;

--
-- table `likes`
--

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
  `usuario_idusuario` int(11) NOT NULL,
  `video_idvideo` int(11) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_idusuario`,`video_idvideo`),
  KEY `fk_usuario_has_video_video1_idx` (`video_idvideo`),
  KEY `fk_usuario_has_video_usuario1_idx` (`usuario_idusuario`),
  CONSTRAINT `fk_usuario_likes_video` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_video_likes_usuario` FOREIGN KEY (`video_idvideo`) REFERENCES `video` (`idvideo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




LOCK TABLES `likes` WRITE;

INSERT INTO `likes` VALUES (2,3,'2019-09-05 10:09:34'),(3,3,'2019-09-05 10:09:52');

UNLOCK TABLES;





-- Dump completed on 2019-09-12  9:12:20
