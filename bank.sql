-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2015 at 06:23 AM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--
create database bank;
use bank;
-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `name` varchar(50) NOT NULL,
  `date` varchar(12) NOT NULL,
  `address` varchar(50) NOT NULL,
  `dob` varchar(12) NOT NULL,
  `accounttype` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `accno` varchar(12) NOT NULL,
  `Accbal` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`name`, `date`, `address`, `dob`, `accounttype`, `gender`, `accno`, `Accbal`) VALUES
('akshay', '11/19/15', 'nashik', '15/08/1947', 'savings', 'male', '1111111111', 12500),
('jitendra', '11/19/15', 'mumbai', '1/1/66', 'sb', 'male', '546', NULL),
('sujit', '11/19/15', 'mumbai', '15/08/1947', 'sb', 'male', '455', NULL),
('sujata', '11/19/15', 'mumbai', '01/01/68', 'sb', 'female', '555', 2000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
