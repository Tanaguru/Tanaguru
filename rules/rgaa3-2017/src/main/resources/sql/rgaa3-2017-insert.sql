INSERT IGNORE INTO `REFERENCE` (`Cd_Reference`, `Description`, `Label`, `Url`, `Rank`, `Id_Default_Level`) VALUES
('Rgaa32017', NULL, 'Rgaa 3-2017', 'http://references.modernisation.gouv.fr/rgaa/criteres.html', 2001, 2);

INSERT IGNORE INTO `TGSI_REFERENTIAL` (`Code`, `Label`) VALUES
('Rgaa32017', 'Rgaa 3-2017');

INSERT IGNORE INTO `THEME` (`Cd_Theme`, `Description`, `Label`, `Rank`) VALUES
('Rgaa32017-1', NULL, 'Images', 1),
('Rgaa32017-2', NULL, 'Cadres', 2),
('Rgaa32017-3', NULL, 'Couleurs', 3),
('Rgaa32017-4', NULL, 'Multimédia', 4),
('Rgaa32017-5', NULL, 'Tableaux', 5),
('Rgaa32017-6', NULL, 'Liens', 6),
('Rgaa32017-7', NULL, 'Scripts', 7),
('Rgaa32017-8', NULL, 'Éléments Obligatoires', 8),
('Rgaa32017-9', NULL, 'Structuration de linformation', 9),
('Rgaa32017-10', NULL, 'Présentation de linformation', 10),
('Rgaa32017-11', NULL, 'Formulaires', 11),
('Rgaa32017-12', NULL, 'Navigation', 12),
('Rgaa32017-13', NULL, 'Consultation', 13);

INSERT IGNORE INTO `CRITERION` (`Cd_Criterion`, `Description`, `Label`, `Url`, `Rank`) VALUES
('Rgaa32017-1-1', 'Chaque image a-t-elle une alternative textuelle ?', '1.1', '', 1),
('Rgaa32017-1-2', 'Pour chaque image de décoration ayant une alternative textuelle, cette alternative est-elle vide ?', '1.2', '', 2),
('Rgaa32017-1-3', 'Pour chaque image porteuse dinformation ayant une alternative textuelle, cette alternative est-elle pertinente (hors cas particuliers) ?', '1.3', '', 3),
('Rgaa32017-1-4', 'Pour chaque image utilisée comme CAPTCHA ou comme image-test, ayant une alternative textuelle, cette alternative permet-elle didentifier la nature et la fonction de limage ?', '1.4', '', 4),
('Rgaa32017-1-5', 'Pour chaque image utilisée comme CAPTCHA, une solution daccès alternatif au contenu ou à la fonction du CAPTCHA est-elle présente ?', '1.5', '', 5),
('Rgaa32017-1-6', 'Chaque image porteuse dinformation a-t-elle, si nécessaire, une description détaillée ?', '1.6', '', 6),
('Rgaa32017-1-7', 'Pour chaque image porteuse dinformation ayant une description détaillée, cette description est-elle pertinente ?', '1.7', '', 7),
('Rgaa32017-1-8', 'Chaque image texte, en labsence dun mécanisme de remplacement, doit si possible être remplacée par du texte stylé. Cette règle est-elle respectée (hors cas particuliers) ?', '1.8', '', 8),
('Rgaa32017-1-9', 'Chaque image texte doit si possible être remplacée par du texte stylé. Cette règle est-elle respectée (hors cas particuliers) ?', '1.9', '', 9),
('Rgaa32017-1-10', 'Chaque légende dimage est-elle, si nécessaire, correctement reliée à limage correspondante ?', '1.10', '', 10),
('Rgaa32017-2-1', 'Chaque cadre en ligne a-t-il un titre de cadre ?', '2.1', '', 11),
('Rgaa32017-2-2', 'Pour chaque cadre en ligne ayant un titre de cadre, ce titre de cadre est-il pertinent ?', '2.2', '', 12),
('Rgaa32017-3-1', 'Dans chaque page Web, linformation ne doit pas être donnée uniquement par la couleur. Cette règle est-elle respectée ?', '3.1', '', 13),
('Rgaa32017-3-2', 'Dans chaque page Web, linformation ne doit pas être donnée uniquement par la couleur. Cette règle est-elle implémentée de façon pertinente ?', '3.2', '', 14),
('Rgaa32017-3-3', 'Dans chaque page Web, le contraste entre la couleur du texte et la couleur de son arrière-plan est-il suffisamment élevé (hors cas particuliers) ?', '3.3', '', 15),
('Rgaa32017-3-4', 'Dans chaque page Web, le contraste entre la couleur du texte et la couleur de son arrière-plan est-il amélioré (hors cas particuliers) ?', '3.4', '', 16),
('Rgaa32017-4-1', 'Chaque média temporel pré-enregistré a-t-il, si nécessaire, une transcription textuelle ou une audio-description (hors cas particuliers) ?', '4.1', '', 17),
('Rgaa32017-4-2', 'Pour chaque média temporel pré-enregistré ayant une transcription textuelle ou une audio-description synchronisée, celles-ci sont-elles pertinentes (hors cas particuliers) ?', '4.2', '', 18),
('Rgaa32017-4-3', 'Chaque média temporel synchronisé pré-enregistré a-t-il, si nécessaire, des sous-titres synchronisés (hors cas particuliers) ?', '4.3', '', 19),
('Rgaa32017-4-4', 'Pour chaque média temporel synchronisé pré-enregistré ayant des sous-titres synchronisés, ces sous-titres sont-ils pertinents ?', '4.4', '', 20),
('Rgaa32017-4-5', 'Chaque média temporel en direct a-t-il, si nécessaire, des sous-titres synchronisés ou une transcription textuelle (hors cas particuliers) ?', '4.5', '', 21),
('Rgaa32017-4-6', 'Pour chaque média temporel en direct ayant des sous-titres synchronisés ou une transcription textuelle, ceux-ci sont-ils pertinents ?', '4.6', '', 22),
('Rgaa32017-4-7', 'Chaque média temporel pré-enregistré a-t-il, si nécessaire, une audio-description synchronisée (hors cas particuliers) ?', '4.7', '', 23),
('Rgaa32017-4-8', 'Pour chaque média temporel pré-enregistré ayant une audio-description synchronisée, celle-ci est-elle pertinente ?', '4.8', '', 24),
('Rgaa32017-4-9', 'Chaque média temporel pré-enregistré a-t-il, si nécessaire, une interprétation en langue des signes (hors cas particuliers) ?', '4.9', '', 25),
('Rgaa32017-4-10', 'Pour chaque média temporel pré-enregistré ayant une interprétation en langue des signes, celle-ci est-elle pertinente ?', '4.10', '', 26),
('Rgaa32017-4-11', 'Chaque média temporel pré-enregistré a-t-il, si nécessaire, une audio-description étendue synchronisée (hors cas particuliers) ?', '4.11', '', 27),
('Rgaa32017-4-12', 'Pour chaque média temporel pré-enregistré ayant une audio-description étendue synchronisée, celle-ci est-elle pertinente ?', '4.12', '', 28),
('Rgaa32017-4-13', 'Chaque média temporel synchronisé ou seulement vidéo a-t-il, si nécessaire, une transcription textuelle (hors cas particuliers) ?', '4.13', '', 29),
('Rgaa32017-4-14', 'Pour chaque média temporel synchronisé ou seulement vidéo, ayant une transcription textuelle, celle-ci est-elle pertinente ?', '4.14', '', 30),
('Rgaa32017-4-15', 'Chaque média temporel est-il clairement identifiable (hors cas particuliers) ?', '4.15', '', 31),
('Rgaa32017-4-16', 'Chaque média non temporel a-t-il, si nécessaire, une alternative (hors cas particuliers) ?', '4.16', '', 32),
('Rgaa32017-4-17', 'Pour chaque média non temporel ayant une alternative, cette alternative est-elle pertinente ?', '4.17', '', 33),
('Rgaa32017-4-18', 'Chaque son déclenché automatiquement est-il contrôlable par lutilisateur ?', '4.18', '', 34),
('Rgaa32017-4-19', 'Pour chaque média temporel seulement audio pré-enregistré, les dialogues sont-ils suffisamment audibles (hors cas particuliers) ?', '4.19', '', 35),
('Rgaa32017-4-20', 'La consultation de chaque média temporel est-elle contrôlable par le clavier et la souris ?', '4.20', '', 36),
('Rgaa32017-4-21', 'La consultation de chaque média non temporel est-elle contrôlable par le clavier et la souris ?', '4.21', '', 37),
('Rgaa32017-4-22', 'Chaque média temporel et non temporel est-il compatible avec les technologies dassistance (hors cas particuliers) ?', '4.22', '', 38),
('Rgaa32017-5-1', 'Chaque tableau de données complexe a-t-il un résumé ?', '5.1', '', 39),
('Rgaa32017-5-2', 'Pour chaque tableau de données complexe ayant un résumé, celui-ci est-il pertinent ?', '5.2', '', 40),
('Rgaa32017-5-3', 'Pour chaque tableau de mise en forme, le contenu linéarisé reste-t-il compréhensible (hors cas particuliers)?', '5.3', '', 41),
('Rgaa32017-5-4', 'Chaque tableau de données a-t-il un titre ?', '5.4', '', 42),
('Rgaa32017-5-5', 'Pour chaque tableau de données ayant un titre, celui-ci est-il pertinent ?', '5.5', '', 43),
('Rgaa32017-5-6', 'Pour chaque tableau de données, chaque en-tête de colonnes et chaque en-tête de lignes sont-ils correctement déclarés ?', '5.6', '', 44),
('Rgaa32017-5-7', 'Pour chaque tableau de données, la technique appropriée permettant dassocier chaque cellule avec ses en-têtes est-elle utilisée ?', '5.7', '', 45),
('Rgaa32017-5-8', 'Chaque tableau de mise en forme ne doit pas utiliser déléments propres aux tableaux de données. Cette règle est-elle respectée ?', '5.8', '', 46),
('Rgaa32017-6-1', 'Chaque lien est-il explicite (hors cas particuliers) ?', '6.1', '', 47),
('Rgaa32017-6-2', 'Pour chaque lien ayant un titre de lien, celui-ci est-il pertinent ?', '6.2', '', 48),
('Rgaa32017-6-3', 'Chaque intitulé de lien seul est-il explicite hors contexte (hors cas particuliers) ?', '6.3', '', 49),
('Rgaa32017-6-4', 'Chaque lien identique a-t-il les mêmes fonction et destination ?', '6.4', '', 50),
('Rgaa32017-6-5', 'Dans chaque page Web, chaque lien, à lexception des ancres, a-t-il un intitulé ?', '6.5', '', 51),
('Rgaa32017-7-1', 'Chaque script est-il, si nécessaire, compatible avec les technologies dassistance ?', '7.1', '', 52),
('Rgaa32017-7-2', 'Pour chaque script ayant une alternative, cette alternative est-elle pertinente ?', '7.2', '', 53),
('Rgaa32017-7-3', 'Chaque script est-il contrôlable par le clavier et la souris (hors cas particuliers) ?', '7.3', '', 54),
('Rgaa32017-7-4', 'Pour chaque script qui initie un changement de contexte, lutilisateur est-il averti ou en a-t-il le contrôle ?', '7.4', '', 55),
('Rgaa32017-7-5', 'Chaque script qui provoque une alerte non sollicitée est-il contrôlable par lutilisateur (hors cas particuliers) ?', '7.5', '', 56),
('Rgaa32017-8-1', 'Chaque page Web est-elle définie par un type de document ?', '8.1', '', 57),
('Rgaa32017-8-2', 'Pour chaque page Web, le code source est-il valide selon le type de document spécifié sauf cas particulier ?', '8.2', '', 58),
('Rgaa32017-8-3', 'Dans chaque page Web, la langue par défaut est-elle présente ?', '8.3', '', 59),
('Rgaa32017-8-4', 'Pour chaque page Web ayant une langue par défaut, le code de langue est-il pertinent ?', '8.4', '', 60),
('Rgaa32017-8-5', 'Chaque page Web a-t-elle un titre de page ?', '8.5', '', 61),
('Rgaa32017-8-6', 'Pour chaque page Web ayant un titre de page, ce titre est-il pertinent ?', '8.6', '', 62),
('Rgaa32017-8-7', 'Dans chaque page Web, chaque changement de langue est-il indiqué dans le code source (hors cas particuliers) ?', '8.7', '', 63),
('Rgaa32017-8-8', 'Dans chaque page Web, chaque changement de langue est-il pertinent ?', '8.8', '', 64),
('Rgaa32017-8-9', 'Dans chaque page Web, les balises ne doivent pas être utilisées uniquement à des fins de présentation. Cette règle est-elle respectée ?', '8.9', '', 65),
('Rgaa32017-8-10', 'Dans chaque page Web, les changements du sens de lecture sont-ils signalés ?', '8.10', '', 66),
('Rgaa32017-9-1', 'Dans chaque page Web, linformation est-elle structurée par lutilisation appropriée de titres ?', '9.1', '', 67),
('Rgaa32017-9-2', 'Dans chaque page Web, la structure du document est-elle cohérente ?', '9.2', '', 68),
('Rgaa32017-9-3', 'Dans chaque page Web, chaque liste est-elle correctement structurée ?', '9.3', '', 69),
('Rgaa32017-9-4', 'Dans chaque page Web, la première occurrence de chaque abréviation permet-elle den connaître la signification ?', '9.4', '', 70),
('Rgaa32017-9-5', 'Dans chaque page Web, la signification de chaque abréviation est-elle pertinente ?', '9.5', '', 71),
('Rgaa32017-9-6', 'Dans chaque page Web, chaque citation est-elle correctement indiquée ?', '9.6', '', 72),
('Rgaa32017-10-1', 'Dans le site Web, des feuilles de styles sont-elles utilisées pour contrôler la présentation de linformation ?', '10.1', '', 73),
('Rgaa32017-10-2', 'Dans chaque page Web, le contenu visible reste-t-il présent lorsque les feuilles de styles ou les images sont désactivées ?', '10.2', '', 74),
('Rgaa32017-10-3', 'Dans chaque page Web, linformation reste-t-elle compréhensible lorsque les feuilles de styles sont désactivées ?', '10.3', '', 75),
('Rgaa32017-10-4', 'Dans chaque page Web, le texte reste-t-il lisible lorsque la taille des caractères est augmentée jusquà 200%, au moins ?', '10.4', '', 76),
('Rgaa32017-10-5', 'Dans chaque page Web, les déclarations CSS de couleurs de fond délément et de police sont-elles correctement utilisées?', '10.5', '', 77),
('Rgaa32017-10-6', 'Dans chaque page Web, chaque lien dont la nature nest pas évidente est-il visible par rapport au texte environnant ?', '10.6', '', 78),
('Rgaa32017-10-7', 'Dans chaque page Web, pour chaque élément recevant le focus, la prise de focus est-elle visible ?', '10.7', '', 79),
('Rgaa32017-10-8', 'Dans chaque page Web, le choix de la couleur de fond et de police du texte est-il contrôlable par lutilisateur ?', '10.8', '', 80),
('Rgaa32017-10-9', 'Pour chaque page Web, le texte ne doit pas être justifié. Cette règle est-elle respectée ?', '10.9', '', 81),
('Rgaa32017-10-10', 'Pour chaque page Web, en affichage plein écran et avec une taille de police à 200%, chaque bloc de texte reste-t-il lisible sans lutilisation de la barre de défilement horizontal ?', '10.10', '', 82),
('Rgaa32017-10-11', 'Pour chaque page Web, les blocs de texte ont-ils une largeur inférieure ou égale à 80 caractères (hors cas particuliers) ?', '10.11', '', 83),
('Rgaa32017-10-12', 'Pour chaque page Web, lespace entre les lignes et les paragraphes est-il suffisant ?', '10.12', '', 84),
('Rgaa32017-10-13', 'Pour chaque page Web, les textes cachés sont-ils correctement restitués par les technologies dassistance ?', '10.13', '', 85),
('Rgaa32017-10-14', 'Dans chaque page Web, linformation ne doit pas être donnée uniquement par la forme, taille ou position. Cette règle est-elle respectée ?', '10.14', '', 86),
('Rgaa32017-10-15', 'Dans chaque page Web, linformation ne doit pas être donnée par la forme, taille ou position uniquement. Cette règle est-elle implémentée de façon pertinente ?', '10.15', '', 87),
('Rgaa32017-11-1', 'Chaque champ de formulaire a-t-il une étiquette ?', '11.1', '', 88),
('Rgaa32017-11-2', 'Chaque étiquette associée à un champ de formulaire est-elle pertinente ?', '11.2', '', 89),
('Rgaa32017-11-3', 'Dans chaque formulaire, chaque étiquette associée à un champ de formulaire ayant la même fonction et répétée plusieurs fois dans une même page ou dans un ensemble de pages est-elle cohérente ?', '11.3', '', 90),
('Rgaa32017-11-4', 'Dans chaque formulaire, chaque étiquette de champ et son champ associé sont-ils accolés ?', '11.4', '', 91),
('Rgaa32017-11-5', 'Dans chaque formulaire, les informations de même nature sont-elles regroupées, si nécessaire ?', '11.5', '', 92),
('Rgaa32017-11-6', 'Dans chaque formulaire, chaque regroupement de champs de formulaire a-t-il une légende ?', '11.6', '', 93),
('Rgaa32017-11-7', 'Dans chaque formulaire, chaque légende associée à un groupement de champs de formulaire est-elle pertinente ?', '11.7', '', 94),
('Rgaa32017-11-8', 'Dans chaque formulaire, chaque liste de choix est-elle structurée de manière pertinente ?', '11.8', '', 95),
('Rgaa32017-11-9', 'Dans chaque formulaire, lintitulé de chaque bouton est-il pertinent ?', '11.9', '', 96),
('Rgaa32017-11-10', 'Dans chaque formulaire, le contrôle de saisie est-il utilisé de manière pertinente ?', '11.10', '', 97),
('Rgaa32017-11-11', 'Dans chaque formulaire, le contrôle de saisie est-il accompagné, si possible, de suggestions facilitant la correction des erreurs de saisie ?', '11.11', '', 98),
('Rgaa32017-11-12', 'Pour chaque formulaire, les données à caractère financier, juridique ou personnel peuvent-elles être modifiées, mise à jour ou récupérées par lutilisateur ?', '11.12', '', 99),
('Rgaa32017-11-13', 'Pour chaque formulaire, toutes les données peuvent-elles être modifiées, mises à jour ou récupérées par lutilisateur ?', '11.13', '', 100),
('Rgaa32017-11-14', 'Pour chaque formulaire, des aides à la saisie sont-elles présentes ?', '11.14', '', 101),
('Rgaa32017-11-15', 'Pour chaque formulaire, chaque aide à la saisie est-elle pertinente ?', '11.15', '', 102),
('Rgaa32017-12-1', 'Chaque ensemble de pages dispose-t-il de deux systèmes de navigation différents, au moins (hors cas particuliers) ?', '12.1', '', 103),
('Rgaa32017-12-2', 'Dans chaque ensemble de pages, le menu ou les barres de navigation sont-ils toujours à la même place (hors cas particuliers) ?', '12.2', '', 104),
('Rgaa32017-12-3', 'Dans chaque ensemble de pages, le menu et les barres de navigation ont-ils une présentation cohérente (hors cas particuliers) ?', '12.3', '', 105),
('Rgaa32017-12-4', 'La page "plan du site" est-elle pertinente ?', '12.4', '', 106),
('Rgaa32017-12-5', 'Dans chaque ensemble de pages, la page "plan du site" est-elle atteignable de manière identique ?', '12.5', '', 107),
('Rgaa32017-12-6', 'Dans chaque ensemble de pages, le moteur de recherche est-il atteignable de manière identique ?', '12.6', '', 108),
('Rgaa32017-12-7', 'Dans chaque page dune collection de pages, des liens facilitant la navigation sont-ils présents ?', '12.7', '', 109),
('Rgaa32017-12-8', 'Dans chaque page web, un fil dAriane est-il présent ?', '12.8', '', 110),
('Rgaa32017-12-9', 'Dans chaque page Web, le fil dAriane est-il pertinent ?', '12.9', '', 111),
('Rgaa32017-12-10', 'Dans chaque page Web, les groupes de liens importants (menu, barre de navigation...) et la zone de contenu sont-ils identifiés ?', '12.10', '', 112),
('Rgaa32017-12-11', 'Dans chaque page Web, des liens dévitement ou daccès rapide aux groupes de liens importants et à la zone de contenu sont-ils présents ?', '12.11', '', 113),
('Rgaa32017-12-12', 'Dans chaque page Web, la page en cours de consultation est-elle indiquée dans le menu de navigation ?', '12.12', '', 114),
('Rgaa32017-12-13', 'Dans chaque page Web, lordre de tabulation est-il cohérent ?', '12.13', '', 115),
('Rgaa32017-12-14', 'Dans chaque page Web, la navigation ne doit pas contenir de piège au clavier. Cette règle est-elle respectée ?', '12.14', '', 116),
('Rgaa32017-13-1', 'Pour chaque page Web, lutilisateur a-t-il le contrôle de chaque limite de temps modifiant le contenu (hors cas particuliers) ?', '13.1', '', 117),
('Rgaa32017-13-2', 'Dans chaque page Web, pour chaque ouverture de nouvelle fenêtre, lutilisateur est-il averti ?', '13.2', '', 118),
('Rgaa32017-13-3', 'Dans chaque page Web, louverture dune nouvelle fenêtre ne doit pas être déclenchée sans action de lutilisateur. Cette règle est-elle respectée ?', '13.3', '', 119),
('Rgaa32017-13-4', 'Dans chaque page Web, une tâche ne doit pas requérir de limite de temps pour être réalisée, sauf si elle se déroule en temps réel ou si cette limite de temps est essentielle. Cette règle est-elle respectée ?', '13.4', '', 120),
('Rgaa32017-13-5', 'Dans chaque page Web, lors dune interruption de session authentifiée, les données saisies par lutilisateur sont-elles récupérées après ré-authentification ?', '13.5', '', 121),
('Rgaa32017-13-6', 'Dans chaque page Web, pour chaque fichier en téléchargement, des informations relatives à sa consultation sont-elles présentes (hors cas particuliers) ?', '13.6', '', 122),
('Rgaa32017-13-7', 'Dans chaque page Web, chaque document bureautique en téléchargement possède-t-il, si nécessaire, une version accessible (hors cas particuliers) ?', '13.7', '', 123),
('Rgaa32017-13-8', 'Pour chaque document bureautique ayant une version accessible, cette version offre-t-elle la même information ?', '13.8', '', 124),
('Rgaa32017-13-9', 'Dans chaque page Web, les expressions inhabituelles, les expressions idiomatiques ou le jargon sont-ils explicités ?', '13.9', '', 125),
('Rgaa32017-13-10', 'Dans chaque page Web, pour chaque expression inhabituelle ou limitée, idiomatique ou de jargon ayant une définition, cette définition est-elle pertinente ?', '13.10', '', 126),
('Rgaa32017-13-11', 'Dans chaque page Web, chaque contenu cryptique (art ascii, émoticon, syntaxe cryptique) a-t-il une alternative ?', '13.11', '', 127),
('Rgaa32017-13-12', 'Dans chaque page Web, pour chaque contenu cryptique (art ascii, émoticon, syntaxe cryptique) ayant une alternative, cette alternative est-elle pertinente ?', '13.12', '', 128),
('Rgaa32017-13-13', 'Dans chaque page Web, pour chaque mot dont le sens ne peut être compris sans en connaître la prononciation, celle-ci est-elle indiquée ?', '13.13', '', 129),
('Rgaa32017-13-14', 'Dans chaque page Web, chaque texte qui nécessite un niveau de lecture plus avancé que le premier cycle de lenseignement secondaire a-t-il une version alternative ?', '13.14', '', 130),
('Rgaa32017-13-15', 'Dans chaque page Web, les changements brusques de luminosité ou les effets de flash sont-ils correctement utilisés ?', '13.15', '', 131),
('Rgaa32017-13-16', 'Dans chaque page Web, les changements brusques de luminosité ou les effets de flash ont-ils une fréquence inférieure ou égale à 3 par seconde ?', '13.16', '', 132),
('Rgaa32017-13-17', 'Dans chaque page Web, chaque contenu en mouvement ou clignotant est-il contrôlable par lutilisateur ?', '13.17', '', 133);

UPDATE `CRITERION` SET `Reference_Id_Reference` = (SELECT `Id_Reference` FROM `REFERENCE` WHERE `Cd_Reference` LIKE 'Rgaa32017') WHERE `Cd_Criterion` LIKE 'Rgaa32017-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-1') WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-2') WHERE `Cd_Criterion` LIKE 'Rgaa32017-2-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-3') WHERE `Cd_Criterion` LIKE 'Rgaa32017-3-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-4') WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-5') WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-6') WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-7') WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-8') WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-9') WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-10') WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-11') WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-12') WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-%';
UPDATE `CRITERION` SET `Theme_Id_Theme` = (SELECT `Id_Theme` FROM `THEME` WHERE `Cd_Theme` LIKE 'Rgaa32017-13') WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-%';

INSERT IGNORE INTO `TEST` (`Cd_Test`, `Description`, `Label`, `Rank`, `Weight`, `Rule_Archive_Name`, `Rule_Class_Name`, `Id_Decision_Level`, `Id_Level`, `Id_Scope`, `Rule_Design_Url`, `No_Process`) VALUES
('Rgaa32017-1-1-1', '', '1.1.1',1, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-1-1', b'1'),
('Rgaa32017-1-1-2', '', '1.1.2',2, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-1-2', b'1'),
('Rgaa32017-1-1-3', '', '1.1.3',3, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-1-3', b'1'),
('Rgaa32017-1-1-4', '', '1.1.4',4, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-1-4', b'1'),
('Rgaa32017-1-2-1', '', '1.2.1',5, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-1', b'1'),
('Rgaa32017-1-2-2', '', '1.2.2',6, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-2', b'1'),
('Rgaa32017-1-2-3', '', '1.2.3',7, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-3', b'1'),
('Rgaa32017-1-2-4', '', '1.2.4',8, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010204', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-4', b'1'),
('Rgaa32017-1-2-5', '', '1.2.5',9, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010205', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-5', b'1'),
('Rgaa32017-1-2-6', '', '1.2.6',10, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010206', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-2-6', b'1'),
('Rgaa32017-1-3-1', '', '1.3.1',11, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-1', b'1'),
('Rgaa32017-1-3-2', '', '1.3.2',12, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010302', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-2', b'1'),
('Rgaa32017-1-3-3', '', '1.3.3',13, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010303', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-3', b'1'),
('Rgaa32017-1-3-4', '', '1.3.4',14, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010304', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-4', b'1'),
('Rgaa32017-1-3-5', '', '1.3.5',15, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010305', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-5', b'1'),
('Rgaa32017-1-3-6', '', '1.3.6',16, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010306', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-6', b'1'),
('Rgaa32017-1-3-7', '', '1.3.7',17, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010307', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-7', b'1'),
('Rgaa32017-1-3-8', '', '1.3.8',18, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010308', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-8', b'1'),
('Rgaa32017-1-3-9', '', '1.3.9',19, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010309', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-9', b'1'),
('Rgaa32017-1-3-10', '', '1.3.10',20, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010310', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-10', b'1'),
('Rgaa32017-1-3-11', '', '1.3.11',21, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010311', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-11', b'1'),
('Rgaa32017-1-3-12', '', '1.3.12',22, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010312', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-12', b'1'),
('Rgaa32017-1-3-13', '', '1.3.13',23, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010313', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-3-13', b'1'),
('Rgaa32017-1-4-1', '', '1.4.1',24, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-1', b'1'),
('Rgaa32017-1-4-2', '', '1.4.2',25, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010402', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-2', b'1'),
('Rgaa32017-1-4-3', '', '1.4.3',26, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010403', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-3', b'1'),
('Rgaa32017-1-4-4', '', '1.4.4',27, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010404', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-4', b'1'),
('Rgaa32017-1-4-5', '', '1.4.5',28, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010405', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-5', b'1'),
('Rgaa32017-1-4-6', '', '1.4.6',29, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010406', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-6', b'1'),
('Rgaa32017-1-4-7', '', '1.4.7',30, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010407', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-7', b'1'),
('Rgaa32017-1-4-8', '', '1.4.8',31, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010408', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-8', b'1'),
('Rgaa32017-1-4-9', '', '1.4.9',32, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010409', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-9', b'1'),
('Rgaa32017-1-4-10', '', '1.4.10',33, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010410', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-10', b'1'),
('Rgaa32017-1-4-11', '', '1.4.11',34, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010411', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-11', b'1'),
('Rgaa32017-1-4-12', '', '1.4.12',35, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010412', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-4-12', b'1'),
('Rgaa32017-1-5-1', '', '1.5.1',36, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-5-1', b'1'),
('Rgaa32017-1-5-2', '', '1.5.2',37, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010502', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-5-2', b'1'),
('Rgaa32017-1-6-1', '', '1.6.1',38, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-1', b'1'),
('Rgaa32017-1-6-2', '', '1.6.2',39, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010602', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-2', b'1'),
('Rgaa32017-1-6-3', '', '1.6.3',40, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010603', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-3', b'1'),
('Rgaa32017-1-6-4', '', '1.6.4',41, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010604', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-4', b'1'),
('Rgaa32017-1-6-5', '', '1.6.5',42, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010605', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-5', b'1'),
('Rgaa32017-1-6-6', '', '1.6.6',43, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010606', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-6', b'1'),
('Rgaa32017-1-6-7', '', '1.6.7',44, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010607', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-7', b'1'),
('Rgaa32017-1-6-8', '', '1.6.8',45, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010608', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-8', b'1'),
('Rgaa32017-1-6-9', '', '1.6.9',46, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010609', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-9', b'1'),
('Rgaa32017-1-6-10', '', '1.6.10',47, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010610', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-6-10', b'1'),
('Rgaa32017-1-7-1', '', '1.7.1',48, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-1', b'1'),
('Rgaa32017-1-7-2', '', '1.7.2',49, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010702', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-2', b'1'),
('Rgaa32017-1-7-3', '', '1.7.3',50, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010703', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-3', b'1'),
('Rgaa32017-1-7-4', '', '1.7.4',51, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010704', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-4', b'1'),
('Rgaa32017-1-7-5', '', '1.7.5',52, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010705', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-5', b'1'),
('Rgaa32017-1-7-6', '', '1.7.6',53, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010706', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-6', b'1'),
('Rgaa32017-1-7-7', '', '1.7.7',54, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010707', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-7', b'1'),
('Rgaa32017-1-7-8', '', '1.7.8',55, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010708', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-7-8', b'1'),
('Rgaa32017-1-8-1', '', '1.8.1',56, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010801', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-8-1', b'1'),
('Rgaa32017-1-8-2', '', '1.8.2',57, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010802', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-8-2', b'1'),
('Rgaa32017-1-8-3', '', '1.8.3',58, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010803', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-8-3', b'1'),
('Rgaa32017-1-8-4', '', '1.8.4',59, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010804', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-8-4', b'1'),
('Rgaa32017-1-8-5', '', '1.8.5',60, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010805', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-8-5', b'1'),
('Rgaa32017-1-9-1', '', '1.9.1',61, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-9-1', b'1'),
('Rgaa32017-1-9-2', '', '1.9.2',62, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010902', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-9-2', b'1'),
('Rgaa32017-1-9-3', '', '1.9.3',63, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010903', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-9-3', b'1'),
('Rgaa32017-1-9-4', '', '1.9.4',64, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010904', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-9-4', b'1'),
('Rgaa32017-1-9-5', '', '1.9.5',65, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule010905', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-9-5', b'1'),
('Rgaa32017-1-10-1', '', '1.10.1',66, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule011001', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-10-1', b'1'),
('Rgaa32017-1-10-2', '', '1.10.2',67, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule011002', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-10-2', b'1'),
('Rgaa32017-1-10-3', '', '1.10.3',68, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule011003', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-10-3', b'1'),
('Rgaa32017-1-10-4', '', '1.10.4',69, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule011004', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-10-4', b'1'),
('Rgaa32017-1-10-5', '', '1.10.5',70, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule011005', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-1-10-5', b'1'),
('Rgaa32017-2-1-1', '', '2.1.1',71, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule020101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-2-1-1', b'1'),
('Rgaa32017-2-2-1', '', '2.2.1',72, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule020201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-2-2-1', b'1'),
('Rgaa32017-3-1-1', '', '3.1.1',73, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-1', b'1'),
('Rgaa32017-3-1-2', '', '3.1.2',74, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-2', b'1'),
('Rgaa32017-3-1-3', '', '3.1.3',75, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-3', b'1'),
('Rgaa32017-3-1-4', '', '3.1.4',76, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-4', b'1'),
('Rgaa32017-3-1-5', '', '3.1.5',77, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030105', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-5', b'1'),
('Rgaa32017-3-1-6', '', '3.1.6',78, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030106', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-1-6', b'1'),
('Rgaa32017-3-2-1', '', '3.2.1',79, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-1', b'1'),
('Rgaa32017-3-2-2', '', '3.2.2',80, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-2', b'1'),
('Rgaa32017-3-2-3', '', '3.2.3',81, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-3', b'1'),
('Rgaa32017-3-2-4', '', '3.2.4',82, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030204', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-4', b'1'),
('Rgaa32017-3-2-5', '', '3.2.5',83, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030205', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-5', b'1'),
('Rgaa32017-3-2-6', '', '3.2.6',84, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030206', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-2-6', b'1'),
('Rgaa32017-3-3-1', '', '3.3.1',85, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030301', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-3-1', b'1'),
('Rgaa32017-3-3-2', '', '3.3.2',86, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030302', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-3-2', b'1'),
('Rgaa32017-3-3-3', '', '3.3.3',87, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030303', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-3-3', b'1'),
('Rgaa32017-3-3-4', '', '3.3.4',88, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030304', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-3-4', b'1'),
('Rgaa32017-3-3-5', '', '3.3.5',89, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030305', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-3-5', b'1'),
('Rgaa32017-3-4-1', '', '3.4.1',90, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-4-1', b'1'),
('Rgaa32017-3-4-2', '', '3.4.2',91, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030402', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-4-2', b'1'),
('Rgaa32017-3-4-3', '', '3.4.3',92, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030403', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-4-3', b'1'),
('Rgaa32017-3-4-4', '', '3.4.4',93, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030404', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-4-4', b'1'),
('Rgaa32017-3-4-5', '', '3.4.5',94, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule030405', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-3-4-5', b'1'),
('Rgaa32017-4-1-1', '', '4.1.1',95, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-1-1', b'1'),
('Rgaa32017-4-1-2', '', '4.1.2',96, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-1-2', b'1'),
('Rgaa32017-4-1-3', '', '4.1.3',97, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-1-3', b'1'),
('Rgaa32017-4-2-1', '', '4.2.1',98, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-2-1', b'1'),
('Rgaa32017-4-2-2', '', '4.2.2',99, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-2-2', b'1'),
('Rgaa32017-4-2-3', '', '4.2.3',100, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-2-3', b'1'),
('Rgaa32017-4-3-1', '', '4.3.1',101, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-3-1', b'1'),
('Rgaa32017-4-3-2', '', '4.3.2',102, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040302', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-3-2', b'1'),
('Rgaa32017-4-4-1', '', '4.4.1',103, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-4-1', b'1'),
('Rgaa32017-4-5-1', '', '4.5.1',104, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040501', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-5-1', b'1'),
('Rgaa32017-4-5-2', '', '4.5.2',105, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040502', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-5-2', b'1'),
('Rgaa32017-4-6-1', '', '4.6.1',106, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040601', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-6-1', b'1'),
('Rgaa32017-4-6-2', '', '4.6.2',107, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040602', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-6-2', b'1'),
('Rgaa32017-4-7-1', '', '4.7.1',108, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040701', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-7-1', b'1'),
('Rgaa32017-4-7-2', '', '4.7.2',109, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040702', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-7-2', b'1'),
('Rgaa32017-4-8-1', '', '4.8.1',110, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040801', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-8-1', b'1'),
('Rgaa32017-4-8-2', '', '4.8.2',111, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040802', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-8-2', b'1'),
('Rgaa32017-4-9-1', '', '4.9.1',112, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-9-1', b'1'),
('Rgaa32017-4-9-2', '', '4.9.2',113, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule040902', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-9-2', b'1'),
('Rgaa32017-4-10-1', '', '4.10.1',114, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041001', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-10-1', b'1'),
('Rgaa32017-4-10-2', '', '4.10.2',115, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041002', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-10-2', b'1'),
('Rgaa32017-4-11-1', '', '4.11.1',116, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041101', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-11-1', b'1'),
('Rgaa32017-4-11-2', '', '4.11.2',117, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041102', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-11-2', b'1'),
('Rgaa32017-4-12-1', '', '4.12.1',118, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041201', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-12-1', b'1'),
('Rgaa32017-4-12-2', '', '4.12.2',119, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041202', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-12-2', b'1'),
('Rgaa32017-4-13-1', '', '4.13.1',120, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041301', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-13-1', b'1'),
('Rgaa32017-4-13-2', '', '4.13.2',121, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041302', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-13-2', b'1'),
('Rgaa32017-4-14-1', '', '4.14.1',122, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-14-1', b'1'),
('Rgaa32017-4-14-2', '', '4.14.2',123, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041402', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-14-2', b'1'),
('Rgaa32017-4-15-1', '', '4.15.1',124, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-15-1', b'1'),
('Rgaa32017-4-15-2', '', '4.15.2',125, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041502', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-15-2', b'1'),
('Rgaa32017-4-16-1', '', '4.16.1',126, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-16-1', b'1'),
('Rgaa32017-4-16-2', '', '4.16.2',127, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041602', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-16-2', b'1'),
('Rgaa32017-4-17-1', '', '4.17.1',128, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-17-1', b'1'),
('Rgaa32017-4-18-1', '', '4.18.1',129, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041801', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-18-1', b'1'),
('Rgaa32017-4-19-1', '', '4.19.1',130, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule041901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-19-1', b'1'),
('Rgaa32017-4-20-1', '', '4.20.1',131, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042001', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-20-1', b'1'),
('Rgaa32017-4-20-2', '', '4.20.2',132, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042002', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-20-2', b'1'),
('Rgaa32017-4-20-3', '', '4.20.3',133, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042003', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-20-3', b'1'),
('Rgaa32017-4-21-1', '', '4.21.1',134, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-21-1', b'1'),
('Rgaa32017-4-21-2', '', '4.21.2',135, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-21-2', b'1'),
('Rgaa32017-4-22-1', '', '4.22.1',136, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-22-1', b'1'),
('Rgaa32017-4-22-2', '', '4.22.2',137, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule042202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-4-22-2', b'1'),
('Rgaa32017-5-1-1', '', '5.1.1',138, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-1-1', b'1'),
('Rgaa32017-5-2-1', '', '5.2.1',139, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-2-1', b'1'),
('Rgaa32017-5-3-1', '', '5.3.1',140, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-3-1', b'1'),
('Rgaa32017-5-4-1', '', '5.4.1',141, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-4-1', b'1'),
('Rgaa32017-5-5-1', '', '5.5.1',142, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-5-1', b'1'),
('Rgaa32017-5-6-1', '', '5.6.1',143, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-6-1', b'1'),
('Rgaa32017-5-6-2', '', '5.6.2',144, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050602', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-6-2', b'1'),
('Rgaa32017-5-7-1', '', '5.7.1',145, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-7-1', b'1'),
('Rgaa32017-5-7-2', '', '5.7.2',146, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050702', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-7-2', b'1'),
('Rgaa32017-5-7-3', '', '5.7.3',147, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050703', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-7-3', b'1'),
('Rgaa32017-5-7-4', '', '5.7.4',148, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050704', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-7-4', b'1'),
('Rgaa32017-5-8-1', '', '5.8.1',149, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule050801', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-5-8-1', b'1'),
('Rgaa32017-6-1-1', '', '6.1.1',150, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-1-1', b'1'),
('Rgaa32017-6-1-2', '', '6.1.2',151, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-1-2', b'1'),
('Rgaa32017-6-1-3', '', '6.1.3',152, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-1-3', b'1'),
('Rgaa32017-6-2-1', '', '6.2.1',153, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-2-1', b'1'),
('Rgaa32017-6-2-2', '', '6.2.2',154, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-2-2', b'1'),
('Rgaa32017-6-2-3', '', '6.2.3',155, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-2-3', b'1'),
('Rgaa32017-6-3-1', '', '6.3.1',156, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060301', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-3-1', b'1'),
('Rgaa32017-6-3-2', '', '6.3.2',157, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060302', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-3-2', b'1'),
('Rgaa32017-6-3-3', '', '6.3.3',158, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060303', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-3-3', b'1'),
('Rgaa32017-6-4-1', '', '6.4.1',159, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-4-1', b'1'),
('Rgaa32017-6-4-2', '', '6.4.2',160, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060402', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-4-2', b'1'),
('Rgaa32017-6-4-3', '', '6.4.3',161, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060403', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-4-3', b'1'),
('Rgaa32017-6-5-1', '', '6.5.1',162, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule060501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-6-5-1', b'1'),
('Rgaa32017-7-1-1', '', '7.1.1',163, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-1', b'1'),
('Rgaa32017-7-1-2', '', '7.1.2',164, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-2', b'1'),
('Rgaa32017-7-1-3', '', '7.1.3',165, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-3', b'1'),
('Rgaa32017-7-1-4', '', '7.1.4',166, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-4', b'1'),
('Rgaa32017-7-1-5', '', '7.1.5',167, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070105', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-5', b'1'),
('Rgaa32017-7-1-6', '', '7.1.6',168, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070106', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-6', b'1'),
('Rgaa32017-7-1-7', '', '7.1.7',169, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070107', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-1-7', b'1'),
('Rgaa32017-7-2-1', '', '7.2.1',170, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-2-1', b'1'),
('Rgaa32017-7-2-2', '', '7.2.2',171, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-2-2', b'1'),
('Rgaa32017-7-3-1', '', '7.3.1',172, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-3-1', b'1'),
('Rgaa32017-7-3-2', '', '7.3.2',173, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070302', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-3-2', b'1'),
('Rgaa32017-7-3-3', '', '7.3.3',174, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070303', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-3-3', b'1'),
('Rgaa32017-7-4-1', '', '7.4.1',175, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-4-1', b'1'),
('Rgaa32017-7-5-1', '', '7.5.1',176, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule070501', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-7-5-1', b'1'),
('Rgaa32017-8-1-1', '', '8.1.1',177, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-1-1', b'1'),
('Rgaa32017-8-1-2', '', '8.1.2',178, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-1-2', b'1'),
('Rgaa32017-8-1-3', '', '8.1.3',179, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-1-3', b'1'),
('Rgaa32017-8-2-1', '', '8.2.1',180, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-2-1', b'1'),
('Rgaa32017-8-2-2', '', '8.2.2',181, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-2-2', b'1'),
('Rgaa32017-8-3-1', '', '8.3.1',182, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-3-1', b'1'),
('Rgaa32017-8-4-1', '', '8.4.1',183, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-4-1', b'1'),
('Rgaa32017-8-5-1', '', '8.5.1',184, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-5-1', b'1'),
('Rgaa32017-8-6-1', '', '8.6.1',185, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-6-1', b'1'),
('Rgaa32017-8-7-1', '', '8.7.1',186, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080701', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-7-1', b'1'),
('Rgaa32017-8-8-1', '', '8.8.1',187, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080801', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-8-1', b'1'),
('Rgaa32017-8-8-2', '', '8.8.2',188, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080802', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-8-2', b'1'),
('Rgaa32017-8-9-1', '', '8.9.1',189, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule080901', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-9-1', b'1'),
('Rgaa32017-8-10-1', '', '8.10.1',190, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule081001', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-10-1', b'1'),
('Rgaa32017-8-10-2', '', '8.10.2',191, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule081002', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-8-10-2', b'1'),
('Rgaa32017-9-1-1', '', '9.1.1',192, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-1-1', b'1'),
('Rgaa32017-9-1-2', '', '9.1.2',193, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-1-2', b'1'),
('Rgaa32017-9-1-3', '', '9.1.3',194, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-1-3', b'1'),
('Rgaa32017-9-1-4', '', '9.1.4',195, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-1-4', b'1'),
('Rgaa32017-9-2-1', '', '9.2.1',196, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-2-1', b'1'),
('Rgaa32017-9-2-2', '', '9.2.2',197, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-2-2', b'1'),
('Rgaa32017-9-3-1', '', '9.3.1',198, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-3-1', b'1'),
('Rgaa32017-9-3-2', '', '9.3.2',199, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090302', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-3-2', b'1'),
('Rgaa32017-9-3-3', '', '9.3.3',200, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090303', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-3-3', b'1'),
('Rgaa32017-9-4-1', '', '9.4.1',201, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-4-1', b'1'),
('Rgaa32017-9-5-1', '', '9.5.1',202, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090501', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-5-1', b'1'),
('Rgaa32017-9-6-1', '', '9.6.1',203, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-6-1', b'1'),
('Rgaa32017-9-6-2', '', '9.6.2',204, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule090602', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-9-6-2', b'1'),
('Rgaa32017-10-1-1', '', '10.1.1',205, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-1-1', b'1'),
('Rgaa32017-10-1-2', '', '10.1.2',206, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-1-2', b'1'),
('Rgaa32017-10-1-3', '', '10.1.3',207, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-1-3', b'1'),
('Rgaa32017-10-2-1', '', '10.2.1',208, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-2-1', b'1'),
('Rgaa32017-10-3-1', '', '10.3.1',209, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-3-1', b'1'),
('Rgaa32017-10-4-1', '', '10.4.1',210, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100401', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-4-1', b'1'),
('Rgaa32017-10-4-2', '', '10.4.2',211, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100402', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-4-2', b'1'),
('Rgaa32017-10-4-3', '', '10.4.3',212, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100403', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-4-3', b'1'),
('Rgaa32017-10-5-1', '', '10.5.1',213, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100501', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-5-1', b'1'),
('Rgaa32017-10-5-2', '', '10.5.2',214, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100502', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-5-2', b'1'),
('Rgaa32017-10-5-3', '', '10.5.3',215, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100503', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-5-3', b'1'),
('Rgaa32017-10-6-1', '', '10.6.1',216, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-6-1', b'1'),
('Rgaa32017-10-7-1', '', '10.7.1',217, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-7-1', b'1'),
('Rgaa32017-10-7-2', '', '10.7.2',218, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100702', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-7-2', b'1'),
('Rgaa32017-10-7-3', '', '10.7.3',219, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100703', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-7-3', b'1'),
('Rgaa32017-10-8-1', '', '10.8.1',220, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100801', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-8-1', b'1'),
('Rgaa32017-10-8-2', '', '10.8.2',221, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100802', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-8-2', b'1'),
('Rgaa32017-10-8-3', '', '10.8.3',222, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100803', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-8-3', b'1'),
('Rgaa32017-10-8-4', '', '10.8.4',223, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100804', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-8-4', b'1'),
('Rgaa32017-10-9-1', '', '10.9.1',224, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule100901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-9-1', b'1'),
('Rgaa32017-10-10-1', '', '10.10.1',225, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101001', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-10-1', b'1'),
('Rgaa32017-10-11-1', '', '10.11.1',226, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101101', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-11-1', b'1'),
('Rgaa32017-10-12-1', '', '10.12.1',227, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101201', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-12-1', b'1'),
('Rgaa32017-10-12-2', '', '10.12.2',228, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101202', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-12-2', b'1'),
('Rgaa32017-10-13-1', '', '10.13.1',229, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-13-1', b'1'),
('Rgaa32017-10-14-1', '', '10.14.1',230, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-14-1', b'1'),
('Rgaa32017-10-14-2', '', '10.14.2',231, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101402', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-14-2', b'1'),
('Rgaa32017-10-14-3', '', '10.14.3',232, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101403', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-14-3', b'1'),
('Rgaa32017-10-14-4', '', '10.14.4',233, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101404', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-14-4', b'1'),
('Rgaa32017-10-15-1', '', '10.15.1',234, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-15-1', b'1'),
('Rgaa32017-10-15-2', '', '10.15.2',235, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101502', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-15-2', b'1'),
('Rgaa32017-10-15-3', '', '10.15.3',236, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101503', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-15-3', b'1'),
('Rgaa32017-10-15-4', '', '10.15.4',237, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule101504', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-10-15-4', b'1'),
('Rgaa32017-11-1-1', '', '11.1.1',238, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-1-1', b'1'),
('Rgaa32017-11-1-2', '', '11.1.2',239, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-1-2', b'1'),
('Rgaa32017-11-1-3', '', '11.1.3',240, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-1-3', b'1'),
('Rgaa32017-11-1-4', '', '11.1.4',241, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-1-4', b'1'),
('Rgaa32017-11-1-5', '', '11.1.5',242, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110105', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-1-5', b'1'),
('Rgaa32017-11-2-1', '', '11.2.1',243, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-2-1', b'1'),
('Rgaa32017-11-2-2', '', '11.2.2',244, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-2-2', b'1'),
('Rgaa32017-11-2-3', '', '11.2.3',245, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-2-3', b'1'),
('Rgaa32017-11-2-4', '', '11.2.4',246, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110204', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-2-4', b'1'),
('Rgaa32017-11-3-1', '', '11.3.1',247, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110301', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-3-1', b'1'),
('Rgaa32017-11-3-2', '', '11.3.2',248, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110302', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-3-2', b'1'),
('Rgaa32017-11-4-1', '', '11.4.1',249, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-4-1', b'1'),
('Rgaa32017-11-5-1', '', '11.5.1',250, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-5-1', b'1'),
('Rgaa32017-11-6-1', '', '11.6.1',251, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-6-1', b'1'),
('Rgaa32017-11-7-1', '', '11.7.1',252, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-7-1', b'1'),
('Rgaa32017-11-8-1', '', '11.8.1',253, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110801', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-8-1', b'1'),
('Rgaa32017-11-8-2', '', '11.8.2',254, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110802', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-8-2', b'1'),
('Rgaa32017-11-8-3', '', '11.8.3',255, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110803', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-8-3', b'1'),
('Rgaa32017-11-9-1', '', '11.9.1',256, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110901', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-9-1', b'1'),
('Rgaa32017-11-9-2', '', '11.9.2',257, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule110902', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-9-2', b'1'),
('Rgaa32017-11-10-1', '', '11.10.1',258, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111001', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-1', b'1'),
('Rgaa32017-11-10-2', '', '11.10.2',259, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111002', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-2', b'1'),
('Rgaa32017-11-10-3', '', '11.10.3',260, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111003', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-3', b'1'),
('Rgaa32017-11-10-4', '', '11.10.4',261, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111004', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-4', b'1'),
('Rgaa32017-11-10-5', '', '11.10.5',262, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111005', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-5', b'1'),
('Rgaa32017-11-10-6', '', '11.10.6',263, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111006', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-6', b'1'),
('Rgaa32017-11-10-7', '', '11.10.7',264, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111007', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-7', b'1'),
('Rgaa32017-11-10-8', '', '11.10.8',265, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111008', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-8', b'1'),
('Rgaa32017-11-10-9', '', '11.10.9',266, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111009', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-9', b'1'),
('Rgaa32017-11-10-10', '', '11.10.10',267, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111010', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-10-10', b'1'),
('Rgaa32017-11-11-1', '', '11.11.1',268, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111101', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-11-1', b'1'),
('Rgaa32017-11-11-2', '', '11.11.2',269, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111102', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-11-2', b'1'),
('Rgaa32017-11-12-1', '', '11.12.1',270, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111201', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-12-1', b'1'),
('Rgaa32017-11-12-2', '', '11.12.2',271, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111202', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-12-2', b'1'),
('Rgaa32017-11-13-1', '', '11.13.1',272, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111301', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-13-1', b'1'),
('Rgaa32017-11-13-2', '', '11.13.2',273, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111302', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-13-2', b'1'),
('Rgaa32017-11-14-1', '', '11.14.1',274, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-1', b'1'),
('Rgaa32017-11-14-2', '', '11.14.2',275, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111402', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-2', b'1'),
('Rgaa32017-11-14-3', '', '11.14.3',276, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111403', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-3', b'1'),
('Rgaa32017-11-14-4', '', '11.14.4',277, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111404', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-4', b'1'),
('Rgaa32017-11-14-5', '', '11.14.5',278, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111405', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-5', b'1'),
('Rgaa32017-11-14-6', '', '11.14.6',279, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111406', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-14-6', b'1'),
('Rgaa32017-11-15-1', '', '11.15.1',280, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule111501', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-11-15-1', b'1'),
('Rgaa32017-12-1-1', '', '12.1.1',281, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120101', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-1-1', b'1'),
('Rgaa32017-12-2-1', '', '12.2.1',282, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120201', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-2-1', b'1'),
('Rgaa32017-12-2-2', '', '12.2.2',283, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120202', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-2-2', b'1'),
('Rgaa32017-12-3-1', '', '12.3.1',284, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120301', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-3-1', b'1'),
('Rgaa32017-12-3-2', '', '12.3.2',285, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120302', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-3-2', b'1'),
('Rgaa32017-12-4-1', '', '12.4.1',286, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120401', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-4-1', b'1'),
('Rgaa32017-12-4-2', '', '12.4.2',287, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120402', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-4-2', b'1'),
('Rgaa32017-12-4-3', '', '12.4.3',288, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120403', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-4-3', b'1'),
('Rgaa32017-12-5-1', '', '12.5.1',289, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120501', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-5-1', b'1'),
('Rgaa32017-12-5-2', '', '12.5.2',290, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120502', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-5-2', b'1'),
('Rgaa32017-12-5-3', '', '12.5.3',291, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120503', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-5-3', b'1'),
('Rgaa32017-12-6-1', '', '12.6.1',292, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120601', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-6-1', b'1'),
('Rgaa32017-12-6-2', '', '12.6.2',293, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120602', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-6-2', b'1'),
('Rgaa32017-12-6-3', '', '12.6.3',294, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120603', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-6-3', b'1'),
('Rgaa32017-12-7-1', '', '12.7.1',295, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120701', NULL,2,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-7-1', b'1'),
('Rgaa32017-12-8-1', '', '12.8.1',296, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120801', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-8-1', b'1'),
('Rgaa32017-12-9-1', '', '12.9.1',297, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule120901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-9-1', b'1'),
('Rgaa32017-12-10-1', '', '12.10.1',298, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121001', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-10-1', b'1'),
('Rgaa32017-12-11-1', '', '12.11.1',299, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-11-1', b'1'),
('Rgaa32017-12-11-2', '', '12.11.2',300, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-11-2', b'1'),
('Rgaa32017-12-11-3', '', '12.11.3',301, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-11-3', b'1'),
('Rgaa32017-12-11-4', '', '12.11.4',302, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-11-4', b'1'),
('Rgaa32017-12-12-1', '', '12.12.1',303, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121201', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-12-1', b'1'),
('Rgaa32017-12-13-1', '', '12.13.1',304, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-13-1', b'1'),
('Rgaa32017-12-13-2', '', '12.13.2',305, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121302', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-13-2', b'1'),
('Rgaa32017-12-14-1', '', '12.14.1',306, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule121401', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-12-14-1', b'1'),
('Rgaa32017-13-1-1', '', '13.1.1',307, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-1-1', b'1'),
('Rgaa32017-13-1-2', '', '13.1.2',308, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130102', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-1-2', b'1'),
('Rgaa32017-13-1-3', '', '13.1.3',309, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130103', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-1-3', b'1'),
('Rgaa32017-13-1-4', '', '13.1.4',310, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130104', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-1-4', b'1'),
('Rgaa32017-13-2-1', '', '13.2.1',311, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-2-1', b'1'),
('Rgaa32017-13-2-2', '', '13.2.2',312, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130202', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-2-2', b'1'),
('Rgaa32017-13-2-3', '', '13.2.3',313, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130203', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-2-3', b'1'),
('Rgaa32017-13-3-1', '', '13.3.1',314, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130301', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-3-1', b'1'),
('Rgaa32017-13-4-1', '', '13.4.1',315, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-4-1', b'1'),
('Rgaa32017-13-5-1', '', '13.5.1',316, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130501', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-5-1', b'1'),
('Rgaa32017-13-6-1', '', '13.6.1',317, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130601', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-6-1', b'1'),
('Rgaa32017-13-6-2', '', '13.6.2',318, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130602', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-6-2', b'1'),
('Rgaa32017-13-6-3', '', '13.6.3',319, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130603', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-6-3', b'1'),
('Rgaa32017-13-7-1', '', '13.7.1',320, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-7-1', b'1'),
('Rgaa32017-13-8-1', '', '13.8.1',321, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130801', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-8-1', b'1'),
('Rgaa32017-13-9-1', '', '13.9.1',322, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule130901', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-9-1', b'1'),
('Rgaa32017-13-10-1', '', '13.10.1',323, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131001', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-10-1', b'1'),
('Rgaa32017-13-11-1', '', '13.11.1',324, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131101', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-11-1', b'1'),
('Rgaa32017-13-12-1', '', '13.12.1',325, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131201', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-12-1', b'1'),
('Rgaa32017-13-13-1', '', '13.13.1',326, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131301', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-13-1', b'1'),
('Rgaa32017-13-14-1', '', '13.14.1',327, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131401', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-14-1', b'1'),
('Rgaa32017-13-15-1', '', '13.15.1',328, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131501', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-15-1', b'1'),
('Rgaa32017-13-15-2', '', '13.15.2',329, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131502', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-15-2', b'1'),
('Rgaa32017-13-15-3', '', '13.15.3',330, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131503', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-15-3', b'1'),
('Rgaa32017-13-16-1', '', '13.16.1',331, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131601', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-16-1', b'1'),
('Rgaa32017-13-16-2', '', '13.16.2',332, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131602', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-16-2', b'1'),
('Rgaa32017-13-16-3', '', '13.16.3',333, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131603', NULL,3,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-16-3', b'1'),
('Rgaa32017-13-17-1', '', '13.17.1',334, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131701', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-17-1', b'1'),
('Rgaa32017-13-17-2', '', '13.17.2',335, '1.0', 'rgaa30', 'org.tanaguru.rules.rgaa32017.Rgaa32017Rule131702', NULL,1,1, 'http://tanaguru-rules-rgaa3.readthedocs.org/en/master/Rule-13-17-2', b'1');



UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-1') WHERE `Cd_Test` LIKE 'Rgaa32017-1-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-2') WHERE `Cd_Test` LIKE 'Rgaa32017-1-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-3') WHERE `Cd_Test` LIKE 'Rgaa32017-1-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-4') WHERE `Cd_Test` LIKE 'Rgaa32017-1-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-5') WHERE `Cd_Test` LIKE 'Rgaa32017-1-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-6') WHERE `Cd_Test` LIKE 'Rgaa32017-1-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-7') WHERE `Cd_Test` LIKE 'Rgaa32017-1-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-8') WHERE `Cd_Test` LIKE 'Rgaa32017-1-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-9') WHERE `Cd_Test` LIKE 'Rgaa32017-1-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-1-10') WHERE `Cd_Test` LIKE 'Rgaa32017-1-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-2-1') WHERE `Cd_Test` LIKE 'Rgaa32017-2-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-2-2') WHERE `Cd_Test` LIKE 'Rgaa32017-2-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-3-1') WHERE `Cd_Test` LIKE 'Rgaa32017-3-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-3-2') WHERE `Cd_Test` LIKE 'Rgaa32017-3-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-3-3') WHERE `Cd_Test` LIKE 'Rgaa32017-3-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-3-4') WHERE `Cd_Test` LIKE 'Rgaa32017-3-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-1') WHERE `Cd_Test` LIKE 'Rgaa32017-4-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-2') WHERE `Cd_Test` LIKE 'Rgaa32017-4-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-3') WHERE `Cd_Test` LIKE 'Rgaa32017-4-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-4') WHERE `Cd_Test` LIKE 'Rgaa32017-4-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-5') WHERE `Cd_Test` LIKE 'Rgaa32017-4-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-6') WHERE `Cd_Test` LIKE 'Rgaa32017-4-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-7') WHERE `Cd_Test` LIKE 'Rgaa32017-4-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-8') WHERE `Cd_Test` LIKE 'Rgaa32017-4-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-9') WHERE `Cd_Test` LIKE 'Rgaa32017-4-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-10') WHERE `Cd_Test` LIKE 'Rgaa32017-4-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-11') WHERE `Cd_Test` LIKE 'Rgaa32017-4-11-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-12') WHERE `Cd_Test` LIKE 'Rgaa32017-4-12-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-13') WHERE `Cd_Test` LIKE 'Rgaa32017-4-13-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-14') WHERE `Cd_Test` LIKE 'Rgaa32017-4-14-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-15') WHERE `Cd_Test` LIKE 'Rgaa32017-4-15-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-16') WHERE `Cd_Test` LIKE 'Rgaa32017-4-16-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-17') WHERE `Cd_Test` LIKE 'Rgaa32017-4-17-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-18') WHERE `Cd_Test` LIKE 'Rgaa32017-4-18-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-19') WHERE `Cd_Test` LIKE 'Rgaa32017-4-19-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-20') WHERE `Cd_Test` LIKE 'Rgaa32017-4-20-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-21') WHERE `Cd_Test` LIKE 'Rgaa32017-4-21-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-4-22') WHERE `Cd_Test` LIKE 'Rgaa32017-4-22-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-1') WHERE `Cd_Test` LIKE 'Rgaa32017-5-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-2') WHERE `Cd_Test` LIKE 'Rgaa32017-5-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-3') WHERE `Cd_Test` LIKE 'Rgaa32017-5-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-4') WHERE `Cd_Test` LIKE 'Rgaa32017-5-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-5') WHERE `Cd_Test` LIKE 'Rgaa32017-5-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-6') WHERE `Cd_Test` LIKE 'Rgaa32017-5-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-7') WHERE `Cd_Test` LIKE 'Rgaa32017-5-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-5-8') WHERE `Cd_Test` LIKE 'Rgaa32017-5-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-1') WHERE `Cd_Test` LIKE 'Rgaa32017-6-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-2') WHERE `Cd_Test` LIKE 'Rgaa32017-6-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-3') WHERE `Cd_Test` LIKE 'Rgaa32017-6-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-4') WHERE `Cd_Test` LIKE 'Rgaa32017-6-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-6-5') WHERE `Cd_Test` LIKE 'Rgaa32017-6-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-1') WHERE `Cd_Test` LIKE 'Rgaa32017-7-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-2') WHERE `Cd_Test` LIKE 'Rgaa32017-7-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-3') WHERE `Cd_Test` LIKE 'Rgaa32017-7-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-4') WHERE `Cd_Test` LIKE 'Rgaa32017-7-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-7-5') WHERE `Cd_Test` LIKE 'Rgaa32017-7-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-1') WHERE `Cd_Test` LIKE 'Rgaa32017-8-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-2') WHERE `Cd_Test` LIKE 'Rgaa32017-8-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-3') WHERE `Cd_Test` LIKE 'Rgaa32017-8-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-4') WHERE `Cd_Test` LIKE 'Rgaa32017-8-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-5') WHERE `Cd_Test` LIKE 'Rgaa32017-8-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-6') WHERE `Cd_Test` LIKE 'Rgaa32017-8-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-7') WHERE `Cd_Test` LIKE 'Rgaa32017-8-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-8') WHERE `Cd_Test` LIKE 'Rgaa32017-8-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-9') WHERE `Cd_Test` LIKE 'Rgaa32017-8-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-8-10') WHERE `Cd_Test` LIKE 'Rgaa32017-8-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-1') WHERE `Cd_Test` LIKE 'Rgaa32017-9-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-2') WHERE `Cd_Test` LIKE 'Rgaa32017-9-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-3') WHERE `Cd_Test` LIKE 'Rgaa32017-9-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-4') WHERE `Cd_Test` LIKE 'Rgaa32017-9-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-5') WHERE `Cd_Test` LIKE 'Rgaa32017-9-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-9-6') WHERE `Cd_Test` LIKE 'Rgaa32017-9-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-1') WHERE `Cd_Test` LIKE 'Rgaa32017-10-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-2') WHERE `Cd_Test` LIKE 'Rgaa32017-10-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-3') WHERE `Cd_Test` LIKE 'Rgaa32017-10-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-4') WHERE `Cd_Test` LIKE 'Rgaa32017-10-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-5') WHERE `Cd_Test` LIKE 'Rgaa32017-10-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-6') WHERE `Cd_Test` LIKE 'Rgaa32017-10-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-7') WHERE `Cd_Test` LIKE 'Rgaa32017-10-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-8') WHERE `Cd_Test` LIKE 'Rgaa32017-10-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-9') WHERE `Cd_Test` LIKE 'Rgaa32017-10-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-10') WHERE `Cd_Test` LIKE 'Rgaa32017-10-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-11') WHERE `Cd_Test` LIKE 'Rgaa32017-10-11-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-12') WHERE `Cd_Test` LIKE 'Rgaa32017-10-12-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-13') WHERE `Cd_Test` LIKE 'Rgaa32017-10-13-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-14') WHERE `Cd_Test` LIKE 'Rgaa32017-10-14-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-10-15') WHERE `Cd_Test` LIKE 'Rgaa32017-10-15-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-1') WHERE `Cd_Test` LIKE 'Rgaa32017-11-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-2') WHERE `Cd_Test` LIKE 'Rgaa32017-11-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-3') WHERE `Cd_Test` LIKE 'Rgaa32017-11-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-4') WHERE `Cd_Test` LIKE 'Rgaa32017-11-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-5') WHERE `Cd_Test` LIKE 'Rgaa32017-11-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-6') WHERE `Cd_Test` LIKE 'Rgaa32017-11-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-7') WHERE `Cd_Test` LIKE 'Rgaa32017-11-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-8') WHERE `Cd_Test` LIKE 'Rgaa32017-11-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-9') WHERE `Cd_Test` LIKE 'Rgaa32017-11-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-10') WHERE `Cd_Test` LIKE 'Rgaa32017-11-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-11') WHERE `Cd_Test` LIKE 'Rgaa32017-11-11-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-12') WHERE `Cd_Test` LIKE 'Rgaa32017-11-12-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-13') WHERE `Cd_Test` LIKE 'Rgaa32017-11-13-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-14') WHERE `Cd_Test` LIKE 'Rgaa32017-11-14-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-11-15') WHERE `Cd_Test` LIKE 'Rgaa32017-11-15-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-1') WHERE `Cd_Test` LIKE 'Rgaa32017-12-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-2') WHERE `Cd_Test` LIKE 'Rgaa32017-12-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-3') WHERE `Cd_Test` LIKE 'Rgaa32017-12-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-4') WHERE `Cd_Test` LIKE 'Rgaa32017-12-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-5') WHERE `Cd_Test` LIKE 'Rgaa32017-12-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-6') WHERE `Cd_Test` LIKE 'Rgaa32017-12-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-7') WHERE `Cd_Test` LIKE 'Rgaa32017-12-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-8') WHERE `Cd_Test` LIKE 'Rgaa32017-12-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-9') WHERE `Cd_Test` LIKE 'Rgaa32017-12-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-10') WHERE `Cd_Test` LIKE 'Rgaa32017-12-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-11') WHERE `Cd_Test` LIKE 'Rgaa32017-12-11-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-12') WHERE `Cd_Test` LIKE 'Rgaa32017-12-12-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-13') WHERE `Cd_Test` LIKE 'Rgaa32017-12-13-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-12-14') WHERE `Cd_Test` LIKE 'Rgaa32017-12-14-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-1') WHERE `Cd_Test` LIKE 'Rgaa32017-13-1-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-2') WHERE `Cd_Test` LIKE 'Rgaa32017-13-2-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-3') WHERE `Cd_Test` LIKE 'Rgaa32017-13-3-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-4') WHERE `Cd_Test` LIKE 'Rgaa32017-13-4-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-5') WHERE `Cd_Test` LIKE 'Rgaa32017-13-5-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-6') WHERE `Cd_Test` LIKE 'Rgaa32017-13-6-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-7') WHERE `Cd_Test` LIKE 'Rgaa32017-13-7-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-8') WHERE `Cd_Test` LIKE 'Rgaa32017-13-8-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-9') WHERE `Cd_Test` LIKE 'Rgaa32017-13-9-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-10') WHERE `Cd_Test` LIKE 'Rgaa32017-13-10-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-11') WHERE `Cd_Test` LIKE 'Rgaa32017-13-11-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-12') WHERE `Cd_Test` LIKE 'Rgaa32017-13-12-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-13') WHERE `Cd_Test` LIKE 'Rgaa32017-13-13-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-14') WHERE `Cd_Test` LIKE 'Rgaa32017-13-14-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-15') WHERE `Cd_Test` LIKE 'Rgaa32017-13-15-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-16') WHERE `Cd_Test` LIKE 'Rgaa32017-13-16-%';
UPDATE `TEST` SET `Id_Criterion` = (SELECT `Id_Criterion` FROM `CRITERION` WHERE `Cd_Criterion` LIKE 'Rgaa32017-13-17') WHERE `Cd_Test` LIKE 'Rgaa32017-13-17-%';

-- ---------------------------------------------------------------------------------------------------------
-- AccedeWeb Insert Data
-- ---------------------------------------------------------------------------------------------------------
INSERT IGNORE INTO `ACCEDEWEB` (`Cd_Accedeweb`, `Rank`, `Dtype`, `Cd_Rgaa3`, `Id_Test_Id`) VALUES
( 'Rgaa32017-1-1-1-Accedeweb-GRAPH-2-3' ,1,'G' , 'Rgaa32017-1-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-1' )),
( 'Rgaa32017-1-1-1-Accedeweb-HTML-6-3' ,2,'H' , 'Rgaa32017-1-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-1' )),
( 'Rgaa32017-1-1-1-Accedeweb-EDIT-4-1' ,3,'E' , 'Rgaa32017-1-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-1' )),
( 'Rgaa32017-1-1-1-Accedeweb-EDIT-4-2' ,4,'E' , 'Rgaa32017-1-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-1' )),
( 'Rgaa32017-1-1-2-Accedeweb-GRAPH-2-3' ,5,'G' , 'Rgaa32017-1-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-2' )),
( 'Rgaa32017-1-1-2-Accedeweb-HTML-13' ,6,'H' , 'Rgaa32017-1-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-2' )),
( 'Rgaa32017-1-1-2-Accedeweb-EDIT-4-1' ,7,'E' , 'Rgaa32017-1-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-2' )),
( 'Rgaa32017-1-1-2-Accedeweb-EDIT-4-2' ,8,'E' , 'Rgaa32017-1-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-2' )),
( 'Rgaa32017-1-1-3-Accedeweb-GRAPH-2-3' ,9,'G' , 'Rgaa32017-1-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-3' )),
( 'Rgaa32017-1-1-3-Accedeweb-HTML-6-3' ,10,'H' , 'Rgaa32017-1-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-3' )),
( 'Rgaa32017-1-1-3-Accedeweb-EDIT-4-2' ,11,'E' , 'Rgaa32017-1-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-3' )),
( 'Rgaa32017-1-1-3-Accedeweb-GRAPH-2-3' ,12,'G' , 'Rgaa32017-1-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-1-3' )),
( 'Rgaa32017-1-2-1-Accedeweb-GRAPH-2-3' ,13,'G' , 'Rgaa32017-1-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-1' )),
( 'Rgaa32017-1-2-1-Accedeweb-HTML-6-3' ,14,'H' , 'Rgaa32017-1-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-1' )),
( 'Rgaa32017-1-2-1-Accedeweb-EDIT-4-1' ,15,'E' , 'Rgaa32017-1-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-1' )),
( 'Rgaa32017-1-2-2-Accedeweb-GRAPH-2-3' ,16,'G' , 'Rgaa32017-1-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-2' )),
( 'Rgaa32017-1-2-2-Accedeweb-EDIT-4-1' ,17,'E' , 'Rgaa32017-1-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-2' )),
( 'Rgaa32017-1-2-3-Accedeweb-GRAPH-2-3' ,18,'G' , 'Rgaa32017-1-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-3' )),
( 'Rgaa32017-1-2-3-Accedeweb-EDIT-4-1' ,19,'E' , 'Rgaa32017-1-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-3' )),
( 'Rgaa32017-1-2-4-Accedeweb-HTML-6-2' ,20,'H' , 'Rgaa32017-1-2-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-4' )),
( 'Rgaa32017-1-2-4-Accedeweb-EDIT-4-1' ,21,'E' , 'Rgaa32017-1-2-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-4' )),
( 'Rgaa32017-1-2-5-Accedeweb-EDIT-4-1' ,22,'E' , 'Rgaa32017-1-2-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-5' )),
( 'Rgaa32017-1-2-6-Accedeweb-EDIT-4-1' ,23,'E' , 'Rgaa32017-1-2-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-2-6' )),
( 'Rgaa32017-1-3-1-Accedeweb-GRAPH-2-3' ,24,'G' , 'Rgaa32017-1-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-1' )),
( 'Rgaa32017-1-3-1-Accedeweb-HTML-6-3' ,25,'H' , 'Rgaa32017-1-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-1' )),
( 'Rgaa32017-1-3-1-Accedeweb-EDIT-4-2' ,26,'E' , 'Rgaa32017-1-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-1' )),
( 'Rgaa32017-1-3-2-Accedeweb-GRAPH-2-3' ,27,'G' , 'Rgaa32017-1-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-2' )),
( 'Rgaa32017-1-3-2-Accedeweb-HTML-13' ,28,'H' , 'Rgaa32017-1-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-2' )),
( 'Rgaa32017-1-3-2-Accedeweb-EDIT-4-2' ,29,'E' , 'Rgaa32017-1-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-2' )),
( 'Rgaa32017-1-3-3-Accedeweb-GRAPH-2-3' ,30,'G' , 'Rgaa32017-1-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-3' )),
( 'Rgaa32017-1-3-3-Accedeweb-HTML-6-3' ,31,'H' , 'Rgaa32017-1-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-3' )),
( 'Rgaa32017-1-3-3-Accedeweb-EDIT-4-2' ,32,'E' , 'Rgaa32017-1-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-3' )),
( 'Rgaa32017-1-3-4-Accedeweb-GRAPH-2-3' ,33,'G' , 'Rgaa32017-1-3-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-4' )),
( 'Rgaa32017-1-3-4-Accedeweb-EDIT-4-2' ,34,'E' , 'Rgaa32017-1-3-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-4' )),
( 'Rgaa32017-1-3-5-Accedeweb-GRAPH-2-3' ,35,'G' , 'Rgaa32017-1-3-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-5' )),
( 'Rgaa32017-1-3-6-Accedeweb-GRAPH-2-3' ,36,'G' , 'Rgaa32017-1-3-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-6' )),
( 'Rgaa32017-1-3-6-Accedeweb-EDIT-4-2' ,37,'E' , 'Rgaa32017-1-3-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-6' )),
( 'Rgaa32017-1-3-7-Accedeweb-GRAPH-2-3' ,38,'G' , 'Rgaa32017-1-3-7' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-7' )),
( 'Rgaa32017-1-3-8-Accedeweb-GRAPH-2-3' ,39,'G' , 'Rgaa32017-1-3-8' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-8' )),
( 'Rgaa32017-1-3-8-Accedeweb-EDIT-4-2' ,40,'E' , 'Rgaa32017-1-3-8' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-8' )),
( 'Rgaa32017-1-3-9-Accedeweb-GRAPH-2-3' ,41,'G' , 'Rgaa32017-1-3-9' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-9' )),
( 'Rgaa32017-1-3-10-Accedeweb-GRAPH-2-3' ,42,'G' , 'Rgaa32017-1-3-10' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-10' )),
( 'Rgaa32017-1-3-10-Accedeweb-EDIT-4-2' ,43,'E' , 'Rgaa32017-1-3-10' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-10' )),
( 'Rgaa32017-1-3-11-Accedeweb-GRAPH-2-3' ,44,'G' , 'Rgaa32017-1-3-11' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-11' )),
( 'Rgaa32017-1-3-12-Accedeweb-GRAPH-2-3' ,45,'G' , 'Rgaa32017-1-3-12' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-12' )),
( 'Rgaa32017-1-3-13-Accedeweb-GRAPH-2-3' ,46,'G' , 'Rgaa32017-1-3-13' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-13' )),
( 'Rgaa32017-1-3-13-Accedeweb-EDIT-4-2' ,47,'E' , 'Rgaa32017-1-3-13' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-3-13' )),
( 'Rgaa32017-1-5-1-Accedeweb-GRAPH-7-13' ,48,'G' , 'Rgaa32017-1-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-5-1' )),
( 'Rgaa32017-1-5-1-Accedeweb-GRAPH-7-14' ,49,'G' , 'Rgaa32017-1-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-5-1' )),
( 'Rgaa32017-1-5-2-Accedeweb-GRAPH-7-13' ,50,'G' , 'Rgaa32017-1-5-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-5-2' )),
( 'Rgaa32017-1-5-2-Accedeweb-GRAPH-7-14' ,51,'G' , 'Rgaa32017-1-5-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-5-2' )),
( 'Rgaa32017-1-6-1-Accedeweb-EDIT-4-4' ,52,'E' , 'Rgaa32017-1-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-1' )),
( 'Rgaa32017-1-6-1-Accedeweb-EDIT-8-1' ,53,'E' , 'Rgaa32017-1-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-1' )),
( 'Rgaa32017-1-6-2-Accedeweb-EDIT-4-4' ,54,'E' , 'Rgaa32017-1-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-2' )),
( 'Rgaa32017-1-6-2-Accedeweb-EDIT-8-1' ,55,'E' , 'Rgaa32017-1-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-2' )),
( 'Rgaa32017-1-6-3-Accedeweb-EDIT-4-4' ,56,'E' , 'Rgaa32017-1-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-3' )),
( 'Rgaa32017-1-6-3-Accedeweb-EDIT-8-1' ,57,'E' , 'Rgaa32017-1-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-3' )),
( 'Rgaa32017-1-6-4-Accedeweb-EDIT-4-4' ,58,'E' , 'Rgaa32017-1-6-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-4' )),
( 'Rgaa32017-1-6-4-Accedeweb-EDIT-8-1' ,59,'E' , 'Rgaa32017-1-6-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-4' )),
( 'Rgaa32017-1-6-6-Accedeweb-HTML-13' ,60,'H' , 'Rgaa32017-1-6-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-6' )),
( 'Rgaa32017-1-6-6-Accedeweb-EDIT-4-4' ,61,'E' , 'Rgaa32017-1-6-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-6' )),
( 'Rgaa32017-1-6-6-Accedeweb-EDIT-8-1' ,62,'E' , 'Rgaa32017-1-6-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-6' )),
( 'Rgaa32017-1-6-7-Accedeweb-HTML-13' ,63,'H' , 'Rgaa32017-1-6-7' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-7' )),
( 'Rgaa32017-1-6-8-Accedeweb-EDIT-4-4' ,64,'E' , 'Rgaa32017-1-6-8' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-8' )),
( 'Rgaa32017-1-6-8-Accedeweb-EDIT-8-1' ,65,'E' , 'Rgaa32017-1-6-8' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-6-8' )),
( 'Rgaa32017-1-7-1-Accedeweb-EDIT-4-4' ,66,'E' , 'Rgaa32017-1-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-1' )),
( 'Rgaa32017-1-7-1-Accedeweb-EDIT-8-1' ,67,'E' , 'Rgaa32017-1-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-1' )),
( 'Rgaa32017-1-7-2-Accedeweb-EDIT-4-4' ,68,'E' , 'Rgaa32017-1-7-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-2' )),
( 'Rgaa32017-1-7-2-Accedeweb-EDIT-8-1' ,69,'E' , 'Rgaa32017-1-7-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-2' )),
( 'Rgaa32017-1-7-3-Accedeweb-EDIT-4-4' ,70,'E' , 'Rgaa32017-1-7-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-3' )),
( 'Rgaa32017-1-7-3-Accedeweb-EDIT-8-1' ,71,'E' , 'Rgaa32017-1-7-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-3' )),
( 'Rgaa32017-1-7-4-Accedeweb-EDIT-4-4' ,72,'E' , 'Rgaa32017-1-7-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-4' )),
( 'Rgaa32017-1-7-4-Accedeweb-EDIT-8-1' ,73,'E' , 'Rgaa32017-1-7-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-4' )),
( 'Rgaa32017-1-7-5-Accedeweb-HTML-13' ,74,'H' , 'Rgaa32017-1-7-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-5' )),
( 'Rgaa32017-1-7-5-Accedeweb-EDIT-4-4' ,75,'E' , 'Rgaa32017-1-7-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-5' )),
( 'Rgaa32017-1-7-5-Accedeweb-EDIT-8-1' ,76,'E' , 'Rgaa32017-1-7-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-5' )),
( 'Rgaa32017-1-7-6-Accedeweb-HTML-13' ,77,'H' , 'Rgaa32017-1-7-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-6' )),
( 'Rgaa32017-1-7-7-Accedeweb-EDIT-4-4' ,78,'E' , 'Rgaa32017-1-7-7' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-7' )),
( 'Rgaa32017-1-7-7-Accedeweb-EDIT-8-1' ,79,'E' , 'Rgaa32017-1-7-7' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-7-7' )),
( 'Rgaa32017-1-8-1-Accedeweb-HTML-10-1' ,80,'H' , 'Rgaa32017-1-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-8-1' )),
( 'Rgaa32017-1-8-2-Accedeweb-HTML-10-1' ,81,'H' , 'Rgaa32017-1-8-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-8-2' )),
( 'Rgaa32017-1-8-3-Accedeweb-HTML-10-1' ,82,'H' , 'Rgaa32017-1-8-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-8-3' )),
( 'Rgaa32017-1-8-4-Accedeweb-HTML-10-1' ,83,'H' , 'Rgaa32017-1-8-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-8-4' )),
( 'Rgaa32017-1-8-5-Accedeweb-HTML-10-1' ,84,'H' , 'Rgaa32017-1-8-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-8-5' )),
( 'Rgaa32017-1-9-1-Accedeweb-HTML-10-1' ,85,'H' , 'Rgaa32017-1-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-9-1' )),
( 'Rgaa32017-1-9-2-Accedeweb-HTML-10-1' ,86,'H' , 'Rgaa32017-1-9-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-9-2' )),
( 'Rgaa32017-1-9-3-Accedeweb-HTML-10-1' ,87,'H' , 'Rgaa32017-1-9-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-9-3' )),
( 'Rgaa32017-1-9-4-Accedeweb-HTML-10-1' ,88,'H' , 'Rgaa32017-1-9-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-9-4' )),
( 'Rgaa32017-1-9-5-Accedeweb-HTML-10-1' ,89,'H' , 'Rgaa32017-1-9-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-9-5' )),
( 'Rgaa32017-1-10-1-Accedeweb-HTML-6-4' ,90,'H' , 'Rgaa32017-1-10-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-1-10-1' )),
( 'Rgaa32017-2-1-1-Accedeweb-HTML-13' ,91,'H' , 'Rgaa32017-2-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-2-1-1' )),
( 'Rgaa32017-2-2-1-Accedeweb-HTML-13' ,92,'H' , 'Rgaa32017-2-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-2-2-1' )),
( 'Rgaa32017-3-1-1-Accedeweb-GRAPH-3-2' ,93,'G' , 'Rgaa32017-3-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-1' )),
( 'Rgaa32017-3-1-1-Accedeweb-HTML-10-3' ,94,'H' , 'Rgaa32017-3-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-1' )),
( 'Rgaa32017-3-1-1-Accedeweb-EDIT-7-2' ,95,'E' , 'Rgaa32017-3-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-1' )),
( 'Rgaa32017-3-1-2-Accedeweb-GRAPH-3-2' ,96,'G' , 'Rgaa32017-3-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-2' )),
( 'Rgaa32017-3-1-2-Accedeweb-EDIT-6-5' ,97,'E' , 'Rgaa32017-3-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-2' )),
( 'Rgaa32017-3-1-2-Accedeweb-EDIT-7-2' ,98,'E' , 'Rgaa32017-3-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-2' )),
( 'Rgaa32017-3-1-3-Accedeweb-GRAPH-3-2' ,99,'G' , 'Rgaa32017-3-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-3' )),
( 'Rgaa32017-3-1-3-Accedeweb-EDIT-7-2' ,100,'E' , 'Rgaa32017-3-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-3' )),
( 'Rgaa32017-3-1-4-Accedeweb-GRAPH-3-2' ,101,'G' , 'Rgaa32017-3-1-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-4' )),
( 'Rgaa32017-3-1-4-Accedeweb-HTML-10-3' ,102,'H' , 'Rgaa32017-3-1-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-4' )),
( 'Rgaa32017-3-1-4-Accedeweb-EDIT-7-2' ,103,'E' , 'Rgaa32017-3-1-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-4' )),
( 'Rgaa32017-3-1-5-Accedeweb-GRAPH-3-2' ,104,'G' , 'Rgaa32017-3-1-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-5' )),
( 'Rgaa32017-3-1-5-Accedeweb-EDIT-7-2' ,105,'E' , 'Rgaa32017-3-1-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-5' )),
( 'Rgaa32017-3-1-6-Accedeweb-GRAPH-3-2' ,106,'G' , 'Rgaa32017-3-1-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-6' )),
( 'Rgaa32017-3-1-6-Accedeweb-EDIT-7-2' ,107,'E' , 'Rgaa32017-3-1-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-1-6' )),
( 'Rgaa32017-3-2-1-Accedeweb-GRAPH-3-2' ,108,'G' , 'Rgaa32017-3-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-1' )),
( 'Rgaa32017-3-2-1-Accedeweb-HTML-10-3' ,109,'H' , 'Rgaa32017-3-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-1' )),
( 'Rgaa32017-3-2-1-Accedeweb-EDIT-7-2' ,110,'E' , 'Rgaa32017-3-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-1' )),
( 'Rgaa32017-3-2-2-Accedeweb-GRAPH-3-2' ,111,'G' , 'Rgaa32017-3-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-2' )),
( 'Rgaa32017-3-2-2-Accedeweb-EDIT-6-5' ,112,'E' , 'Rgaa32017-3-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-2' )),
( 'Rgaa32017-3-2-2-Accedeweb-EDIT-7-2' ,113,'E' , 'Rgaa32017-3-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-2' )),
( 'Rgaa32017-3-2-3-Accedeweb-GRAPH-3-2' ,114,'G' , 'Rgaa32017-3-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-3' )),
( 'Rgaa32017-3-2-3-Accedeweb-EDIT-7-2' ,115,'E' , 'Rgaa32017-3-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-3' )),
( 'Rgaa32017-3-2-4-Accedeweb-GRAPH-3-2' ,116,'G' , 'Rgaa32017-3-2-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-4' )),
( 'Rgaa32017-3-2-4-Accedeweb-HTML-10-3' ,117,'H' , 'Rgaa32017-3-2-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-4' )),
( 'Rgaa32017-3-2-4-Accedeweb-EDIT-7-2' ,118,'E' , 'Rgaa32017-3-2-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-4' )),
( 'Rgaa32017-3-2-5-Accedeweb-GRAPH-3-2' ,119,'G' , 'Rgaa32017-3-2-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-5' )),
( 'Rgaa32017-3-2-5-Accedeweb-EDIT-7-2' ,120,'E' , 'Rgaa32017-3-2-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-5' )),
( 'Rgaa32017-3-2-6-Accedeweb-GRAPH-3-2' ,121,'G' , 'Rgaa32017-3-2-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-6' )),
( 'Rgaa32017-3-2-6-Accedeweb-EDIT-7-2' ,122,'E' , 'Rgaa32017-3-2-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-2-6' )),
( 'Rgaa32017-3-3-1-Accedeweb-GRAPH-3-1' ,123,'G' , 'Rgaa32017-3-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-1' )),
( 'Rgaa32017-3-3-1-Accedeweb-GRAPH-8-5' ,124,'G' , 'Rgaa32017-3-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-1' )),
( 'Rgaa32017-3-3-1-Accedeweb-EDIT-7-1' ,125,'E' , 'Rgaa32017-3-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-1' )),
( 'Rgaa32017-3-3-2-Accedeweb-GRAPH-3-1' ,126,'G' , 'Rgaa32017-3-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-2' )),
( 'Rgaa32017-3-3-2-Accedeweb-EDIT-7-1' ,127,'E' , 'Rgaa32017-3-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-2' )),
( 'Rgaa32017-3-3-3-Accedeweb-GRAPH-3-1' ,128,'G' , 'Rgaa32017-3-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-3' )),
( 'Rgaa32017-3-3-3-Accedeweb-EDIT-7-1' ,129,'E' , 'Rgaa32017-3-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-3' )),
( 'Rgaa32017-3-3-4-Accedeweb-GRAPH-3-1' ,130,'G' , 'Rgaa32017-3-3-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-4' )),
( 'Rgaa32017-3-3-4-Accedeweb-EDIT-7-1' ,131,'E' , 'Rgaa32017-3-3-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-3-4' )),
( 'Rgaa32017-3-4-1-Accedeweb-EDIT-7-1' ,132,'E' , 'Rgaa32017-3-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-4-1' )),
( 'Rgaa32017-3-4-2-Accedeweb-EDIT-7-1' ,133,'E' , 'Rgaa32017-3-4-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-4-2' )),
( 'Rgaa32017-3-4-3-Accedeweb-EDIT-7-1' ,134,'E' , 'Rgaa32017-3-4-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-4-3' )),
( 'Rgaa32017-3-4-4-Accedeweb-EDIT-7-1' ,135,'E' , 'Rgaa32017-3-4-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-3-4-4' )),
( 'Rgaa32017-4-1-1-Accedeweb-GRAPH-8-2' ,136,'G' , 'Rgaa32017-4-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-1' )),
( 'Rgaa32017-4-1-1-Accedeweb-GRAPH-8-6' ,137,'G' , 'Rgaa32017-4-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-1' )),
( 'Rgaa32017-4-1-1-Accedeweb-HTML-13' ,138,'H' , 'Rgaa32017-4-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-1' )),
( 'Rgaa32017-4-1-1-Accedeweb-EDIT-8-3' ,139,'E' , 'Rgaa32017-4-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-1' )),
( 'Rgaa32017-4-1-2-Accedeweb-GRAPH-8-6' ,140,'G' , 'Rgaa32017-4-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-2' )),
( 'Rgaa32017-4-1-2-Accedeweb-GRAPH-8-2' ,141,'G' , 'Rgaa32017-4-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-2' )),
( 'Rgaa32017-4-1-2-Accedeweb-HTML-13' ,142,'H' , 'Rgaa32017-4-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-2' )),
( 'Rgaa32017-4-1-2-Accedeweb-EDIT-8-3' ,143,'E' , 'Rgaa32017-4-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-2' )),
( 'Rgaa32017-4-1-3-Accedeweb-GRAPH-8-6' ,144,'G' , 'Rgaa32017-4-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-3' )),
( 'Rgaa32017-4-1-3-Accedeweb-GRAPH-8-2' ,145,'G' , 'Rgaa32017-4-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-3' )),
( 'Rgaa32017-4-1-3-Accedeweb-HTML-13' ,146,'H' , 'Rgaa32017-4-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-3' )),
( 'Rgaa32017-4-1-3-Accedeweb-EDIT-8-3' ,147,'E' , 'Rgaa32017-4-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-1-3' )),
( 'Rgaa32017-4-2-1-Accedeweb-HTML-13' ,148,'H' , 'Rgaa32017-4-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-1' )),
( 'Rgaa32017-4-2-1-Accedeweb-EDIT-8-3' ,149,'E' , 'Rgaa32017-4-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-1' )),
( 'Rgaa32017-4-2-2-Accedeweb-HTML-13' ,150,'H' , 'Rgaa32017-4-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-2' )),
( 'Rgaa32017-4-2-2-Accedeweb-EDIT-8-3' ,151,'E' , 'Rgaa32017-4-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-2' )),
( 'Rgaa32017-4-2-3-Accedeweb-HTML-13' ,152,'H' , 'Rgaa32017-4-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-3' )),
( 'Rgaa32017-4-2-3-Accedeweb-EDIT-8-3' ,153,'E' , 'Rgaa32017-4-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-2-3' )),
( 'Rgaa32017-4-3-1-Accedeweb-EDIT-8-3' ,154,'E' , 'Rgaa32017-4-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-3-1' )),
( 'Rgaa32017-4-3-1-Accedeweb-EDIT-8-4' ,155,'E' , 'Rgaa32017-4-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-3-1' )),
( 'Rgaa32017-4-3-2-Accedeweb-EDIT-8-3' ,156,'E' , 'Rgaa32017-4-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-3-2' )),
( 'Rgaa32017-4-4-1-Accedeweb-EDIT-8-3' ,157,'E' , 'Rgaa32017-4-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-4-1' )),
( 'Rgaa32017-4-5-1-Accedeweb-EDIT-8-4' ,158,'E' , 'Rgaa32017-4-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-5-1' )),
( 'Rgaa32017-4-7-1-Accedeweb-GRAPH-8-6' ,159,'G' , 'Rgaa32017-4-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-7-1' )),
( 'Rgaa32017-4-7-1-Accedeweb-EDIT-8-3' ,160,'E' , 'Rgaa32017-4-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-7-1' )),
( 'Rgaa32017-4-7-2-Accedeweb-EDIT-8-3' ,161,'E' , 'Rgaa32017-4-7-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-7-2' )),
( 'Rgaa32017-4-8-1-Accedeweb-EDIT-8-3' ,162,'E' , 'Rgaa32017-4-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-8-1' )),
( 'Rgaa32017-4-8-2-Accedeweb-EDIT-8-3' ,163,'E' , 'Rgaa32017-4-8-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-8-2' )),
( 'Rgaa32017-4-13-1-Accedeweb-GRAPH-8-2' ,164,'G' , 'Rgaa32017-4-13-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-13-1' )),
( 'Rgaa32017-4-13-1-Accedeweb-EDIT-8-3' ,165,'E' , 'Rgaa32017-4-13-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-13-1' )),
( 'Rgaa32017-4-13-2-Accedeweb-GRAPH-8-2' ,166,'G' , 'Rgaa32017-4-13-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-13-2' )),
( 'Rgaa32017-4-13-2-Accedeweb-EDIT-8-3' ,167,'E' , 'Rgaa32017-4-13-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-13-2' )),
( 'Rgaa32017-4-14-1-Accedeweb-EDIT-8-3' ,168,'E' , 'Rgaa32017-4-14-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-14-1' )),
( 'Rgaa32017-4-14-2-Accedeweb-EDIT-8-3' ,169,'E' , 'Rgaa32017-4-14-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-14-2' )),
( 'Rgaa32017-4-15-1-Accedeweb-GRAPH-8-1' ,170,'G' , 'Rgaa32017-4-15-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-15-1' )),
( 'Rgaa32017-4-15-2-Accedeweb-GRAPH-8-1' ,171,'G' , 'Rgaa32017-4-15-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-15-2' )),
( 'Rgaa32017-4-16-1-Accedeweb-HTML-13' ,172,'H' , 'Rgaa32017-4-16-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-16-1' )),
( 'Rgaa32017-4-16-2-Accedeweb-HTML-13' ,173,'H' , 'Rgaa32017-4-16-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-16-2' )),
( 'Rgaa32017-4-17-1-Accedeweb-HTML-13' ,174,'H' , 'Rgaa32017-4-17-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-17-1' )),
( 'Rgaa32017-4-20-1-Accedeweb-GRAPH-4-20' ,175,'G' , 'Rgaa32017-4-20-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-20-1' )),
( 'Rgaa32017-4-22-1-Accedeweb-HTML-13' ,176,'H' , 'Rgaa32017-4-22-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-4-22-1' )),
( 'Rgaa32017-5-1-1-Accedeweb-HTML-9-1' ,177,'H' , 'Rgaa32017-5-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-1-1' )),
( 'Rgaa32017-5-2-1-Accedeweb-HTML-9-1' ,178,'H' , 'Rgaa32017-5-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-2-1' )),
( 'Rgaa32017-5-3-1-Accedeweb-HTML-9-5' ,179,'H' , 'Rgaa32017-5-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-3-1' )),
( 'Rgaa32017-5-3-1-Accedeweb-HTML-9-7' ,180,'H' , 'Rgaa32017-5-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-3-1' )),
( 'Rgaa32017-5-4-1-Accedeweb-GRAPH-6-1' ,181,'G' , 'Rgaa32017-5-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-4-1' )),
( 'Rgaa32017-5-4-1-Accedeweb-HTML-9-1' ,182,'H' , 'Rgaa32017-5-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-4-1' )),
( 'Rgaa32017-5-5-1-Accedeweb-GRAPH-6-1' ,183,'G' , 'Rgaa32017-5-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-5-1' )),
( 'Rgaa32017-5-5-1-Accedeweb-HTML-9-1' ,184,'H' , 'Rgaa32017-5-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-5-1' )),
( 'Rgaa32017-5-6-1-Accedeweb-HTML-9-2' ,185,'H' , 'Rgaa32017-5-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-6-1' )),
( 'Rgaa32017-5-6-2-Accedeweb-HTML-9-2' ,186,'H' , 'Rgaa32017-5-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-6-2' )),
( 'Rgaa32017-5-7-1-Accedeweb-HTML-9-3' ,187,'H' , 'Rgaa32017-5-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-7-1' )),
( 'Rgaa32017-5-7-2-Accedeweb-HTML-9-3' ,188,'H' , 'Rgaa32017-5-7-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-7-2' )),
( 'Rgaa32017-5-7-3-Accedeweb-HTML-9-4' ,189,'H' , 'Rgaa32017-5-7-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-7-3' )),
( 'Rgaa32017-5-7-4-Accedeweb-HTML-9-4' ,190,'H' , 'Rgaa32017-5-7-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-7-4' )),
( 'Rgaa32017-5-8-1-Accedeweb-HTML-9-6' ,191,'H' , 'Rgaa32017-5-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-5-8-1' )),
( 'Rgaa32017-6-1-1-Accedeweb-GRAPH-4-1' ,192,'G' , 'Rgaa32017-6-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-1' )),
( 'Rgaa32017-6-1-1-Accedeweb-HTML-5-2' ,193,'H' , 'Rgaa32017-6-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-1' )),
( 'Rgaa32017-6-1-1-Accedeweb-EDIT-3-1' ,194,'E' , 'Rgaa32017-6-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-1' )),
( 'Rgaa32017-6-1-2-Accedeweb-GRAPH-4-1' ,195,'G' , 'Rgaa32017-6-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-2' )),
( 'Rgaa32017-6-1-2-Accedeweb-HTML-5-2' ,196,'H' , 'Rgaa32017-6-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-2' )),
( 'Rgaa32017-6-1-2-Accedeweb-HTML-6-3' ,197,'H' , 'Rgaa32017-6-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-2' )),
( 'Rgaa32017-6-1-2-Accedeweb-EDIT-4-3' ,198,'E' , 'Rgaa32017-6-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-2' )),
( 'Rgaa32017-6-1-3-Accedeweb-GRAPH-4-1' ,199,'G' , 'Rgaa32017-6-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-3' )),
( 'Rgaa32017-6-1-3-Accedeweb-HTML-5-2' ,200,'H' , 'Rgaa32017-6-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-1-3' )),
( 'Rgaa32017-6-2-1-Accedeweb-HTML-5-3' ,201,'H' , 'Rgaa32017-6-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-1' )),
( 'Rgaa32017-6-2-1-Accedeweb-HTML-5-5' ,202,'H' , 'Rgaa32017-6-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-1' )),
( 'Rgaa32017-6-2-1-Accedeweb-EDIT-3-4' ,203,'E' , 'Rgaa32017-6-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-1' )),
( 'Rgaa32017-6-2-2-Accedeweb-HTML-5-3' ,204,'H' , 'Rgaa32017-6-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-2' )),
( 'Rgaa32017-6-2-2-Accedeweb-HTML-5-5' ,205,'H' , 'Rgaa32017-6-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-2' )),
( 'Rgaa32017-6-2-2-Accedeweb-EDIT-3-4' ,206,'E' , 'Rgaa32017-6-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-2' )),
( 'Rgaa32017-6-2-3-Accedeweb-HTML-5-3' ,207,'H' , 'Rgaa32017-6-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-3' )),
( 'Rgaa32017-6-2-3-Accedeweb-HTML-5-5' ,208,'H' , 'Rgaa32017-6-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-3' )),
( 'Rgaa32017-6-2-3-Accedeweb-EDIT-3-4' ,209,'E' , 'Rgaa32017-6-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-2-3' )),
( 'Rgaa32017-6-3-1-Accedeweb-GRAPH-4-1' ,210,'G' , 'Rgaa32017-6-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-1' )),
( 'Rgaa32017-6-3-1-Accedeweb-HTML-5-2' ,211,'H' , 'Rgaa32017-6-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-1' )),
( 'Rgaa32017-6-3-1-Accedeweb-EDIT-3-1' ,212,'E' , 'Rgaa32017-6-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-1' )),
( 'Rgaa32017-6-3-2-Accedeweb-GRAPH-4-1' ,213,'G' , 'Rgaa32017-6-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-2' )),
( 'Rgaa32017-6-3-2-Accedeweb-HTML-6-3' ,214,'H' , 'Rgaa32017-6-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-2' )),
( 'Rgaa32017-6-3-2-Accedeweb-EDIT-4-3' ,215,'E' , 'Rgaa32017-6-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-3-2' )),
( 'Rgaa32017-6-4-1-Accedeweb-GRAPH-4-1' ,216,'G' , 'Rgaa32017-6-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-6-4-1' )),
( 'Rgaa32017-7-1-1-Accedeweb-HTML-5-1' ,217,'H' , 'Rgaa32017-7-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-1-1' )),
( 'Rgaa32017-7-1-1-Accedeweb-HTML-5-2' ,218,'H' , 'Rgaa32017-7-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-1-1' )),
( 'Rgaa32017-7-1-1-Accedeweb-HTML-6-2' ,219,'H' , 'Rgaa32017-7-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-1-1' )),
( 'Rgaa32017-7-1-5-Accedeweb-HTML-5-2' ,220,'H' , 'Rgaa32017-7-1-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-1-5' )),
( 'Rgaa32017-7-3-1-Accedeweb-HTML-13-1' ,221,'H' , 'Rgaa32017-7-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-3-1' )),
( 'Rgaa32017-7-3-2-Accedeweb-HTML-13-1' ,222,'H' , 'Rgaa32017-7-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-3-2' )),
( 'Rgaa32017-7-3-3-Accedeweb-HTML-13-1' ,223,'H' , 'Rgaa32017-7-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-7-3-3' )),
( 'Rgaa32017-8-1-1-Accedeweb-HTML-4-1' ,224,'H' , 'Rgaa32017-8-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-1-1' )),
( 'Rgaa32017-8-1-2-Accedeweb-HTML-4-1' ,225,'H' , 'Rgaa32017-8-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-1-2' )),
( 'Rgaa32017-8-1-3-Accedeweb-HTML-4-1' ,226,'H' , 'Rgaa32017-8-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-1-3' )),
( 'Rgaa32017-8-2-1-Accedeweb-HTML-4-1' ,227,'H' , 'Rgaa32017-8-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-2-1' )),
( 'Rgaa32017-8-2-2-Accedeweb-HTML-4-1' ,228,'H' , 'Rgaa32017-8-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-2-2' )),
( 'Rgaa32017-8-3-1-Accedeweb-HTML-3-1' ,229,'H' , 'Rgaa32017-8-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-3-1' )),
( 'Rgaa32017-8-4-1-Accedeweb-HTML-3-1' ,230,'H' , 'Rgaa32017-8-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-4-1' )),
( 'Rgaa32017-8-5-1-Accedeweb-HTML-2-1' ,231,'H' , 'Rgaa32017-8-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-5-1' )),
( 'Rgaa32017-8-6-1-Accedeweb-HTML-2-1' ,232,'H' , 'Rgaa32017-8-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-6-1' )),
( 'Rgaa32017-8-7-1-Accedeweb-HTML-3-2' ,233,'H' , 'Rgaa32017-8-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-7-1' )),
( 'Rgaa32017-8-7-1-Accedeweb-EDIT-6-4' ,234,'E' , 'Rgaa32017-8-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-7-1' )),
( 'Rgaa32017-8-8-1-Accedeweb-HTML-3-2' ,235,'H' , 'Rgaa32017-8-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-8-1' )),
( 'Rgaa32017-8-8-1-Accedeweb-EDIT-6-4' ,236,'E' , 'Rgaa32017-8-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-8-1' )),
( 'Rgaa32017-8-8-2-Accedeweb-HTML-3-2' ,237,'H' , 'Rgaa32017-8-8-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-8-2' )),
( 'Rgaa32017-8-8-2-Accedeweb-EDIT-6-4' ,238,'E' , 'Rgaa32017-8-8-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-8-2' )),
( 'Rgaa32017-8-9-1-Accedeweb-HTML-4-2' ,239,'H' , 'Rgaa32017-8-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-9-1' )),
( 'Rgaa32017-8-9-1-Accedeweb-EDIT-1-2' ,240,'E' , 'Rgaa32017-8-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-8-9-1' )),
( 'Rgaa32017-9-1-1-Accedeweb-HTML-1-7' ,241,'H' , 'Rgaa32017-9-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-1' )),
( 'Rgaa32017-9-1-1-Accedeweb-EDIT-2' ,242,'E' , 'Rgaa32017-9-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-1' )),
( 'Rgaa32017-9-1-2-Accedeweb-HTML-1-7' ,243,'H' , 'Rgaa32017-9-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-2' )),
( 'Rgaa32017-9-1-2-Accedeweb-EDIT-2' ,244,'E' , 'Rgaa32017-9-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-2' )),
( 'Rgaa32017-9-1-3-Accedeweb-HTML-1-7' ,245,'H' , 'Rgaa32017-9-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-3' )),
( 'Rgaa32017-9-1-3-Accedeweb-EDIT-2' ,246,'E' , 'Rgaa32017-9-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-3' )),
( 'Rgaa32017-9-1-4-Accedeweb-HTML-1-7' ,247,'H' , 'Rgaa32017-9-1-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-4' )),
( 'Rgaa32017-9-1-4-Accedeweb-EDIT-2' ,248,'E' , 'Rgaa32017-9-1-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-1-4' )),
( 'Rgaa32017-9-2-1-Accedeweb-HTML-1-1' ,249,'H' , 'Rgaa32017-9-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-2-1' )),
( 'Rgaa32017-9-2-1-Accedeweb-HTML-1-3' ,250,'H' , 'Rgaa32017-9-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-2-1' )),
( 'Rgaa32017-9-2-1-Accedeweb-HTML-1-4' ,251,'H' , 'Rgaa32017-9-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-2-1' )),
( 'Rgaa32017-9-2-1-Accedeweb-HTML-1-5' ,252,'H' , 'Rgaa32017-9-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-2-1' )),
( 'Rgaa32017-9-2-2-Accedeweb-HTML-1-7' ,253,'H' , 'Rgaa32017-9-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-2-2' )),
( 'Rgaa32017-9-3-1-Accedeweb-HTML-1-6' ,254,'H' , 'Rgaa32017-9-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-1' )),
( 'Rgaa32017-9-3-1-Accedeweb-HTML-8-1' ,255,'H' , 'Rgaa32017-9-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-1' )),
( 'Rgaa32017-9-3-1-Accedeweb-EDIT-5' ,256,'E' , 'Rgaa32017-9-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-1' )),
( 'Rgaa32017-9-3-2-Accedeweb-HTML-8-2' ,257,'H' , 'Rgaa32017-9-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-2' )),
( 'Rgaa32017-9-3-2-Accedeweb-EDIT-5' ,258,'E' , 'Rgaa32017-9-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-2' )),
( 'Rgaa32017-9-3-3-Accedeweb-HTML-8-3' ,259,'H' , 'Rgaa32017-9-3-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-3-3' )),
( 'Rgaa32017-9-5-1-Accedeweb-EDIT-6-2' ,260,'E' , 'Rgaa32017-9-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-5-1' )),
( 'Rgaa32017-9-6-1-Accedeweb-HTML-13' ,261,'H' , 'Rgaa32017-9-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-6-1' )),
( 'Rgaa32017-9-6-1-Accedeweb-EDIT-6-3' ,262,'E' , 'Rgaa32017-9-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-6-1' )),
( 'Rgaa32017-9-6-2-Accedeweb-HTML-13' ,263,'H' , 'Rgaa32017-9-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-6-2' )),
( 'Rgaa32017-9-6-2-Accedeweb-EDIT-6-3' ,264,'E' , 'Rgaa32017-9-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-9-6-2' )),
( 'Rgaa32017-10-1-1-Accedeweb-EDIT-1-2' ,265,'E' , 'Rgaa32017-10-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-1-1' )),
( 'Rgaa32017-10-1-2-Accedeweb-EDIT-1-2' ,266,'E' , 'Rgaa32017-10-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-1-2' )),
( 'Rgaa32017-10-1-3-Accedeweb-EDIT-1-2' ,267,'E' , 'Rgaa32017-10-1-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-1-3' )),
( 'Rgaa32017-10-2-1-Accedeweb-HTML-6-5' ,268,'H' , 'Rgaa32017-10-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-2-1' )),
( 'Rgaa32017-10-3-1-Accedeweb-HTML-1-8' ,269,'H' , 'Rgaa32017-10-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-3-1' )),
( 'Rgaa32017-10-4-1-Accedeweb-HTML-11-1' ,270,'H' , 'Rgaa32017-10-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-4-1' )),
( 'Rgaa32017-10-4-2-Accedeweb-HTML-11-1' ,271,'H' , 'Rgaa32017-10-4-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-4-2' )),
( 'Rgaa32017-10-4-3-Accedeweb-HTML-11-2' ,272,'H' , 'Rgaa32017-10-4-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-4-3' )),
( 'Rgaa32017-10-5-1-Accedeweb-HTML-10-2' ,273,'H' , 'Rgaa32017-10-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-5-1' )),
( 'Rgaa32017-10-5-2-Accedeweb-HTML-10-2' ,274,'H' , 'Rgaa32017-10-5-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-5-2' )),
( 'Rgaa32017-10-5-3-Accedeweb-HTML-10-2' ,275,'H' , 'Rgaa32017-10-5-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-5-3' )),
( 'Rgaa32017-10-6-1-Accedeweb-GRAPH-4-2' ,276,'G' , 'Rgaa32017-10-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-6-1' )),
( 'Rgaa32017-10-7-1-Accedeweb-HTML-12-3' ,277,'H' , 'Rgaa32017-10-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-7-1' )),
( 'Rgaa32017-10-7-2-Accedeweb-HTML-12-3' ,278,'H' , 'Rgaa32017-10-7-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-7-2' )),
( 'Rgaa32017-10-7-3-Accedeweb-HTML-12-3' ,279,'H' , 'Rgaa32017-10-7-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-7-3' )),
( 'Rgaa32017-10-9-1-Accedeweb-GRAPH-2-2' ,280,'G' , 'Rgaa32017-10-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-9-1' )),
( 'Rgaa32017-10-9-1-Accedeweb-EDIT-1-1' ,281,'E' , 'Rgaa32017-10-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-9-1' )),
( 'Rgaa32017-10-14-1-Accedeweb-HTML-10-3' ,282,'H' , 'Rgaa32017-10-14-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-14-1' )),
( 'Rgaa32017-10-15-1-Accedeweb-HTML-10-3' ,283,'H' , 'Rgaa32017-10-15-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-10-15-1' )),
( 'Rgaa32017-11-1-1-Accedeweb-GRAPH-7-1' ,284,'G' , 'Rgaa32017-11-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-1-1' )),
( 'Rgaa32017-11-1-1-Accedeweb-HTML-7-1' ,285,'H' , 'Rgaa32017-11-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-1-1' )),
( 'Rgaa32017-11-1-1-Accedeweb-HTML-7-2' ,286,'H' , 'Rgaa32017-11-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-1-1' )),
( 'Rgaa32017-11-1-2-Accedeweb-GRAPH-7-1' ,287,'G' , 'Rgaa32017-11-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-1-2' )),
( 'Rgaa32017-11-1-2-Accedeweb-HTML-7-1' ,288,'H' , 'Rgaa32017-11-1-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-1-2' )),
( 'Rgaa32017-11-2-1-Accedeweb-GRAPH-7-1' ,289,'G' , 'Rgaa32017-11-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-1' )),
( 'Rgaa32017-11-2-1-Accedeweb-HTML-7-1' ,290,'H' , 'Rgaa32017-11-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-1' )),
( 'Rgaa32017-11-2-2-Accedeweb-GRAPH-7-1' ,291,'G' , 'Rgaa32017-11-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-2' )),
( 'Rgaa32017-11-2-2-Accedeweb-HTML-7-2' ,292,'H' , 'Rgaa32017-11-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-2' )),
( 'Rgaa32017-11-2-3-Accedeweb-GRAPH-7-1' ,293,'G' , 'Rgaa32017-11-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-3' )),
( 'Rgaa32017-11-2-3-Accedeweb-HTML-7-2' ,294,'H' , 'Rgaa32017-11-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-2-3' )),
( 'Rgaa32017-11-3-1-Accedeweb-GRAPH-7-2' ,295,'G' , 'Rgaa32017-11-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-3-1' )),
( 'Rgaa32017-11-3-1-Accedeweb-HTML-7-1' ,296,'H' , 'Rgaa32017-11-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-3-1' )),
( 'Rgaa32017-11-3-2-Accedeweb-GRAPH-7-2' ,297,'G' , 'Rgaa32017-11-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-3-2' )),
( 'Rgaa32017-11-3-2-Accedeweb-HTML-7-1' ,298,'H' , 'Rgaa32017-11-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-3-2' )),
( 'Rgaa32017-11-4-1-Accedeweb-GRAPH-7-3' ,299,'G' , 'Rgaa32017-11-4-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-4-1' )),
( 'Rgaa32017-11-5-1-Accedeweb-GRAPH-7-4' ,300,'G' , 'Rgaa32017-11-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-5-1' )),
( 'Rgaa32017-11-5-1-Accedeweb-HTML-7-7' ,301,'H' , 'Rgaa32017-11-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-5-1' )),
( 'Rgaa32017-11-6-1-Accedeweb-GRAPH-7-4' ,302,'G' , 'Rgaa32017-11-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-6-1' )),
( 'Rgaa32017-11-6-1-Accedeweb-HTML-7-7' ,303,'H' , 'Rgaa32017-11-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-6-1' )),
( 'Rgaa32017-11-7-1-Accedeweb-GRAPH-7-4' ,304,'G' , 'Rgaa32017-11-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-7-1' )),
( 'Rgaa32017-11-7-1-Accedeweb-HTML-7-7' ,305,'H' , 'Rgaa32017-11-7-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-7-1' )),
( 'Rgaa32017-11-9-1-Accedeweb-GRAPH-7-6' ,306,'G' , 'Rgaa32017-11-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-9-1' )),
( 'Rgaa32017-11-9-1-Accedeweb-HTML-5-2' ,307,'H' , 'Rgaa32017-11-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-9-1' )),
( 'Rgaa32017-11-9-1-Accedeweb-HTML-5-3' ,308,'H' , 'Rgaa32017-11-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-9-1' )),
( 'Rgaa32017-11-10-1-Accedeweb-GRAPH-7-7' ,309,'G' , 'Rgaa32017-11-10-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-1' )),
( 'Rgaa32017-11-10-1-Accedeweb-GRAPH-7-9' ,310,'G' , 'Rgaa32017-11-10-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-1' )),
( 'Rgaa32017-11-10-1-Accedeweb-HTML-7-4' ,311,'H' , 'Rgaa32017-11-10-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-1' )),
( 'Rgaa32017-11-10-2-Accedeweb-GRAPH-7-7' ,312,'G' , 'Rgaa32017-11-10-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-2' )),
( 'Rgaa32017-11-10-2-Accedeweb-GRAPH-7-9' ,313,'G' , 'Rgaa32017-11-10-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-2' )),
( 'Rgaa32017-11-10-2-Accedeweb-HTML-7-4' ,314,'H' , 'Rgaa32017-11-10-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-2' )),
( 'Rgaa32017-11-10-3-Accedeweb-GRAPH-7-7' ,315,'G' , 'Rgaa32017-11-10-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-3' )),
( 'Rgaa32017-11-10-3-Accedeweb-GRAPH-7-9' ,316,'G' , 'Rgaa32017-11-10-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-3' )),
( 'Rgaa32017-11-10-4-Accedeweb-GRAPH-7-7' ,317,'G' , 'Rgaa32017-11-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-4' )),
( 'Rgaa32017-11-10-4-Accedeweb-GRAPH-7-9' ,318,'G' , 'Rgaa32017-11-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-4' )),
( 'Rgaa32017-11-10-4-Accedeweb-HTML-7-5' ,319,'H' , 'Rgaa32017-11-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-4' )),
( 'Rgaa32017-11-10-4-Accedeweb-HTML-7-6' ,320,'H' , 'Rgaa32017-11-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-4' )),
( 'Rgaa32017-11-10-5-Accedeweb-GRAPH-7-7' ,321,'G' , 'Rgaa32017-11-10-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-5' )),
( 'Rgaa32017-11-10-5-Accedeweb-GRAPH-7-9' ,322,'G' , 'Rgaa32017-11-10-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-5' )),
( 'Rgaa32017-11-10-6-Accedeweb-GRAPH-7-7' ,323,'G' , 'Rgaa32017-11-10-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-6' )),
( 'Rgaa32017-11-10-6-Accedeweb-GRAPH-7-9' ,324,'G' , 'Rgaa32017-11-10-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-6' )),
( 'Rgaa32017-11-10-6-Accedeweb-HTML-7-5' ,325,'H' , 'Rgaa32017-11-10-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-10-6' )),
( 'Rgaa32017-11-11-1-Accedeweb-GRAPH-7-9' ,326,'G' , 'Rgaa32017-11-11-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-11-1' )),
( 'Rgaa32017-11-11-1-Accedeweb-GRAPH-7-11' ,327,'G' , 'Rgaa32017-11-11-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-11-1' )),
( 'Rgaa32017-11-11-1-Accedeweb-GRAPH-7-12' ,328,'G' , 'Rgaa32017-11-11-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-11-1' )),
( 'Rgaa32017-11-12-1-Accedeweb-GRAPH-7-11' ,329,'G' , 'Rgaa32017-11-12-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-12-1' )),
( 'Rgaa32017-11-12-1-Accedeweb-GRAPH-7-12' ,330,'G' , 'Rgaa32017-11-12-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-12-1' )),
( 'Rgaa32017-11-14-1-Accedeweb-GRAPH-7-8' ,331,'G' , 'Rgaa32017-11-14-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-1' )),
( 'Rgaa32017-11-14-1-Accedeweb-HTML-7-3' ,332,'H' , 'Rgaa32017-11-14-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-1' )),
( 'Rgaa32017-11-14-2-Accedeweb-GRAPH-7-8' ,333,'G' , 'Rgaa32017-11-14-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-2' )),
( 'Rgaa32017-11-14-3-Accedeweb-GRAPH-7-8' ,334,'G' , 'Rgaa32017-11-14-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-3' )),
( 'Rgaa32017-11-14-3-Accedeweb-HTML-7-3' ,335,'H' , 'Rgaa32017-11-14-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-3' )),
( 'Rgaa32017-11-14-4-Accedeweb-GRAPH-7-8' ,336,'G' , 'Rgaa32017-11-14-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-4' )),
( 'Rgaa32017-11-14-4-Accedeweb-HTML-7-5' ,337,'H' , 'Rgaa32017-11-14-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-4' )),
( 'Rgaa32017-11-14-5-Accedeweb-GRAPH-7-8' ,338,'G' , 'Rgaa32017-11-14-5' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-5' )),
( 'Rgaa32017-11-14-6-Accedeweb-GRAPH-7-8' ,339,'G' , 'Rgaa32017-11-14-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-6' )),
( 'Rgaa32017-11-14-6-Accedeweb-HTML-7-5' ,340,'H' , 'Rgaa32017-11-14-6' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-14-6' )),
( 'Rgaa32017-11-15-1-Accedeweb-GRAPH-7-8' ,341,'G' , 'Rgaa32017-11-15-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-15-1' )),
( 'Rgaa32017-11-15-1-Accedeweb-HTML-7-3' ,342,'H' , 'Rgaa32017-11-15-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-15-1' )),
( 'Rgaa32017-11-15-1-Accedeweb-HTML-7-5' ,343,'H' , 'Rgaa32017-12-1-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-1-1' )),
( 'Rgaa32017-12-1-1-Accedeweb-GRAPH-1-2' ,344,'G' , 'Rgaa32017-11-15-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-11-15-1' )),
( 'Rgaa32017-12-2-1-Accedeweb-HTML-1-9' ,345,'H' , 'Rgaa32017-12-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-2-1' )),
( 'Rgaa32017-12-2-1-Accedeweb-GRAPH-1-4' ,346,'G' , 'Rgaa32017-12-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-2-1' )),
( 'Rgaa32017-12-2-2-Accedeweb-HTML-1-9' ,347,'H' , 'Rgaa32017-12-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-2-2' )),
( 'Rgaa32017-12-2-2-Accedeweb-GRAPH-1-4' ,348,'G' , 'Rgaa32017-12-2-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-2-2' )),
( 'Rgaa32017-12-3-1-Accedeweb-GRAPH-1-4' ,349,'G' , 'Rgaa32017-12-3-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-3-1' )),
( 'Rgaa32017-12-3-2-Accedeweb-GRAPH-1-4' ,350,'G' , 'Rgaa32017-12-3-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-3-2' )),
( 'Rgaa32017-12-5-1-Accedeweb-GRAPH-1-4' ,351,'G' , 'Rgaa32017-12-5-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-5-1' )),
( 'Rgaa32017-12-5-2-Accedeweb-GRAPH-1-4' ,352,'G' , 'Rgaa32017-12-5-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-5-2' )),
( 'Rgaa32017-12-5-3-Accedeweb-GRAPH-1-4' ,353,'G' , 'Rgaa32017-12-5-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-5-3' )),
( 'Rgaa32017-12-6-1-Accedeweb-GRAPH-1-4' ,354,'G' , 'Rgaa32017-12-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-6-1' )),
( 'Rgaa32017-12-6-2-Accedeweb-GRAPH-1-4' ,355,'G' , 'Rgaa32017-12-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-6-2' )),
( 'Rgaa32017-12-6-3-Accedeweb-GRAPH-1-4' ,356,'G' , 'Rgaa32017-12-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-6-3' )),
( 'Rgaa32017-12-5-3-Accedeweb-HTML-1-9' ,357,'H' , 'Rgaa32017-12-5-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-5-3' )),
( 'Rgaa32017-12-6-3-Accedeweb-HTML-1-9' ,358,'H' , 'Rgaa32017-12-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-6-3' )),
( 'Rgaa32017-12-8-1-Accedeweb-GRAPH-1-1' ,359,'G' , 'Rgaa32017-12-8-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-8-1' )),
( 'Rgaa32017-12-9-1-Accedeweb-GRAPH-1-1' ,360,'G' , 'Rgaa32017-12-9-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-9-1' )),
( 'Rgaa32017-12-10-1-Accedeweb-HTML-12-2' ,361,'H' , 'Rgaa32017-12-10-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-1' )),
( 'Rgaa32017-12-10-2-Accedeweb-HTML-12-2' ,362,'H' , 'Rgaa32017-12-10-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-2' )),
( 'Rgaa32017-12-10-3-Accedeweb-HTML-12-2' ,363,'H' , 'Rgaa32017-12-10-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-3' )),
( 'Rgaa32017-12-10-4-Accedeweb-HTML-1-1' ,364,'H' , 'Rgaa32017-12-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-4' )),
( 'Rgaa32017-12-10-4-Accedeweb-HTML-1-2' ,365,'H' , 'Rgaa32017-12-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-4' )),
( 'Rgaa32017-12-10-4-Accedeweb-HTML-1-3' ,366,'H' , 'Rgaa32017-12-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-4' )),
( 'Rgaa32017-12-10-4-Accedeweb-HTML-1-4' ,367,'H' , 'Rgaa32017-12-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-4' )),
( 'Rgaa32017-12-10-4-Accedeweb-HTML-1-5' ,368,'H' , 'Rgaa32017-12-10-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-10-4' )),
( 'Rgaa32017-12-11-1-Accedeweb-GRAPH-1-7' ,369,'G' , 'Rgaa32017-12-11-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-1' )),
( 'Rgaa32017-12-11-2-Accedeweb-GRAPH-1-7' ,370,'G' , 'Rgaa32017-12-11-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-2' )),
( 'Rgaa32017-12-11-3-Accedeweb-GRAPH-1-7' ,371,'G' , 'Rgaa32017-12-11-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-3' )),
( 'Rgaa32017-12-11-4-Accedeweb-GRAPH-1-7' ,372,'G' , 'Rgaa32017-12-11-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-4' )),
( 'Rgaa32017-12-11-1-Accedeweb-HTML-12-2' ,373,'H' , 'Rgaa32017-12-11-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-1' )),
( 'Rgaa32017-12-11-2-Accedeweb-HTML-12-2' ,374,'H' , 'Rgaa32017-12-11-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-2' )),
( 'Rgaa32017-12-11-3-Accedeweb-HTML-12-2' ,375,'H' , 'Rgaa32017-12-11-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-3' )),
( 'Rgaa32017-12-11-4-Accedeweb-HTML-12-2' ,376,'H' , 'Rgaa32017-12-11-4' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-11-4' )),
( 'Rgaa32017-12-12-1-Accedeweb-GRAPH-1-3' ,377,'G' , 'Rgaa32017-12-12-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-12-1' )),
( 'Rgaa32017-12-13-1-Accedeweb-HTML-12-1' ,378,'H' , 'Rgaa32017-12-13-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-13-1' )),
( 'Rgaa32017-12-13-2-Accedeweb-HTML-12-1' ,379,'H' , 'Rgaa32017-12-13-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-12-13-2' )),
( 'Rgaa32017-13-2-1-Accedeweb-HTML-5-5' ,380,'H' , 'Rgaa32017-13-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-2-1' )),
( 'Rgaa32017-13-2-1-Accedeweb-EDIT-3-3' ,381,'E' , 'Rgaa32017-13-2-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-2-1' )),
( 'Rgaa32017-13-2-3-Accedeweb-HTML-5-5' ,382,'H' , 'Rgaa32017-13-2-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-2-3' )),
( 'Rgaa32017-13-6-1-Accedeweb-GRAPH-5-1' ,383,'G' , 'Rgaa32017-13-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-1' )),
( 'Rgaa32017-13-6-1-Accedeweb-HTML-5-4' ,384,'H' , 'Rgaa32017-13-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-1' )),
( 'Rgaa32017-13-6-1-Accedeweb-EDIT-3-2' ,385,'E' , 'Rgaa32017-13-6-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-1' )),
( 'Rgaa32017-13-6-2-Accedeweb-GRAPH-5-1' ,386,'G' , 'Rgaa32017-13-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-2' )),
( 'Rgaa32017-13-6-2-Accedeweb-HTML-5-4' ,387,'H' , 'Rgaa32017-13-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-2' )),
( 'Rgaa32017-13-6-2-Accedeweb-EDIT-3-2' ,388,'E' , 'Rgaa32017-13-6-2' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-2' )),
( 'Rgaa32017-13-6-3-Accedeweb-GRAPH-5-1' ,389,'G' , 'Rgaa32017-13-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-3' )),
( 'Rgaa32017-13-6-3-Accedeweb-EDIT-3-2' ,390,'E' , 'Rgaa32017-13-6-3' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-6-3' )),
( 'Rgaa32017-13-17-1-Accedeweb-GRAPH-8-8' ,391,'G' , 'Rgaa32017-13-17-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-17-1' )),
( 'Rgaa32017-13-17-1-Accedeweb-EDIT-8-2' ,392,'E' , 'Rgaa32017-13-17-1' ,(SELECT Id_Test FROM TEST where Cd_Test='Rgaa32017-13-17-1' ));

INSERT IGNORE INTO `PARAMETER` (`Id_Parameter_Element`, `Parameter_Value`, `Is_Default`) VALUES
(5, 'Rgaa32017;LEVEL_1', b'0'),
(5, 'Rgaa32017;LEVEL_2', b'1'),
(5, 'Rgaa32017;LEVEL_3', b'0');

UPDATE TEST SET `No_Process`=b'0' WHERE 
Cd_Test='Rgaa32017-1-1-1' OR 
Cd_Test='Rgaa32017-1-1-2' OR 
Cd_Test='Rgaa32017-1-1-3' OR 
Cd_Test='Rgaa32017-1-1-4' OR 
Cd_Test='Rgaa32017-1-2-1' OR
Cd_Test='Rgaa32017-1-2-2' OR
Cd_Test='Rgaa32017-1-2-3' OR
Cd_Test='Rgaa32017-1-2-4' OR
Cd_Test='Rgaa32017-1-2-5' OR
Cd_Test='Rgaa32017-1-2-6' OR
Cd_Test='Rgaa32017-1-3-1' OR 
Cd_Test='Rgaa32017-1-3-2' OR 
Cd_Test='Rgaa32017-1-3-3' OR 
Cd_Test='Rgaa32017-1-3-4' OR 
Cd_Test='Rgaa32017-1-3-5' OR 
Cd_Test='Rgaa32017-1-3-6' OR 
Cd_Test='Rgaa32017-1-3-7' OR 
Cd_Test='Rgaa32017-1-3-8' OR 
Cd_Test='Rgaa32017-1-3-9' OR 
Cd_Test='Rgaa32017-1-3-10' OR 
Cd_Test='Rgaa32017-1-3-11' OR 
Cd_Test='Rgaa32017-1-3-12' OR 
Cd_Test='Rgaa32017-1-4-1' OR
Cd_Test='Rgaa32017-1-4-2' OR
Cd_Test='Rgaa32017-1-4-3' OR
Cd_Test='Rgaa32017-1-4-4' OR
Cd_Test='Rgaa32017-1-4-5' OR
Cd_Test='Rgaa32017-1-4-6' OR
Cd_Test='Rgaa32017-1-4-7' OR
Cd_Test='Rgaa32017-1-4-8' OR
Cd_Test='Rgaa32017-1-4-9' OR
Cd_Test='Rgaa32017-1-4-10' OR
Cd_Test='Rgaa32017-1-4-11' OR
Cd_Test='Rgaa32017-1-4-12' OR
Cd_Test='Rgaa32017-1-5-1' OR
Cd_Test='Rgaa32017-1-5-2' OR
Cd_Test='Rgaa32017-1-6-1' OR
Cd_Test='Rgaa32017-1-6-2' OR
Cd_Test='Rgaa32017-1-6-3' OR
Cd_Test='Rgaa32017-1-6-4' OR
Cd_Test='Rgaa32017-1-6-5' OR
Cd_Test='Rgaa32017-1-6-6' OR
Cd_Test='Rgaa32017-1-6-7' OR
Cd_Test='Rgaa32017-1-6-8' OR
Cd_Test='Rgaa32017-1-6-9' OR
Cd_Test='Rgaa32017-1-7-1' OR
Cd_Test='Rgaa32017-1-7-2' OR
Cd_Test='Rgaa32017-1-7-3' OR
Cd_Test='Rgaa32017-1-7-4' OR
Cd_Test='Rgaa32017-1-7-5' OR
Cd_Test='Rgaa32017-1-7-6' OR
Cd_Test='Rgaa32017-1-7-7' OR
Cd_Test='Rgaa32017-1-7-8' OR
Cd_Test='Rgaa32017-1-8-1' OR
Cd_Test='Rgaa32017-1-8-2' OR
Cd_Test='Rgaa32017-1-8-3' OR
Cd_Test='Rgaa32017-1-8-4' OR
Cd_Test='Rgaa32017-1-8-5' OR
Cd_Test='Rgaa32017-1-8-6' OR
Cd_Test='Rgaa32017-1-9-1' OR
Cd_Test='Rgaa32017-1-9-2' OR
Cd_Test='Rgaa32017-1-9-3' OR
Cd_Test='Rgaa32017-1-9-4' OR
Cd_Test='Rgaa32017-1-9-5' OR
Cd_Test='Rgaa32017-1-9-6' OR
Cd_Test='Rgaa32017-1-10-1' OR
Cd_Test='Rgaa32017-1-10-2' OR
Cd_Test='Rgaa32017-1-10-3' OR
Cd_Test='Rgaa32017-1-10-4' OR
Cd_Test='Rgaa32017-1-10-5' OR
Cd_Test='Rgaa32017-2-1-1' OR
Cd_Test='Rgaa32017-2-2-1' OR
Cd_Test='Rgaa32017-3-3-1' OR
Cd_Test='Rgaa32017-3-3-2' OR
Cd_Test='Rgaa32017-3-3-3' OR
Cd_Test='Rgaa32017-3-3-4' OR
Cd_Test='Rgaa32017-3-4-1' OR
Cd_Test='Rgaa32017-3-4-2' OR
Cd_Test='Rgaa32017-3-4-3' OR
Cd_Test='Rgaa32017-3-4-4' OR
Cd_Test='Rgaa32017-4-1-1' OR
Cd_Test='Rgaa32017-4-1-2' OR
Cd_Test='Rgaa32017-4-22-1' OR 
Cd_Test='Rgaa32017-4-22-2' OR
Cd_Test='Rgaa32017-5-1-1' OR
Cd_Test='Rgaa32017-5-2-1' OR
Cd_Test='Rgaa32017-5-3-1' OR
Cd_Test='Rgaa32017-5-4-1' OR
Cd_Test='Rgaa32017-5-5-1' OR
Cd_Test='Rgaa32017-5-6-1' OR
Cd_Test='Rgaa32017-5-6-2' OR
Cd_Test='Rgaa32017-5-7-1' OR
Cd_Test='Rgaa32017-5-7-2' OR
Cd_Test='Rgaa32017-5-7-3' OR
Cd_Test='Rgaa32017-5-7-4' OR
Cd_Test='Rgaa32017-5-8-1' OR
Cd_Test='Rgaa32017-6-1-1' OR 
Cd_Test='Rgaa32017-6-1-2' OR 
Cd_Test='Rgaa32017-6-1-3' OR 
Cd_Test='Rgaa32017-6-1-4' OR 
Cd_Test='Rgaa32017-6-1-5' OR 
Cd_Test='Rgaa32017-6-2-1' OR 
Cd_Test='Rgaa32017-6-2-2' OR 
Cd_Test='Rgaa32017-6-2-3' OR 
Cd_Test='Rgaa32017-6-2-4' OR 
Cd_Test='Rgaa32017-6-2-5' OR 
Cd_Test='Rgaa32017-6-3-1' OR 
Cd_Test='Rgaa32017-6-3-2' OR 
Cd_Test='Rgaa32017-6-3-3' OR 
Cd_Test='Rgaa32017-6-3-4' OR 
Cd_Test='Rgaa32017-6-3-5' OR 
Cd_Test='Rgaa32017-6-4-1' OR 
Cd_Test='Rgaa32017-6-4-2' OR 
Cd_Test='Rgaa32017-6-4-3' OR 
Cd_Test='Rgaa32017-6-4-4' OR 
Cd_Test='Rgaa32017-6-4-5' OR 
Cd_Test='Rgaa32017-6-5-1' OR
Cd_Test='Rgaa32017-7-4-1' OR
Cd_Test='Rgaa32017-8-1-1' OR 
Cd_Test='Rgaa32017-8-1-2' OR 
Cd_Test='Rgaa32017-8-1-3' OR 
Cd_Test='Rgaa32017-8-3-1' OR 
Cd_Test='Rgaa32017-8-4-1' OR 
Cd_Test='Rgaa32017-8-5-1' OR 
Cd_Test='Rgaa32017-8-6-1' OR 
Cd_Test='Rgaa32017-8-7-1' OR 
Cd_Test='Rgaa32017-8-8-1' OR 
Cd_Test='Rgaa32017-8-8-2' OR 
Cd_Test='Rgaa32017-8-9-1' OR 
Cd_Test='Rgaa32017-9-1-1' OR 
Cd_Test='Rgaa32017-9-1-2' OR 
Cd_Test='Rgaa32017-9-1-4' OR 
Cd_Test='Rgaa32017-9-2-1' OR 
Cd_Test='Rgaa32017-10-1-1' OR 
Cd_Test='Rgaa32017-10-1-2' OR 
Cd_Test='Rgaa32017-10-4-1' OR 
Cd_Test='Rgaa32017-10-4-2' OR 
Cd_Test='Rgaa32017-10-7-1' OR 
Cd_Test='Rgaa32017-10-8-3' OR 
Cd_Test='Rgaa32017-10-8-4' OR 
Cd_Test='Rgaa32017-10-13-1' OR
Cd_Test='Rgaa32017-11-1-1' OR 
Cd_Test='Rgaa32017-11-1-2' OR 
Cd_Test='Rgaa32017-11-1-3' OR 
Cd_Test='Rgaa32017-11-2-1' OR 
Cd_Test='Rgaa32017-11-2-2' OR 
Cd_Test='Rgaa32017-11-2-3' OR 
Cd_Test='Rgaa32017-11-2-4' OR 
Cd_Test='Rgaa32017-11-3-1' OR 
Cd_Test='Rgaa32017-11-3-2' OR 
Cd_Test='Rgaa32017-11-4-1' OR 
Cd_Test='Rgaa32017-11-5-1' OR 
Cd_Test='Rgaa32017-11-6-1' OR 
Cd_Test='Rgaa32017-11-7-1' OR 
Cd_Test='Rgaa32017-11-8-1' OR 
Cd_Test='Rgaa32017-11-8-2' OR 
Cd_Test='Rgaa32017-11-8-3' OR 
Cd_Test='Rgaa32017-11-9-1' OR 
Cd_Test='Rgaa32017-11-9-2' OR 
Cd_Test='Rgaa32017-11-10-1' OR 
Cd_Test='Rgaa32017-11-10-2' OR 
Cd_Test='Rgaa32017-11-10-4' OR 
Cd_Test='Rgaa32017-11-10-7' OR 
Cd_Test='Rgaa32017-11-11-1' OR 
Cd_Test='Rgaa32017-11-11-2' OR 
Cd_Test='Rgaa32017-11-12-1' OR 
Cd_Test='Rgaa32017-11-12-2' OR 
Cd_Test='Rgaa32017-11-13-1' OR 
Cd_Test='Rgaa32017-11-13-2' OR 
Cd_Test='Rgaa32017-11-14-1' OR 
Cd_Test='Rgaa32017-11-14-4' OR 
Cd_Test='Rgaa32017-11-15-1' OR 
Cd_Test='Rgaa32017-12-1-1' OR 
Cd_Test='Rgaa32017-12-2-1' OR 
Cd_Test='Rgaa32017-12-2-2' OR 
Cd_Test='Rgaa32017-12-3-1' OR 
Cd_Test='Rgaa32017-12-3-2' OR 
Cd_Test='Rgaa32017-12-5-1' OR 
Cd_Test='Rgaa32017-12-5-2' OR 
Cd_Test='Rgaa32017-12-5-3' OR 
Cd_Test='Rgaa32017-12-6-1' OR 
Cd_Test='Rgaa32017-12-6-2' OR 
Cd_Test='Rgaa32017-12-6-3' OR 
Cd_Test='Rgaa32017-12-7-1' OR 
Cd_Test='Rgaa32017-12-11-4' OR 
Cd_Test='Rgaa32017-13-1-2' OR 
Cd_Test='Rgaa32017-13-2-1' OR 
Cd_Test='Rgaa32017-13-2-2' OR 
Cd_Test='Rgaa32017-13-2-3' OR 
Cd_Test='Rgaa32017-13-6-1' OR 
Cd_Test='Rgaa32017-13-6-2' OR 
Cd_Test='Rgaa32017-13-6-3' OR
Cd_Test='Rgaa32017-13-7-1';