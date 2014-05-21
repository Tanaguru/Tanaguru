SET foreign_key_checks=0;

--
-- Contenu de la table `reference`
--
INSERT IGNORE INTO `REFERENCE` (`ID_REFERENCE`, `CD_REFERENCE`, `DESCRIPTION`, `LABEL`, `URL`, `RANK`, `ID_DEFAULT_LEVEL`) VALUES
(900, 'ARIA10', NULL, 'Aria 1.0', 'http://www.w3.org/TR/wai-aria/', 900, 1);

INSERT IGNORE INTO `TGSI_REFERENTIAL` (`Code`, `Label`) VALUES
('ARIA10', 'Aria 1.0') ;

--
-- Contenu de la table `theme`
--
INSERT IGNORE INTO `THEME` (`ID_THEME`, `CD_THEME`, `DESCRIPTION`, `LABEL`, `RANK`) VALUES
(901, 'ARIA10-DP', NULL, 'Design Pattern', 1);

--
-- Contenu de la table `criterion`
--
INSERT IGNORE INTO `CRITERION` (`ID_CRITERION`, `reference_ID_REFERENCE`, `theme_ID_THEME`, `CD_CRITERION`, `DESCRIPTION`, `LABEL`, `URL`, `RANK`) VALUES
(901, 900, 901, 'ARIA10-Accordion', '', 'Accordion', 'http://www.w3.org/TR/wai-aria-practices/#accordion', 901);

--
-- table `TEST`
--
INSERT IGNORE INTO `TEST` (`Id_Test`, `Cd_Test`, `Description`, `Label`, `Rank`, `Weight`, `Rule_Archive_Name`, `Rule_Class_Name`, `Id_Criterion`, `Id_Decision_Level`, `Id_Level`, `Id_Scope`,`No_Process`) VALUES
(901, 'Aria-Accordion', '', 'Accordion', 9000001, '1.0', 'aria1.0', 'org.opens.tanaguru.rules.aria10.Aria10RuleDpAccordion', 901, NULL, 1, 1, b'0');


INSERT IGNORE INTO `PARAMETER` (`Id_Parameter_Element`, `Parameter_Value`, `Is_Default`) VALUES
(5, 'ARIA10;LEVEL_1', b'0');


SET foreign_key_checks=1;