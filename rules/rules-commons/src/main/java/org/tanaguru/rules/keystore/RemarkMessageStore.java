/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.rules.keystore;

/**
 * Utility class that stores remark messages keys as static String
 */
public final class RemarkMessageStore {

    // general 
    public static final String MANUAL_CHECK_ON_ELEMENTS_MSG
            = "ManualCheckOnElements";
    public static final String NO_PATTERN_DETECTED_MSG
            = "NoPatternDetected";
    public static final String TABINDEX_DETECTED_MSG = "TabindexDetectedMsg";
    public static final String TITLE_ATTR_MISSING_MSG = "TitleAttributeMissing";
    public static final String ARIA_LABEL_ATTR_MISSING_MSG = "AriaLabelAttributeMissing";
    public static final String ID_MISSING_MSG = "IdMissing";
    public static final String ARIA_LABELLEDBY_EMPTY_MSG = "AriaLabelledbyEmpty";
    public static final String FOR_MISSING_MSG = "ForMissing";
    public static final String ID_NOT_UNIQUE_MSG = "IdNotUnique";
    public static final String DIR_TEXT_CKECK_MANUALLY_MSG = "DirTextCheckManually";
    public static final String INVALID_DIR_TEXT_VALUE_MSG = "InvalidDirTextValue";
    public static final String NOT_PERTINENT_TEXTUAL_CONTENT_MSG = "NotPertinentTextualContent";
    public static final String TITLE_NOT_IDENTICAL_PLACEHOLDER = "TitleNotIdenticalPlaceholder";
    public static final String CHECK_TITLE_ATTR_PERTINENCE_MSG = "CheckTitleAttrPertinence";

    //multimedia
    public static final String CHECK_TRANS_VIDEO_MSG = "CheckTransVideoMsg";
    public static final String CHECK_KIND_VALUE_MSG = "checkKindValue";

    // doctype
    public static final String DOCTYPE_MISSING_MSG = "DoctypeMissing";
    public static final String BAD_DOCTYPE_LOCATION_MSG = "BadDoctypeLocation";
    public static final String INVALID_DOCTYPE_MSG
            = "InvalidDoctypeDeclaration";
    public static final String DOCTYPE_ABSENT_CHECK_HTML5
            = "DoctypeAbsentCheckHtml5AndCheckManually";
    public static final String HTML5_DOCTYPE_DETECTED_CHECK_MANUALLY
            = "Html5DoctypeDetectedCheckManually";

    //Doc Structure 
    /*Main elements*/
    public static final String CHECK_DETECTED_MAIN_ELEMNT_MSG = "CheckDetectedMainElement";
    public static final String CHECK_MAIN_ELEMENT_MULTIPLE_MISSING_MSG = "CheckMainElementMultipleMissing";
    public static final String ROLE_MAIN_NOT_IN_MAIN_MSG = "RoleMainNotInMain";
    public static final String MISSING_ROLE_MAIN_IN_MAIN_MSG = "MissingRoleMainInMain";
    public static final String CHECK_ROLE_MAIN_ELEMENT_MSG = "CheckRoleMainElement";
    public static final String MISSING_ROLE_ARIA_MAIN_MSG="MissingRoleAriaMain";
    public static final String MAIN_WITHOUT_ROLE_MAIN_ARIA_MSG="MainWithoutRoleMainAria";
    public static final String CHECK_UNICITY_MAIN_ARIA_MSG="CheckUnicityMainAria";
    /*Nav elements*/
    public static final String CHECK_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG = "CheckNavElementWithNavigationRole";
    public static final String MISIING_ROLE_NAVIGATION_IN_NAV_MSG = "MissingRoleNavigationInNav";
    public static final String MISSING_NAV_ELEMNT_WITH_NAVIGATION_ROLE_MSG = "MissingNavElementWithNavigationRole";
    public static final String CHECK_ROLE_NAGIVATION_ARIA_MSG="CheckRoleNavigationAria";
    public static final String MISSING_ROLE_NAVIGATION_ARIA_MSG="MissingRoleNavigatioAria";
    /*Header element*/
    public static final String MISSING_HEADER_ELEMENT_MSG = "MissingHeaderElement";
    public static final String WRONG_USE_HEADER_ROLE_BANNER_ELEMENT_MSG = "WrongUseHeaderRoleBannerElement";
    public static final String ROLE_BANNER_NOT_IN_HEADER_MSG = "RoleBannerNotInHeader";
    public static final String CHECK_HEADER_ELEMENT_MSG = "CheckHeaderElement";
    public static final String ROLE_BANNER_UNICITY_MSG = "RoleBannerUnicity";
    public static final String MISSING_ROLE_BANNER_ARIA_MSG="MissingRoleBannerAria";
    public static final String ROLE_BANNER_ARIA_UNICITY_MSG = "RoleBannerAriaUnicity";
    public static final String ADD_ROLE_BANNER_MSG="AddRoleBanner";
    public static final String CHECK_HEADER_ELEMENT_ARIA_MSG = "CheckHeaderElementAria";
    /*Footer elements*/
    public static final String MISSING_FOOTER_ELEMENT_MSG = "MissingFooterElement";
    public static final String WRONG_USE_FOOTER_ROLE_CONTENT_INFO_ELEMENT_MSG = "WrongUseFooterRoleContentInfoElement";
    public static final String ROLE_CONTENT_INFO_NOT_IN_FOOTER_MSG = "RoleContentInfoNotInFooter";
    public static final String CHECK_FOOTER_ELEMENT_MSG = "CheckFooterElement";
    public static final String ROLE_CONTENT_INFO_UNICITY_MSG = "RoleContentInfoUnicity";
    public static final String CHECK_ROLE_CONTENT_INFO_MSG= "CheckRoleContentInfo";
    public static final String MISSING_ROLE_CONTENT_INFO_ARIA_MSG="MissingRoleContentInfoAria";
    public static final String ROLE_CONTENT_INFO_ARIA_UNICITY_MSG = "RoleContentInfoAriaUnicity";
    public static final String ADD_ROLE_CONTENT_INFO_MSG="AddRoleContentInfo";
    public static final String CHECK_FOOTER_ELEMENT_ARIA_MSG = "CheckFooterElementAria";
    /*search elements */
    public static final String MISSING_ROLE_SEARCH_ARIA_MSG="MissingRoleSearchAria";
    public static final String ROLE_SEARCH_ARIA_UNICITY_MSG = "RoleSearchAriaUnicity";
   // public static final String MISSING_ROLE_SEARCH_MSG="MissingRoleSearch";
    public static final String ROLE_SEARCH_ON_INPUT_MSG="RoleSearchOnInput";
    public static final String CHECK_SEARCH_ELEMENT_ARIA_MSG = "CheckSearchElementAria";
    
    // images
    public static final String INVALID_TEXT_ALTERNATIVE_MSG = "InvalidAlternativeMsg";
    public static final String TEXT_ALTERNATIVE_MISSING = "TextAlternativeMissing";
    public static final String CHECK_NATURE_OF_IMAGE= "CheckNatureOfImage";
    public static final String CHECK_NATURE_OF_IMAGE_WITHOUT_TEXT_ALTERNATIVE
    		= "CheckNatureOfImageWithoutTextAlternativeMissing";
    public static final String CHECK_NATURE_OF_IMAGE_WITH_TEXT_ALTERNATIVE
			= "CheckNatureOfImageWithTextAlternative";
    public static final String ALT_MISSING_MSG = "AltMissing";
    public static final String DECORATIVE_ELEMENT_WITH_NOT_EMPTY_ALT_MSG
            = "DecorativeElementWithNotEmptyAltAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_TEXT_ALTERNATIVE_MSG
    		= "DecorativeElementWithTextAlternative";
    public static final String DECORATIVE_ELEMENT_WITH_ROLE_IMG_MSG
    		= "DecorativeElementWithRoleImgAttribute";
    public static final String DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG
            = "DecorativeElementWithoutAriaHiddenTrueAttribute";
    public static final String DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG
    		= "DecorativeElementWithoutRolePresentationAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_TITLE_ATTR_MSG
            = "DecorativeElementWithTitleAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_ARIA_LABEL_ATTR_MSG
            = "DecorativeElementWithTAria-LabelAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_ARIA_LABELLEDBY_ATTR_MSG
            = "DecorativeElementWithTAria-LabelledbyAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_ARIA_DESCRIBEDBY_ATTR_MSG
            = "DecorativeElementWithAria-describedbyAttribute";
    public static final String DECORATIVE_ELEMENT_WITH_ROLE_ATTR_MSG
    		= "DecorativeElementWithRoleAttr";  
    public static final String CHECK_ALTERNATIVE_OF_DECORATIVE_ELEMENT_MSG
            = "CheckAlternativeOfDecorativeElement";
    public static final String CHECK_NATURE_AND_ALTERNATIVE_OF_ELEMENT_MSG
            = "CheckNatureAndAlternativeOfElement";
    public static final String CHECK_NATURE_AND_PRESENCE_OF_ALTERNATIVE_MECHANISM_MSG
            = "CheckNatureOfImageAndPresenceOfAlternativeMechanism";
    public static final String CHECK_PRESENCE_OF_ALTERNATIVE_MECHANISM_FOR_INFORMATIVE_IMG_MSG
            = "CheckPresenceOfAlternativeMechanismForInformativeImage";
    public static final String CHECK_ELEMENT_WITH_NOT_EMPTY_ALT_MSG
            = "CheckNatureOfElementWithNotEmptyAltAttribute";
    public static final String CHECK_PRESENCE_ELEMENT_TITLE_MSG
            = "CheckNatureOfElementWithNotEmptyTitleAttribute";
    public static final String CHECK_ELEMENT_WITH_EMPTY_ALT_MSG
            = "CheckNatureOfElementWithEmptyAltAttribute";
    public static final String CHECK_NOT_PRESENCE_ELEMENT_TITLE_MSG
            = "CheckNatureOfElementWithEmptyTitleAttribute";
    public static final String NOT_PERTINENT_ALT_MSG = "NotPertinentAlt";
    public static final String TITLE_NOT_IDENTICAL_TO_ALT_MSG = "TitleNotIdenticalToAlt";
    public static final String ARIA_LABEL_NOT_IDENTICAL_TO_ALT_MSG = "AriaLabelNotIdenticalToAlt";
    public static final String ARIA_LABELLEDBY_NOT_IDENTICAL_TO_ALT_MSG = "AriaLabelledbyNotIdenticalToAlt";
    public static final String TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG 
    		= "TextNotIdenticalToAlt";
    public static final String CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG
            = "CheckPertinenceOfAltAttributeOfInformativeImage";
    public static final String CHECK_NATURE_OF_IMAGE_WITH_NOT_PERTINENT_ALT_MSG
            = "CheckNatureOfImageWithNotPertinentAlt";
    public static final String CHECK_NATURE_OF_IMAGE_WITH_EMPTY_ALT_MSG
            = "CheckNatureOfElementWithEmptyAltAttribute";
    public static final String CHECK_NATURE_OF_IMAGE_WITH_NOT_EMPTY_ALT_MSG
            = "CheckNatureOfElementWithNotEmptyAltAttribute";
    public static final String CHECK_NATURE_OF_IMAGE_AND_ALT_PERTINENCE_MSG
            = "CheckNatureOfImageAndAltPertinence";
    public static final String CHECK_CAPTCHA_ALTERNATIVE_MSG
            = "CheckCaptchaAlternative";
    public static final String CHECK_CAPTCHA_ALTERNATIVE_ACCES_MSG
            = "CheckCaptchaAlternativeAccess";
    public static final String CHECK_NATURE_OF_IMAGE_AND_DETAILED_DESC_AVAILABILITY_MSG
            = "CheckNatureOfImageAndLongdescDefinition";
    public static final String CHECK_DETAILED_DESC_DEFINITION_OF_INFORMATIVE_IMG_MSG
            = "CheckLongdescDefinitionOfInformativeImage";
    public static final String CHECK_DESC_PRESENCE_OF_INFORMATIVE_IMG_MSG
            = "CheckDescriptionPresenceOfInformativeImage";
    public static final String CHECK_NATURE_OF_IMAGE_AND_DESC_PRESENCE_MSG
            = "CheckNatureOfImageAndDescriptionPresence";
    public static final String CHECK_DESC_PERTINENCE_OF_INFORMATIVE_IMG_MSG
            = "CheckDescriptionPertinenceOfInformativeImage";
    public static final String CHECK_AT_RESTITUTION_OF_DESC_OF_INFORMATIVE_IMG_MSG
            = "CheckAtRestitutionOfDescriptionOfInformativeImage";
    public static final String CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_CAPTCHA_MSG
            = "CheckAtRestitutionOfAlternativeOfCaptcha";
    public static final String CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG
            = "CheckAtRestitutionOfAlternativeOfInformativeImage";
    public static final String CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_ALTERNATIVE_MSG
            = "CheckNatureOfImageAndAtRestitutionOfAlternative";
    public static final String CHECK_NATURE_OF_IMAGE_AND_DESC_PERTINENCE_MSG
            = "CheckNatureOfImageAndDescriptionPertinence";
    public static final String CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_PERTINENCE_MSG
            = "CheckNatureOfImageAndAtRestitutionOfDescription";
    public static final String ALTERNATIVE_TOO_LONG_MSG = "AlternativeTooLong";
    public static final String CHECK_NATURE_OF_IMAGE_AND_ALT_LENGTH_MSG
            = "CheckNatureOfImageAndAltLength";
    public static final String ALT_SVG_DETECTED_MSG = "AltSvgDetect";
    public static final String DECORATIVE_SVG_WITH_ROLE_ATTRIBUTE
            = "DecorativeSvgWithRole";
    public static final String DECORATIVE_SVG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE
            = "DecorativeSvgOrChildrenWithAriaAttribute";
    public static final String DECORATIVE_SVG_WITH_NOT_EMPTY_TITLE_OR_DESC_TAGS
            = "DecorativeSvgWithNotEmptyTitleOrDescTags";
    public static final String DECORATIVE_SVG_OR_CHILD_WITH_TITLE_ATTRIBUTE
            = "DecorativeSvgWithTitleAttribute";
    public static final String DECORATIVE_IMG_OR_CHILDREN_WITH_ARIA_ATTRIBUTE
            = "DecorativeImgOrChildrenWithAriaAttribute";
    public static final String DECORATIVE_IMG_OR_CHILD_WITH_TITLE_ATTRIBUTE
            = "DecorativeImgWithTitleAttribute";
    public static final String SVG_WITHOUT_ROLE_IMAGE_MSG
            = "SvgWithoutRoleImage";
    public static final String INFORMATIVE_SVG_WITH_NOT_PERTINENT_ALT_MSG
            = "InformativeSvgWithNotPertinentAlternative";
    public static final String CHECK_NATURE_OF_SVG_WITH_NOT_PERTINENT_ALT_MSG
            = "CheckNatureOfSvgWithNotPertinentAlternative";
    public static final String CHECK_ALT_PERTINENCE_OF_INFORMATIVE_SVG_MSG
            = "CheckPertinenceOfAlternativeOfInformativeSvg";
    public static final String CHECK_NATURE_OF_SVG_AND_ALT_PERTINENCE_MSG
            = "CheckNatureOfSvgAndAlternativePertinence";
    public static final String SUSPECTED_INFORMATIVE_SVG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD
            = "SuspectedInformativeSvgWithAriaAttributeDetectedOnElementOrChild";
    public static final String SUSPECTED_INFORMATIVE_SVG_WITH_DESC_OR_TITLE_CHILD_TAG
            = "SuspectedInformativeSvgWithDescOrTitleChildTag";
    public static final String SUSPECTED_INFORMATIVE_SVG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD
            = "SuspectedInformativeSvgWithTitleAttributeOnElementOrChild";
    public static final String SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ARIA_HIDDEN_TRUE_MSG
    		= "SuspectedDecorativeImgWithoutAriaHiddenTrueAttribute";
    public static final String SUSPECTED_DECORATIVE_ELEMENT_WITHOUT_ROLE_PRESENTATION_MSG
    		= "SuspectedDecorativeImgWithoutRolePresentationAttribute";
    public static final String SUSPECTED_DECORATIVE_IMG_WITH_ARIA_ATTRIBUTE_DETECTED_ON_ELEMENT_OR_CHILD
            = "SuspectedDecorativeImgWithAriaAttributeDetectedOnElementOrChild";
    public static final String SUSPECTED_DECORATIVE_IMG_WITH_TITLE_ATTRIBUTE_ON_ELEMENT_OR_CHILD
            = "SuspectedDecorativeImgWithTitleAttributeOnElementOrChild";
    public static final String SUSPECTED_WELL_FORMATED_DECORATIVE_IMG
    		= "SuspectedWellFormedDecorativeImg";
    public static final String SUSPECTED_DECORATIVE_IMG_WITH_NOT_EMPTY_TEXT_ALT_MSG
			= "SuspectedDecorativeImgWithNotEmptyTextualAlternativeAttribute";
    public static final String SUSPECTED_INFORMATIVE_SVG_ROLE_IMAGE_MISSING_ON_SVG 
    		= "SuspectedInformativeSvgWithRoleImgMissing";
    public static final String SUSPECTED_DECORATIVE_SVG_ROLE_ON_SVG 
			= "SuspectedDecorativeSvgWithRole";
    public static final String SUSPECTED_WELL_FORMATED_DECORATIVE_SVG
            = "SuspectedWellFormedDecorativeSvg";
    public static final String CHECK_NATURE_OF_IMAGE_AND_TEXT_STYLED_PRESENCE_MSG
            = "CheckNatureOfImageAndStyledTextPresence";
    public static final String CHECK_TEXT_STYLED_PRESENCE_OF_INFORMATIVE_IMG_MSG
            = "CheckStyledTextPresenceOfInformativeImage";
    public static final String CHECK_OBJ_IMG_ARIA_MSG
            ="CheckObjImgAriaMsg";
    public static final String CHECK_OBJ_IMG_ARIA_LABELLEDBY_MSG
    		="CheckObjImgAriaLabelledbyMsg";
    public static final String CHECK_CANVAS_IMG_ARIA_MSG
            ="CheckCanvasImgAriaMsg";    
    public static final String CHECK_CANVAS_IMG_ARIA_LABELLEDBY_MSG
    		="CheckCanvasImgAriaLabelledbyMsg";
    public static final String CHECK_EMB_IMG_ARIA_MSG
            ="CheckEmbImgAriaMsg";
    public static final String CHECK_EMB_IMG_ARIA_LABELLEDBY_MSG
            ="CheckEmbImgAriaLabelledbyMsg";    
    public static final String CHECK_INPUT_IMG_ARIA_MSG
            ="CheckInputImgAriaMsg";
    public static final String CHECK_INPUT_LEGD_ARIA_MSG
            ="CheckInputLegdAriaMsg";
    public static final String CHECK_OBJ_LEGD_ARIA_MSG
            ="CheckObjLegdAriaMsg";
    public static final String CHECK_EMB_LEGD_ARIA_MSG
            ="CheckEmbLegdAriaMsg";
    public static final String CHECK_SVG_IMG_ARIA_MSG
            ="CheckSvgImgAriaMsg";
    public static final String CHECK_CANVAS_LEGD_ARIA_MSG
            ="CheckCanvasLegdAriaMsg";
    public static final String CHECK_IMG_TAGS_MSG="CheckImgTags";
    public static final String INFORMATIVE_EMB_NOT_INDENTICAL_ATTR_MSG
     		= "InformativeEmbNotIdenticalAttr";     
    public static final String INFORMATIVE_EMB_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG
    		= "InformativeEmbNotIdenticalAriaLabelledby";     
    public static final String SUSPECTED_DECORATIVE_EMB_WITH_ARIA_ATTRIBUTE_DETECTED
            = "SuspectedDecorativeEmbWithAriaAttributeDetected";
    public static final String SUSPECTED_INFORMATIVE_EMB_DETECTED
            = "SuspectedInformativeEmbDetected";     
    public static final String SUSPECTED_INFORMATIVE_EMB_WITH_LABELLEDBY_DETECTED
     		= "SuspectedInformativeEmbWithLabelledbyDetected";     
    public static final String SUSPECTED_INFORMATIVE_EMB_WITH_ARIA_ATTRIBUTE_NOT_DETECTED
            = "SuspectedInformativeEmbWithAriaAttributeNotDetected";
    public static final String SUSPECTED_INFORMATIVE_OBJ_DETECTED
			= "SuspectedInformativeObjDetected";
    public static final String SUSPECTED_INFORMATIVE_OBJ_WITH_LABELLEDBY_DETECTED
			= "SuspectedInformativeObjWithLabelledbyDetected";
 	public static final String INFORMATIVE_OBJ_NOT_INDENTICAL_ATTR_MSG
			= "InformativeObjNotIndenticalAttr";
 	public static final String INFORMATIVE_OBJ_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG
			= "InformativeObjNotIndenticalAriaLabelledby";
    public static final String INFORMATIVE_CANVAS_NOT_INDENTICAL_ATTR_MSG
			= "InformativeCanvasNotIdenticalAttr";     
	public static final String INFORMATIVE_CANVAS_NOT_INDENTICAL_ARIA_LABELLEDBY_MSG
			= "InformativeCanvasNotIdenticalAriaLabelledby";   
    public static final String SUSPECTED_INFORMATIVE_CANVAS_DETECTED
			= "SuspectedInformativeCanvasDetected";
    public static final String SUSPECTED_INFORMATIVE_CANVAS_WITH_LABELLEDBY_DETECTED
			= "SuspectedInformativeCanvasWithLabelledbyDetected";
    public static final String INFORMATIVE_AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG 
			= "InformativeAreaTextNotIdenticalToAlt";
    public static final String AREA_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG 
			= "AreaTextWithAriaLabelledbyNotIdenticalToAlt";
    public static final String INFORMATIVE_IMG_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG 
		= "InformativeImgTextNotIdenticalToAlt";
    public static final String IMG_TEXT_NOT_IDENTICAL_TO_ALT_WITH_ARIA_LABELLEDBY_MSG 
			= "ImgTextWithAriaLabelledbyNotIdenticalToAlt";

    // frames 
    public static final String NOT_PERTINENT_TITLE_OF_FRAME_MSG
            = "NotPertinentTitleOfFrame";
    public static final String NOT_PERTINENT_TITLE_OF_FRAME_MSG2
    		= "NotPertinentTitleOfFrame2";
    public static final String NOT_PERTINENT_TITLE_OF_IFRAME_MSG
            = "NotPertinentTitleOfIframe";
    public static final String CHECK_TITLE_OF_FRAME_PERTINENCE_MSG
            = "CheckTitleOfFramePertinence";
    public static final String CHECK_TITLE_OF_FRAME_PERTINENCE_MSG2
    		= "CheckTitleOfFramePertinence2";
    public static final String CHECK_TITLE_OF_IFRAME_PERTINENCE_MSG
            = "CheckTitleOfIframePertinence";
    public static final String EMPTY_TITLE_OF_FRAME_MSG = "EmtpyTitleOfFrame";

    // form 
    public static final String NOT_PERTINENT_LEGEND_MSG = "NotPertinentLegend";
    public static final String CHECK_LEGEND_PERTINENCE_MSG
            = "CheckLegendPertinence";
    public static final String OPTGROUP_WITHOUT_LABEL_MSG
            = "OptgroupWithoutLabel";
    public static final String FIELDSET_WITHOUT_LEGEND_MSG
            = "FieldsetWithoutLegend";
    public static final String CHECK_SELECT_ELEMENT_USAGE_MSG
            = "CheckSelectUsage";
    public static final String CHECK_LABEL_PERTINENCE_MSG
            = "CheckLabelPertinence";
    public static final String CHECK_TEXT_PERTINENCE_FOR_LABEL_MSG
    		= "CheckTextPertinenceForLabel";
    public static final String CHECK_TEXT_PERTINENCE_MSG
			= "CheckTextPertinence";    
    public static final String FORM_ELEMENT_WITHOUT_LABEL_MSG
            = "FormElementWithoutLabel";
    public static final String CHECK_ARIA_LABEL_PERTINENCE_MSG
    		= "CheckAriaLabelPertinence";
    public static final String FORM_ELEMENT_WITH_NOT_UNIQUE_LABEL_MSG
            = "FormElementWithNotUniqueLabel";
    public static final String CHECK_TITLE_OF_FORM_ELEMENT_MSG
            = "CheckTitleOfFormElement";
    public static final String NOT_PERTINENT_OPTGROUP_LABEL_MSG
            = "NotPertinentOptgroupLabel";
    public static final String CHECK_OPTGROUP_LABEL_PERTINENCE_MSG
            = "CheckOptgroupLabelPertinence";
    public static final String FORM_ELEMENT_WITHOUT_IDENTIFIER_MSG
            = "FormElementWithoutIdentifier";
    public static final String INVALID_FORM_FIELD_MSG = "InvalidFormField";
    public static final String INVALID_LABEL_MSG = "InvalidLabel";
    public static final String INVALID_INPUT_MSG = "InvalidInput";
    public static final String CHECK_INPUT_ARIA_LABEL_IDENTIFICATION = "CheckIputAriaLabelIdentification";
    public static final String CHECK_FORM_ARIA_MSG= "CheckFormAria";
    public static final String FORM_NOT_REFERENCED_MSG
    		= "FormElementNotReferenced";
    public static final String CHECK_REPEATED_LABEL_PERTINENCE_MSG
    		= "CheckRepeatedLabelPertinence";

    // table
    public static final String TABLE_TITLE_RELEVANT_CONTENT
    		= "TableTitleRelevantContent";
    public static final String TABLE_TITLE_NOT_RELEVANT_CONTENT
			= "TableTitleNotRelevantContent";
    public static final String WRONG_TITLE_ASSOCIATION_WITH_TABLE 
    		= "WrongTitleAssociationWithTable";
    public static final String SUMMARY_MISSING_MSG = "SummaryMissing";
    public static final String SUMMARY_TEXT_MISSING_MSG = "SummaryTextMissing";
    public static final String CHECK_NATURE_OF_TABLE_WITH_EMPTY_SUMMARY_MSG
            = "CheckNatureOfTableWithEmptySummaryAttribute";
    public static final String CHECK_NATURE_OF_TABLE_WITH_NOT_EMPTY_SUMMARY_MSG
            = "CheckNatureOfTableWithNotEmptySummaryAttribute";
    public static final String CHECK_NATURE_OF_TABLE_WITH_SUMMARY_MSG
            = "CheckNatureOfTableWithSummaryAttribute";
    public static final String CHECK_NATURE_OF_TABLE_WITH_SUMMARY_TEXT_MSG
    		= "CheckNatureOfTableWithSummaryText";
    public static final String CHECK_NATURE_OF_TABLE_WITHOUT_SUMMARY_MSG
            = "CheckNatureOfTableWithoutSummaryAttribute";
    public static final String CHECK_NATURE_OF_TABLE_WITHOUT_SUMMARY_TEXT_MSG
    		= "CheckNatureOfTableWithoutSummaryText";
    public static final String CAPTION_MISSING_MSG = "CaptionMissing";
    public static final String CAPTION_MISSING_ON_COMPLEX_TABLE_MSG = "CaptionMissingOnComplexTable";
    public static final String CHECK_NATURE_OF_TABLE_WITHOUT_CAPTION_MSG
            = "CheckNatureOfTableWithoutCaptionChildElement";
    public static final String CHECK_TABLE_WITHOUT_CAPTION_IS_NOT_COMPLEX_MSG
            = "CheckTableWithoutCaptionChildElementIsNotComplex";
    public static final String CHECK_NATURE_OF_TABLE_WITH_CAPTION_MSG
            = "CheckNatureOfTableWithCaptionChildElement";
    public static final String CHECK_TABLE_WITH_CAPTION_IS_COMPLEX_MSG
            = "CheckTableWithCaptionChildElementIsComplex";
    public static final String NOT_EMPTY_SUMMARY_MSG
            = "NotEmptySummaryForPresentationTable";
    public static final String NOT_PERTINENT_SUMMARY_MSG
            = "NotPertinentSummaryForDataTable";
    public static final String NOT_PERTINENT_CAPTION_MSG
            = "NotPertinentCaptionForDataTable";
    public static final String NOT_PERTINENT_CAPTION_FOR_COMPLEX_TABLE_MSG
            = "NotPertinentCaptionForComplexTable";
    public static final String NOT_PERTINENT_SUMMARY_TEXT_FOR_COMPLEX_TABLE_MSG
    		= "NotPertinentSummaryTextForComplexTable";
    public static final String CHECK_SUMMARY_PERTINENCE_FOR_DATA_TABLE_MSG
            = "CheckSummaryPertinenceForDataTable";
    public static final String CHECK_CAPTION_PERTINENCE_FOR_DATA_TABLE_MSG
            = "CheckCaptionPertinenceForDataTable";
    public static final String CHECK_CAPTION_PERTINENCE_FOR_COMPLEX_TABLE_MSG
            = "CheckCaptionPertinenceForComplexTable";
    public static final String CHECK_SUMMARY_TEXT_PERTINENCE_FOR_COMPLEX_TABLE_MSG
    		= "CheckSummaryTextPertinenceForComplexTable";
    public static final String CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_SUMMARY_MSG
            = "CheckNatureOfTableForNotPertinentSummary";
    public static final String CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_SUMMARY_TEXT_MSG
    		= "CheckNatureOfTableForNotPertinentSummaryText";
    public static final String CHECK_NATURE_OF_TABLE_FOR_NOT_PERTINENT_CAPTION_MSG
            = "CheckNatureOfTableForNotPertinentCaption";
    public static final String CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_CAPTION_MSG
            = "CheckTableIsComplexForNotPertinentCaption";
    public static final String CHECK_TABLE_IS_COMPLEX_FOR_NOT_PERTINENT_SUMMARY_TEXT_MSG
    		= "CheckTableIsComplexForNotPertinentSummaryText";
    public static final String CHECK_NATURE_OF_TABLE_AND_SUMMARY_PERTINENCE_MSG
            = "CheckNatureOfTableAndSummaryPertinence";
    public static final String CHECK_NATURE_OF_TABLE_AND_CAPTION_PERTINENCE_MSG
            = "CheckNatureOfTableAndCaptionPertinence";
    public static final String CHECK_TABLE_IS_COMPLEX_AND_CAPTION_PERTINENCE_MSG
            = "CheckTableIsComplexAndCaptionPertinence";
    public static final String CHECK_TABLE_IS_COMPLEX_AND_SUMMARY_TEXT_PERTINENCE_MSG
    		= "CheckTableIsComplexAndSummaryTextPertinence";
    public static final String CHECK_NATURE_OF_TABLE_AND_LINEARISED_CONTENT_MSG
            = "CheckNatureOfTableAndLinearisedContent";
    public static final String CHECK_USAGE_OF_HEADERS_FOR_DATA_TABLE_MSG
            = "CheckUsageOfHeaderForDataTable";
    public static final String CHECK_USAGE_OF_ROW_HEADERS_MSG
    		= "CheckUsageOfRowHeader";
    public static final String CHECK_USAGE_OF_COLUMN_HEADERS_MSG
			= "CheckUsageOfColumnHeader";
    public static final String CHECK_USAGE_OF_SCOPE_ROW_OR_COL_MSG
			= "CheckUsageOfScopeRowOrCol";
	public static final String WRONG_SCOPE_VALUE_MSG
			= "WrongScopeValue";	
    public static final String CHECK_NATURE_OF_TABLE_AND_HEADERS_USAGE_MSG
            = "CheckNatureOfTableAndUsageOfHeaders";
    public static final String CHECK_DEFINITION_OF_HEADERS_FOR_DATA_TABLE_MSG
            = "CheckDefinitionOfHeaderForDataTable";
    public static final String CHECK_NATURE_OF_TABLE_AND_HEADERS_DEFINITION_MSG
            = "CheckNatureOfTableAndHeadersDefinition";
    public static final String CHECK_LINEARISED_CONTENT_MSG
            = "CheckLinearisedContent";
    public static final String PRESENTATION_TABLE_WITH_FORBIDDEN_MARKUP_MSG
            = "PresentationTableWithForbiddenMarkup";
    public static final String PRESENTATION_TABLE_WITHOUT_ARIA_MARKUP_MSG
            = "PresentationTableWithoutAriaMarkup";
    public static final String CHECK_TABLE_IS_PRESENTATION_WITH_ROLE_ARIA_MSG
            = "CheckTableIsPresentationWithRoleAria";
    public static final String CHECK_TABLE_IS_NOT_PRESENTATION_WITHOUT_ROLE_ARIA_MSG
            = "CheckTableIsNotPresentationWithoutRoleAria";
    public static final String CHECK_TABLE_IS_DATA_TABLE_MSG
            = "CheckTableIsDataTable";
    public static final String CHECK_TABLE_IS_PRESENTATION_TABLE_MSG
            = "CheckTableIsPresentationTable";
    public static final String DATA_TABLE_WITHOUT_HEADER_MSG
            = "DataTableWithoutHeader";
    public static final String SUSPECTED_HEADERS_NOT_COVER_WHOLE_ELEMENT_MSG
			= "SuspectedHeadersNotCoverWholeElement";
    public static final String SUSPECTED_HEADERS_WELL_FORMED_COVER_WHOLE_ELEMENT_MSG
    		= "SuspectedHeadersWellFormedCoverWholeElement";
    public static final String HEADER_DETECTED_CHECK_ALL_HEADERS_ARE_WELL_FORMED_MSG
            = "HeaderDetectedCheckAllHeadersAreWellFormed";

    // mandatory elements 
    public static final String TITLE_TAG_MISSING_MSG = "TitleTagMissing";
    public static final String MULTIPLE_TITLE_TAG_MSG= "MultipleTitleTagMessage";
    public static final String TITLE_TAG_IN_THE_BODY_MSG = "TitleTagInTheBody";
    public static final String NOT_PERTINENT_TITLE_MSG = "NotPertinentTitle";
    public static final String CHECK_TITLE_PERTINENCE_MSG = "CheckTitlePertinence";
    public static final String LANG_ATTRIBUTE_MISSING_ON_HTML_TAG_MSG
            = "LangAttributeMissingOnHtml";
    public static final String LANG_ATTRIBUTE_MISSING_ON_WHOLE_PAGE_MSG
            = "LangAttributeMissingOnWholePage";
    public static final String WRONG_LANGUAGE_DECLARATION_MSG
            = "WrongLanguageDeclaration";
    public static final String SUSPECTED_RELEVANT_LANG_DECL_MSG
            = "SuspectedRelevantLanguageDeclaration";
    public static final String SUSPECTED_IRRELEVANT_LANG_DECL_MSG
            = "SuspectedIrrelevantLanguageDeclaration";
    public static final String IRRELEVANT_LANG_DECL_MSG
            = "IrrelevantLanguageDeclaration";
    public static final String UNDETECTED_LANG_MSG = "UndetectedLanguage";
    public static final String MALFORMED_LANGUAGE_DECLARATION_MSG
            = "MalformedLanguage";
    public static final String LANGUAGE_CHANGE_MISSING_MSG
            = "LangChangeMissingOnElementOrOneOfItsParent";
    public static final String CHECK_SHORT_TEST_MSG = "CheckManuallyShortText";
    public static final String LINK_WITHOUT_TARGET_MSG = "LinkWithoutTarget";
    public static final String FIELDSET_NOT_WITHIN_FORM_MSG
            = "FieldsetNotWithinForm";

    // links
    public static final String EMPTY_LINK_MSG = "EmptyLink";
    public static final String UNEXPLICIT_LINK_WITH_CONTEXT_MSG
            = "UnexplicitLinkWithContext";
    public static final String CHECK_LINK_WITH_CONTEXT_PERTINENCE_MSG
            = "CheckLinkWithContextPertinence";
    public static final String CHECK_LINK_WITHOUT_CONTEXT_PERTINENCE_MSG
            = "CheckLinkWithoutContextPertinence";
    public static final String CHECK_LINK_PERTINENCE_MSG = "CheckLinkPertinence";
    public static final String CHECK_BUTTON_TITLE_PERTINENCE_MSG
            = "CheckButtonTitlePertinence";
    public static final String CHECK_BUTTON_WITH_SAME_TEXT_LEAD_TO_SAME_ACTION_MSG
            = "CheckButtonWithSameTextLeadToSameAction";
    public static final String UNEXPLICIT_LINK_MSG = "UnexplicitLink";
    public static final String NOT_PERTINENT_LINK_TITLE_MSG
            = "NotPertinentLinkTitle";
    public static final String SUSPECTED_NOT_PERTINENT_LINK_TITLE_MSG
            = "SuspectedNotPertinentLinkTitle";
    public static final String SUSPECTED_PERTINENT_LINK_TITLE_MSG
            = "SuspectedPertinentLinkTitle";
    public static final String EMPTY_LINK_TITLE_MSG = "EmptyLinkTitle";
    public static final String IDENTICAL_LINK_WITH_DIFFERENT_TARGET
            = "IdenticalLinkWithDifferentTarget";
    public static final String SUSPECTED_IDENTICAL_LINK_WITH_DIFFERENT_TARGET
            = "SuspectedIdenticalLinkWithDifferentTarget";

    // scripts
    public static final String CONTEXT_CHANGED_SCRIPT_MSG
            = "ContextChangedScriptDetected";
    public static final String ARIA_FORM_LABEL_MISSING
    		= "AriaFormLabelMissing";
    public static final String ARIA_FORM_LABEL_EMPTY
			= "AriaFormLabelEmpty";
    public static final String ALT_IMG_FORM_LABEL_EMPTY
			= "AltImgFormLabelEmpty";
    public static final String ONKEYPRESS_MISSING_MSG = "OnKeyPressMissing";
    public static final String CHECK_ONCLICK_DEFINTION_IN_JS_MSG
            = "CheckOnClickDefinitionInJs";

    // consultation 
    public static final String NOT_IMMEDIATE_REDIRECT_VIA_META_MSG
            = "NotImmediateRedirectionViaMeta";
    public static final String OFFICE_DOCUMENT_DETECTED_MSG
            = "OfficeDocumentDetected";
    public static final String DOWNLOADABLE_FILE_DETECTED_CHECK_FORMAT_MSG
            = "FileToDownloadDetectedCheckFormat";
    public static final String DOWNLOADABLE_FILE_DETECTED_CHECK_WEIGHT_MSG
            = "FileToDownloadDetectedCheckWeight";
    public static final String DOWNLOADABLE_FILE_DETECTED_CHECK_LANG_MSG
            = "FileToDownloadDetectedCheckLang";
    public static final String CHECK_MANUALLY_LINK_WITHOUT_EXT_MSG
            = "CheckManuallyLinkWithoutExtension";
    public static final String CHECK_DOWNLOADABLE_DOCUMENT_FROM_FORM_MSG
            = "CheckDownloadableDocumentFromForm";
    public static final String CHECK_USER_IS_WARNED_WHEN_NEW_WINDOW_OPEN_MSG
            = "CheckUserIsWarnedWhenNewWindowOpen";
    public static final String CHECK_USER_IS_WARNED_IN_CASE_OF_NEW_WINDOW_MSG
            = "CheckUserIsWarnedInCaseOfNewWindow";
    public static final String CHECK_JS_PROMPT_A_NEW_WINDOW_MSG
            = "CheckJavaScriptPromptANewWindow";

    // structuration of information
    public static final String HEADER_NOT_HIERARCHICALLY_WELL_DEFINED_MSG
            = "HeaderTagNotHierarchicallyWelldefined";
    public static final String H1_TAG_MISSING_MSG = "H1TagMissing";
    public static final String NOT_PERTINENT_HEADING_MSG = "NotPertinentHeading";
    public static final String CHECK_HEADING_PERTINENCE_MSG
            = "CheckHeadingPertinence";
    public static final String PRESENTATION_TAG_DETECTED_MSG
            = "PresentationTagFound";
    public static final String PRESENTATION_ATTR_DETECTED_MSG
            = "PresentationAttrFound";
    public static final String DETECTED_TAG_MSG = "DetectedTag";

    // presentation of information
    public static final String HIDDEN_TEXT_DETECTED_MSG = "HiddenTextDetected";
    public static final String INVISIBLE_OUTLINE_ON_FOCUS_MSG
            = "InvisibleOutlineOnFocus";
    public static final String CHECK_MANUALLY_OUTLINE_FOR_FORM_ELEMENT_AND_IFRAME_MSG
            = "CheckManuallyOutlineForFormElementAndIframe";
    public static final String CHECK_IF_USER_HAVE_MECHANISM_TO_DELETE_JUSTIFY_TEXT_ALIGN_MSG
            = "ChekIfUserHaveAMechanismToDeleteJustifyTextAlign";
    
    //quotations 
    public static final String BLOCKQUOTE_DETECTED_MSG
    		= "BlockquoteDetectedMsg";
    public static final String Q_DETECTED_MSG
			= "QDetectedMsg";

    // css
    public static final String BAD_UNIT_TYPE_MSG = "BadUnitType";
    public static final String FORBIDDEN_UNIT_TYPE_MSG = "ForbiddenUnitType";
    public static final String FORBIDDEN_UNRELATIVE_UNIT_TYPE_MSG = "ForbiddenUnrelativeUnitType";
    public static final String CONTENT_CSS_PROPERTY_DETECTED_MSG
            = "ContentCssPropertyDetected";

    // colors and contrast
    public static final String BAD_CONTRAST_MSG = "BadContrast";
    public static final String BAD_CONTRAST_HIDDEN_ELEMENT_MSG
            = "BadContrastHiddenElement";
    public static final String BAD_CONTRAST_BUT_ALT_MECHANISM_MSG
            = "BadContrastButAlternativeContrastMechanismOnPage";
    public static final String CHECK_CONTRAST_MANUALLY_MSG
            = "CheckContrastManually";
    public static final String NOT_TREATED_BACKGROUND_COLOR_MSG
            = "NotTreatedBackgroundColor";
    public static final String CHECK_CONTRAST_OF_IMAGE_MSG
            = "CheckTheContrastOfImagesWithText";
    public static final String CHECK_BG_COLOR_PRESENCE
            = "CheckBackGroundColorPresence";

    //  navigation
    public static final String SUSPECTED_MISSING_ATTRIBUTE_WITH_VALUE_BANNER
            = "SuspectedMissingTagWithRoleAttributeThatValueIsBanner";
    public static final String SUSPECTED_MISSING_ATTRIBUTE_WITH_VALUE_BANNER2
            = "SuspectedMissingTagWithRoleAttributeThatValueIsBanner2";
    public static final String SUSPECTED_MISSING_ATTRIBUTE_WITH_VALUE_BANNER3
            = "SuspectedMissingTagWithRoleAttributeThatValueIsBanner3";

    // seo 
    public static final String META_DESC_MISSING_MSG
            = "MetaDescriptionTagMissing";
    public static final String MORE_THAN_ONE_META_DESC_MSG
            = "MoreThanOneMetaDescriptionTag";
    public static final String META_DESC_EXCEEDS_LIMIT_MSG
            = "MetaDescriptionTagLengthExceedLimit";
    public static final String URL_EXCEEDS_LIMIT_MSG
            = "UrlLengthExceedLimit";
    public static final String TITLE_EXCEEDS_LIMIT_MSG
            = "TitleTagLengthExceedLimit";
    public static final String META_DESC_NOT_UNIQUE_MSG
            = "MetaDescriptionNotUnique";
    public static final String META_DESC_IDENTICAL_TO_ANOTHER_PAGE_MSG
            = "MetaDescriptionIdenticalTo";
    public static final String META_DESC_NOT_RELEVANT_MSG
            = "EmptyMetaDescriptionTag";
    public static final String CHECK_META_DESC_RELEVANCY_MSG
            = "CheckRelevancyMetaDescriptionTag";

    public static final String TITLE_NOT_UNIQUE_MSG = "TitleNotUnique";
    public static final String TITLE_IDENTICAL_TO_ANOTHER_PAGE_MSG
            = "TitleIdenticalTo";
    public static final String H1_NOT_UNIQUE_MSG = "H1NotUnique";
    public static final String H1_IDENTICAL_TO_ANOTHER_PAGE_MSG
            = "H1IdenticalTo";
    public static final String SOURCE_CODE_NOT_UNIQUE_MSG = "SourceCodeNotUnique";
    public static final String SOURCE_CODE_IDENTICAL_TO_ANOTHER_PAGE_MSG
            = "SourceCodeIdenticalTo";
    public static final String ROBOTS_TXT_MSG = "RobotsTxtMissing";
    public static final String SITEMAP_MSG = "SitemapMissing";
    public static final String FRAMESET_DETECTED_MSG = "FramesetDetected";
    public static final String NOT_RELEVANT_H1_MSG = "notRelevantH1Tag";
    public static final String CHECK_H1_RELEVANCY_MSG = "checkRelevancyH1Tag";
    public static final String MORE_THAN_ONE_H1_MSG = "MoreThanOneH1Tag";
    public static final String FLASH_CONTENT_DETECTED_MSG
            = "FlashContentDetected";
    public static final String SUSPECTED_FLASH_CONTENT_DETECTED_MSG
            = "SuspectedFlashContentDetected";
    public static final String IDENTICAL_H1_AND_TITLE_MSG = "IdenticalH1AndTitleTags";
    public static final String URL_PARAMETERS_DETECTED = "UrlParametersDetected";
    public static final String URL_PATH_UNDERSCORE_DETECTED = "UrlPathUnderscoreDetected";

    public static final String CHECK_LINK_ASSO_WITH_SERVER_SIDED_IMG_MAP
            = "CheckALinkIsAssociatedWithAServerSidedImageMap";

    /**
     * Private constructor. This class handles keys and must not be instantiated
     */
    private RemarkMessageStore() {
    }

}
