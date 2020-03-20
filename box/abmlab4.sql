/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.4.11-MariaDB : Database - lab4-bd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lab4-bd` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `lab4-bd`;

/*Table structure for table `empresa` */

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `empresa_denominacion` varchar(255) DEFAULT NULL,
  `empresa_domicilio` varchar(255) DEFAULT NULL,
  `empresa_email` varchar(255) DEFAULT NULL,
  `empresa_horario` varchar(255) DEFAULT NULL,
  `empresa_latitud` float DEFAULT NULL,
  `empresa_longitud` float DEFAULT NULL,
  `empresa_quienes_somos` varchar(255) DEFAULT NULL,
  `empresa_telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `empresa` */

insert  into `empresa`(`id`,`empresa_denominacion`,`empresa_domicilio`,`empresa_email`,`empresa_horario`,`empresa_latitud`,`empresa_longitud`,`empresa_quienes_somos`,`empresa_telefono`) values (1,'Tumba Inc','Suipacha 254 Barrio Lihué','eltumba@gmail.com','8:00 am a 17:00pm',-7,1,'Tumba Inc es una empresa dedicada a ser el tumba mas tumba ','2612524162'),(2,'Elmu Rúa','Los Nogales 254 Barrio Unimev','elmurua@gmail.com','8:30 am a 20:00pm',-5,3,'Elmu Rúa es una empresa de De La Rúa','251256235');

/*Table structure for table `noticia` */

DROP TABLE IF EXISTS `noticia`;

CREATE TABLE `noticia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticia_fecha` varchar(255) DEFAULT NULL,
  `noticia_html` varchar(255) DEFAULT NULL,
  `noticia_imagen` varchar(255) DEFAULT NULL,
  `noticia_publicada` tinyint(4) DEFAULT NULL,
  `noticia_resumen` varchar(255) DEFAULT NULL,
  `noticia_titulo` varchar(255) DEFAULT NULL,
  `empresa_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpkj6n6e69tv9wb8c4fkd6vr48` (`empresa_id`),
  CONSTRAINT `FKpkj6n6e69tv9wb8c4fkd6vr48` FOREIGN KEY (`empresa_id`) REFERENCES `empresa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `noticia` */

insert  into `noticia`(`id`,`noticia_fecha`,`noticia_html`,`noticia_imagen`,`noticia_publicada`,`noticia_resumen`,`noticia_titulo`,`empresa_id`) values (1,'20/3/2020','<h1><strong>Naa como se va a morir el tumbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</strong></h1>\n<h1>SOOO<span style=\"background-color: #e03e2d;\">OOOOOY</span> DE RIVER<span style=\"background-color: #e03e2d;\"> PEGA</span>RLE A LOS JUGADORES</h1>','https://acordesweb.com/img/rip-dbdf5444750db217b7979ac813b77f7b.jpg',1,'Parece que se murió nomás','Se murió el tumba',1),(7,'20/3/2020','<p><strong>Contenido <span style=\"background-color: #3598db;\">HTML </span>innereado</strong></p>','https://picsum.photos/200/300',1,'Basicamente el ramiro es el ramiro viste como es ','El Ramiro es el ramiro',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
