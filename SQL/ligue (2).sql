-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 15 avr. 2022 à 13:45
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
  `idemploye` int(255) NOT NULL AUTO_INCREMENT,
  `dateajout` date DEFAULT NULL,
  `datesuppr` date DEFAULT NULL,
  `mailemploye` varchar(42) DEFAULT NULL,
  `nomemploye` varchar(42) DEFAULT NULL,
  `prenomemploye` varchar(42) DEFAULT NULL,
  `mdpemployé` varchar(42) DEFAULT NULL,
  `abilitation` int(42) DEFAULT NULL,
  `idligue` int(42) DEFAULT NULL,
  PRIMARY KEY (`idemploye`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligue`
--

DROP TABLE IF EXISTS `ligue`;
CREATE TABLE IF NOT EXISTS `ligue` (
  `idligue` int(255) NOT NULL AUTO_INCREMENT,
  `nomligue` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`idligue`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `ligue`
--

INSERT INTO `ligue` (`idligue`, `nomligue`) VALUES
(1, 'ligue1'),
(2, 'ligue2'),
(3, 'ligue5'),
(4, 'LIGUE6'),
(5, 'LIGUETEST');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
