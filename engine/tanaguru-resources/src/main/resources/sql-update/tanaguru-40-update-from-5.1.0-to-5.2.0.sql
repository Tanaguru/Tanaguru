ALTER TABLE `AUDIT` MODIFY `Dt_Creation` DATETIME(3);
	INSERT INTO EVIDENCE (Cd_Evidence) VALUE ('aria-hidden');
	UPDATE TEST SET `No_Process`=b'0' WHERE
	Cd_Test='Rgaa32017-11-1-4' OR
	Cd_Test='Rgaa32017-11-1-5' OR
	Cd_Test='Rgaa32017-11-10-10' ;

	INSERT IGNORE INTO `TGSI_OPTION` (`Id_Option`, `Code`, `Description`, `Is_Restriction`, OPTION_FAMILY_Id_Option_Family) VALUES
	(18,'IS_EACCESS_ENABLED_CONTRACT', 'IS the E-Accessibilite labale enabled on contract', b'1', '2');