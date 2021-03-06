-- Host: localhost    Database: database_lms
-- ------------------------------------------------------
drop database if exists database_LMS;
create database database_LMS;
use database_LMS;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT= @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS= @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION= @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE= @@TIME_ZONE */;
/*!40103 SET TIME_ZONE= '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS= @@UNIQUE_CHECKS,
UNIQUE_CHECKS= 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS= @@FOREIGN_KEY_CHECKS,
FOREIGN_KEY_CHECKS= 0 */;
/*!40101 SET @OLD_SQL_MODE= @@SQL_MODE,
SQL_MODE= 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES= @@SQL_NOTES,
SQL_NOTES= 0 */;
--
-- Table structure for table `Member`
--
DROP TABLE IF EXISTS `Members`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Members`
(
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar (45) NOT NULL,
   `role` varchar (9) NOT NULL,
   `book_limit` int,
   `non_paid_fine` int,
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 10 DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Members`
--
LOCK TABLES `Members` WRITE;
/*!40000 ALTER TABLE `Members` DISABLE KEYS */;
INSERT INTO `Members` VALUES
(
   1,
   'Marie Smith',
   'Student',
   3,
   0
),

(
   2,
   'Oliver Williams',
   'Student',
   3,
   0
),

(
   3,
   'Harriet Taylor',
   'Student',
   3,
   0
);
/*!40000 ALTER TABLE `Members` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Books`
--
DROP TABLE IF EXISTS `Books`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Books`
(
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `ISBN` bigint NOT NULL,
   `title` varchar (45) NOT NULL,
   `publisher` varchar (45) NOT NULL,
   `year` int NOT NULL,
   `available` BIT,
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 10 DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Books`
--
LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;
INSERT INTO `Books` VALUES
(
   1,
   9780812036381,
   'Hamlet',
   'Barrons Educational Series',
   1986,
   1
),

(
   2,
   9780061122415,
   'The Alchemist',
   'HarperOne',
   1993,
   1
),

(
   3,
   9780062073567,
   'The Murder of Roger Ackroyd',
   'William Morrow & Company',
   2011,
   1
);
/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Book_Authors_Map`
--
DROP TABLE IF EXISTS `Book_Authors_Map`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book_Authors_Map`
(
   `book_id` bigint unsigned NOT NULL,
   `author_id` bigint unsigned NOT NULL,
   primary key
   (
      `book_id`,
      `author_id`
   ),
   KEY `FK_Book_Authors_Map_1` (`author_id`),
   KEY `FK_Book_Authors_Map_2` (`book_id`),
   CONSTRAINT `FK_Book_Authors_Map_1` FOREIGN KEY (`author_id`) REFERENCES `Authors` (`id`),
   CONSTRAINT `FK_Book_Authors_Map_2` FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Book_Authors_Map`
--
LOCK TABLES `Book_Authors_Map` WRITE;
/*!40000 ALTER TABLE `Book_Authors_Map` DISABLE KEYS */;
INSERT INTO `Book_Authors_Map` VALUES
(
   1,
   1
),

(
   2,
   5
),

(
   3,
   4
);
/*!40000 ALTER TABLE `Book_Authors_Map` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Authors`
--
DROP TABLE IF EXISTS `Authors`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Authors`
(
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar (45) NOT NULL,
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 10 DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Authors`
--
LOCK TABLES `Authors` WRITE;
/*!40000 ALTER TABLE `Authors` DISABLE KEYS */;
INSERT INTO `Authors` VALUES
(
   1,
   'William Shakespeare'
),

(
   2,
   'Agatha Christie'
),

(
   3,
   'Danielle Steel'
),

(
   4,
   'Stephen King'
),

(
   5,
   'Paulo Coelho'
);
/*!40000 ALTER TABLE `Authors` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Book_Subject_Map`
--
DROP TABLE IF EXISTS `Book_Subject_Map`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book_Subject_Map`
(
   `book_id` bigint unsigned NOT NULL,
   `subject_id` bigint unsigned NOT NULL,
   primary key
   (
      `book_id`,
      `subject_id`
   ),
   KEY `FK_Book_Subject_Map_1` (`book_id`),
   KEY `FK_Book_Subject_Map_2` (`subject_id`),
   CONSTRAINT `FK_Book_Subject_Map_1` FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`),
   CONSTRAINT `FK_Book_Subject_Map_2` FOREIGN KEY (`subject_id`) REFERENCES `Subject` (`id`)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Book_Subject_Map`
--
LOCK TABLES `Book_Subject_Map` WRITE;
/*!40000 ALTER TABLE `Book_Subject_Map` DISABLE KEYS */;
INSERT INTO `Book_Subject_Map` VALUES
(
   1,
   7
),

(
   2,
   3
),

(
   3,
   6
),

(
   2,
   1
);
/*!40000 ALTER TABLE `Book_Subject_Map` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Subject`
--
DROP TABLE IF EXISTS `Subject`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Subject`
(
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `name` varchar (45) NOT NULL,
   PRIMARY KEY (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 10 DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `Subject`
--
LOCK TABLES `Subject` WRITE;
/*!40000 ALTER TABLE `Subject` DISABLE KEYS */;
INSERT INTO `Subject` VALUES
(
   1,
   'Fantasy'
),

(
   2,
   'Poetry'
),

(
   3,
   'Fiction'
),

(
   4,
   'Horror'
),

(
   5,
   'Science'
),

(
   6,
   'Mystery & Crime'
),

(
   7,
   'Classics'
),

(
   8,
   'Sports'
),

(
   9,
   'Cooking'
),

(
   10,
   'Computers'
);
/*!40000 ALTER TABLE `Subject` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `Book_Issue`
--
DROP TABLE IF EXISTS `Book_issue`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Book_issue`
(
   `id` bigint unsigned NOT NULL AUTO_INCREMENT,
   `book_id` bigint unsigned NOT NULL,
   `member_id` bigint unsigned NOT NULL,
   `date_of_issue` date NOT NULL,
   `term_of_return` date NOT NULL,
   `actual_return_date` date NOT NULL,
   `fine_amount` int,
   PRIMARY KEY (`id`),
   CONSTRAINT `FK_Book_Issue_Map_1` FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`),
   CONSTRAINT `FK_Book_Issue_Map_2` FOREIGN KEY (`member_id`) REFERENCES `Members` (`id`)
)
ENGINE= InnoDB AUTO_INCREMENT= 10 DEFAULT CHARSET= utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40101 SET SQL_MODE= @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS= @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS= @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT= @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS= @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION= @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES= @OLD_SQL_NOTES */;
-- Dump completed on