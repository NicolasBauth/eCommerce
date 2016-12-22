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

INSERT INTO `magicabrac`.`categorie` (`idCategorie`, `icon`) VALUES
(1, 'flask'),
(2, 'diamond'),
(3, 'key'),
(4, 'magic'),
(5, 'book'),
(6, 'leaf');


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
(1, 'Poudre de dragon', '2016-09-21', 14.50, 'Faite à partir de sang de dragon. Cet objet est indispensable pour réaliser des effets pyrotechniques faciles.', '15gr', 200, 1, 1),
(2, 'Poudre de corne de licorne', '2016-09-22', 20.99, 'Véritable poudre de licorne fait à partir de l\'intérieur de la corne. Elle sert principalement à lors des sortilèges de bonheur.', '15gr', 200, 1, 1),
(3, 'Poudre de perlimpinpin', '2016-09-23', 10.99, 'Faite à partir d\'illusions, elle est utilisable pour toutes vos potions, sortilèges et effets.', '15gr', 200, 1, 1),
(4, 'Poudre d’escampette', '2016-09-30', 17.99, 'Cette poudre vous permettra d\'invoquer le pouvoir de Flash en un rien de temps. Les effets se dissipent dans l\'heure suivante.', '15gr', 200, 1, 1),
(5, 'Bave de crapaud', '2016-10-10', 8.99, 'Faite à partir de bave d\'Incilius periglenes. Ce liquide sert pour bon nombre de préparations.', '15cl', 200, 1, 1),
(6, 'Eau du loch ness', '2016-11-12', 12.50, 'Eau puissée au fond du Loch Ness, elle permet de purifier les monstres.', '15cl', 200, 1, 1),
(7, 'Larmes de sirènes', '2016-11-21', 19.99, 'Récoltées à la main, ces larmes sont précieuses pour entendre le chant des sirènes et respirer sous l\'eau.', '10cl', 200, 1, 1),
(8, 'Sang de vampire', '2016-12-07', 13.50, 'Ce liquide est indispensable pour effacer les rides et gagner quelques années de vie. On estime une année par ampoule.', '2 x 7cl', 200, 1, 1),
(9, 'Larmes de crocodiles', '2016-12-13', 18.50, 'Ces larmes sont très dangeureuse, elles mordent les yeux lorsqu\'elles entrent en contact avec.', '10cl', 200, 1, 1),

(10, 'Oeufs de Caille pourris', '2016-09-10', 5.99, 'Ces oeufs servent de base à la majorité des préparations.', '7 oeufs', 200, 1, 2),
(11, 'Oeuf de Dragon', '2016-09-18', 16.50, 'Chaque oeuf de dragon est scellé par le froid. Pour le faire éclore il faudra le jeter dans le feu.', '1 oeuf', 200, 1, 2),
(12, 'Oeuf d’Ankylosaurus', '2016-10-08', 19.99, 'Les oeuf de dinosaure sont assez courant, mais ceux d\'Ankylosaurus on la propriété de guérir et d\'immuniser la personne qui le mange.', '1 oeuf', 200, 1, 2),
(14, 'Gemmes du petit Poucet', '2016-11-28', 5.00, 'Ce sac de gemmes vous permettra de vous téléporter entre deux pierres de celui-ci. Il suffit de réciter l\'incantation de téléportation et de choisir la destination.', '20 pierres', 200, 1, 2),
(15, 'Rubis de vision nocturne', '2016-11-30', 8.99, 'Ces rubis ont la propriété incroyable de vous donner la vision nocturne infrarouge si vous les placer devant vos yeux. Petit conseil : Demandez à votre opticien d\'en faire des lunettes.', '5 pierres', 200, 1, 2),
(16, 'Oeuf de Xénormorphe', '2016-12-21', 12.50, 'Ce oeuf a deux utilisations, soit vous le faites éclore en le couvant pendant un mois ; soit vous l\'utilisez dans une préparation', '1 oeuf', 200, 1, 2),

(17, 'La Pierre Philosophale', '2016-09-22', 25000.00, 'Cette pierre change les métaux vils en métaux précieux, guérit les maladies et prolonge la vie.', 'Objet unique', 1, 1, 3),
(18, 'La Lampe d’Aladin', '2016-09-26', 4000.00,'La lampe merveilleuse vous accordera 3 voeux dès lors que vous la frotterez', 'Objet unique', 1, 1, 3),
(19, 'Excalibur', '2016-09-27', 22000.00, 'Cette épée magique a appartenu au Roi Arthur, elle est incassable et tranche toute matière. Son fourreau protège son porteur de toute blessure.', 'Objet unique', 1, 1, 3),
(20, 'La Sainte Lance', '2016-10-13', 21000.00, 'Cette lance est une vieille relique, elle ne possède qu\'une vague symbolique religieuse et est en général mise en décoraction par son acquéreur. D\'après les légendes, cette lance aura transpercé le flanc droit d\'un grand magicien.', 'Objet unique', 1, 1, 3),
(21, 'Le Saint Graal', '2016-10-20', 25000.00, 'Ce gobelet usé est une vieille relique qui transforme tout liquide en vin. L\'abus d\'alcool est dangereux pour la santé, consommez avec modération.', 'Objet unique', 1, 1, 3),
(22, 'Le Miroir à Deux Faces', '2016-11-09', 3500.00, 'Le miroir à deux faces vous permettra de communiquer avec l\'au-delà. Cet objet unique fut possédé par bon nombre de sorciers et les as tous conduit à la folie.', 'Objet unique', 1, 1, 3),
(24, 'Le Coeur de l’Océan', '2016-11-21', 12000.00, 'Ce bijoux inestimable est désormais publique, après l\'avoir réupéré de l\'épave du Titanic, il fut mis en vente. Il ne possède aucun pouvoir, mais quiquonque le possède fait corps avec l\'eau.', 'Objet unique', 1, 1, 3),
(25, 'La Cape d’invisibilité', '2016-12-01', 3000.00, 'Ce vêtement possède la particularité de rendre son porteur invisble.', 'Objet unique', 1, 1, 3),
(26, 'La Panthère Rose', '2016-12-12', 15000.00, 'Cette pierre a la particularité de renfermer l\'âme d\'une panthère. Celui qui possède cette pierre ', 'Objet unique', 1, 1, 3),


(27, 'Bois de rose et crin de Licorne', '2016-09-21', 51.50, 'Cette baguette magique est très fidèle, peu puissante mais rarement sujette à des blocages ou a des fluctuations.', '1 baguette', 200, 1, 4),
(28, 'Bois de Cerisier noir et ventricule de Dragon', '2016-09-21', 66.99, ' Elle possède un pouvoir mortel, nécessite une maîtrise de soi et une force mentale exceptionnelle. Elle est puissant et facilite l\'apprentissage de sortilèges mais est souvent générateur d\'accidents', '1 baguette', 200, 1, 4),
(29, 'Bois de rose et corne de Buffalo', '2016-10-11', 54.99, 'Cette baguette magique permet de réaliser les meilleur sotilège avec élégance et force.', '1 baguette', 200, 1, 4),
(30, 'Bois de Bloodwood et plume de Phénix', '2016-10-11', 78.50, 'Cette baguette offre un large éventail de capacités magiques.', '1 baguette', 200, 1, 4),
(31, 'Bois d’Ebène et plume d’Oiseau-Tonnerre', '2016-11-21', 69.50, 'Elle est faite pour les propriétaires fidèle à leurs convictions et qui ont le courage d\'être eux-mêmes. Elle est cependant difficile à manier', '1 baguette', 200, 1, 4),
(32, 'Bois de Frêne épineux et de moustache de Troll', '2016-11-21', 53.00, 'Cette baguette magique est faite pour les débutants dans les sortilèges noirs. Elle est difficile à manier mais une fois maitrisée, vous permet de réaliser de grandes choses.', '1 baguette', 200, 1, 4),
(33, 'Bois de Palmier noir et épine de monstre du Fleuve Blanc', '2016-12-13', 76.99, 'Elle produit des sortilèges puissants et élégants.', '1 baguette', 200, 1, 4),
(34, 'Bois de Chêne rouge et plume de Phénix', '2016-12-13', 80.00, 'Idéal pour le duel, aime les sorciers rapides, convient parfaitement aux sorciers à l\'esprit vif et adaptable.', '1 baguette', 200, 1, 4),

(35, 'Grimoire de Merlin', '2016-09-18', 92.00, 'Ce grimoire contient la majorité des incantations, potions, préparations et conseils rassemblés par le conseil de Merlin ces derniers millénaires.', '1 exemplaire', 200, 1, 5),
(36, 'Carte de l’Île aux trésors', '2016-09-29', 23.50, 'L\'île aux trésors possède toutes les ressources nécessaires aux magicien. Afin de vous y rendre, vous pouvez acheter la dernière carte et découvrir toutes les ressources de l\'île une fois sur place.', '1 exemplaire', 200, 1, 5),
(37, 'Parchemin de Jean Lafitte', '2016-11-30', 34.99, 'Ce parchemin est quelque peu hors norme. On y décrit tous les tours de voleur ainsi que les îles des pirates des siècles passés.', '1 exemplaire', 200, 1, 5),
(38, 'Carte du maraudeur', '2016-12-21', 87.00, 'Cette carte vous permettra de savoir qui est où et où est qui. Chaque carte du maraudeur est réinitialisable pour votre maison, il suffit de la connecter à votre esprit.', '1 exemplaire', 200, 1, 5),

(39, 'Mandragore', '2016-10-21', 17.00, 'Cette plante aux propriété magiques et hallucinogènes peuvent vous faire entrer dans d\'autres dimensions de l\'univers.', '1 plante', 200, 1, 6),
(40, 'Saule cogneur', '2016-10-22', 9.50, 'Nous vendons des plants de saule cogneur pour protéger votre maison des intrus.', '1 plante', 200, 1, 6),
(41, 'Tue-Loup', '2016-11-23', 19.99, 'Ce plante contient un poison très fort que vous pouvez utiliser dans vos préparations', '1 plante', 200, 1, 6),
(42, 'Filet du Diable', '2016-12-12', 31.00, 'Cette plante est pratique à mettre dans votre cave afin de protéger coffre fort et autres des intrus.', '1 plante', 200, 1, 6),
(43, 'Champignon Vénéneux Sauteur', '2016-12-21', 3.50, 'Ingrédient de potions, il est trés complexe à maitriser mais possède d\'inombrables vertus.', '2 champignons', 200, 1, 6);


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

(7, 'Powders and Potions', 1, 2), 
(8, 'Gemstones and Eggs', 2, 2), 
(9, 'Single Items', 3, 2), 
(10, 'Magic Wands', 4, 2), 
(11, 'Grimoires and Parchments', 5, 2), 
(12, 'Plants and Mushrooms', 6, 2),

(13, 'Pulver und Tränke', 1, 3), 
(14, 'Gems und Eier', 2, 3), 
(15, 'Einzigartige Objekte', 3, 3), 
(16, 'Stäbe', 4, 3), 
(17, 'Tomes und Blättert', 5, 3), 
(18, 'Pflanzen und Pilze', 6, 3);


--
-- Contenu de table UTILISATEUR
--

INSERT INTO `magicabrac`.`utilisateur` (`idUtilisateur`, `nom`, `prenom`, `pseudo`, `telephone`, `email`, `motDePasse`, `dateNaissance`, `rue`, `numero`, `ville`, `codePostal`, `pays`) VALUES
(1, 'Denis', 'Jennifer', 'Brodylive', 0472757565, 'brodylive@gmail.com', '456456', '1992-11-04', 'Rue de Mons', 10, 'Estinnes', 7120, 'Belgique');


--
-- Contenu de la table IMAGE
--

INSERT INTO `magicabrac`.`image` (`idImage`, `nom`, `chemin`, `id_produit`) VALUES
(1, 'Poudre de dragon', 'poudre-dragon.png', 1),
(2, 'Poudre de corne de licorne', 'poudre-licorne.png', 2),
(3, 'Poudre de perlimpinpin', 'poudre-perlimpinpin.png', 3),
(4, 'Poudre d’escampette', 'poudre-escampette.png', 4),
(5, 'Bave de crapaud', 'bave-crapaud.png', 5),
(6, 'Eau du loch ness', 'eau-loch-ness.png', 6),
(7, 'Larmes de sirènes', 'larmes-sirenes.png', 7),
(8, 'Sang de vampire', 'sang-vampire.png', 8),
(9, 'Larmes de crocodiles', 'larmes-crocodiles.jpg', 9),

(10, 'Oeufs de Caille pourris', 'oeuf-caille.png', 10),
(11, 'Oeuf de Dragon', 'oeuf-dragon.png', 11),
(12, 'Oeuf d’Ankylosaurus', 'oeuf-ankylo.png', 12),
(14, 'Gemmes du petit Poucet', 'gemmes-petit-poucet.png', 14),
(15, 'Rubis de vision nocturne', 'rubis-vision-nocturne.png', 15),
(16, 'Oeuf de Xénomorphe', 'oeuf-xenomorphe.png', 16),

(17, 'La Pierre Philosophale', 'pierre-philosophale.png', 17),
(18, 'La Lampe d’Aladin', 'lampe-aladdin.png', 18),
(19, 'Excalibur', 'excalibur.png', 19),
(20, 'La Sainte Lance', 'sainte-lance.png', 20),
(21, 'Le Saint Graal', 'saint-graal.png', 21),
(22, 'Le Miroir à Deux Faces', 'miroir-deux-faces.png', 22),
(24, 'Le Coeur de l’Océan', 'coeur-ocean.png', 24),
(25, 'La Cape d’invisibilité', 'cape-invisibilite.png', 25),
(26, 'La Panthère Rose', 'pink-panther.png', 26),

(27, 'Bois de rose et crin de Licorne', 'rose-licorne.png', 27),
(28, 'Bois de Cerisier noir et ventricule de Dragon', 'cerisier-dragon.png', 28),
(29, 'Bois de rose et corne de Buffalo', 'rose-buffalo.png', 29),
(30, 'Bois de Bloodwood et plume de Phénix', 'bloodwood-phenix.png', 30),
(31, 'Bois d’Ebène et plume d’Oiseau-Tonnerre', 'ebene-oiseau-tonnerre.png' , 31),
(32, 'Bois de Frêne épineux et de moustache de Troll', 'frene-troll.png', 32),
(33, 'Bois de Palmier noir et épine de monstre du Fleuve Blanc', 'palmier-monstre.png', 33),
(34, 'Bois de Chêne rouge et plume de Phénix', 'chene-phenix.png', 34),

(35, 'Grimoire de Merlin', 'grimoire-merlin-1.gif', 35),
(36, 'Carte de l’Île aux trésors', 'carte-ile-tresor.png', 36),
(37, 'Parchemin de Jean Lafitte', 'parchemin-jean-lafitte.png', 37),
(38, 'Carte du maraudeur', 'carte-maraudeur.png', 38),

(39, 'Mandragore', 'mandragore-1.gif', 39),
(40, 'Saule cogneur', 'saule-cogneur.jpg', 40),
(41, 'Tue-Loup', 'tue-loup.png', 41),
(42, 'Filet du Diable', 'filet-diable.png', 42),
(43, 'Champignon Vénéneux Sauteur', 'champignon-veneneux-sauteur-1.png', 43),
(44, 'Champignon Vénéneux Sauteur', 'champignon-veneneux-sauteur-2.png', 43),
(45, 'Grimoire de Merlin', 'grimoire-merlin-2.png', 35),
(46, 'Mandragore', 'mandragore-2.jpg', 39);



