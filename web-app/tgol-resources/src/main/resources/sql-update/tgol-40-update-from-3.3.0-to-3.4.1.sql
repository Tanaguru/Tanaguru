INSERT INTO `PARAMETER_ELEMENT` ( `Cd_Parameter_Element`, `Id_Parameter_Family`, `Short_Label`, `Long_Label`) VALUES ('ALTERNATIVE_JUSTIFY_MECHANISM', '3', 'Alternative Justify Mechanism', 'The page embeds a mechanism that can remove text justification');

INSERT INTO `PARAMETER` (`Parameter_Value`, `Id_Parameter_Element`, `Is_Default`) VALUES ('true', '50', 0);
INSERT INTO `PARAMETER` (`Parameter_Value`, `Id_Parameter_Element`, `Is_Default`) VALUES ('false', '50', 1);
