/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.0.27-community-nt : Database - makan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`makan` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `makan`;

/*Table structure for table `add_apartment_photos_vo` */

DROP TABLE IF EXISTS `add_apartment_photos_vo`;

CREATE TABLE `add_apartment_photos_vo` (
  `PHOTO_ID` int(11) NOT NULL,
  `FILE_NAME` varchar(255) default NULL,
  `ENCRYPTED_NAME` varchar(255) default NULL,
  `Apartment_ID` int(11) default NULL,
  PRIMARY KEY  (`PHOTO_ID`),
  KEY `FK448D898C61F32727` (`Apartment_ID`),
  CONSTRAINT `FK448D898C61F32727` FOREIGN KEY (`Apartment_ID`) REFERENCES `add_apartment_vo` (`APARTMENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `add_apartment_photos_vo` */

insert  into `add_apartment_photos_vo`(`PHOTO_ID`,`FILE_NAME`,`ENCRYPTED_NAME`,`Apartment_ID`) values (1,'d5eed9997bedd059e5081fc42f8d0115-1876292514.png','1946240e6a4f98b6fd3b32d4a20793d9409223984.png',1),(2,'46648868c8b31317d13f332d180e33191763607980.jpg','e5ae9bdaba79ae98f20a0d458ad45eb0759562969.jpg',1),(3,'46648868c8b31317d13f332d180e3319873331295.jpg','22bc0ee18bae560b47c48e4dd3f46a75-420178744.jpg',11),(4,'46648868c8b31317d13f332d180e3319739119465.jpg','a4d502895701842ac14c3f463d392c77-795216808.jpg',11),(5,'46648868c8b31317d13f332d180e3319213389662.jpg','d4583d3bcfeff5b960398aee94197cfd1538336301.jpg',2),(6,'7f8da140959ac7a7d46089f11132688a220026601.jpg','235bc12c3ee77629b0fabd9c877da64b-914518537.jpg',2);

/*Table structure for table `add_apartment_vo` */

DROP TABLE IF EXISTS `add_apartment_vo`;

CREATE TABLE `add_apartment_vo` (
  `APARTMENT_ID` int(11) NOT NULL,
  `FILE_NAME` varchar(255) default NULL,
  `ENCRYPTED_NAME` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `NO_OF_BEDROOM` int(11) default NULL,
  `NO_OF_BATHROOM` int(11) default NULL,
  `AMINITIES` varchar(255) default NULL,
  `CITY` varchar(255) default NULL,
  `STATE` varchar(255) default NULL,
  `ZIP_CODE` bigint(20) default NULL,
  `PRICE` float default NULL,
  `RENTAL_STATUS` varchar(255) default NULL,
  PRIMARY KEY  (`APARTMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `add_apartment_vo` */

insert  into `add_apartment_vo`(`APARTMENT_ID`,`FILE_NAME`,`ENCRYPTED_NAME`,`ADDRESS`,`NO_OF_BEDROOM`,`NO_OF_BATHROOM`,`AMINITIES`,`CITY`,`STATE`,`ZIP_CODE`,`PRICE`,`RENTAL_STATUS`) values (1,'2c55373e81b10eec627ab5c44ce048b9813886944.jpg','aba14d0f069334ff18cb88651318aa52815601591.jpg','59 North Allen Street\r\nFloor 2',3,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,2200,'rented'),(2,'3a5b897e4a5ab22e7d875cfda8a548801288746983.png','3962993b2a71e075c6061a86fdddfd5620777841.png','639 washington Ave',4,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12206,2300,'available'),(3,'4c1186908ecf2462431c8bd2554b54d668996640.jpeg','bc41db86c5575a541074cc9c7e561fd4-2049664879.jpeg','638 Washington Ave',3,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,1950,'available'),(4,'5ca7334c9b2f4c1b1d233ee5abb962e1-261582232.png','0d18804029b413d7564dcaf56fe3fa66-339324185.png','547 Washington Ave',5,2,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,2400,'rented'),(5,'5ca7334c9b2f4c1b1d233ee5abb962e1446493563.png','385ab0d68736cbe335d03153d74dc01d1945751900.png','549 Washington Aven',6,2,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,2650,'available'),(6,'7f8da140959ac7a7d46089f11132688a220026601.jpg','235bc12c3ee77629b0fabd9c877da64b-460838622.jpg','57 North Allen St',4,2,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,1650,'available'),(7,'452d0dd2725cc7ca07863bc04b0fd300-287136885.jpg','55302e57df659b48b508a4aae9b19efb1373526910.jpg','141 Manning Blvd',4,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,1800,'available'),(8,'488e14d1e0f48dd0d7fe3dad2b307896-328001692.png','092a569898e80a0a523e6a7b295032461198876085.png','142 Manning Blvd',4,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,1950,'available'),(9,'02045102b6a20e773545a3b5b84e29f6-345783793.jpg','8312e61604a267fb0451a498bd0c52e12105660249.jpg','654 Washington Ave',3,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12222,2150,'available'),(10,'46648868c8b31317d13f332d180e3319-1345511446.jpg','686a05e174a3aa2230254dd42da2d8a91022300473.jpg','127 North Allen Street\r\nApt 1',3,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,2250,'available'),(11,'46648868c8b31317d13f332d180e3319213389662.jpg','d4583d3bcfeff5b960398aee94197cfd1539901435.jpg','128 N Allen St',5,1,'Swimming Pool, Laundry, Parking, Gym.','Albany','New York',12203,2320,'available');

/*Table structure for table `add_appointment_vo` */

DROP TABLE IF EXISTS `add_appointment_vo`;

CREATE TABLE `add_appointment_vo` (
  `APPOINTMENT_ID` int(11) NOT NULL,
  `FIRSTNAME` varchar(255) default NULL,
  `LASTNAME` varchar(255) default NULL,
  `EMAILID` varchar(255) default NULL,
  `PHONENO` varchar(255) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `DATE` varchar(255) default NULL,
  `SLOT` varchar(255) default NULL,
  `APARTMENT_ID` int(11) default NULL,
  PRIMARY KEY  (`APPOINTMENT_ID`),
  KEY `FK24CC9AF761F32727` (`APARTMENT_ID`),
  CONSTRAINT `FK24CC9AF761F32727` FOREIGN KEY (`APARTMENT_ID`) REFERENCES `add_apartment_vo` (`APARTMENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `add_appointment_vo` */

insert  into `add_appointment_vo`(`APPOINTMENT_ID`,`FIRSTNAME`,`LASTNAME`,`EMAILID`,`PHONENO`,`ADDRESS`,`DATE`,`SLOT`,`APARTMENT_ID`) values (123446,'Jim','Costello','jim@gmail.com','1234567891','CTG ALBANY','05/11/2017','10:00AM - 12:00PM',11);

/*Table structure for table `add_resident_vo` */

DROP TABLE IF EXISTS `add_resident_vo`;

CREATE TABLE `add_resident_vo` (
  `RESIDENT_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(255) default NULL,
  `LAST_NAME` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `PHONE_NUMBER` bigint(20) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `USER_ID` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `USER_TYPE` varchar(255) default NULL,
  `LOGIN_id` int(11) default NULL,
  `APARTMENT_ID` int(11) default NULL,
  PRIMARY KEY  (`RESIDENT_ID`),
  KEY `FKC725114A61F32727` (`APARTMENT_ID`),
  KEY `FKC725114A938F35E` (`LOGIN_id`),
  CONSTRAINT `FKC725114A61F32727` FOREIGN KEY (`APARTMENT_ID`) REFERENCES `add_apartment_vo` (`APARTMENT_ID`) ON DELETE CASCADE,
  CONSTRAINT `FKC725114A938F35E` FOREIGN KEY (`LOGIN_id`) REFERENCES `login_vo` (`LOGIN_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `add_resident_vo` */

insert  into `add_resident_vo`(`RESIDENT_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL_ID`,`PHONE_NUMBER`,`ADDRESS`,`USER_ID`,`PASSWORD`,`USER_TYPE`,`LOGIN_id`,`APARTMENT_ID`) values (1,'Bhaumik ','Patel','bhaumik55231@gmail.com',9292617230,'59 N Allen','bhaumik55231@gmail.com','jagruti@754','admin',1,NULL),(2,'Prasang','Prajapati','prajapatiprasang1@gmail.com',1234567890,'59 North Allen Street\r\nFloor 2, Albany, NY - 12203','prajapatiprasang1@gmail.com','prasang@123','resident',2,1),(5,'kevin ','zhen','kevin@gmain.com',1234567891,'547 Washington Ave, Albany, New York - 12203.','kevin@gmail.com','kevin@albany','resident',4,4);

/*Table structure for table `contact_us_vo` */

DROP TABLE IF EXISTS `contact_us_vo`;

CREATE TABLE `contact_us_vo` (
  `CONTACT_US_ID` int(11) NOT NULL,
  `NAME` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `PHONE` varchar(255) default NULL,
  `MESSAGE` varchar(255) default NULL,
  PRIMARY KEY  (`CONTACT_US_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `contact_us_vo` */

/*Table structure for table `login_vo` */

DROP TABLE IF EXISTS `login_vo`;

CREATE TABLE `login_vo` (
  `LOGIN_ID` int(11) NOT NULL,
  `USERNAME` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `USERTYPE` varchar(255) default NULL,
  PRIMARY KEY  (`LOGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login_vo` */

insert  into `login_vo`(`LOGIN_ID`,`USERNAME`,`PASSWORD`,`USERTYPE`) values (1,'bhaumik55231@gmail.com','jagruti@754','admin'),(2,'prajapatiprasang1@gmail.com','prasang@123','resident'),(4,'kevin@gmail.com','kevin@albany','resident');

/*Table structure for table `payment_vo` */

DROP TABLE IF EXISTS `payment_vo`;

CREATE TABLE `payment_vo` (
  `PAYMENT_ID` int(11) NOT NULL,
  `DATE` varchar(255) default NULL,
  `STATUS` varchar(255) default NULL,
  `APARTMENT_ID` int(11) default NULL,
  `RESIDENT_ID` int(11) default NULL,
  `PAYMENT_DATE` datetime default NULL,
  PRIMARY KEY  (`PAYMENT_ID`),
  KEY `FK7D0D1FB261F32727` (`APARTMENT_ID`),
  KEY `FK7D0D1FB2AEEAF37F` (`RESIDENT_ID`),
  CONSTRAINT `FK7D0D1FB261F32727` FOREIGN KEY (`APARTMENT_ID`) REFERENCES `add_apartment_vo` (`APARTMENT_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK7D0D1FB2AEEAF37F` FOREIGN KEY (`RESIDENT_ID`) REFERENCES `add_resident_vo` (`RESIDENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `payment_vo` */

insert  into `payment_vo`(`PAYMENT_ID`,`DATE`,`STATUS`,`APARTMENT_ID`,`RESIDENT_ID`,`PAYMENT_DATE`) values (1,'2017-05-09 02:33:36','pending',1,2,NULL);

/*Table structure for table `rental_request_vo` */

DROP TABLE IF EXISTS `rental_request_vo`;

CREATE TABLE `rental_request_vo` (
  `RENTAL_REQUEST_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(255) default NULL,
  `LAST_NAME` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `PHONE_NUMBER` bigint(20) default NULL,
  `ADDRESS` varchar(255) default NULL,
  `STATUS` varchar(255) default NULL,
  `APARTMENT_ID` int(11) default NULL,
  PRIMARY KEY  (`RENTAL_REQUEST_ID`),
  KEY `FK585B2C8461F32727` (`APARTMENT_ID`),
  CONSTRAINT `FK585B2C8461F32727` FOREIGN KEY (`APARTMENT_ID`) REFERENCES `add_apartment_vo` (`APARTMENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `rental_request_vo` */

insert  into `rental_request_vo`(`RENTAL_REQUEST_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL_ID`,`PHONE_NUMBER`,`ADDRESS`,`STATUS`,`APARTMENT_ID`) values (2,'kevin ','zhen','kevin@gmain.com',1234567891,'547 Washington Ave, Albany, New York - 12203.','approved',4);

/*Table structure for table `reply_vo` */

DROP TABLE IF EXISTS `reply_vo`;

CREATE TABLE `reply_vo` (
  `REPLY_ID` int(11) NOT NULL,
  `REPLY_MESSAGE` varchar(255) default NULL,
  `SERVICE_ID` int(11) default NULL,
  `RESIDENT_ID` int(11) default NULL,
  PRIMARY KEY  (`REPLY_ID`),
  KEY `FK150AE84E7C404BD9` (`SERVICE_ID`),
  KEY `FK150AE84EAEEAF37F` (`RESIDENT_ID`),
  CONSTRAINT `FK150AE84E7C404BD9` FOREIGN KEY (`SERVICE_ID`) REFERENCES `service_vo` (`SERVICE_ID`) ON DELETE CASCADE,
  CONSTRAINT `FK150AE84EAEEAF37F` FOREIGN KEY (`RESIDENT_ID`) REFERENCES `add_resident_vo` (`RESIDENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `reply_vo` */

/*Table structure for table `service_vo` */

DROP TABLE IF EXISTS `service_vo`;

CREATE TABLE `service_vo` (
  `SERVICE_ID` int(11) NOT NULL,
  `SERVICE_TYPE` varchar(255) default NULL,
  `SERVICE_DESCRIPTION` varchar(255) default NULL,
  `RESIDENT_ID` int(11) default NULL,
  PRIMARY KEY  (`SERVICE_ID`),
  KEY `FKB61C98A3AEEAF37F` (`RESIDENT_ID`),
  CONSTRAINT `FKB61C98A3AEEAF37F` FOREIGN KEY (`RESIDENT_ID`) REFERENCES `add_resident_vo` (`RESIDENT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `service_vo` */

insert  into `service_vo`(`SERVICE_ID`,`SERVICE_TYPE`,`SERVICE_DESCRIPTION`,`RESIDENT_ID`) values (1,'Heater','Heater is not working',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
