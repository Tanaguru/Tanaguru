SET foreign_key_checks=0;

insert into `TGSI_OPTION` (`Id_Option`, `Code`, `Description`, `Is_Restriction`, `OPTION_FAMILY_Id_Option_Family` ) 
value (16,'MAX_PAGES_AUDIT_CONTROL', 'The max pages of audit in pages scope', true, 4);

SET foreign_key_checks=1;