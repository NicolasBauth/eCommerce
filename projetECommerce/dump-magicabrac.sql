-- SQL Dump
-- MySQL Workbench Community (GPL) version 6.3.8 CE build 1228 (64 bit)
--
-- Généré le :  Décembre 2016


--
-- Base de données :  MAGICABRAC
--

-- --------------------------------------------------------

--
-- ENGINE = InnoDB
-- DEFAULT CHARACTER SET = utf8
--


--
-- Suppression des tables existantes
--
-- SET FOREIGN_KEY_CHECKS=0;
DROP TABLE if exists `magicabrac`.`ligne`;
DROP TABLE if exists `magicabrac`.`traduction`;
DROP TABLE if exists `magicabrac`.`langue`;
DROP TABLE if exists `magicabrac`.`produit`;
DROP TABLE if exists `magicabrac`.`promotion`;
DROP TABLE if exists `magicabrac`.`categorie`;
DROP TABLE if exists `magicabrac`.`commande`;
DROP TABLE if exists `magicabrac`.`utilisateur`;
DROP TABLE if exists `magicabrac`.`image`;
-- SET FOREIGN_KEY_CHECKS=1;

--
-- Structure de la table PRODUIT
--

CREATE TABLE `magicabrac`.`produit` (
  `idProduit` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom` VARCHAR(70) NOT NULL,
  `dateCommercialisation` DATE NOT NULL,
  `prixUnitaire` DECIMAL NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `quantiteIndividuelle` VARCHAR(15) NOT NULL, 
  `quantiteEnStock` INT(5) NOT NULL,
  `id_promotion` INT(5) NOT NULL,
  `id_categorie` INT(5) NOT NULL);


--
-- Structure de la table IMAGE
--

CREATE TABLE `magicabrac`.`image` (
`idImage` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
`nom` VARCHAR(45) NOT NULL,
`chemin` VARCHAR(255) NOT NULL,
`id_produit` INT(5) NOT NULL);


--
-- Structure de la table PROMOTION
--

CREATE TABLE `magicabrac`.`promotion` (
  `idPromo` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `dateDeb` DATE NOT NULL,
  `dateFin` DATE NULL,
  `pourcentage` DECIMAL NOT NULL);


--
-- Structure de la table CATEGORIE
--

CREATE TABLE `magicabrac`.`categorie` (
  `idCategorie` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT);


--
-- Structure de la table TRADUCTION
--

CREATE TABLE `magicabrac`.`traduction` (
  `idTraduction` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `libelle` VARCHAR(45) NOT NULL,
  `id_categorie` INT(5) NOT NULL,
  `id_langue` INT(5) NOT NULL);


--
-- Structure de la table LANGUE
--

CREATE TABLE `magicabrac`.`langue` (
  `idLangue` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL);


--
-- Structure de la table LIGNE
--

CREATE TABLE `magicabrac`.`ligne` (
  `numero` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `quantite` INT(5) NOT NULL,
  `prixUnitaire` DECIMAL NOT NULL,
  `id_produit` INT(5) NOT NULL,
  `id_commande` INT(5) NOT NULL);


--
-- Structure de la table COMMANDE
--

CREATE TABLE `magicabrac`.`commande` (
  `numero` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `dateCommande` DATE NOT NULL,
  `id_utilisateur` INT(5) NOT NULL);


--
-- Structure de la table UTILISATEUR
--

CREATE TABLE `magicabrac`.`utilisateur` (
  `idUtilisateur` INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `pseudo` VARCHAR(45) NOT NULL,
  `telephone` INT(15) NULL,
  `email` VARCHAR(45) NOT NULL,
  `motDePasse` VARCHAR(45) NOT NULL,
  `dateNaissance` date NOT NULL,
  `rue` VARCHAR(90) NOT NULL,
  `numero` INT(5) NOT NULL,
  `ville` VARCHAR(45) NOT NULL,
  `codePostal` INT(10) NOT NULL,
  `pays` VARCHAR(45) NOT NULL);


--
-- Clés étrangères de la table PRODUIT
--

ALTER TABLE `magicabrac`.`produit` 
ADD FOREIGN KEY (`id_promotion`) 
  REFERENCES `magicabrac`.`promotion` (`idPromo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD FOREIGN KEY (`id_categorie`) 
  REFERENCES `magicabrac`.`categorie` (`idCategorie`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


--
-- Clés étrangères de la table LIGNE
--

ALTER TABLE `magicabrac`.`ligne` 
ADD FOREIGN KEY (`id_produit`)
  REFERENCES `magicabrac`.`produit` (`idProduit`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD FOREIGN KEY (`id_commande`)
  REFERENCES `magicabrac`.`commande` (`numero`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


--
-- Clés étrangères de la table TRADUCTION
--

ALTER TABLE `magicabrac`.`traduction`
ADD FOREIGN KEY (`id_categorie`)
  REFERENCES `magicabrac`.`categorie` (`idCategorie`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD FOREIGN KEY (`id_langue`)
  REFERENCES `magicabrac`.`langue` (`idLangue`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


--
-- Clés étrangères de la table COMMANDE
--

ALTER TABLE `magicabrac`.`commande` 
ADD FOREIGN KEY (`id_utilisateur`)
  REFERENCES `magicabrac`.`utilisateur` (`idUtilisateur`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


--
-- Clés étrangères de la table COMMANDE
--

ALTER TABLE `magicabrac`.`image` 
ADD FOREIGN KEY (`id_produit`) 
  REFERENCES `magicabrac`.`produit` (`idProduit`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
