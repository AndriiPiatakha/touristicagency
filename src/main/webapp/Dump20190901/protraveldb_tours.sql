-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: protraveldb
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `tours`
--

DROP TABLE IF EXISTS `tours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tours` (
  `tour_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(1045) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tours`
--

LOCK TABLES `tours` WRITE;
/*!40000 ALTER TABLE `tours` DISABLE KEYS */;
INSERT INTO `tours` VALUES (1,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-05-06 10:19:00','2018-05-06 12:19:00','180','English'),(2,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-02-06 10:19:00','2018-03-06 12:19:00','180','English'),(3,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-01-06 10:19:00','2018-04-06 12:19:00','200','English'),(4,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-04-10 10:19:00','2018-04-10 10:19:00','123','Russian'),(5,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-07-13 10:19:00','2018-04-14 08:19:00','123','English'),(6,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2018-10-15 10:19:00','2018-04-18 06:19:00','123','Russian'),(7,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2019-01-17 10:19:00','2018-04-22 04:19:00','200','English'),(8,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2019-04-21 10:19:00','2018-04-26 02:19:00','200','Russian'),(9,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2019-07-24 10:19:00','2018-04-30 00:19:00','180','English'),(10,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2019-10-26 10:19:00','2018-05-03 22:19:00','180','Russian'),(11,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2020-01-28 10:19:00','2018-05-07 20:19:00','200','English'),(12,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2020-05-01 10:19:00','2018-05-11 18:19:00','123','Russian'),(13,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2020-08-03 10:19:00','2018-05-15 16:19:00','123','English'),(14,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2020-11-05 10:19:00','2018-05-19 14:19:00','123','Russian'),(15,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2021-02-07 10:19:00','2018-05-23 12:19:00','200','English'),(16,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2021-05-12 10:19:00','2018-05-27 10:19:00','180','Russian'),(17,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2021-08-14 10:19:00','2018-05-31 08:19:00','180','English'),(18,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2021-11-16 10:19:00','2018-06-04 06:19:00','200','Russian'),(19,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2022-02-18 10:19:00','2018-06-08 04:19:00','123','English'),(20,'New Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2022-05-23 10:19:00','2018-06-12 02:19:00','123','Russian'),(21,'Colosseum Underground','Many tourists visit the Colosseum, but few see the monument�s underground chambers. Get an in-depth look of one of the New7Wonders of the World on this Rome sightseeing tour. Descend to chambers used to keep gladiators and wild animals before you embar...','2022-08-25 10:19:00','2018-06-16 00:19:00','123','English');
/*!40000 ALTER TABLE `tours` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-01 21:16:47
