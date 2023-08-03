-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Aug 03. 18:21
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `project_bookmark`
--
CREATE DATABASE IF NOT EXISTS `project_bookmark` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `project_bookmark`;

DELIMITER $$
--
-- Eljárások
--
DROP PROCEDURE IF EXISTS `addAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAdmin` (IN `username` VARCHAR(50), IN `familyName` VARCHAR(100), IN `givenName` VARCHAR(100), IN `email` VARCHAR(50), IN `pwd` VARCHAR(50), IN `phone` VARCHAR(15), IN `town` VARCHAR(100))   INSERT INTO `user`
VALUES(NULL, username, familyName, givenName, email, SHA2(pwd, 256), phone, town, 1, NOW(), NOW(), NULL)$$

DROP PROCEDURE IF EXISTS `addBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBook` (IN `user_id` INT, IN `title` VARCHAR(100), IN `author` VARCHAR(100), IN `price` INT, IN `description` TEXT, IN `img` VARCHAR(100))   INSERT INTO `product`
VALUES(NULL, user_id, title, author, price, description, img, 1, NOW())$$

DROP PROCEDURE IF EXISTS `addFav`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFav` (IN `userId` INT, IN `productId` INT)   INSERT INTO `favourites`
VALUES (NULL, userId, productId)$$

DROP PROCEDURE IF EXISTS `delete fav`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete fav` (IN `userId` INT, IN `bookId` INT)   DELETE FROM `favourites`
WHERE `favourites`.`user_id` = userId AND `favourites`.`product_id` = bookId$$

DROP PROCEDURE IF EXISTS `deleteBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBook` (IN `id` INT)   DELETE FROM `product`
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `deleteUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `id` INT)   DELETE FROM `user` WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `orderBooksAsc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `orderBooksAsc` ()   SELECT * FROM `product` ORDER BY `product`.`price` ASC$$

DROP PROCEDURE IF EXISTS `orderBooksAZ`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `orderBooksAZ` ()   SELECT * FROM `product` ORDER BY `product`.`title` ASC$$

DROP PROCEDURE IF EXISTS `orderBooksDesc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `orderBooksDesc` ()   SELECT * FROM `product` ORDER BY `product`.`price` DESC$$

DROP PROCEDURE IF EXISTS `orderBooksZA`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `orderBooksZA` ()   SELECT * FROM `product` ORDER BY `product`.`title` DESC$$

DROP PROCEDURE IF EXISTS `selectAllAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllAdmin` ()   SELECT * from `user` WHERE `user`.`role_id` = 1$$

DROP PROCEDURE IF EXISTS `selectAllBooks`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllBooks` ()   SELECT * FROM `product`$$

DROP PROCEDURE IF EXISTS `selectAllUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllUser` ()   SELECT * from `user` WHERE `user`.`role_id` = 2$$

DROP PROCEDURE IF EXISTS `updateBookAuthor`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookAuthor` (IN `id` INT, IN `newAuthor` VARCHAR(100))   UPDATE `product`
SET `product`.`author` = newAuthor
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateBookDesc`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookDesc` (IN `id` INT, IN `newDesc` TEXT)   UPDATE `product`
SET `product`.`description` = newDesc
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateBookImg`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookImg` (IN `id` INT, IN `newImg` VARCHAR(100))   UPDATE `product`
SET `product`.`image` = newImg
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateBookPrice`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookPrice` (IN `id` INT, IN `newPrice` INT)   UPDATE `product`
SET `product`.`price` = newPrice
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateBookStatus`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookStatus` (IN `id` INT, IN `newStatus` INT)   UPDATE `product`
SET `product`.`status_id` = newStatus
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateBookTitle`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateBookTitle` (IN `id` INT, IN `newTitle` VARCHAR(100))   UPDATE `product`
SET `product`.`title` = newTitle
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateUserPassword`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserPassword` (IN `idIN` INT, IN `newPwd` VARCHAR(50))   UPDATE `user`
SET `user`.`pwd` = newPwd
WHERE `user`.`id` = idIN$$

DROP PROCEDURE IF EXISTS `updateUserPhone`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserPhone` (IN `idIN` INT, IN `newPhone` VARCHAR(15))   UPDATE `user`
SET `user`.`phone` = newPhone
WHERE `user`.`id` = idIN$$

DROP PROCEDURE IF EXISTS `updateUserTown`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserTown` (IN `idIN` INT(11), IN `newTown` VARCHAR(100))   UPDATE `user`
SET `user`.`town` = newTown
WHERE `user`.`id` = idIN$$

DROP PROCEDURE IF EXISTS `updateUserUsername`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserUsername` (IN `idIN` INT(11), IN `newUsername` VARCHAR(50))   UPDATE `user`
SET `user`.`username` = newUsername
WHERE `user`.`id` = idIN$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `favourites`
--

DROP TABLE IF EXISTS `favourites`;
CREATE TABLE `favourites` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `image` varchar(100) NOT NULL COMMENT 'kép helyét jelöli',
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `family_name` varchar(100) NOT NULL,
  `given_name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pwd` char(64) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `town` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_login` timestamp NOT NULL DEFAULT current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `favourites`
--
ALTER TABLE `favourites`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- A tábla indexei `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_id` (`role_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `favourites`
--
ALTER TABLE `favourites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
