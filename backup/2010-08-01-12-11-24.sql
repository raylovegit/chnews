-- MySQL dump 10.11
--
-- Host: localhost    Database: chnews
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt

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
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL auto_increment,
  `newsId` bigint(20) NOT NULL default '0',
  `author` varchar(20) collate utf8_unicode_ci default NULL,
  `content` varchar(200) collate utf8_unicode_ci default NULL,
  PRIMARY KEY  (`id`),
  KEY `newsId` (`newsId`),
  CONSTRAINT `newsId` FOREIGN KEY (`newsId`) REFERENCES `news` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (4,4,'rslee','test'),(5,5,'rslee','test'),(6,6,'rslee','test'),(7,7,'rslee','test'),(8,8,'rslee','test'),(10,10,'rslee','test'),(11,11,'rslee','test'),(12,12,'rslee','test');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `items` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(20) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (3,'item3'),(4,'item4'),(5,'item5'),(6,'item6'),(7,'item7');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) collate utf8_unicode_ci NOT NULL,
  `sub_title` varchar(100) collate utf8_unicode_ci default NULL,
  `sub2_title` varchar(100) collate utf8_unicode_ci default NULL,
  `caption` longtext collate utf8_unicode_ci,
  `kindid` int(11) NOT NULL default '0',
  `newsType` int(11) NOT NULL default '0',
  `time` date NOT NULL default '0000-00-00',
  `author` varchar(30) collate utf8_unicode_ci NOT NULL default '',
  `visitnum` int(6) NOT NULL default '0',
  `news_from` varchar(30) collate utf8_unicode_ci default '',
  `kindName` varchar(40) collate utf8_unicode_ci NOT NULL,
  `typeName` varchar(40) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (4,'test','test','test','test',4,1,'2010-07-19','rslee',1,'hjj','',''),(5,'5','test','test','<p><img width=\"0\" height=\"0\" alt=\"\" src=\"/chnews/userfiles//image/2010-07-30-0.bmp\" /><img width=\"320\" height=\"240\" alt=\"\" src=\"/chnews/userfiles//image/2010-07-30-0.bmp\" /></p>',3,1,'2010-07-19','rslee',0,'hjj','item3','图片新闻'),(6,'test','test','test','test',6,1,'2010-07-19','rslee',1,'hjj','',''),(7,'test','test','test','test',7,1,'2010-07-19','rslee',1,'hjj','',''),(8,'test','test','test','test',8,1,'2010-07-19','rslee',1,'hjj','',''),(10,'test','test','test','test',1,1,'2010-07-19','rslee',1,'hjj','',''),(11,'test','test','test','test',2,1,'2010-07-19','rslee',1,'hjj','',''),(12,'test','test','test','test',3,1,'2010-07-19','rslee',1,'hjj','',''),(30,'30','test','test','<p>test</p>',2,0,'2010-07-19','rslee',0,'hjj','item2','一般新闻'),(31,'4444','test','test','<p>test</p>',3,1,'2010-07-19','rslee',0,'hjj','item3','图片新闻'),(32,'32','test','test','<p>test</p>',6,2,'2010-07-19','rslee',0,'hjj','item6','视频新闻'),(33,'33','ee','eee','',7,0,'2010-07-30','eee',0,'eeee','item7','一般新闻');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `loginName` varchar(20) collate utf8_unicode_ci NOT NULL,
  `passwords` varchar(20) collate utf8_unicode_ci NOT NULL,
  `des` varchar(100) collate utf8_unicode_ci NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (6,'hjj','zzzzzz','supser admin'),(7,'rslee','zzzzzz','超级管理员'),(8,'sql','sql','超级管理员'),(9,'w','w','超级管理员'),(10,'ym','ym','超级管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visit_num`
--

DROP TABLE IF EXISTS `visit_num`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `visit_num` (
  `id` int(11) NOT NULL default '0',
  `nums` bigint(20) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `visit_num`
--

LOCK TABLES `visit_num` WRITE;
/*!40000 ALTER TABLE `visit_num` DISABLE KEYS */;
/*!40000 ALTER TABLE `visit_num` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-08-01  4:11:24
