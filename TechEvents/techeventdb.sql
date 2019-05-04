-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 04 mai 2019 à 12:57
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `techeventdb`
--

-- --------------------------------------------------------

--
-- Structure de la table `actualite`
--

DROP TABLE IF EXISTS `actualite`;
CREATE TABLE IF NOT EXISTS `actualite` (
  `numActu` int(11) NOT NULL AUTO_INCREMENT,
  `dateActu` date NOT NULL,
  `imageActu` text NOT NULL,
  `descActu` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  PRIMARY KEY (`numActu`),
  KEY `idEvent` (`idEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idCom` int(11) NOT NULL AUTO_INCREMENT,
  `textCom` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  `numActu` int(11) NOT NULL,
  PRIMARY KEY (`idCom`),
  KEY `idEvent` (`idEvent`),
  KEY `numActu` (`numActu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `idEvent` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `capaciteMax` int(11) NOT NULL,
  `capaciteMin` int(11) NOT NULL,
  `dateEvent` date NOT NULL,
  `duree` int(11) NOT NULL,
  `idSponsor` int(11) NOT NULL,
  `idLoc` int(11) NOT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `idLoc` (`idLoc`),
  KEY `idSponsor` (`idSponsor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

DROP TABLE IF EXISTS `localisation`;
CREATE TABLE IF NOT EXISTS `localisation` (
  `idLoc` int(11) NOT NULL AUTO_INCREMENT,
  `ville` varchar(20) NOT NULL,
  `adresse` text NOT NULL,
  PRIMARY KEY (`idLoc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `localisation`
--

INSERT INTO `localisation` (`idLoc`, `ville`, `adresse`) VALUES
(1, 'tunis', 'chargia 2');

-- --------------------------------------------------------

--
-- Structure de la table `organisation`
--

DROP TABLE IF EXISTS `organisation`;
CREATE TABLE IF NOT EXISTS `organisation` (
  `idEvent` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idEvent`,`idUser`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `idReclam` int(11) NOT NULL AUTO_INCREMENT,
  `textReclam` text NOT NULL,
  `idEvent` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idReclam`),
  KEY `idEvent` (`idEvent`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `idEvent` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idEvent`,`idUser`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE IF NOT EXISTS `sponsor` (
  `idSponsor` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `logo` text NOT NULL,
  PRIMARY KEY (`idSponsor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sponsor`
--

INSERT INTO `sponsor` (`idSponsor`, `nom`, `logo`) VALUES
(1, 'testspons', '');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `dateNaiss` date DEFAULT NULL,
  `sexe` varchar(10) NOT NULL,
  `adresse` text NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'SimpleUser',
  `confirmationCode` varchar(20) NOT NULL,
  `confirmation` tinyint(1) NOT NULL DEFAULT '0',
  `active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `nom`, `prenom`, `dateNaiss`, `sexe`, `adresse`, `email`, `password`, `role`, `confirmationCode`, `confirmation`, `active`) VALUES
(1, 'jeddy', 'aymen', NULL, '', 'tunis', 'aymen@gmail.com', '123', '', '', 0, 0),
(2, 'ben salah', 'ahmed', NULL, '', 'tunis', 'ahmed@gmail.com', '123456', '', '', 0, 0),
(3, 'test', 'test', NULL, '', 'test', 'test@test.com', '7845', '', '', 0, 0),
(4, 'test2', 'test2', NULL, '', 'test2', 'test2', 'test2', '', '', 0, 0),
(5, 'ahmmed', 'ben ahmed ', NULL, '', 'tunis', 'ahmend@gmail.com', '123456', '', '', 0, 0),
(6, 'admin', 'admin', '1995-06-06', 'Homme', 'Tunis', 'aymen.jeddey@esprit.tn', '123456', 'Admin', '', 1, 1),
(10, 'esprit7', 'esprit7', '2019-05-14', 'Homme', 'chargia 2', 'aymenjeddey@gmail.com', '123', 'SimpleUser', '251124', 0, 0);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `actualite`
--
ALTER TABLE `actualite`
  ADD CONSTRAINT `actualite_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`);

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `commentaire_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`),
  ADD CONSTRAINT `commentaire_ibfk_2` FOREIGN KEY (`numActu`) REFERENCES `actualite` (`numActu`);

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `evenement_ibfk_1` FOREIGN KEY (`idLoc`) REFERENCES `localisation` (`idLoc`),
  ADD CONSTRAINT `evenement_ibfk_2` FOREIGN KEY (`idSponsor`) REFERENCES `sponsor` (`idSponsor`);

--
-- Contraintes pour la table `organisation`
--
ALTER TABLE `organisation`
  ADD CONSTRAINT `organisation_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`),
  ADD CONSTRAINT `organisation_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `reclamation_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`),
  ADD CONSTRAINT `reclamation_ibfk_2` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`idEvent`) REFERENCES `evenement` (`idEvent`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
