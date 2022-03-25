CREATE DATABASE IF NOT EXISTS `LIGUES` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `LIGUES`;

DROP TABLE IF EXISTS `employe`;
CREATE TABLE IF NOT EXISTS `employe` (
  `idemploye` int(255) NOT NULL AUTO_INCREMENT,
  `dateajout` varchar(42) DEFAULT NULL,
  `datesuppr` varchar(42) DEFAULT NULL,
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
  `idligue` int(255) NOT NULL AUTO_INCREMENT,
  `nomligue` varchar(42) DEFAULT NULL,
  PRIMARY KEY (`idligue`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;