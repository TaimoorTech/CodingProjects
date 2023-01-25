-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2023 at 05:09 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taxgo_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Phone Number` varchar(50) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`Id`, `Name`, `Email`, `Phone Number`, `Date`, `Time`) VALUES
(6, 'irtaza ', 'irtazaarain14@gmail.com', '0314', '22/10/2023', '11:00 AM');

-- --------------------------------------------------------

--
-- Table structure for table `property_tax`
--

CREATE TABLE `property_tax` (
  `Id` int(11) NOT NULL,
  `Property Type` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Land Area` varchar(50) NOT NULL,
  `Covered Area` varchar(50) NOT NULL,
  `Construction Type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `property_tax`
--

INSERT INTO `property_tax` (`Id`, `Property Type`, `City`, `Address`, `Land Area`, `Covered Area`, `Construction Type`) VALUES
(1, 'Commercial Plot', 'Karachi', 'Korangi 309/C Lakhnow Society', '2500', '2000', 'RCC');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_history`
--

CREATE TABLE `transaction_history` (
  `Id` int(11) NOT NULL,
  `Tax Type` varchar(50) NOT NULL,
  `Year` varchar(50) NOT NULL,
  `Month` varchar(50) NOT NULL,
  `Credit Card Number` varchar(50) NOT NULL,
  `Expiry Date` varchar(50) NOT NULL,
  `CVV Code` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Date` varchar(11) NOT NULL,
  `Time` varchar(50) NOT NULL,
  `Method` varchar(50) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_history`
--

INSERT INTO `transaction_history` (`Id`, `Tax Type`, `Year`, `Month`, `Credit Card Number`, `Expiry Date`, `CVV Code`, `Name`, `Date`, `Time`, `Method`, `Amount`) VALUES
(1, 'Property', '2023', 'June', '2224555869698477', '886', '07/2024', 'irtaza ', '22-01-2023', '19:24', 'credit card', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL,
  `First Name` varchar(50) NOT NULL,
  `Last Name` varchar(50) NOT NULL,
  `CNIC` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Number` varchar(50) NOT NULL,
  `Image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`Id`, `First Name`, `Last Name`, `CNIC`, `Email`, `Password`, `Number`, `Image`) VALUES
(1, 'irtaza ', 'arain', '4410357474177', 'irtazaarain14@gmail.com', '12345678', '', 'http://192.168.1.107/project/User_images/IMG40158618.jpg'),
(4, 'Daniyal ', 'Amir', '4410367454188', 'Daniyalamir@gmail.com', '22228888', '', 'http://192.168.1.107/project/User_images/IMG1217247462.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_tax`
--

CREATE TABLE `vehicle_tax` (
  `Id` int(11) NOT NULL,
  `Vehicle Class` varchar(50) NOT NULL,
  `Purchase Type` varchar(50) NOT NULL,
  `Ownership Status` varchar(50) NOT NULL,
  `Price` varchar(50) NOT NULL,
  `Seating Capacity` varchar(50) NOT NULL,
  `Import/Purchase Date` varchar(50) NOT NULL,
  `Engine Size` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle_tax`
--

INSERT INTO `vehicle_tax` (`Id`, `Vehicle Class`, `Purchase Type`, `Ownership Status`, `Price`, `Seating Capacity`, `Import/Purchase Date`, `Engine Size`) VALUES
(3, 'Car', 'Imported', 'Owner', '2050000', '4', '11/02/2019', '1000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `property_tax`
--
ALTER TABLE `property_tax`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `transaction_history`
--
ALTER TABLE `transaction_history`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `vehicle_tax`
--
ALTER TABLE `vehicle_tax`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `property_tax`
--
ALTER TABLE `property_tax`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaction_history`
--
ALTER TABLE `transaction_history`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user_info`
--
ALTER TABLE `user_info`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vehicle_tax`
--
ALTER TABLE `vehicle_tax`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
