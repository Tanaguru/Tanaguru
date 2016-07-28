
SET foreign_key_checks=0;

insert into `TGSI_OPTION` ( `Code`, `Description`, `Is_Restriction`, `OPTION_FAMILY_Id_Option_Family` ) 
value ('MAX_PAGES_AUDIT_CONTROL', 'The max pages of audit in pages scope', true, 4);

insert into `TGSI_OPTION` ( `Code`, `Description`, `Is_Restriction`, `OPTION_FAMILY_Id_Option_Family` ) 
value ('IS_DOMAINE_RESTRICTED_CONTRACT', 'Is the domaine restricted on domaine URL', true, 2);
INSERT INTO `PARAMETER` (`Parameter_Value`, `Id_Parameter_Element`, `Is_Default`) VALUES ('true', '45', 0);
INSERT INTO `PARAMETER` (`Parameter_Value`, `Id_Parameter_Element`, `Is_Default`) VALUES ('false', '45', 1);

SET foreign_key_checks=1;