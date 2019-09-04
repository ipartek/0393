CREATE DATABASE  IF NOT EXISTS `v2019` 
USE `v2019`;


DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `codigo` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


LOCK TABLES `video` WRITE;
INSERT INTO `video` VALUES (1,'Su Ta Gar - Mari  Su Ta Gar 20 Urte','5oi2WTPAHcs'),(5,'Clasicos del Rock','BWcmD_de99g'),(9,'The Black Eyed Peas - Where Is The Love? (Official Music Video)','WpYeekQkAdc'),(10,'Bob Marley - redemption song','kOFu6b3w6c0'),(16,'El Where','i_cVJgIz_Cs'),(17,'Red Hot Chili Peppers - Dark Necessities','Q0oIoR9mLwc');
UNLOCK TABLES;


 SET NAMES utf8 ;


DROP TABLE IF EXISTS `usuario`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `contra` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


LOCK TABLES `usuario` WRITE;

INSERT INTO `usuario` VALUES (1,'admin','admin'),(2,'pepe','pepe'),(3,'tomas','tomas'),(4,'giovanni','giovanni'),(5,'rosa','rosa');

UNLOCK TABLES;


DROP TABLE IF EXISTS `video`;

 SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `codigo` varchar(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `FK_VIDEO_TIEN_EUSUARIO_idx` (`id_usuario`),
  CONSTRAINT `FK_VIDEO_TIEN_EUSUARIO` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;


LOCK TABLES `video` WRITE;

INSERT INTO `video` VALUES (1,'CA Osasuna vs FC Barcelona 2-2','ui7U1jmFv4w',3),(5,'Atletico vs Eibar 3-2','LLMDgUEGGNw',2),(9,'Tiësto, Jonas Blue, Rita Ora - Ritual (Official Audio)','0s7pKFWLgWk',1),(10,'K-pop Artist Reaction] Becky G, Natti Natasha - Sin Pijama','AQSLgbzrxIw',4),(16,'ESTA SELECCIÓN me HACE una OFERTA ','vrC01JKAVM0',5),(17,'Fito&Fitipaldis - Entre dos mares','1xvP2AXbDXQ',1);

UNLOCK TABLES;



