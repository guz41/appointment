CREATE DATABASE  IF NOT EXISTS `AppointmentDev` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `AppointmentDev`;
-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: appointmentdev.c0tdnzoloirs.us-west-2.rds.amazonaws.com    Database: AppointmentDev
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-09 21:41:30
CREATE DATABASE  IF NOT EXISTS `base` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `base`;
-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: appointmentdev.c0tdnzoloirs.us-west-2.rds.amazonaws.com    Database: base
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `business_object_field`
--

DROP TABLE IF EXISTS `business_object_field`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_object_field` (
  `bof_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_object` varchar(45) NOT NULL,
  `field_name` varchar(45) DEFAULT NULL,
  `field_label` varchar(45) DEFAULT NULL,
  `field_type` varchar(45) DEFAULT NULL,
  `field_validation` varchar(100) DEFAULT NULL,
  `display_in_table` tinyint(1) DEFAULT NULL,
  `read_only` tinyint(1) DEFAULT NULL,
  `field_validation_label` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`bof_id`),
  UNIQUE KEY `bof_id_UNIQUE` (`bof_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_object_field`
--

LOCK TABLES `business_object_field` WRITE;
/*!40000 ALTER TABLE `business_object_field` DISABLE KEYS */;
INSERT INTO `business_object_field` VALUES (1,'businessobjectfield','id','Field ID','0','',1,1,NULL),(2,'businessobjectfield','parentObject','Parent Object','0',NULL,1,0,NULL),(3,'businessobjectfield','fieldName','Field Name','0',NULL,1,0,NULL),(4,'businessobjectfield','fieldLabel','Field Label','0',NULL,1,0,NULL),(5,'businessobjectfield','fieldType','Field Type','0',NULL,1,0,NULL),(6,'businessobjectfield','fieldValidation','Field Validation','0',NULL,0,0,NULL),(7,'businessobjectfield','displayInTable','Display In Table','0',NULL,0,0,NULL),(8,'businessobjectfield','readOnly','Read Only','0',NULL,0,0,NULL),(9,'businessobjectfield','fieldValidationLabel','Field Validation Label','0',NULL,0,0,NULL),(11,'customer','id','ID','0',NULL,1,1,NULL),(12,'customer','firstName','First Name','0',NULL,1,0,NULL),(13,'customer','lastName','Last Name','0',NULL,1,0,NULL),(14,'customer','phone','Phone Number','1',NULL,0,0,NULL),(15,'customer','suburb','Suburb','1',NULL,0,0,NULL),(16,'customer','email','Email Address','1',NULL,0,0,NULL);
/*!40000 ALTER TABLE `business_object_field` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cust_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(256) NOT NULL,
  `create_time` varchar(45) DEFAULT 'CURRENT_TIMESTAMP',
  `update_time` varchar(45) DEFAULT 'CURRENT_TIMESTAMP',
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `cust_id_UNIQUE` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (2,'Marlon','Mendoza','CURRENT_TIMESTAMP','CURRENT_TIMESTAMP'),(8,'Jay','Jay','CURRENT_TIMESTAMP','CURRENT_TIMESTAMP'),(19,'Added','Customer','CURRENT_TIMESTAMP','CURRENT_TIMESTAMP'),(91,'Fresh','Customer','CURRENT_TIMESTAMP','CURRENT_TIMESTAMP');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_char`
--

DROP TABLE IF EXISTS `customer_char`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_char` (
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `cust_id` int(11) NOT NULL,
  `char_type` varchar(20) NOT NULL,
  `char_value` varchar(256) NOT NULL,
  `char_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`char_id`),
  UNIQUE KEY `char_id_UNIQUE` (`char_id`),
  KEY `CustomerID_idx` (`cust_id`),
  CONSTRAINT `CustomerID` FOREIGN KEY (`cust_id`) REFERENCES `customer` (`cust_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_char`
--

LOCK TABLES `customer_char` WRITE;
/*!40000 ALTER TABLE `customer_char` DISABLE KEYS */;
INSERT INTO `customer_char` VALUES ('2015-08-26 10:41:12','2015-08-26 10:41:12',2,'suburb','Stafford',1),('2015-08-27 11:54:29','2015-08-27 11:54:29',2,'phone','22222223',2),('2015-08-27 11:54:30','2015-08-27 11:54:30',2,'phone','22222221',3),('2015-08-27 11:57:22','2015-08-27 11:57:22',2,'phone','22222223',4),('2015-09-02 05:53:55','2015-09-02 05:53:55',2,'phone','12345',6),('2015-09-02 06:23:41','2015-09-02 06:23:41',2,'suburb','Second Suburb',8),('2015-09-02 06:28:01','2015-09-02 06:28:01',8,'phone','123457',10),('2015-09-05 02:24:38','2015-09-05 02:24:38',19,'suburb','Bardon',12),('2015-09-06 02:01:31','2015-09-06 02:01:31',91,'phone','0412341234',14),('2015-09-06 02:04:26','2015-09-06 02:04:26',91,'suburb','Spring Hill',15);
/*!40000 ALTER TABLE `customer_char` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource` (
  `reso_id` int(11) NOT NULL,
  `resource_name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`reso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-09 21:41:41
