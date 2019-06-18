UPDATE TEST SET `No_Process`=b'0' WHERE
Cd_Test='Rgaa32017-7-1-1' OR
Cd_Test='Rgaa32017-1-2-3' OR
Cd_Test='Rgaa32017-9-6-1' OR
Cd_Test='Rgaa32017-9-6-2' OR
Cd_Test='Rgaa32017-11-1-5';

INSERT IGNORE INTO `EVIDENCE` (`Id_Evidence`, `Cd_Evidence`, `Description`, `Long_Label`) VALUES
(42, 'id', NULL, NULL),
(43, 'tabindex', NULL, NULL),
(44, 'for', NULL, NULL),
(45, 'placeholder', NULL, NULL);

UPDATE NOMENCLATURE SET Cd_Nomenclature='UnrelativeCssUnits' WHERE
Id_Nomenclature=9;

INSERT IGNORE INTO `NOMENCLATURE` (`Id_Nomenclature`, `Cd_Nomenclature`, `Description`, `Long_Label`, `Short_Label`, `Id_Nomenclature_Parent`) VALUES
(24, 'DownloadableDocumentExtensions', NULL, NULL, NULL, NULL),
(25, 'RelativeCssUnits', NULL, NULL, NULL, NULL);

INSERT IGNORE INTO `NOMENCLATURE_ELEMENT` (`DTYPE`, `Id_Nomenclature_Element`, `Label`, `shortValue`, `Id_Nomenclature`) VALUES
('NomenclatureCssUnitImpl', 2000, '%', 30, 25),
('NomenclatureCssUnitImpl', 2001, 'em', 31, 25),
('NomenclatureCssUnitImpl', 2002, 'rem', 32, 25),
('NomenclatureCssUnitImpl', 2003, 'vw', 33, 25),
('NomenclatureCssUnitImpl', 2004, 'vh', 34, 25),
('NomenclatureCssUnitImpl', 2005, 'vmin', 35, 25),
('NomenclatureCssUnitImpl', 2006, 'vmax', 36, 25),
('NomenclatureCssUnitImpl', 2007, 'xx-small', 37, 25),
('NomenclatureCssUnitImpl', 2008, 'x-small', 38, 25),
('NomenclatureCssUnitImpl', 2009, 'small', 39, 25),
('NomenclatureCssUnitImpl', 2010, 'medium', 40, 25),
('NomenclatureCssUnitImpl', 2011, 'large', 41, 25),
('NomenclatureCssUnitImpl', 2012, 'x-large', 42, 25),
('NomenclatureCssUnitImpl', 2013, 'xx-large', 43, 25),
('NomenclatureCssUnitImpl', 2014, 'xsmaller', 44, 25),
('NomenclatureCssUnitImpl', 2015, 'larger', 45, 25),
('NomenclatureCssUnitImpl', 2016, 'pt', 46, 25),
('NomenclatureCssUnitImpl', 2017, 'pc', 47, 25),
('NomenclatureCssUnitImpl', 2018, 'mm', 48, 25),
('NomenclatureCssUnitImpl', 2019, 'cm', 49, 25),
('NomenclatureCssUnitImpl', 2020, 'in', 50, 25);

INSERT IGNORE INTO `PARAMETER_FAMILY` (`Cd_Parameter_Family`, `Description`, `Long_Label`, `Short_Label`) VALUES
('SCENARIO', 'This parameter family handles all the parameters needed by the crawler component', 'scenario parameters', 'scenario params');

INSERT IGNORE INTO `PARAMETER_ELEMENT` (`Cd_Parameter_Element`,`Id_Parameter_Family`,  `Long_Label`, `Short_Label`) VALUES
('PREVENT_DEFAULT_PAGE_FIRING', (SELECT `Id_Parameter_Family` FROM `PARAMETER_FAMILY` WHERE `Cd_Parameter_Family` LIKE 'SCENARIO'), 'Prevent automatic new page event', 'Prevent automatic new page event');

INSERT IGNORE INTO `PARAMETER` (`Id_Parameter_Element`,  `Parameter_Value`, `Is_Default`) VALUES
((SELECT `Id_Parameter_Element` FROM `PARAMETER_ELEMENT` WHERE `Cd_Parameter_Element` LIKE 'PREVENT_DEFAULT_PAGE_FIRING'), 'false', b'1');