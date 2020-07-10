-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: hangout
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Temporary view structure for view `absentatten`
--

DROP TABLE IF EXISTS `absentatten`;
/*!50001 DROP VIEW IF EXISTS `absentatten`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `absentatten` AS SELECT 
 1 AS `eid`,
 1 AS `year`,
 1 AS `month`,
 1 AS `absentcount`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `attenid` int(11) NOT NULL AUTO_INCREMENT,
  `presentdate` date DEFAULT NULL,
  `clockin` time DEFAULT '08:00:00',
  `clockout` time DEFAULT '17:00:00',
  `atten` varchar(30) DEFAULT 'Present',
  `atd_eid` int(11) DEFAULT NULL,
  PRIMARY KEY (`attenid`),
  KEY `fk_attendEmp` (`atd_eid`),
  CONSTRAINT `fk_attendEmp` FOREIGN KEY (`atd_eid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (58,'2019-09-24','00:00:00','00:00:00','Absent',35),(59,'2019-09-24','08:00:00','18:00:00','Present',38),(60,'2019-09-24','08:00:00','15:00:00','Present',39),(61,'2019-09-24','08:00:00','17:00:00','Present',27),(62,'2019-09-24','08:00:00','15:00:00','Present',29),(63,'2019-09-24','08:00:00','15:00:00','Present',34),(64,'2019-09-24','07:00:00','15:00:00','Present',37),(65,'2019-09-24','08:00:00','15:00:00','Present',41),(66,'2019-09-24','08:00:00','15:00:00','Present',47),(67,'2019-09-25','00:00:00','00:00:00','Absent',28),(68,'2019-09-20','00:00:00','00:00:00','Absent',28),(69,'2019-09-20','08:00:00','19:00:00','Present',27),(70,'2019-09-15','08:00:00','21:00:00','Present',27),(71,'2019-09-26','00:00:00','00:00:00','Absent',58),(72,'2019-09-20','00:00:00','00:00:00','Absent',28),(73,'2019-09-19','00:00:00','00:00:00','Absent',28),(74,'2019-09-18','00:00:00','00:00:00','Absent',28),(75,'2019-09-17','00:00:00','00:00:00','Absent',28),(76,'2019-09-16','00:00:00','00:00:00','Absent',28),(77,'2019-09-15','00:00:00','00:00:00','Absent',28),(78,'2019-09-20','00:00:00','00:00:00','Absent',35),(79,'2019-09-19','00:00:00','00:00:00','Absent',35),(80,'2019-09-18','00:00:00','00:00:00','Absent',35),(81,'2019-09-17','00:00:00','00:00:00','Absent',35),(82,'2019-09-20','08:00:00','17:00:00','Present',31),(83,'2019-09-19','08:00:00','17:00:00','Present',31),(84,'2019-09-18','08:00:00','17:00:00','Present',31),(85,'2019-09-17','08:00:00','17:00:00','Present',31),(86,'2019-09-16','08:00:00','17:00:00','Present',31),(87,'2019-09-20','08:00:00','17:00:00','Present',40),(88,'2019-09-19','08:00:00','17:00:00','Present',40),(89,'2019-09-20','08:00:00','17:00:00','Present',33),(90,'2019-09-19','08:00:00','17:00:00','Present',33),(91,'2019-09-20','08:00:00','17:00:00','Present',33),(92,'2019-09-19','08:00:00','17:00:00','Present',33),(93,'2019-09-18','08:00:00','17:00:00','Present',33),(94,'2019-09-17','08:00:00','17:00:00','Present',33),(95,'2019-09-20','08:00:00','17:00:00','Present',42),(96,'2019-09-19','08:00:00','17:00:00','Present',42),(97,'2019-09-18','08:00:00','17:00:00','Present',42),(98,'2019-09-20','08:00:00','17:00:00','Present',30),(99,'2019-09-19','08:00:00','17:00:00','Present',30),(100,'2019-09-18','08:00:00','17:00:00','Present',30),(101,'2019-09-20','00:00:00','00:00:00','Absent',45),(102,'2019-09-19','00:00:00','00:00:00','Absent',45),(103,'2019-09-18','00:00:00','00:00:00','Absent',45),(104,'2019-09-17','00:00:00','00:00:00','Absent',45),(105,'2019-09-16','00:00:00','00:00:00','Absent',45),(106,'2019-09-20','08:00:00','17:00:00','Present',32),(107,'2019-09-19','08:00:00','17:00:00','Present',32),(108,'2019-09-18','08:00:00','17:00:00','Present',32),(109,'2019-09-20','08:00:00','17:00:00','Present',43),(110,'2019-09-19','08:00:00','17:00:00','Present',43),(111,'2019-09-18','08:00:00','17:00:00','Present',43),(112,'2019-09-17','08:00:00','17:00:00','Present',43),(113,'2019-09-20','08:00:00','17:00:00','Present',34),(114,'2019-09-19','08:00:00','17:00:00','Present',34),(115,'2019-09-18','08:00:00','17:00:00','Present',34),(116,'2019-09-17','08:00:00','17:00:00','Present',34),(117,'2019-09-16','08:00:00','17:00:00','Present',34),(118,'2019-09-15','08:00:00','17:00:00','Present',34),(119,'2019-09-20','08:00:00','17:00:00','Present',41),(120,'2019-09-19','08:00:00','17:00:00','Present',41),(121,'2019-09-18','08:00:00','17:00:00','Present',41),(122,'2019-09-17','08:00:00','17:00:00','Present',41),(123,'2019-09-20','08:00:00','17:00:00','Present',27),(124,'2019-09-19','08:00:00','17:00:00','Present',27),(125,'2019-09-18','08:00:00','17:00:00','Present',27),(126,'2019-09-20','08:00:00','17:00:00','Present',29),(127,'2019-09-19','08:00:00','17:00:00','Present',29),(128,'2019-09-18','08:00:00','17:00:00','Present',29),(129,'2019-09-17','08:00:00','17:00:00','Present',29),(130,'2019-09-16','08:00:00','17:00:00','Present',29),(131,'2019-09-26','00:00:00','00:00:00','Absent',28),(132,'2019-09-26','00:00:00','00:00:00','Absent',35),(133,'2019-09-26','08:00:00','17:00:00','Present',38),(134,'2019-09-26','08:00:00','17:00:00','Present',39),(135,'2019-09-26','08:00:00','17:00:00','Present',58),(136,'2019-09-26','08:00:00','17:00:00','Present',63),(137,'2019-09-26','08:00:00','17:00:00','Present',31),(138,'2019-09-26','08:00:00','17:00:00','Present',40),(139,'2019-09-26','08:00:00','17:00:00','Present',50),(140,'2019-09-26','08:00:00','17:00:00','Present',57),(141,'2019-09-26','08:00:00','17:00:00','Present',64),(142,'2019-09-26','08:00:00','17:00:00','Present',65),(143,'2019-09-26','08:00:00','17:00:00','Present',33),(144,'2019-09-26','08:00:00','17:00:00','Present',36),(145,'2019-09-26','08:00:00','17:00:00','Present',42),(146,'2019-09-26','08:00:00','17:00:00','Present',44),(147,'2019-09-26','08:00:00','17:00:00','Present',46),(148,'2019-09-26','08:00:00','17:00:00','Present',53),(149,'2019-09-26','00:00:00','00:00:00','Absent',54),(150,'2019-09-26','08:00:00','17:00:00','Present',32),(151,'2019-09-26','08:00:00','17:00:00','Present',43),(152,'2019-09-26','08:00:00','17:00:00','Present',51),(153,'2019-09-26','08:00:00','17:00:00','Present',55),(154,'2019-09-26','08:00:00','17:00:00','Present',60),(155,'2019-09-26','08:00:00','17:00:00','Present',61),(156,'2019-09-26','00:00:00','00:00:00','Absent',28),(157,'2019-09-26','08:00:00','17:00:00','Present',30),(158,'2019-09-26','00:00:00','00:00:00','Absent',45),(159,'2019-09-26','08:00:00','17:00:00','Present',48),(160,'2019-09-26','08:00:00','17:00:00','Present',52),(161,'2019-09-26','08:00:00','17:00:00','Present',54),(162,'2019-09-26','08:00:00','17:00:00','Present',59),(163,'2019-09-26','08:00:00','17:00:00','Present',34),(164,'2019-09-26','07:00:00','17:00:00','Present',37),(165,'2019-09-26','08:00:00','17:00:00','Present',41),(166,'2019-09-26','08:00:00','17:00:00','Present',47),(167,'2019-09-26','08:00:00','17:00:00','Present',56),(168,'2019-09-26','08:00:00','17:00:00','Present',62),(169,'2019-09-26','08:00:00','17:00:00','Present',66),(170,'2019-09-27','00:00:00','00:00:00','Absent',35),(171,'2019-09-27','00:00:00','00:00:00','Absent',45);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bak_pro`
--

DROP TABLE IF EXISTS `bak_pro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bak_pro` (
  `bak_proId` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(45) DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`bak_proId`),
  KEY `stock_idx` (`stock`),
  CONSTRAINT `stock` FOREIGN KEY (`stock`) REFERENCES `stock` (`stockId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bak_pro`
--

LOCK TABLES `bak_pro` WRITE;
/*!40000 ALTER TABLE `bak_pro` DISABLE KEYS */;
INSERT INTO `bak_pro` VALUES (1,'Chocolate Cake',80,NULL),(2,'Dougnut',100,NULL),(3,'Apple Cake',80,NULL),(4,'Rolls',60,NULL),(5,'Patis',50,NULL),(6,'Cupcake',50,NULL);
/*!40000 ALTER TABLE `bak_pro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bakeryorders`
--

DROP TABLE IF EXISTS `bakeryorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bakeryorders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `stockId` int(11) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `currentDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `dueDate` varchar(10) DEFAULT NULL,
  `status` varchar(15) DEFAULT 'Open',
  PRIMARY KEY (`orderId`),
  KEY `fk_stock` (`stockId`),
  CONSTRAINT `fk_stock` FOREIGN KEY (`stockId`) REFERENCES `stock` (`stockId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bakeryorders`
--

LOCK TABLES `bakeryorders` WRITE;
/*!40000 ALTER TABLE `bakeryorders` DISABLE KEYS */;
INSERT INTO `bakeryorders` VALUES (1,NULL,'burgers',2,NULL,'2019-09-29','Open'),(2,NULL,'cake',30,'2019-09-26 15:19:00','2019-09-30','Completed'),(3,NULL,'Rolls',30,'2019-09-26 23:25:50','2019-09-27','Open'),(4,NULL,'Patis',30,'2019-09-26 23:25:50','2019-09-27','Open'),(5,NULL,'Cuppcake',30,'2019-09-26 23:25:51','2019-09-27','Open'),(6,NULL,'bread',30,'2019-09-27 09:48:36','2019-09-28','Completed'),(7,NULL,'bread',30,'2019-09-27 09:48:54','2019-09-29','Completed'),(8,NULL,'cake',30,'2019-09-27 09:49:06','2019-09-30','Completed'),(9,NULL,'cake',20,'2019-09-27 09:49:14','2019-09-29','Completed'),(10,NULL,'fish bun',20,'2019-09-27 09:49:26','2019-09-29','Open'),(11,NULL,'fish bun',20,'2019-09-27 09:49:36','2019-09-29','Completed'),(12,NULL,'fish roll',20,'2019-09-27 09:49:45','2019-09-29','Open'),(13,NULL,'fish roll',20,'2019-09-27 09:49:56','2019-09-29','Completed'),(14,NULL,'mini pizza',20,'2019-09-27 09:50:08','2019-09-30','Completed'),(15,NULL,'mini pizza',15,'2019-09-27 09:50:18','2019-09-29','Completed'),(16,NULL,'mini pizza',30,'2019-09-27 09:50:31','2019-09-30','Open'),(17,NULL,'cake',40,'2019-09-27 11:52:16','2019-09-30','Open');
/*!40000 ALTER TABLE `bakeryorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `item` varchar(50) DEFAULT NULL,
  `ppu` float DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `cost` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `cat_reports`
--

DROP TABLE IF EXISTS `cat_reports`;
/*!50001 DROP VIEW IF EXISTS `cat_reports`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `cat_reports` AS SELECT 
 1 AS `cateringID`,
 1 AS `packageID`,
 1 AS `cus_Name`,
 1 AS `orderdate`,
 1 AS `pay_date`,
 1 AS `tot_amnt`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `catering`
--

DROP TABLE IF EXISTS `catering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `catering` (
  `cateringID` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(10) NOT NULL,
  `customerID` int(11) DEFAULT NULL,
  `packageID` int(11) DEFAULT NULL,
  `plates` int(11) DEFAULT NULL,
  `orderdate` varchar(10) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cateringID`,`phone`),
  KEY `fk_packageID` (`packageID`),
  KEY `fk_CustomerID` (`customerID`),
  CONSTRAINT `fk_CustomerID` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_packageID` FOREIGN KEY (`packageID`) REFERENCES `package` (`packageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catering`
--

LOCK TABLES `catering` WRITE;
/*!40000 ALTER TABLE `catering` DISABLE KEYS */;
INSERT INTO `catering` VALUES (29,'0724696970',7,2,50,'2019/10/13','pending'),(30,'0782748940',8,3,220,'2019/09/01','completed'),(32,'0713456849',15,2,130,'2018/11/21','Completed'),(33,'0724696970',7,2,50,'2019/10/13','pending'),(34,'0782748940',8,3,220,'2019/09/01','completed'),(35,'0813858493',1,1,100,'2019/11/01','pending'),(37,'0762674829',8,4,230,'2019/10/30','pending'),(38,'0118284834',10,4,60,'2019/11/12','pending'),(39,'0284839495',4,2,330,'2019/10/24','pending'),(40,'0738284924',17,1,130,'2019/10/16','pending'),(42,'071234567',1,3,130,'12-08-2019','Completed'),(43,'0718011283',19,2,156,'18-09-2019','Completed');
/*!40000 ALTER TABLE `catering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `catpay`
--

DROP TABLE IF EXISTS `catpay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `catpay` (
  `paymentID` varchar(10) NOT NULL,
  `cateringID` int(11) DEFAULT NULL,
  `cus_ID` int(11) DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  `tot_amnt` float DEFAULT NULL,
  PRIMARY KEY (`paymentID`),
  KEY `fk_cateringID` (`cateringID`),
  CONSTRAINT `fk_cateringID` FOREIGN KEY (`cateringID`) REFERENCES `catering` (`cateringID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catpay`
--

LOCK TABLES `catpay` WRITE;
/*!40000 ALTER TABLE `catpay` DISABLE KEYS */;
INSERT INTO `catpay` VALUES ('C0001',32,15,'2019-09-27',48450),('C0002',30,8,'2019-09-27',76500),('C0003',35,1,'2019-09-27',35700),('C0004',32,15,'2019-09-27',48450),('C0005',32,15,'2019-09-27',48450),('C0006',29,7,'2019-09-27',28050),('C0007',40,17,'2019-09-27',43350),('C0008',42,1,'2019-09-27',53550),('C0009',30,8,'2019-09-27',76500),('C0010',30,15,'2019-08-23',10734),('C0011',30,15,'2019-01-13',8737),('C0012',30,15,'2019-03-10',10734),('C0013',30,15,'2019-03-13',6702),('C0014',37,8,'2019-09-27',84150);
/*!40000 ALTER TABLE `catpay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `cus_rep`
--

DROP TABLE IF EXISTS `cus_rep`;
/*!50001 DROP VIEW IF EXISTS `cus_rep`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `cus_rep` AS SELECT 
 1 AS `customerID`,
 1 AS `cus_Name`,
 1 AS `Points`,
 1 AS `tot_amnt`,
 1 AS `MONTHNAME(c.pay_date)`,
 1 AS `YEAR(c.pay_date)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cuspoi`
--

DROP TABLE IF EXISTS `cuspoi`;
/*!50001 DROP VIEW IF EXISTS `cuspoi`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `cuspoi` AS SELECT 
 1 AS `cus_ID`,
 1 AS `total_exp`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cuspoints`
--

DROP TABLE IF EXISTS `cuspoints`;
/*!50001 DROP VIEW IF EXISTS `cuspoints`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `cuspoints` AS SELECT 
 1 AS `customerID`,
 1 AS `cus_name`,
 1 AS `Tot_amnt`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `cust_dis`
--

DROP TABLE IF EXISTS `cust_dis`;
/*!50001 DROP VIEW IF EXISTS `cust_dis`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `cust_dis` AS SELECT 
 1 AS `phone`,
 1 AS `points`,
 1 AS `discount`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cust_stock`
--

DROP TABLE IF EXISTS `cust_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cust_stock` (
  `stockID` int(11) NOT NULL,
  `custID` int(11) NOT NULL,
  `paymentID` int(11) DEFAULT NULL,
  PRIMARY KEY (`stockID`,`custID`),
  KEY `fk_custmID` (`custID`),
  KEY `fk_paymentID` (`paymentID`),
  CONSTRAINT `fk_custmID` FOREIGN KEY (`custID`) REFERENCES `customer` (`customerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_paymentID` FOREIGN KEY (`paymentID`) REFERENCES `payment` (`paymentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_stockID` FOREIGN KEY (`stockID`) REFERENCES `stock` (`stockId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cust_stock`
--

LOCK TABLES `cust_stock` WRITE;
/*!40000 ALTER TABLE `cust_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `cust_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `cus_Name` varchar(50) DEFAULT NULL,
  `Phone` char(10) NOT NULL,
  `Email` char(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `total_exp` varchar(100) DEFAULT '0',
  PRIMARY KEY (`customerID`,`Phone`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Dulshan','0714323456','dul@gmail.com','qwee','1220'),(4,'vidula','0712345678','vidula@gmail.com','peradeniya','5000'),(7,'Keels','0770044817','keels@gmail.com','kandy','0'),(8,'NIm','0770044918','nim@gmil.com','kandy','24000'),(9,'Isuru Bowatte','0768644258','isuru14@yahoo.com','peradeniya','50000'),(10,'Priyan Abeysekara','0768322415','priyan@yahoo.com','katugasthota','65000'),(11,'Haritha Dassanayake','0768817502','haritha@gmail.com','galagedara','45000'),(12,'George Silva','0770044814','george@gmail.com','peradeniya','25000'),(13,'Arjuna Thalwatte','0776262395','arjuna@yahoo.com','thalwatte','35000'),(14,'Dulshan Premathilaka','0778819672','dulshan@hotmail.com','kiribathkubura','15000'),(15,'Vidula Thalawala','0710883551','vidula@yahoo.com','katugasthota','45000'),(16,'Keshan Weragoda','0711646491','keshan@yahoo.com','mawanalle','65000'),(17,'Ishan Mudalige','0756250997','ishan@yahoo.com','nugawela','75000'),(18,'Udesh Bandara','0713785251','udesh@gmail.com','matale','15000'),(19,'Priya','0770044819','priyan@gmail.com','kandy','107140'),(20,'isuru b','0751234567','isuru@gmail.com','kandy','0'),(21,'Priyan','071234567','priyan@gmail.com','Kandy','0'),(22,'Isuru','071234567','bow@gmail.com','pera','0'),(23,'Priyan','071234567','priyan@gmail.com','Kandy','0');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `deletedleaves`
--

DROP TABLE IF EXISTS `deletedleaves`;
/*!50001 DROP VIEW IF EXISTS `deletedleaves`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `deletedleaves` AS SELECT 
 1 AS `leaveid`,
 1 AS `pempid`,
 1 AS `leave_type`,
 1 AS `leave_date`,
 1 AS `leave_status`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `empleaves`
--

DROP TABLE IF EXISTS `empleaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleaves` (
  `leaveid` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type` varchar(60) DEFAULT NULL,
  `leave_status` varchar(50) DEFAULT 'In Progress',
  `leave_date` date DEFAULT NULL,
  PRIMARY KEY (`leaveid`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleaves`
--

LOCK TABLES `empleaves` WRITE;
/*!40000 ALTER TABLE `empleaves` DISABLE KEYS */;
INSERT INTO `empleaves` VALUES (23,'Full Day','In Progress','2019-09-27'),(24,'Full Day','In Progress','2019-09-26'),(25,'Half Day','Completed','2019-08-16'),(26,'Half Day','Completed','2019-08-09'),(27,'Full Day','In Progress','2019-10-04'),(28,'Full Day','In Progress','2019-11-22'),(29,'Half Day','In Progress','2019-11-15'),(30,'Half Day','In Progress','2019-10-18'),(31,'Full Day','In Progress','2019-11-04'),(32,'Half Day','In Progress','2019-09-30'),(33,'Full Day','In Progress','2019-10-03'),(34,'Full Day','In Progress','2019-10-24'),(35,'Half Day','In Progress','2019-10-01'),(36,'Full Day','In Progress','2019-10-07'),(37,'Full Day','In Progress','2019-10-08'),(38,'Full Day','In Progress','2019-10-14'),(39,'Half Day','In Progress','2019-10-21'),(40,'Half Day','In Progress','2019-11-25'),(41,'Full Day','In Progress','2019-11-08'),(42,'Full Day','In Progress','2019-11-15'),(43,'Half Day','In Progress','2019-11-08'),(44,'Full Day','In Progress','2019-10-23'),(45,'Half Day','In Progress','2019-10-31'),(46,'Half Day','In Progress','2019-11-13'),(47,'Half Day','In Progress','2019-10-30'),(48,'Full Day','In Progress','2019-12-02'),(49,'Full Day','In Progress','2019-12-03'),(50,'Half Day','In Progress','2019-11-08'),(51,'Half Day','In Progress','2019-11-12'),(52,'Half Day','In Progress','2019-10-21'),(53,'Full Day','In Progress','2019-11-04'),(54,'Full Day','In Progress','2019-11-15'),(55,'Half Day','In Progress','2019-12-26'),(56,'Full Day','In Progress','2019-12-10'),(57,'Full Day','In Progress','2020-01-06'),(58,'Full Day','In Progress','2019-12-30'),(59,'Half Day','In Progress','2019-11-04'),(60,'Half Day','Completed','2019-08-12'),(61,'Half Day','In Progress','2019-10-23'),(62,'Half Day','In Progress','2019-12-16'),(63,'Half Day','In Progress','2020-01-06'),(64,'Full Day','In Progress','2019-10-08');
/*!40000 ALTER TABLE `empleaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` varchar(50) DEFAULT NULL,
  `fname` varchar(60) DEFAULT NULL,
  `lname` varchar(60) DEFAULT NULL,
  `nic` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'Available',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (27,NULL,'Thumalee','Nandisena','123456789V','2019-09-05','Permanent','Female','HRM','Other','Available'),(28,NULL,'Nimal','Silva','789654123V','2019-09-06','Temporary','Male','Restaurant and Bakery','Assistant Chef','Available'),(29,NULL,'George','Silva','987456213V','2003-09-12','Permanent','Male','HRM','Other','Available'),(30,NULL,'Isuru','Bowatte','741258963V','2006-09-09','Permanent','Male','Customer Management','Other','Available'),(31,NULL,'Nimaya','Ganhewa','456321789V','2006-09-09','Permanent','Female','Raw material & Utility Management','Raw material Manager','Available'),(32,NULL,'Avishka','Thilakarathne','654789321V','2012-09-08','Permanent','Female','Finished products','Stock Manager','Available'),(33,NULL,'Priyan','Abeysekara','021345678V','2006-09-07','Permanent','Male','Catering & Order book','Other','Available'),(34,NULL,'Rashini','Sahabandu','963258741V','2009-09-04','Permanent','Female','Function hall','Other','Available'),(35,NULL,'Haritha','Dasanayake','302145698V','2008-09-06','Permanent','Male','Restaurant and Bakery','Floor Manager','Available'),(36,NULL,'Sunil','Fernando','986574320V','2009-09-10','Permanent','Male','Catering & Order book','Other','Available'),(37,NULL,'Kamal','Perera','987451236V','2009-09-09','Permanent','Male','Function hall','Other','Available'),(38,NULL,'Kethakie','Ratnayake','753698412V','2009-09-05','Permanent','Female','Restaurant and Bakery','Chef','Available'),(39,NULL,'Nirasha','Rathnayake','995566889V','2009-09-11','Temporary','Female','Restaurant and Bakery','Assistant Chef','Available'),(40,NULL,'Ushani','Silva','968523147V','2005-09-03','Temporary','Female','Raw material & Utility Management','Cashier','Available'),(41,NULL,'Keshan','Rajapaksha','789458769V','2007-09-13','Temporary','Male','Function hall','Other','Available'),(42,NULL,'Thilina','Niranjan','159632874V','2011-09-13','Temporary','Male','Catering & Order book','Cashier','Available'),(43,NULL,'Ranil','Wickramasinghe','159874632V','2010-09-29','Temporary','Male','Finished products','Cashier','Available'),(44,NULL,'Siva','Dev','357896412V','2009-09-25','Temporary','Male','Catering & Order book','Stock Manager','Available'),(45,NULL,'Chathura','Udurawana','759846302V','2009-09-04','Temporary','Male','Customer Management','Floor Manager','Available'),(46,NULL,'Mahela','Jayawardana','365492178V','2008-09-12','Temporary','Male','Catering & Order book','Cashier','Available'),(47,NULL,'Kumar','Sangakkara','658931470V','2007-09-08','Temporary','Male','Function hall','Cashier','Available'),(48,NULL,'Hiroshi','Silva','985632014V','2013-09-10','Temporary','Male','Customer Management','Other','Available'),(49,NULL,'Yasith','Rathnayake','854963201V','2007-09-08','Permanent','Male','HRM','Other','Available'),(50,NULL,'Lakmina ','Abeyrathna','780546178V','2005-09-22','Permanent','Male','Raw material & Utility Management','Chef','Available'),(51,NULL,'Nimalka','Rajasinghe','875469851V','2011-09-06','Permanent','Female','Finished products','Other','Available'),(52,NULL,'Ridmi','Weerakotuwa','789548674V','2007-09-20','Permanent','Female','Customer Management','Other','Available'),(53,NULL,'Sachini','Tennakoon','879658794V','2012-09-01','Permanent','Female','Catering & Order book','Other','Available'),(54,NULL,'Yasangi','Perera','879684859V','2006-09-20','Permanent','Female','Customer Management','Other','Available'),(55,NULL,'Sajini','Bandara','879587412V','2009-09-04','Permanent','Female','Finished products','Other','Available'),(56,NULL,'Moveena','Rajapakse','984758612V','2012-09-07','Permanent','Female','Function hall','Other','Available'),(57,NULL,'Indika','Perera','985689742V','2008-09-13','Permanent','Male','Raw material & Utility Management','Other','Available'),(58,NULL,'Chalintha','Fernando','987458632V','2007-09-03','Permanent','Male','Restaurant and Bakery','Other','Available'),(59,NULL,'Sanduni','Sulochana','968578947V','2012-09-07','Temporary','Female','Customer Management','Other','Available'),(60,NULL,'Sampath','Warakagoda','698578924V','2007-09-01','Temporary','Male','Finished products','Other','Available'),(61,NULL,'Vidula','Thalawala','875964824V','2003-09-20','Temporary','Male','Finished products','Other','Available'),(62,NULL,'Keshan','Weragoda','987586142V','2009-09-18','Temporary','Male','Function hall','Other','Available'),(63,NULL,'Arjuna','Madushanka','698758942V','2006-09-09','Temporary','Male','Restaurant and Bakery','Other','Available'),(64,NULL,'Dulshan','Premarathna','985674852V','2009-09-04','Temporary','Male','Raw material & Utility Management','Other','Available'),(65,NULL,'Naruto','Izumaki','685974320V','2004-09-03','Temporary','Male','Raw material & Utility Management','Other','Available'),(66,NULL,'Keshan','Warakagoda','987586752V','2009-09-18','Temporary','Male','Function hall','Other','Unavailable'),(67,NULL,'Geo','Sil',NULL,NULL,NULL,NULL,'admin',NULL,'Available'),(68,NULL,'Nimal','Perera','859743256V','2013-09-12','Temporary','Male','Catering & Order book','Other','Unavailable'),(69,NULL,'Nimal ','Perera','987548632V','1998-10-22','Permanent','Male','Restaurant and Bakery','Chef','Available'),(70,NULL,'Nimal','Perera','987548632V','1998-10-22','Permanent','Male','Restaurant and Bakery','Chef','Available');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall_function`
--

DROP TABLE IF EXISTS `hall_function`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hall_function` (
  `functionID` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(10) NOT NULL,
  `custID` varchar(50) DEFAULT NULL,
  `cust_name` varchar(50) NOT NULL,
  `func_date` varchar(20) DEFAULT NULL,
  `func_time` varchar(20) DEFAULT NULL,
  `packageID` varchar(50) DEFAULT NULL,
  `menuID` varchar(50) NOT NULL,
  `no_of_people` int(11) NOT NULL,
  `amount` double NOT NULL,
  `advance` double NOT NULL,
  `tax` double DEFAULT NULL,
  `serviceCharge` double DEFAULT NULL,
  `total` double NOT NULL,
  `func_status` varchar(50) DEFAULT NULL,
  `paymentID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`functionID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall_function`
--

LOCK TABLES `hall_function` WRITE;
/*!40000 ALTER TABLE `hall_function` DISABLE KEYS */;
INSERT INTO `hall_function` VALUES (6,'0770044825','3','Nimal','1970-01-01','2 PM','package 1','menu 5',21,1200000,12000,240000,1200,1428120,NULL,NULL),(9,'0768644244','5','John','1970-01-01','10PM','package 3','menu 3',100,10000,5000,2000,1200,7120,NULL,NULL),(11,'0712345678','4','vidula','2019-07-01','2 PM','package 3','Fast food special',120,1200000,12000,240000,1200,1428120,NULL,NULL),(12,'0768644244','5','John','1970-01-01','5 pm','package 1','Sandwiches',45,300000,12000,60000,2000,348200,NULL,NULL),(15,'0713785251','18','Udesh Bandara','1970-01-01','4 pm','package 2','Fast food special',34,120000000,345555,24000000,5677,143655012,NULL,NULL);
/*!40000 ALTER TABLE `hall_function` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `leavecount`
--

DROP TABLE IF EXISTS `leavecount`;
/*!50001 DROP VIEW IF EXISTS `leavecount`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `leavecount` AS SELECT 
 1 AS `eid`,
 1 AS `noofleaves`,
 1 AS `month`,
 1 AS `year`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) NOT NULL,
  `menu_description` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`menuId`,`menu_name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Chinese','fried rice',250),(3,'Special','Chicken fried rice,devil chicken',600),(4,'Sri lankan','Rice with dall curry,polos',180),(6,'Chicken Buriyani','yellow rice with peanuts and plums,chicken curry,chilliepaste',300),(7,'Thanduri Chicken Rice','Steamed rice ,Thanduri chicken,dhall curry',250),(9,'Hangout Special Rice','Egg fried rice,chicken devil,pork,beef,fried egg,sausages,chilliepaste',600),(10,'Sea food special','vegitable fried rice,shrimps,prawn',650),(11,'Chicken fried rice','egg fried rice,chicken devil,chilliepaste',350),(12,'Vegitable fried rice','vegitable fried rice,vegitable chopsy',250),(13,'Rice and curry','keerisamba rice,dhall curry,fish curry,papadam',200),(14,'Chinese Special Noodles','vegitable noodles,chicken devil,vegitable chopsy,chilliepaste,',400),(15,'Hangout Special noodles','chicken mixed noodles,chicken devil,pork,beef,fried egg,sausages,chilliepaste',600),(16,'Chicken noodles','vegitables noodles,chicken devil,chilliepaste',300),(17,'Vegitable noodles','vegitable noodles,vegitable chopsy',250),(18,'sri lankan','rice and curry',200),(19,'Chicken fried rice','egg fried rice,chicken devil,chilliepaste',200),(20,'Special','Chicken fried rice,devil chicken',600),(21,'Western','Pasta',500);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `monthly_rep`
--

DROP TABLE IF EXISTS `monthly_rep`;
/*!50001 DROP VIEW IF EXISTS `monthly_rep`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `monthly_rep` AS SELECT 
 1 AS `Year`,
 1 AS `Month`,
 1 AS `Total`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `package` (
  `packageId` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `pack_Price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`packageId`),
  KEY `fk_mid` (`menu_id`),
  CONSTRAINT `fk_mid` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menuId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (1,1,'10000'),(2,1,'15000'),(3,1,'20000'),(4,1,'25000');
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_utility`
--

DROP TABLE IF EXISTS `package_utility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `package_utility` (
  `pid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  KEY `fk_pid` (`pid`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `package` (`packageId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `utilities` (`utilityId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_utility`
--

LOCK TABLES `package_utility` WRITE;
/*!40000 ALTER TABLE `package_utility` DISABLE KEYS */;
/*!40000 ALTER TABLE `package_utility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `payinfo`
--

DROP TABLE IF EXISTS `payinfo`;
/*!50001 DROP VIEW IF EXISTS `payinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `payinfo` AS SELECT 
 1 AS `cateringID`,
 1 AS `cus_ID`,
 1 AS `packageID`,
 1 AS `pack_price`,
 1 AS `plates`,
 1 AS `discount`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `paymentID` int(11) NOT NULL AUTO_INCREMENT,
  `pay_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `tot_amnt` float DEFAULT NULL,
  `Type` varchar(20) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`paymentID`),
  KEY `fk_payments` (`customerId`),
  CONSTRAINT `fk_payments` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (2,'2019-09-26 15:16:48',2400,'Restaurant',NULL),(3,'2019-09-26 16:08:34',8400,'Restaurant',NULL),(4,'2019-09-26 16:50:48',12000,'Restaurant-Reg',NULL),(5,'2019-09-26 17:26:49',24000,'Restaurant-Reg',8),(6,'2019-09-26 17:28:12',24000,'Restaurant-Reg',8),(7,'2019-09-26 17:28:36',24000,'Restaurant-Reg',8),(8,'2019-09-26 17:30:18',24000,'Restaurant-Reg',8),(9,'2019-09-26 17:31:22',24000,'Restaurant-Reg',8),(10,'2019-01-01 00:00:00',190000,'Restaurant',NULL),(11,'2019-02-01 00:00:00',25000,'Restaurant',NULL),(12,'2019-03-01 00:00:00',180000,'Restaurant',NULL),(13,'2019-04-01 00:00:00',190000,'Restaurant',NULL),(14,'2018-05-01 00:00:00',290000,'Restaurant',NULL),(15,'2018-06-01 00:00:00',190000,'Restaurant',NULL),(16,'2018-07-01 00:00:00',290000,'Restaurant',NULL),(17,'2018-08-01 00:00:00',190000,'Restaurant',NULL),(18,'2018-09-01 00:00:00',190000,'Restaurant',NULL),(19,'2019-09-26 23:25:55',50000,'Restaurant-Reg',9),(20,'2019-09-26 23:25:55',65000,'Restaurant-Reg',10),(21,'2019-09-26 23:25:55',45000,'Restaurant-Reg',11),(22,'2019-09-26 23:25:56',25000,'Restaurant-Reg',12),(23,'2019-09-26 23:25:56',35000,'Restaurant-Reg',13),(24,'2019-09-26 23:25:56',15000,'Restaurant-Reg',14),(25,'2019-09-26 23:25:56',45000,'Restaurant-Reg',15),(26,'2019-09-26 23:25:56',65000,'Restaurant-Reg',16),(27,'2019-09-26 23:25:57',75000,'Restaurant-Reg',17),(28,'2019-09-26 23:25:57',15000,'Restaurant-Reg',18),(29,'2019-09-27 10:49:32',25800,'Restaurant-Reg',19),(30,'2019-09-27 11:55:39',1340,'Restaurant-Reg',19);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permanentemp`
--

DROP TABLE IF EXISTS `permanentemp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permanentemp` (
  `peid` int(11) NOT NULL,
  `bonus` float DEFAULT NULL,
  `epf` float DEFAULT NULL,
  `etf` float DEFAULT NULL,
  `basicSalary` float DEFAULT NULL,
  `month` varchar(45) NOT NULL DEFAULT '1',
  `year` varchar(45) NOT NULL DEFAULT '2019',
  `hours` float DEFAULT NULL,
  `hrate` float DEFAULT NULL,
  `ot` float DEFAULT NULL,
  `netSal` float DEFAULT NULL,
  PRIMARY KEY (`peid`,`year`,`month`),
  CONSTRAINT `fk_peid` FOREIGN KEY (`peid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permanentemp`
--

LOCK TABLES `permanentemp` WRITE;
/*!40000 ALTER TABLE `permanentemp` DISABLE KEYS */;
INSERT INTO `permanentemp` VALUES (27,5000,8000,3000,100000,'2','2018',6,100,600,97600),(27,10000,8000,3000,100000,'9','2019',2,1000,2000,104000),(27,NULL,NULL,NULL,100000,'January','2019',NULL,NULL,NULL,NULL),(29,5000,8000,3000,100000,'3','2018',8,500,4000,101000),(29,NULL,NULL,NULL,100000,'1','2019',NULL,NULL,NULL,NULL),(30,500,40000,15000,500000,'4','2018',6,100,600,461100),(30,NULL,NULL,NULL,500000,'1','2019',NULL,NULL,NULL,NULL),(31,400,8000,3000,100000,'4','2018',7,3000,21000,113400),(31,400,8000,3000,100000,'1','2019',7,3000,21000,113400),(32,5000,5600,2100,70000,'4','2018',7,400,2800,72200),(32,5000,5600,2100,70000,'1','2019',7,400,2800,72200),(32,500,5600,2100,70000,'10','2019',0,100,0,64900),(33,1000,4800,1800,60000,'4','2018',5,800,4000,60200),(33,NULL,NULL,NULL,60000,'1','2019',NULL,NULL,NULL,NULL),(34,7000,6000,2250,75000,'5','2018',5,1000,5000,81000),(34,NULL,NULL,NULL,75000,'1','2019',NULL,NULL,NULL,NULL),(35,4000,6400,2400,80000,'6','2018',10,1000,10000,87600),(35,NULL,NULL,NULL,80000,'1','2019',NULL,NULL,NULL,NULL),(35,5000,6400,2400,80000,'8','2019',5,1000,5000,83600),(35,5000,6400,2400,80000,'9','2019',0,100,0,78600),(36,2000,4000,1500,50000,'7','2018',5,1000,5000,53000),(36,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(37,500,4000,1500,50000,'7','2018',5,100,500,47000),(37,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(38,NULL,NULL,NULL,150000,'1','2019',NULL,NULL,NULL,NULL),(38,5000,12000,4500,150000,'9','2019',1,500,500,143500),(49,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(50,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(51,NULL,NULL,NULL,80000,'1','2019',NULL,NULL,NULL,NULL),(52,NULL,NULL,NULL,40000,'1','2019',NULL,NULL,NULL,NULL),(53,NULL,NULL,NULL,20000,'1','2019',NULL,NULL,NULL,NULL),(54,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(55,NULL,NULL,NULL,45000,'1','2019',NULL,NULL,NULL,NULL),(56,NULL,NULL,NULL,55000,'1','2019',NULL,NULL,NULL,NULL),(57,NULL,NULL,NULL,35000,'1','2019',NULL,NULL,NULL,NULL),(58,NULL,NULL,NULL,35000,'1','2019',NULL,NULL,NULL,NULL),(58,500,2800,1050,35000,'9','2019',0,100,0,32700),(67,NULL,NULL,NULL,50000,'','2019',NULL,NULL,NULL,NULL),(69,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL),(70,NULL,NULL,NULL,50000,'1','2019',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `permanentemp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `permanentemployee`
--

DROP TABLE IF EXISTS `permanentemployee`;
/*!50001 DROP VIEW IF EXISTS `permanentemployee`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `permanentemployee` AS SELECT 
 1 AS `eid`,
 1 AS `ename`,
 1 AS `basicSalary`,
 1 AS `year`,
 1 AS `month`,
 1 AS `bonus`,
 1 AS `netSalary`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `permanentleave`
--

DROP TABLE IF EXISTS `permanentleave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `permanentleave` (
  `pempid` int(11) NOT NULL,
  `leave_id` int(11) NOT NULL,
  PRIMARY KEY (`pempid`,`leave_id`),
  KEY `fk_leave_id` (`leave_id`),
  CONSTRAINT `fk_leave_id` FOREIGN KEY (`leave_id`) REFERENCES `empleaves` (`leaveid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pempid` FOREIGN KEY (`pempid`) REFERENCES `permanentemp` (`peid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permanentleave`
--

LOCK TABLES `permanentleave` WRITE;
/*!40000 ALTER TABLE `permanentleave` DISABLE KEYS */;
INSERT INTO `permanentleave` VALUES (27,23),(27,24),(29,25),(29,26),(29,27),(29,28),(30,29),(38,30),(35,31),(31,32),(31,33),(33,34),(36,35),(32,36),(32,37),(34,38),(34,39),(34,40),(27,41),(27,42),(29,43),(49,44),(55,45),(32,46),(58,47),(57,48),(50,49),(53,50),(53,51),(53,52),(54,53),(52,54),(54,55),(55,56),(55,57),(55,58),(56,59),(49,60),(49,61),(29,62),(27,63),(27,64);
/*!40000 ALTER TABLE `permanentleave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `presentatten`
--

DROP TABLE IF EXISTS `presentatten`;
/*!50001 DROP VIEW IF EXISTS `presentatten`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `presentatten` AS SELECT 
 1 AS `eid`,
 1 AS `year`,
 1 AS `month`,
 1 AS `presentcount`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `rest_report`
--

DROP TABLE IF EXISTS `rest_report`;
/*!50001 DROP VIEW IF EXISTS `rest_report`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `rest_report` AS SELECT 
 1 AS `YEAR(pay_date)`,
 1 AS `MONTHNAME(pay_date)`,
 1 AS `tot_amnt`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `rest_report2`
--

DROP TABLE IF EXISTS `rest_report2`;
/*!50001 DROP VIEW IF EXISTS `rest_report2`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `rest_report2` AS SELECT 
 1 AS `year`,
 1 AS `month`,
 1 AS `total`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `restitem`
--

DROP TABLE IF EXISTS `restitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `restitem` (
  `rItemNo` int(11) NOT NULL AUTO_INCREMENT,
  `rItem` varchar(20) DEFAULT NULL,
  `rqty` int(11) DEFAULT NULL,
  `rUnitPrice` float DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`rItemNo`),
  KEY `fk_restitems` (`menuId`),
  CONSTRAINT `fk_restitems` FOREIGN KEY (`menuId`) REFERENCES `menu` (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restitem`
--

LOCK TABLES `restitem` WRITE;
/*!40000 ALTER TABLE `restitem` DISABLE KEYS */;
INSERT INTO `restitem` VALUES (1,'Pepsi',50,80,NULL),(2,'Sprite',50,80,NULL),(3,'Yougart',50,35,NULL),(4,'EGB',50,80,NULL);
/*!40000 ALTER TABLE `restitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `stockId` int(11) NOT NULL AUTO_INCREMENT,
  `arrivalDate` date DEFAULT NULL,
  `expDate` date DEFAULT NULL,
  `stock_type` varchar(100) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `leftQty` int(11) DEFAULT NULL,
  `Status1` varchar(20) DEFAULT 'Available',
  `name` varchar(45) DEFAULT NULL,
  `unitPrice` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `availability` int(11) DEFAULT NULL,
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (76,'2019-09-05','2019-09-17',NULL,500,NULL,'Expired','Salt',1000,500000,0),(77,'2019-09-05','2019-10-13',NULL,500,NULL,'Unavailable','Salt',100,40000,200),(78,'2019-09-03','2019-09-25',NULL,500,NULL,'Expired','Sugar',85,NULL,NULL),(79,'2019-09-01','2019-10-25',NULL,300,NULL,'Available','Sugar',85,NULL,NULL),(80,'2019-09-02','2019-09-30',NULL,600,NULL,'Unavailable','Salt',100,60000,0),(81,'2019-09-10','2019-10-27',NULL,500,NULL,'Available','Wheat',110,NULL,NULL),(82,'2019-09-11','2019-10-15',NULL,300,NULL,'Available','Salt',100,30000,100),(83,'2019-09-07','2019-10-28',NULL,700,NULL,'Available','Salt',100,70000,200),(84,'2019-09-05','2019-09-27',NULL,100,NULL,'Expired','Salt',100,10000,0),(85,'2019-09-10','2019-09-13',NULL,50,50,'Expired','Fish roll',NULL,NULL,NULL),(86,'2019-09-10','2019-09-16',NULL,20,20,'Expired','Cake',NULL,NULL,NULL),(87,'2019-09-11','2019-09-13',NULL,40,40,'Expired','Fish bun',NULL,NULL,NULL),(88,'2019-09-12','2019-09-15',NULL,30,30,'Expired','Mini pizza',NULL,NULL,NULL),(89,'2019-09-12','2019-09-18',NULL,20,20,'Expired','Cake',NULL,NULL,NULL),(90,'2019-09-13','2019-09-16',NULL,40,40,'Expired','Fish roll',NULL,NULL,NULL),(91,'2019-09-14','2019-09-16',NULL,35,35,'Expired','Fish bun',NULL,NULL,NULL),(92,'2019-09-14','2019-09-19',NULL,40,40,'Expired','Bread',NULL,NULL,NULL),(93,'2019-09-14','2019-09-17',NULL,40,40,'Expired','Mini pizza',NULL,NULL,NULL),(94,'2019-09-16','2019-09-21',NULL,40,40,'Expired','Bread',NULL,NULL,NULL),(95,'2019-09-16','2019-09-20',NULL,40,40,'Expired','Fish bun',NULL,NULL,NULL),(97,'2019-09-17','2019-09-20',NULL,55,50,'Expired','',NULL,NULL,NULL),(98,'2019-09-18','2019-09-21',NULL,30,30,'Expired','Fish roll',NULL,NULL,NULL),(99,'2019-09-18','2019-09-20',NULL,20,20,'Expired','Fish bun',NULL,NULL,NULL),(100,'2019-09-18','2019-09-23',NULL,45,45,'Expired','Bread',NULL,NULL,NULL),(101,'2019-09-14','2019-09-20',NULL,15,15,'Expired','Cake',NULL,NULL,NULL),(102,'2019-09-16','2019-09-22',NULL,20,20,'Expired','Cake',NULL,NULL,NULL),(103,'2019-09-20','2019-09-23',NULL,50,50,'Expired','Fish roll',NULL,NULL,NULL),(104,'2019-09-18','2019-09-24',NULL,15,15,'Expired','Cake',NULL,NULL,NULL),(105,'2019-09-20','2019-09-23',NULL,45,45,'Expired','Mini pizza',NULL,NULL,NULL),(106,'2019-09-21','2019-09-27',NULL,20,20,'Expired','Cake',NULL,NULL,NULL),(107,'2019-09-22','2019-10-27',NULL,30,0,'Closed','Bread',NULL,NULL,NULL),(108,'2019-09-23','2019-09-29',NULL,25,0,'Expired','Cake',NULL,NULL,NULL),(110,'2019-09-24','2019-09-27',NULL,40,40,'Expired','Fish roll',NULL,NULL,NULL),(111,'2019-09-24','2019-09-27',NULL,30,30,'Expired','Mini pizza',NULL,NULL,NULL),(112,'2019-09-24','2019-09-29',NULL,40,40,'Available','Bread',NULL,NULL,NULL),(113,'2019-09-25','2019-10-01',NULL,20,0,'Expired','Cake',NULL,NULL,NULL),(114,'2019-09-25','2019-09-28',NULL,30,10,'Available','Fish roll',NULL,NULL,NULL),(115,'2019-09-25','2019-09-28',NULL,45,10,'Available','Mini pizza',NULL,NULL,NULL),(116,'2019-09-25','2019-09-30',NULL,35,35,'Available','Bread',NULL,NULL,NULL),(117,'2019-09-25','2019-09-27',NULL,40,40,'Expired','Fish bun',NULL,NULL,NULL),(118,'2019-09-26','2019-09-29',NULL,20,20,'Available','Mini pizza',NULL,NULL,NULL),(119,'2019-09-26','2019-09-29',NULL,40,40,'Available','Fish roll',NULL,NULL,NULL),(120,'2019-09-26','2019-10-03',NULL,30,30,'Available','Bread',NULL,NULL,NULL),(121,'2019-09-26','2019-09-28',NULL,50,30,'Available','Fish bun',NULL,NULL,NULL),(122,'2019-09-27','2019-10-13',NULL,30,25,'Available','Cake',NULL,NULL,NULL),(123,'2019-09-27','2019-10-02',NULL,40,40,'Available','Bread',NULL,NULL,NULL),(124,'2019-09-27','2019-09-30',NULL,35,35,'Available','Fish roll',NULL,NULL,NULL),(125,'2019-09-27','2019-09-29',NULL,40,40,'Available','Fish bun',NULL,NULL,NULL),(126,'2019-09-27','2019-09-30',NULL,40,40,'Available','Mini pizza',NULL,NULL,NULL),(127,'2019-09-27','2019-10-15',NULL,35,35,'Available','Cake',NULL,NULL,NULL),(128,'2019-09-27','2019-09-30',NULL,44,44,'Available','Fish roll',NULL,NULL,NULL),(129,'2019-09-27','2019-09-30',NULL,10,10,'Available','bread',NULL,NULL,NULL),(130,'2019-09-01','2019-09-30',NULL,500,NULL,'Available','Salt',100,50000,100),(131,'2019-09-27','2019-09-30',NULL,6,6,'Available','bread',NULL,NULL,NULL),(132,'2019-10-06','2019-10-10',NULL,10,10,'Available','bread',NULL,NULL,NULL);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tempemployee`
--

DROP TABLE IF EXISTS `tempemployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tempemployee` (
  `teid` int(11) NOT NULL,
  `hours` float DEFAULT NULL,
  `otRate` float DEFAULT NULL,
  `totalSal` float DEFAULT NULL,
  `month` varchar(45) NOT NULL DEFAULT '1',
  `year` varchar(45) NOT NULL DEFAULT '2019',
  PRIMARY KEY (`teid`,`month`,`year`),
  CONSTRAINT `fk_teid` FOREIGN KEY (`teid`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tempemployee`
--

LOCK TABLES `tempemployee` WRITE;
/*!40000 ALTER TABLE `tempemployee` DISABLE KEYS */;
INSERT INTO `tempemployee` VALUES (28,10,10000,100000,'8','2019'),(28,11,10000,110000,'9','2019'),(28,NULL,10000,NULL,'January','2019'),(39,NULL,2500,NULL,'1','2019'),(39,10,2500,25000,'6','2018'),(39,8,2500,20000,'7','2019'),(39,10,2500,25000,'8','2019'),(39,10,2500,25000,'9','2019'),(40,NULL,1000,NULL,'1','2019'),(40,5,1000,5000,'8','2018'),(40,7,1000,7000,'8','2019'),(40,9,1000,9000,'9','2019'),(41,NULL,700,NULL,'1','2019'),(41,20,700,14000,'5','2019'),(41,7,700,4900,'9','2018'),(42,NULL,500,NULL,'1','2019'),(42,9,500,4500,'10','2019'),(42,9,500,4500,'7','2018'),(43,10,200,2000,'1','2019'),(43,20,200,4000,'5','2019'),(43,20,200,4000,'6','2019'),(43,7,200,1400,'8','2019'),(44,NULL,800,NULL,'1','2019'),(44,9,800,7200,'10','2019'),(44,40,800,32000,'6','2019'),(45,NULL,500,NULL,'1','2019'),(45,9,500,4500,'6','2019'),(45,9,500,4500,'7','2019'),(45,9,500,4500,'8','2019'),(46,NULL,600,NULL,'1','2019'),(46,30,600,18000,'7','2019'),(46,9,600,5400,'8','2019'),(47,NULL,800,NULL,'1','2019'),(47,35,800,28000,'6','2019'),(47,50,800,40000,'7','2019'),(47,20,800,16000,'8','2019'),(47,16,800,12800,'9','2019'),(48,NULL,800,NULL,'1','2019'),(59,NULL,1000,NULL,'1','2019'),(60,NULL,2000,NULL,'1','2019'),(61,NULL,1500,NULL,'1','2019'),(62,NULL,750,NULL,'1','2019'),(63,NULL,350,NULL,'1','2019'),(64,NULL,600,NULL,'1','2019'),(65,NULL,600,NULL,'1','2019'),(66,NULL,750,NULL,'1','2019'),(66,9,750,6750,'9','2019'),(68,NULL,500,NULL,'1','2019');
/*!40000 ALTER TABLE `tempemployee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `temporaryemployee`
--

DROP TABLE IF EXISTS `temporaryemployee`;
/*!50001 DROP VIEW IF EXISTS `temporaryemployee`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `temporaryemployee` AS SELECT 
 1 AS `eid`,
 1 AS `ename`,
 1 AS `year`,
 1 AS `month`,
 1 AS `hrate`,
 1 AS `hours`,
 1 AS `netSalary`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `temppackage`
--

DROP TABLE IF EXISTS `temppackage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temppackage` (
  `empid` int(11) NOT NULL,
  `packageId` int(11) NOT NULL,
  PRIMARY KEY (`empid`,`packageId`),
  KEY `fk_packid` (`packageId`),
  CONSTRAINT `fk_empid` FOREIGN KEY (`empid`) REFERENCES `tempemployee` (`teid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_packid` FOREIGN KEY (`packageId`) REFERENCES `package` (`packageId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temppackage`
--

LOCK TABLES `temppackage` WRITE;
/*!40000 ALTER TABLE `temppackage` DISABLE KEYS */;
/*!40000 ALTER TABLE `temppackage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transaction` (
  `cusID` varchar(50) NOT NULL,
  `grossTotal` varchar(10) DEFAULT '0',
  `Discount` varchar(10) DEFAULT '0',
  `Points` varchar(10) DEFAULT '0',
  `cusname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('1','300','2','5',NULL),('10','0','0','0',NULL),('11','0','0','0',NULL),('12','0','0','0',NULL),('13','0','0','0',NULL),('14','0','0','0',NULL),('15','0','0','0',NULL),('16','0','0','0',NULL),('17','0','0.05','750.0',NULL),('18','0','0.0','150.00',NULL),('19','0','0.1','1058.00',NULL),('20','0','0','0',NULL),('21','0','0','0',NULL),('22','0','0','0',NULL),('23','0','0','0',NULL),('7','0','0.0','0.0',NULL),('8','0','0','0',NULL),('9','0','0','0',NULL);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `eid` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  CONSTRAINT `fk_user` FOREIGN KEY (`eid`) REFERENCES `permanentemp` (`peid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (27,'thum@outlook.com','uN2x'),(29,'george@gmail.com','sC8K'),(30,'isuru@gmail.com','gnyc'),(31,'nimaya@gmail.com','QnRR'),(32,'avishka@gmail.com','js2x'),(33,'priyan@gmail.com','YMiz'),(34,'rashini@gmail.com','OB2w'),(35,'haritha@gmail.com','43Sc'),(67,'geo@gmail.com','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilities`
--

DROP TABLE IF EXISTS `utilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utilities` (
  `utilityId` int(11) NOT NULL AUTO_INCREMENT,
  `qty` int(11) DEFAULT NULL,
  `uti_name` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `arrD` date DEFAULT NULL,
  `Status1` varchar(20) DEFAULT 'Available',
  `availability` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL,
  PRIMARY KEY (`utilityId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilities`
--

LOCK TABLES `utilities` WRITE;
/*!40000 ALTER TABLE `utilities` DISABLE KEYS */;
INSERT INTO `utilities` VALUES (15,500,'Forks',700,'2019-09-03','Available',200,350000),(16,200,'Spoons',800,'2019-09-10','Available',NULL,NULL),(17,300,'Forks',700,'2019-09-05','Unavailable ',0,210000),(18,100,'Forks',700,'2019-09-09','Available',50,70000),(19,500,'Spoons',800,'2019-09-05','Available',NULL,NULL),(20,500,'Knives',1000,'2019-09-10','Unavailable ',NULL,NULL),(21,700,'Forks',700,'2019-09-11','Available',200,490000),(22,500,'Forks',700,'2019-09-01','Available',NULL,NULL);
/*!40000 ALTER TABLE `utilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hangout'
--

--
-- Dumping routines for database 'hangout'
--
/*!50003 DROP PROCEDURE IF EXISTS `absentatten` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `absentatten`(In eid int)
begin
insert into attendance
(presentdate,atd_eid)
values(curdate(),eid);

update attendance
set atten ='Absent',clockin='00:00:00',clockout='00:00:00'
where atd_eid=eid;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addleaves` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addleaves`(In empid int,In fname varchar(60), in lname varchar(60), in leavetype varchar(60),  in leavedate date)
begin
insert into empleaves(leave_type,leave_date)
values(leavetype,leavedate);

insert into permanentleave
values(empid,last_insert_id());
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addPermanentEmployees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addPermanentEmployees`(In fname varchar(60),In lname varchar(60),In nic varchar(10),In dob date, In gender varchar(45),In department varchar(45),In position varchar(45),In empType varchar(45),In basicSalary float)
begin
	if(empType = 'permanent') THEN
		insert into employee (fname,lname,nic,dob,gender,department,position,type)
		values(fname,lname,nic,dob,gender,department,position,empType);
        
        insert into permanentEmp(peid,basicSalary)
		values(last_insert_id(),basicSalary);
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `addTemporaryEmployees` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addTemporaryEmployees`(In fname varchar(60),In lname varchar(60),In nic varchar(10),In dob date, In gender varchar(45),In department varchar(45),In position varchar(45),In empType varchar(45),In otRate float)
begin
	if(empType = 'temporary') THEN
		insert into employee (fname,lname,nic,dob,gender,department,position,type)
		values(fname,lname,nic,dob,gender,department,position,empType);
        
        insert into tempemployee(teid,otRate)
        values(last_insert_id(),otRate);
    end if;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_payment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_payment`(IN tot float,cusmob varchar(10) )
BEGIN
Declare cusId int;
set cusId =(select customerID
from customer
where Phone=cusmob);

insert into payment(tot_amnt,Type,customerId)values(tot,'Restaurant-Reg',cusId); 


update customer
set total_exp= total_exp+tot
where customerID=cusId;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CusReg` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CusReg`(In CusName varchar(50),In phone char(10),In email char(50),In address varchar(100),In total_exp varchar(100))
BEGIN

		insert into customer
		(cus_Name,Phone,email,address,total_exp) values 
        (CusName,phone,email,address,total_exp);
        
        
        insert into transaction 
        (cusID)
        values
        (last_insert_id());
        

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteleaves` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteleaves`(In leavid int)
begin
update empleaves set leave_status ='Completed' where leaveid=leavid;

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertleaves` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertleaves`(IN empId int, IN type varchar(50),IN dayTime datetime  )
BEGIN
insert into empleaves(leave_type,leave_date) values(type,dayTime);



insert into permanentleave(pempid) values(empId);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `markatten` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `markatten`(In eid int)
begin
insert into attendance
(presentdate,atd_eid)
values(curdate(),eid);

end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `timeCal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `timeCal`(In id int, out sal float)
begin
	
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `absentatten`
--

/*!50001 DROP VIEW IF EXISTS `absentatten`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `absentatten` (`eid`,`year`,`month`,`absentcount`) AS select `attendance`.`atd_eid` AS `atd_eid`,year(`attendance`.`presentdate`) AS `year(presentdate)`,month(`attendance`.`presentdate`) AS `month(presentdate)`,count(`attendance`.`atten`) AS `count(atten)` from `attendance` where (`attendance`.`atten` = 'Absent') group by `attendance`.`atd_eid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cat_reports`
--

/*!50001 DROP VIEW IF EXISTS `cat_reports`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cat_reports` AS select `c`.`cateringID` AS `cateringID`,`c`.`packageID` AS `packageID`,`cus`.`cus_Name` AS `cus_Name`,`c`.`orderdate` AS `orderdate`,`cat`.`pay_date` AS `pay_date`,`cat`.`tot_amnt` AS `tot_amnt` from ((`catering` `c` join `customer` `cus`) join `catpay` `cat`) where ((`c`.`customerID` = `cus`.`customerID`) and (`c`.`cateringID` = `cat`.`cateringID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cus_rep`
--

/*!50001 DROP VIEW IF EXISTS `cus_rep`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cus_rep` AS select `cus`.`customerID` AS `customerID`,`cus`.`cus_Name` AS `cus_Name`,`t`.`Points` AS `Points`,`c`.`tot_amnt` AS `tot_amnt`,monthname(`c`.`pay_date`) AS `MONTHNAME(c.pay_date)`,year(`c`.`pay_date`) AS `YEAR(c.pay_date)` from ((`catpay` `c` join `customer` `cus` on((`c`.`cus_ID` = `cus`.`customerID`))) join `transaction` `t` on((`cus`.`customerID` = `t`.`cusID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cuspoi`
--

/*!50001 DROP VIEW IF EXISTS `cuspoi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cuspoi` AS select `c`.`customerID` AS `cus_ID`,`c`.`total_exp` AS `total_exp` from `customer` `c` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cuspoints`
--

/*!50001 DROP VIEW IF EXISTS `cuspoints`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cuspoints` AS select `c`.`customerID` AS `customerID`,`c`.`cus_Name` AS `cus_name`,sum(`ca`.`tot_amnt`) AS `Tot_amnt` from (`customer` `c` join `catpay` `ca`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `cust_dis`
--

/*!50001 DROP VIEW IF EXISTS `cust_dis`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `cust_dis` AS select `c`.`Phone` AS `phone`,`t`.`Points` AS `points`,`t`.`Discount` AS `discount` from (`customer` `c` join `transaction` `t`) where (`c`.`customerID` = `t`.`cusID`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `deletedleaves`
--

/*!50001 DROP VIEW IF EXISTS `deletedleaves`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `deletedleaves` AS select `el`.`leaveid` AS `leaveid`,`pl`.`pempid` AS `pempid`,`el`.`leave_type` AS `leave_type`,`el`.`leave_date` AS `leave_date`,`el`.`leave_status` AS `leave_status` from (`empleaves` `el` join `permanentleave` `pl`) where ((`el`.`leaveid` = `pl`.`leave_id`) and (`el`.`leave_status` = 'Completed')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `leavecount`
--

/*!50001 DROP VIEW IF EXISTS `leavecount`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `leavecount` (`eid`,`noofleaves`,`month`,`year`) AS select `pl`.`pempid` AS `pempid`,count(`pl`.`leave_id`) AS `count(leave_id)`,month(`el`.`leave_date`) AS `month`,year(`el`.`leave_date`) AS `year` from (`permanentleave` `pl` join `empleaves` `el`) where (`pl`.`leave_id` = `el`.`leaveid`) group by `pl`.`pempid`,`month` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `monthly_rep`
--

/*!50001 DROP VIEW IF EXISTS `monthly_rep`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `monthly_rep` AS select year(`catpay`.`pay_date`) AS `Year`,monthname(`catpay`.`pay_date`) AS `Month`,sum(`catpay`.`tot_amnt`) AS `Total` from `catpay` group by year(`catpay`.`pay_date`),month(`catpay`.`pay_date`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `payinfo`
--

/*!50001 DROP VIEW IF EXISTS `payinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `payinfo` AS select `c`.`cateringID` AS `cateringID`,`cus`.`customerID` AS `cus_ID`,`p`.`packageId` AS `packageID`,`p`.`pack_Price` AS `pack_price`,`c`.`plates` AS `plates`,`t`.`Discount` AS `discount` from (((`catering` `c` join `customer` `cus`) join `package` `p`) join `transaction` `t`) where ((`c`.`packageID` = `p`.`packageId`) and (`c`.`customerID` = `cus`.`customerID`) and (`c`.`customerID` = `t`.`cusID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `permanentemployee`
--

/*!50001 DROP VIEW IF EXISTS `permanentemployee`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `permanentemployee` (`eid`,`ename`,`basicSalary`,`year`,`month`,`bonus`,`netSalary`) AS select `e`.`id` AS `id`,concat(`e`.`fname`,`e`.`lname`) AS `concat(fname,lname)`,`p`.`basicSalary` AS `basicSalary`,`p`.`year` AS `year`,`p`.`month` AS `month`,`p`.`bonus` AS `bonus`,`p`.`netSal` AS `netSal` from (`employee` `e` join `permanentemp` `p`) where (`e`.`id` = `p`.`peid`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `presentatten`
--

/*!50001 DROP VIEW IF EXISTS `presentatten`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `presentatten` (`eid`,`year`,`month`,`presentcount`) AS select `attendance`.`atd_eid` AS `atd_eid`,year(`attendance`.`presentdate`) AS `year(presentdate)`,month(`attendance`.`presentdate`) AS `month(presentdate)`,count(`attendance`.`atten`) AS `count(atten)` from `attendance` where (`attendance`.`atten` = 'present') group by `attendance`.`atd_eid` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rest_report`
--

/*!50001 DROP VIEW IF EXISTS `rest_report`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rest_report` AS select year(`payment`.`pay_date`) AS `YEAR(pay_date)`,monthname(`payment`.`pay_date`) AS `MONTHNAME(pay_date)`,`payment`.`tot_amnt` AS `tot_amnt` from `payment` where ((`payment`.`Type` = 'Restaurant') or (`payment`.`Type` = 'Restauarant-Reg')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `rest_report2`
--

/*!50001 DROP VIEW IF EXISTS `rest_report2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `rest_report2` AS select distinct year(`payment`.`pay_date`) AS `year`,monthname(`payment`.`pay_date`) AS `month`,sum(`payment`.`tot_amnt`) AS `total` from `payment` where ((`payment`.`Type` = 'Restaurant') or (0 <> 'Restaurant-Reg')) group by month(`payment`.`pay_date`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `temporaryemployee`
--

/*!50001 DROP VIEW IF EXISTS `temporaryemployee`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `temporaryemployee` (`eid`,`ename`,`year`,`month`,`hrate`,`hours`,`netSalary`) AS select `e`.`id` AS `id`,concat(`e`.`fname`,`e`.`lname`) AS `concat(fname,lname)`,`t`.`year` AS `year`,`t`.`month` AS `month`,`t`.`otRate` AS `otRate`,`t`.`hours` AS `hours`,`t`.`totalSal` AS `totalSal` from (`employee` `e` join `tempemployee` `t`) where (`e`.`id` = `t`.`teid`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-09 16:53:58
