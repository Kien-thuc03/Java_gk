-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for xe
CREATE DATABASE IF NOT EXISTS `xe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `xe`;

-- Dumping structure for table xe.loaixe
CREATE TABLE IF NOT EXISTS `loaixe` (
  `maLoai` varchar(50) NOT NULL,
  `tenLoai` varchar(50) NOT NULL,
  PRIMARY KEY (`maLoai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table xe.loaixe: ~4 rows (approximately)
INSERT INTO `loaixe` (`maLoai`, `tenLoai`) VALUES
	('2khds', 'xe moto'),
	('3afsc', 'xe oto'),
	('4akhb', 'container'),
	('qweqw', 'xe may');

-- Dumping structure for table xe.xe
CREATE TABLE IF NOT EXISTS `xe` (
  `maXe` varchar(50) NOT NULL,
  `tenXe` varchar(50) NOT NULL,
  `gia` double NOT NULL DEFAULT 0,
  `namSX` int(11) NOT NULL DEFAULT 0,
  `maLoai` varchar(50) NOT NULL,
  PRIMARY KEY (`maXe`),
  KEY `FK__loaixe` (`maLoai`),
  CONSTRAINT `FK__loaixe` FOREIGN KEY (`maLoai`) REFERENCES `loaixe` (`maLoai`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table xe.xe: ~4 rows (approximately)
INSERT INTO `xe` (`maXe`, `tenXe`, `gia`, `namSX`, `maLoai`) VALUES
	('1sddf', 'yamaha', 10000, 1999, '4akhb'),
	('27f19c1c-3909-41de-ad12-49ae352df4bb', 'tan', 8386, 2003, '3afsc'),
	('2adhd', 'honda', 2000000, 1999, '2khds'),
	('7f03d88a-686c-451d-ac4a-24bfe0d77b0e', 'fu\'ck', 86883, 2003, '2khds');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
