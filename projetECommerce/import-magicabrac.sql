-- SQL Dump
-- MySQL Workbench Community (GPL) version 6.3.8 CE build 1228 (64 bit)
--
-- Généré le :  Décembre 2016


--
-- Base de données :  MAGICABRAC
--

-- --------------------------------------------------------


--
-- Contenu de table LANGUE
--

INSERT INTO `magicabrac`.`langue` (`idLangue`, `nom`) VALUES
(1, 'Français'),
(2, 'Anglais'),
(3, 'Allemand');


--
-- Contenu de table CATEGORIE
--

INSERT INTO `magicabrac`.`categorie` (`idCategorie`) VALUES
(1),(2),(3),(4),(5),(6);


--
-- Contenu de table PROMOTION
--

INSERT INTO `magicabrac`.`promotion` (`idPromo`, `dateDeb`, `dateFin`, `pourcentage`) VALUES
(1, '2016-10-10', null, 0.0),
(2, '2016-10-10', '2017-01-01', 10.0);


--
-- Contenu de table PRODUIT
--

INSERT INTO `magicabrac`.`produit` (`idProduit`, `nom`, `dateCommercialisation`, `prixUnitaire`, `description`, `quantiteIndividuelle`, `quantiteEnStock`, `id_promotion`, `id_categorie`) VALUES 
(1, 'Poudre de dragon', '2016-09-21', 14.50, '', '15gr', 200, 1, 1),
(2, 'Poudre de corne de licorne', '2016-09-21', 20.99, '', '15gr', 200, 1, 1),
(3, 'Poudre de perlimpinpin', '2016-09-21', 10.99, '', '15gr', 200, 1, 1),
(4, 'Poudre d’escampette', '2016-09-21', 17.99, '', '15gr', 200, 1, 1),
(5, 'Bave de crapaud', '2016-09-21', 8.99, '', '15cl', 200, 1, 1),
(6, 'Eau du loch ness', '2016-10-21', 12.50, '', '15cl', 200, 1, 1),
(7, 'Larmes de sirènes', '2016-10-21', 19.99, '', '15cl', 200), 1, 1,
(8, 'Sang de vampire', '2016-10-21', 13.50, '', '15cl', 200, 1, 1),
(9, 'Larmes de crocodiles', '2016-10-21', 18.50, '', '15cl', 200, 1, 1),

(10, 'Oeufs de Caille pourris', '2016-09-21', 5.99, '', '7 oeufs', 200, 1, 2),
(11, 'Oeuf de Dragon', '2016-09-21', 16.50, '', '1 oeuf', 200, 1, 2),
(12, 'Oeuf d’Ankylosaurus', '2016-09-21', 19.99, '', '1 oeuf', 200, 1, 2),
(14, 'Gemmes du petit Poucet', '2016-10-21', 5.00, '', '20 pierres', 200, 1, 2),
(15, 'Rubis de vision nocturne', '2016-10-21', 8.99, '', '5 pierres', 200, 1, 2),
(16, 'Oeuf de Xénormorphe', '2016-10-21', 12.50, '', '1 oeuf', 200, 1, 2),

(17, 'Pierre Philosophale', '2016-09-21', 2500.00, '', 'Objet unique', 1, 1, 3),
(18, 'La Lampe d’Aladin', '2016-09-21', 400.000,'', 'Objet unique', 1, 1, 3),
(19, 'L’Epée du Roi Arthur', '2016-09-21', 2200.00, '', 'Objet unique', 1, 1, 3),
(20, 'La Sainte Lance', '2016-09-21', 2100.00, '', 'Objet unique', 1, 1, 3),
(21, 'Le Saint Graal', '2016-09-21', 2500.00, '', 'Objet unique', 1, 1, 3),
(22, 'Le Miroir à Deux Faces', '2016-10-21', 350.00, '', 'Objet unique', 1, 1, 3),
(24, 'Le Coeur de l’Océan', '2016-10-21', 1200.00, '', 'Objet unique', 1, 1, 3),
(25, 'La Cape d’invisibilité', '2016-10-21', 300.00, '', 'Objet unique', 1, 1, 3),
(26, 'La Panthère Rose', '2016-10-21', 1500.00, '', 'Objet unique', 1, 1, 3),


(27, 'Bois de rose et crin de Licorne', '2016-09-21', 51.50, '', '1 baguette', 200, 1, 4),
(28, 'Bois de Cerisier noir et ventricule de Dragon', '2016-09-21', 66.99, '', '1 baguette', 200, 1, 4),
(29, 'Bois de rose et corne de Buffalo', '2016-10-21', 54.99, '', '1 baguette', 200, 1, 4),
(30, 'Bois de Bloodwood et plume de Phénix', '2016-10-21', 78.50, '', '1 baguette', 200, 1, 4),
(31, 'Bois d’Ebène et plume d’Oiseau-Tonnerre', '2016-10-21', 69.50, '', '1 baguette', 200, 1, 4),
(32, 'Bois de Frêne épineux et de moustache de Troll', '2016-10-21', 53.00, '', '1 baguette', 200, 1, 4),
(33, 'Bois de Palmier noir et épine de monstre du Fleuve Blanc', '2016-10-21', 76.99, '', '1 baguette', 200, 1, 4),
(34, 'Bois de Chêne rouge et plume de Phénix', '2016-10-21', 80.00, '', '1 baguette', 200, 1, 4),

(35, 'Grimoire de Merlin', '2016-09-21', 92.00, '', '1 exemplaire', 200, 1, 5),
(36, 'Carte de l’Île aux trésors', '2016-09-21', 23.50, '', '1 exemplaire', 200, 1, 5),
(37, 'Parchemin de Jean Lafitte', '2016-10-21', 34.99, '', '1 exemplaire', 200, 1, 5),
(38, 'Carte du maraudeur', '2016-10-21', 87.00, '', '1 exemplaire', 200, 1, 5),

(39, 'Mandragore', '2016-09-21', 17.00, '', '1 plante', 200, 1, 6),
(40, 'Plante à Chat', '2016-09-21', 9.50, '', '1 plante', 200, 1, 6),
(41, 'Pissendore', '2016-09-21', 7.99, '', '3 plantes', 200, 1, 6),
(42, 'Tue-Loup', '2016-10-21', 19.99, '', '1 plante', 200, 1, 6),
(43, 'Filet du Diable', '2016-10-21', 31.00, '', '1 plante', 200, 1, 6),
(44, 'Champignon Vénéneux Sauteur', '2016-10-21', 3.50, '', '2 champignons', 200, 1, 6);


--
-- Contenu de table TRADUCTION
--

INSERT INTO `magicabrac`.`traduction` (`idTraduction`, `libelle`, `id_categorie`, `id_langue`) VALUES
(1, 'Poudres et Potions', 1, 1), 
(2, 'Pierres Précieuses et Oeufs', 2, 1), 
(3, 'Objets uniques', 3, 1), 
(4, 'Baguettes Magiques', 4, 1), 
(5, 'Grimoires et Parchemins', 5, 1), 
(6, 'Plantes et Champignons', 6, 1),
(7, 'Poudres et Potions', 1, 2), 
(8, 'Poudres et Potions', 2, 2), 
(9, 'Poudres et Potions', 3, 2), 
(10, 'Poudres et Potions', 4, 2), 
(11, 'Poudres et Potions', 5, 2), 
(12, 'Poudres et Potions', 6, 2);


INSERT INTO `magicabrac`.`utilisateur` (`idUtilisateur`, `nom`, `prenom`, `pseudo`, `telephone`, `email`, `motDePasse`, `dateNaissance`, `rue`, `numero`, `ville`, `codePostal`, `pays`) VALUES
(1, 'Denis', 'Jennifer', 'Brodylive', 0472757565, 'brodylive@gmail.com', '456456', '1992-11-04', 'Rue de Mons', 10, 'Estinnes', 7120, 'Belgique')

