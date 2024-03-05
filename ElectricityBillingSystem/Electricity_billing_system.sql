/*
SQLyog Community v13.1.2 (32 bit)
MySQL - 5.5.41 : Database - Electricity_billing_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`Electricity_billing_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `Electricity_billing_system`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admins`;

CREATE TABLE `admins` (
  `AdminID` varchar(50) NOT NULL,
  `AdminPasswordHash` varchar(64) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admins` */

insert  into `admins`(`AdminID`,`AdminPasswordHash`) values 
('Adnan@ebs.com','Adnan@123');

/*Table structure for table `electricitybilling` */

DROP TABLE IF EXISTS `electricitybilling`;

CREATE TABLE `electricitybilling` (
  `BillID` int(11) NOT NULL AUTO_INCREMENT,
  `MeterNumber` varchar(20) NOT NULL,
  `ReadingDate` date NOT NULL,
  `ConsumptionKWh` decimal(10,2) DEFAULT NULL,
  `BillAmount` decimal(10,2) NOT NULL,
  `UserID` int(11) NOT NULL,
  `SubsidyAmount` decimal(10,2) DEFAULT NULL,
  `SubsidyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`BillID`),
  KEY `MeterNumber` (`MeterNumber`),
  KEY `electricitybilling_ibfk_2` (`UserID`),
  KEY `electricitybilling_ibfk_3` (`SubsidyID`),
  CONSTRAINT `electricitybilling_ibfk_3` FOREIGN KEY (`SubsidyID`) REFERENCES `subsidies` (`SubsidyID`),
  CONSTRAINT `electricitybilling_ibfk_1` FOREIGN KEY (`MeterNumber`) REFERENCES `meters` (`MeterNumber`),
  CONSTRAINT `electricitybilling_ibfk_2` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `electricitybilling` */

/*Table structure for table `meters` */

DROP TABLE IF EXISTS `meters`;

CREATE TABLE `meters` (
  `MeterNumber` varchar(20) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `userid` int(11) NOT NULL,
  `InstallationDate` date DEFAULT NULL,
  PRIMARY KEY (`MeterNumber`),
  KEY `Email` (`Email`),
  KEY `userid` (`userid`),
  CONSTRAINT `meters_ibfk_1` FOREIGN KEY (`Email`) REFERENCES `users` (`Email`),
  CONSTRAINT `meters_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `users` (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `meters` */

insert  into `meters`(`MeterNumber`,`Email`,`userid`,`InstallationDate`) values 
('100','adnanshariff.9@gmail.com',1000,'2024-02-17'),
('101','adnanshariff.9@gmail.com',1000,'2024-02-18'),
('102','adnanshariff.9@gmail.com',1000,'2024-02-18'),
('103','adnanshariff.9@gmail.com',1000,'2024-02-18'),
('104','adnanshariff.9@gmail.com',1000,'2024-02-18'),
('105','adnanshariff.9@gmail.com',1000,'2024-02-19');

/*Table structure for table `poweravailability` */

DROP TABLE IF EXISTS `poweravailability`;

CREATE TABLE `poweravailability` (
  `Pincode` bigint(7) NOT NULL,
  `IsPowerAvailable` enum('Available','Not Available') DEFAULT NULL,
  `LastUpdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expectedOutageTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Pincode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `poweravailability` */

insert  into `poweravailability`(`Pincode`,`IsPowerAvailable`,`LastUpdated`,`expectedOutageTime`) values 
(560001,'Not Available','2024-02-19 14:00:35','2024-02-19 14:00:00'),
(560002,'Available','2024-02-19 12:34:31',NULL);

/*Table structure for table `subsidies` */

DROP TABLE IF EXISTS `subsidies`;

CREATE TABLE `subsidies` (
  `SubsidyID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `MeterID` varchar(20) NOT NULL,
  `aplORbplCardNo` varchar(50) NOT NULL,
  `SubsidyType` enum('Above Poverty Line','Below Poverty Line') NOT NULL,
  PRIMARY KEY (`SubsidyID`),
  UNIQUE KEY `aplORbplCardNo` (`aplORbplCardNo`),
  KEY `subsidies_ibfk_1` (`UserID`),
  KEY `subsidies_ibfk_2` (`MeterID`),
  CONSTRAINT `subsidies_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`),
  CONSTRAINT `subsidies_ibfk_2` FOREIGN KEY (`MeterID`) REFERENCES `meters` (`MeterNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `subsidies` */

insert  into `subsidies`(`SubsidyID`,`UserID`,`MeterID`,`aplORbplCardNo`,`SubsidyType`) values 
(1,1000,'100','7410852963','Above Poverty Line'),
(3,1001,'103','9876543210','Above Poverty Line');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `AadharCardNumber` bigint(12) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` bigint(10) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Pincode` bigint(7) DEFAULT NULL,
  `PasswordHash` varchar(64) NOT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `newConnectionStatus` enum('not applied','applied') DEFAULT 'not applied',
  `newSubsidyStatus` enum('not applied','applied','existing') DEFAULT 'not applied',
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `AadharCardNumber` (`AadharCardNumber`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`UserID`,`AadharCardNumber`,`Email`,`Phone`,`Address`,`Pincode`,`PasswordHash`,`Name`,`newConnectionStatus`,`newSubsidyStatus`) values 
(1000,123456789012,'adnanshariff.9@gmail.com',1234567890,'kanaka nagar',560001,'Adnan@123','Adnan Shariff','applied','existing'),
(1001,9516328740,'hamza@gmail.com',7418529630,'chamundi nagar',560032,'Hamza@123','hamza','not applied','existing');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
