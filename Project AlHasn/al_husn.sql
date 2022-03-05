-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 19, 2021 at 09:38 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `al_husn`
--

-- --------------------------------------------------------

--
-- Table structure for table `a_tour_gride`
--

CREATE TABLE `a_tour_gride` (
  `Id` int(11) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `DAYS_WORK` int(11) NOT NULL,
  `phone` text NOT NULL,
  `cost` double NOT NULL,
  `persistent` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `a_tour_gride`
--

INSERT INTO `a_tour_gride` (`Id`, `Name`, `DAYS_WORK`, `phone`, `cost`, `persistent`) VALUES
(57, 'Abdalkreem', 22, '0988322', 100, 0),
(58, 'khaled', 23, '095675675', 30, 0),
(59, 'Amar', 22, '09567545', 50, 0);

-- --------------------------------------------------------

--
-- Table structure for table `days`
--

CREATE TABLE `days` (
  `Days_work` int(11) NOT NULL,
  `Sunday` tinyint(1) DEFAULT NULL,
  `Monday` tinyint(1) DEFAULT NULL,
  `Tuesday` tinyint(1) DEFAULT NULL,
  `Wednesday` tinyint(1) DEFAULT NULL,
  `Thursday` tinyint(1) DEFAULT NULL,
  `Friday` tinyint(1) DEFAULT NULL,
  `Saturday` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `days`
--

INSERT INTO `days` (`Days_work`, `Sunday`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`) VALUES
(22, 1, 1, 1, 0, 0, 0, 0),
(23, 0, 1, 0, 0, 0, 0, 0),
(24, 1, 1, 1, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`id`, `Image`) VALUES
(1, 'E:\\\\a\\\\a.jpg'),
(2, 'E:\\\\a\\\\b.jpg'),
(3, 'E:\\\\a\\\\c.jpg'),
(4, 'E:\\\\a\\\\d.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `visitor`
--

CREATE TABLE `visitor` (
  `id` int(11) NOT NULL,
  `Name` varchar(70) NOT NULL,
  `Kind_of_visit` varchar(100) NOT NULL,
  `A_Tour_Gride` varchar(100) NOT NULL,
  `Bill` double DEFAULT NULL,
  `Time_IN` datetime DEFAULT NULL,
  `Time_OUT` datetime DEFAULT NULL,
  `kindcost` double NOT NULL,
  `idtour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `visitor`
--

INSERT INTO `visitor` (`id`, `Name`, `Kind_of_visit`, `A_Tour_Gride`, `Bill`, `Time_IN`, `Time_OUT`, `kindcost`, `idtour`) VALUES
(35, 'Ahamd', 'Round', 'Abdalkreem', 1400, '2021-01-19 22:09:28', '2021-01-19 22:17:16', 100, 57);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `a_tour_gride`
--
ALTER TABLE `a_tour_gride`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `days`
--
ALTER TABLE `days`
  ADD PRIMARY KEY (`Days_work`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `visitor`
--
ALTER TABLE `visitor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `a_tour_gride`
--
ALTER TABLE `a_tour_gride`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT for table `days`
--
ALTER TABLE `days`
  MODIFY `Days_work` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `visitor`
--
ALTER TABLE `visitor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
