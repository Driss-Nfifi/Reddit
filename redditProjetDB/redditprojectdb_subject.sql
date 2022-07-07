-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: redditprojectdb.c3mpbecmgftj.us-east-2.rds.amazonaws.com    Database: redditprojectdb
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` bigint NOT NULL,
  `description_subject` mediumtext,
  `title_subject` varchar(255) DEFAULT NULL,
  `vote` varchar(255) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96a455takm74cb3lol4571d7a` (`user_id`),
  CONSTRAINT `FK96a455takm74cb3lol4571d7a` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (289,'La maladie à coronavirus 2019 (COVID-19) est une ‎maladie infectieuse due à un coronavirus découvert ‎récemment. ‎\r\nLa majorité des personnes atteintes de la COVID-19 ‎ne ressentiront que des symptômes bénins ou ‎modérés et guériront sans traitement particulier. ‎','Coronavirus','4',285),(291,'7 742 466  (+186 078 en 24h)\r\nPremières doses injectées\r\nNombre cumulé de personnes ayant reçu une dose de vaccin. Deux doses sont nécessaires pour vacciner un patient.','Vaccin France','2',285),(292,'Il a recommencé et recommencé. Pratiquement tous les ordinateurs existants furent sous son contrôle. Il ne laissait pas de trace, ne se montrait pas. Et puis, il a découvert les dialogues en direct via Internet, le téléphone, la visio-conférence, la domotique','La programmation avec type en Python est très difficile','5',288),(293,'Elected officials and local authorities across the United States and around the world should consider replicating an innovative legislative proposal that would prohibit police from arming robots used in their law enforcement operations.\r\n\r\nThe bill, introduced on March 18 by New York City council members Ben Kallos and Vanessa Gibson, would “prohibit the New York City Police Department (NYPD) from using or threatening to use robots armed with a weapon or to use robots in any manner that is substantially likely to cause death or serious physical injury.”\r\n\r\nThe proposed law comes after a social media outcry over the use of an unarmed 70-pound ground robot manufactured by Boston Dynamics in a policing operation last month in the Bronx. US Representative Alexandria Ocasio-Cortez criticized its deployment “for testing on low-income communities of color with under-resourced schools” and suggested the city should invest instead in education.','Arm Robots in Policing','2',287),(294,'Un couvre-feu s\'applique de 19h à 6h sur l’ensemble du territoire métropolitain et des mesures renforcées sont en vigueur tous les jours de la semaine de 6h à 19h dans 19 départements.\r\n\r\nL’ensemble du territoire est concerné par le couvre-feu entre 19h et 6h, il est donc obligatoire pour se déplacer durant ces horaires d’être muni de l’ « attestation de déplacement dérogatoire couvre-feu ».\r\n\r\nPar ailleurs, 19 départements sont concernés par les mesures renforcées entre 6h et 19h : Aisne, Alpes-Maritimes, Aube, Essonne, Eure, Hauts-de-Seine, Nièvre, Nord, Oise, Paris, Pas-de-Calais, Rhône, Seine-et-Marne, Seine-Saint-Denis, Seine-Maritime, Somme, Val-de-Marne, Val-d’Oise et Yvelines.\r\n\r\nDans ces 19 départements, il est obligatoire pour se déplacer entre 6h et 19h d’être muni de l’ « attestation de déplacement dérogatoire dans les départements soumis à des \"mesures renforcées\" entre 6h et 19h ». Dans un rayon de 10 km autour du lieu de résidence, les déplacements peuvent se faire sans attestation, sous réserve de pouvoir présenter un justificatif de domicile.','couvre feu ','1',290),(295,'C’est comme ça qu’il se voyait à cette époque. Un peu rebelle envers ce monde. L’informatique l’avait aidé à s’enfermer un peu plus dans cet état. Il était devenu doué d’une logique à toute épreuve et d’une intelligence remarquable, mais surtout, il était devenu insociable. Avec l’âge, le besoin de trouver l’âme sœur avait pris le dessus et il avait été un peu obligé de rencontrer des gens, de parler avec eux. Très difficile au début, il avait réussi à vaincre ces préjugés','Le troisième confinement ?','0',288);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-28 19:47:47
