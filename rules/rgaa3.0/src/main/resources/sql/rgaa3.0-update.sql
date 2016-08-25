-- Alternate mechanism   text justification remove
INSERT INTO `PARAMETER_ELEMENT` ( `Cd_Parameter_Element`, `Id_Parameter_Family`, `Short_Label`, `Long_Label`) VALUES ('ALTERNATIVE_JUSTIFY_MECHANISM', '3', 'Alternative Justify Mechanism', 'The page embeds a mechanism that can remove text justification');
INSERT INTO `PARAMETER` (`Parameter_Value`, `Id_Parameter_Element`, `Is_Default`) VALUES ('', '45', 1);


-- to disable test
UPDATE TEST SET `No_Process`=b'0' WHERE 
Cd_Test='Rgaa30-1-1-1' OR 
 ;