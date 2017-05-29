INSERT INTO `PARAMETER_ELEMENT` ( `Cd_Parameter_Element`, `Id_Parameter_Family`, `Short_Label`, `Long_Label`) VALUES 
('WAIT_TIME_NG_APP', (SELECT `Id_Parameter_Family` FROM `PARAMETER_FAMILY` WHERE `Cd_Parameter_Family` LIKE 'GENERAL'), 'Time to wait untel the page loads (AngularJS App)', 'Time to wait untel the page loads (AngularJS App)');

INSERT IGNORE INTO `PARAMETER` (`Id_Parameter_Element`, `Parameter_Value`, `Is_Default`) VALUES
((SELECT `Id_Parameter_Element` FROM `PARAMETER_ELEMENT` WHERE `Cd_Parameter_Element` LIKE 'WAIT_TIME_NG_APP'), '500', b'1');