CREATE DATABASE  IF NOT EXISTS `empadronamiento_jon` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `empadronamiento_jon`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: empadronamiento_jon
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `municipio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'48600','Sopela'),(2,'48610','Urduliz'),(3,'48620','Berango'),(4,'48630','Getxo'),(5,'48700','Bilbao'),(6,'48800','Leioa');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(80) NOT NULL,
  `vivienda_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_persona_vivienda1_idx` (`vivienda_id`),
  CONSTRAINT `fk_persona_vivienda1` FOREIGN KEY (`vivienda_id`) REFERENCES `vivienda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'16085300R','Jon','Antolin',1),(2,'14836291M','Margarita','Gonzalez',1),(3,'18653611W','Alba','Antolin',1),(4,'17625367P','Mikel','Loyola',4),(5,'87264567B','Borja','Loyola',4),(6,'89643734W','Marta','Perez',3),(7,'98358632P','Lucas','Alvarez',5),(8,'13274674G','Pepe','Urzaiz',8);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_tiene_vivienda`
--

DROP TABLE IF EXISTS `persona_tiene_vivienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persona_tiene_vivienda` (
  `persona_id` int(11) NOT NULL,
  `vivienda_id` int(11) NOT NULL,
  PRIMARY KEY (`persona_id`,`vivienda_id`),
  KEY `fk_persona_has_vivienda_vivienda1_idx` (`vivienda_id`),
  KEY `fk_persona_has_vivienda_persona1_idx` (`persona_id`),
  CONSTRAINT `fk_persona_has_vivienda_persona1` FOREIGN KEY (`persona_id`) REFERENCES `persona` (`id`),
  CONSTRAINT `fk_persona_has_vivienda_vivienda1` FOREIGN KEY (`vivienda_id`) REFERENCES `vivienda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_tiene_vivienda`
--

LOCK TABLES `persona_tiene_vivienda` WRITE;
/*!40000 ALTER TABLE `persona_tiene_vivienda` DISABLE KEYS */;
INSERT INTO `persona_tiene_vivienda` VALUES (2,1),(5,2),(2,3),(4,4),(1,5),(3,7);
/*!40000 ALTER TABLE `persona_tiene_vivienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vivienda`
--

DROP TABLE IF EXISTS `vivienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vivienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `calle` varchar(80) NOT NULL,
  `numero` int(11) NOT NULL,
  `municipio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vivienda_municipio_idx` (`municipio_id`),
  CONSTRAINT `fk_vivienda_municipio` FOREIGN KEY (`municipio_id`) REFERENCES `municipio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vivienda`
--

LOCK TABLES `vivienda` WRITE;
/*!40000 ALTER TABLE `vivienda` DISABLE KEYS */;
INSERT INTO `vivienda` VALUES (1,'47364','Mendieta',18,1),(2,'76542','Sabino Arana',10,5),(3,'76358','Etxebarri',4,1),(4,'86435','Landabe',8,2),(5,'93642','Kalesa',12,3),(6,'47433','Autonomia',10,5),(7,'62568','Keskena',2,3),(8,'86352','Arbolada',8,6);
/*!40000 ALTER TABLE `vivienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'empadronamiento_jon'
--

--
-- Dumping routines for database 'empadronamiento_jon'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-05 18:37:14
