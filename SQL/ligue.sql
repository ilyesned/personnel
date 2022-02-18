-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 18 fév. 2022 à 13:28
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `ligue`
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `idemploye` int(255) AUTO_INCREMENT,
  `dateajout` DATE,
  `datesuppr` DATE,
  `mailemploye` varchar(42) DEFAULT NULL,
  `nomemploye` varchar(42) DEFAULT NULL,
  `prenomemploye` varchar(42) DEFAULT NULL,
  `mdpemployé` varchar(42) DEFAULT NULL,
  `abilitation` varchar(42) DEFAULT NULL,
  `idligue` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`idemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligue`
--

DROP TABLE IF EXISTS `ligue`;
CREATE TABLE IF NOT EXISTS `ligue` (
  `idligue` int(255) AUTO_INCREMENT,
  `nomligue` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`idligue`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ligue`
--

INSERT INTO `ligue` (`idligue`, `nomligue`) VALUES
(1, 'ligue 1'),
(2, 'Flï¿½chettes'),
(3, 'TestLigue'),
(4, 'TestLigue'),
(5, 'Testligue1'),
(6, 'Flechettes'),
(7, 'TestLigue'),
(8, 'TestLigue'),
(9, 'Flechettes'),
(10, 'Testligue'),
(11, 'TestLigue'),
(12, 'Flï¿½chettes'),
(13, 'TestLigue'),
(14, 'TestLigue'),
(15, 'Testligue1'),
(16, 'Flechettes'),
(17, 'TestLigue'),
(18, 'TestLigue'),
(19, 'Flechettes'),
(20, 'TestLigue'),
(21, 'Flï¿½chettes'),
(22, 'TestLigue'),
(23, 'TestLigue'),
(24, 'Testligue1'),
(25, 'Flechettes'),
(26, 'TestLigue'),
(27, 'TestLigue'),
(28, 'Flechettes'),
(29, 'TestLigue'),
(30, 'ligue'),
(31, 'ligueTest');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
