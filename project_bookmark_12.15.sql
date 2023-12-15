-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Dec 15. 16:28
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `project_bookmark_test`
--
CREATE DATABASE IF NOT EXISTS `project_bookmark_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `project_bookmark_test`;

DELIMITER $$
--
-- Eljárások
--
DROP PROCEDURE IF EXISTS `addAdmin`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addAdmin` (IN `username` VARCHAR(50), IN `familyName` VARCHAR(100), IN `givenName` VARCHAR(100), IN `email` VARCHAR(50), IN `pwd` VARCHAR(50), IN `phone` VARCHAR(15), IN `town` VARCHAR(100))   INSERT INTO `user`
VALUES(NULL, username, familyName, givenName, email, SHA2(pwd, 256), phone, town, 1, NOW(), NOW(), NULL)$$

DROP PROCEDURE IF EXISTS `addBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addBook` (IN `user_id` INT, IN `title` VARCHAR(100), IN `author` VARCHAR(100), IN `price` INT, IN `description` TEXT, IN `img` VARCHAR(100))   INSERT INTO `product`
VALUES(NULL, user_id, title, author, price, description, img, 1, NOW(), NULL)$$

DROP PROCEDURE IF EXISTS `addFav`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addFav` (IN `userId` INT, IN `productId` INT)   INSERT INTO `favourites`
VALUES (NULL, userId, productId)$$

DROP PROCEDURE IF EXISTS `addUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser` (IN `username` VARCHAR(50), IN `familyName` VARCHAR(100), IN `givenName` VARCHAR(100), IN `email` VARCHAR(50), IN `pwd` VARCHAR(50), IN `phone` VARCHAR(15), IN `town` VARCHAR(100))   INSERT INTO `user`
VALUES(NULL, username, familyName, givenName, email, SHA2(pwd, 256), phone, town, 2, NOW(), NOW(), NULL)$$

DROP PROCEDURE IF EXISTS `deleteBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteBook` (IN `id` INT)   DELETE FROM `product`
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `deleteFav`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteFav` (IN `userId` INT, IN `bookId` INT)   DELETE FROM `favourites`
WHERE `favourites`.`user_id` = userId AND `favourites`.`product_id` = bookId$$

DROP PROCEDURE IF EXISTS `deleteUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteUser` (IN `id` INT)   DELETE FROM `user` WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `logDeleteBook`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `logDeleteBook` (IN `id` INT)   UPDATE `product`
SET `product`.`status_id` = 4, `product`.`deleted_at` = NOW()
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `logDeleteUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `logDeleteUser` (IN `id` INT)   UPDATE `user`
SET `user`.`deleted_at` = NOW()
WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `login`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `login` (IN `email` VARCHAR(50), IN `pwd` VARCHAR(255))   BEGIN
    DECLARE user_count INT;

    SELECT COUNT(*) INTO user_count
    FROM `user`
    WHERE `user`.`email` = email AND `user`.`pwd` = SHA2(pwd, 256);

    IF user_count = 1 THEN
        SELECT 'Login successful' AS result;
    ELSE
        SELECT 'Login failed' AS result;
    END IF;
END$$

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

DROP PROCEDURE IF EXISTS `selectAllFav`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllFav` (IN `userId` INT)   SELECT `favourites`.`product_id`, `product`.`title`, `product`.`author`, `product`.`price`, `product`.`description`, `product`.`image`
FROM `favourites`
RIGHT JOIN `product` ON `product`.`id` = `favourites`.`product_id`
WHERE `favourites`.`user_id` = userId$$

DROP PROCEDURE IF EXISTS `selectAllUser`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllUser` ()   SELECT * from `user` WHERE `user`.`role_id` = 2$$

DROP PROCEDURE IF EXISTS `selectProduct`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectProduct` (IN `id` INT, OUT `idOUT` INT, OUT `userId` INT, OUT `title` VARCHAR(100), OUT `author` VARCHAR(100), OUT `price` INT, OUT `description` TEXT, OUT `img` VARCHAR(100))   SELECT `product`.`id`, `product`.`user_id`, `product`.`title`, `product`.`author`, `product`.`price`, `product`.`description`, `product`.`image` 
INTO idOUT, userId, title, author, price, description, img
FROM `product` 
WHERE `product`.`id` = id$$

DROP PROCEDURE IF EXISTS `selectUserByEmail`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectUserByEmail` (IN `email` VARCHAR(50), IN `pwd` VARCHAR(100), OUT `id` INT, OUT `username` VARCHAR(50), OUT `familyName` VARCHAR(100), OUT `givenName` VARCHAR(100), OUT `emailOUT` VARCHAR(50), OUT `phone` VARCHAR(15), OUT `town` VARCHAR(100), OUT `role` INT)   SELECT `user`.`id`, `user`.`username`, `user`.`family_name`, `user`.`given_name`, `user`.`email`, `user`.`phone`, `user`.`town`, `user`.`role_id`
INTO id, username, familyName, givenName, emailOUT, phone, town, role
FROM `user` 
WHERE `user`.`email` = email AND `user`.`pwd` = SHA2(pwd, 256)$$

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserPassword` (IN `id` INT, IN `newPwd` VARCHAR(50))   UPDATE `user`
SET `user`.`pwd` = SHA2(newPwd, 256)
WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateUserPhone`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserPhone` (IN `id` INT, IN `newPhone` VARCHAR(15))   UPDATE `user`
SET `user`.`phone` = newPhone
WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateUserTown`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserTown` (IN `id` INT(11), IN `newTown` VARCHAR(100))   UPDATE `user`
SET `user`.`town` = newTown
WHERE `user`.`id` = id$$

DROP PROCEDURE IF EXISTS `updateUserUsername`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserUsername` (IN `id` INT(11), IN `newUsername` VARCHAR(50))   UPDATE `user`
SET `user`.`username` = newUsername
WHERE `user`.`id` = id$$

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

--
-- A tábla adatainak kiíratása `favourites`
--

INSERT INTO `favourites` (`id`, `user_id`, `product_id`) VALUES
(1, 1, 2),
(3, 1, 1),
(7, 2, 1);

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
  `image` varchar(100) DEFAULT NULL COMMENT 'kép helyét jelöli',
  `status_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `product`
--

INSERT INTO `product` (`id`, `user_id`, `title`, `author`, `price`, `description`, `image`, `status_id`, `created_at`, `deleted_at`) VALUES
(1, 1, 'asd', 'asd asd', 1000, 'valami szép könyv', 'C:\\project-img\\card-img', 4, '2023-09-26 08:19:50', NULL),
(4, 2, 'aaaa', 'ssssss', 222222, 'könyv', '', 1, '2023-09-26 09:04:45', NULL),
(5, 2, 'asdasd', 'asdasdasd', 1234, 'assssssssssaaaaasdddd', 'asd', 1, '2023-12-14 17:05:56', NULL),
(6, 2, 'postman könyv', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 1, '2023-12-14 17:06:00', NULL),
(7, 2, 'postman könyv 2', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 1, '2023-12-14 17:35:50', NULL),
(8, 2, 'postman könyv 3', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 1, '2023-12-14 17:45:14', NULL),
(9, 2, 'postman könyv 4', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 1, '2023-12-14 17:55:51', NULL),
(10, 2, 'postman könyv 4', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 4, '2023-12-14 18:04:26', '2023-12-15 09:04:30'),
(11, 2, 'postman könyv 4', 'Postman', 10000, 'Egy nagyon szép könyv amit a postmannel töltöttem fel.', 'kép helye', 1, '2023-12-14 18:17:49', NULL);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `status`
--

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'elérhető'),
(2, 'lefoglalva'),
(3, 'eladva'),
(4, 'törölt');

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
  `pwd` char(64) NOT NULL COMMENT 'A JELSZO "alma123"!!!!!',
  `phone` varchar(15) NOT NULL,
  `town` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `last_login` timestamp NOT NULL DEFAULT current_timestamp(),
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`id`, `username`, `family_name`, `given_name`, `email`, `pwd`, `phone`, `town`, `role_id`, `created_at`, `last_login`, `deleted_at`) VALUES
(2, 'weblapfelhasznalo', 'ad', 'min', 'admin@proba.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123456789876', 'weblapváros', 1, '2023-08-01 10:12:20', '2023-08-01 10:12:20', NULL),
(3, 'user1', 'us', 'er', 'user1@proba.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'asd', 2, '2023-08-01 10:13:59', '2023-08-01 10:13:59', '2023-11-23 08:43:34'),
(5, 'postmanfelhasznalo', 'pelda', 'pelda', 'aaaaaa@email.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123456789', 'postmanváros', 2, '2023-09-05 19:27:53', '2023-09-05 19:27:53', NULL),
(7, 'postmanproba', 'Postás', 'Pat', 'probatest@gmail.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'Kukutyin', 2, '2023-09-26 09:18:19', '2023-09-26 09:18:19', NULL),
(8, 'adminpostmanproba', 'adminPostás', 'adminPat', 'adminprobatest@gmail.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'újváros', 1, '2023-09-26 09:30:41', '2023-09-26 09:30:41', NULL),
(9, 'aaaaaa', 'falnak', 'megyek', 'abc@abc.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'város', 2, '2023-10-11 13:35:27', '2023-10-11 13:35:27', NULL),
(10, 'user2', 'a', 'b', 'abc@aaa.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'aaaaa', 2, '2023-10-16 13:20:19', '2023-10-16 13:20:19', NULL),
(11, 'postman', 'post', 'man', 'postmanemail@aaaa.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'város', 2, '2023-10-16 13:25:17', '2023-10-16 13:25:17', NULL),
(13, 'postman', 'post', 'man', 'postmane@aaaa.com', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'város', 2, '2023-10-16 13:51:51', '2023-10-16 13:51:51', NULL),
(14, 'aaaaaaaaa', 'aaaaaaaaa', 'aaaaaaaaaa', 'aaaaa@aaaaa.aaaaa', '67ed8e80ce399188b15e9128b9777790ca6b6d1a63cb32d95a35f2a20d3ca00c', '123', 'aaaaaaaaa', 2, '2023-10-16 13:52:05', '2023-10-16 13:52:05', NULL);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT a táblához `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT a táblához `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
