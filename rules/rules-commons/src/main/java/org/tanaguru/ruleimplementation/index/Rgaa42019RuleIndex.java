package org.tanaguru.ruleimplementation.index;

import org.tanaguru.ruleimplementation.impl.form.*;
import org.tanaguru.ruleimplementation.impl.frame.FrameAndIframeHasTitle;
import org.tanaguru.ruleimplementation.impl.frame.FrameAndIframeTitleIsRelevant;
import org.tanaguru.ruleimplementation.impl.image.*;
import org.tanaguru.ruleimplementation.impl.table.*;

public enum  Rgaa42019RuleIndex {
    /**
     * This enum is not used anywhere. Its only purpose is to help developers
     * to find multi referential rules.
     *
     * @Author Raphaël Charre
     */

    rgaa42019_1_1_1(InformativeImageHasAltAttr.class, "RGAA42019 1.1.1"),
    rgaa42019_1_1_2(AreaOfInformativeImageHasAltText.class, "RGAA42019 1.1.2"),
    rgaa42019_1_1_3(ImageInputHasAltText.class, "RGAA42019 1.1.3"),
    //rgaa42019_1_1_4(Rgaa32017Rule010104.class, "RGAA42019 1.1.4"),
    rgaa42019_1_1_5(InformativeSvgHasRoleImageAndAltText.class, "RGAA42019 1.1.5"),
    rgaa42019_1_1_6(InformativeImageObjectHasAltTextOrAltContentLinkOrObjectContentSwitchMechanism.class, "RGAA42019 1.1.6"),
    rgaa42019_1_1_7(InformativeEbdImageHasAltTextOrAltContentLinkOrEmbedContentSwitchMechanism.class, "RGAA42019 1.1.7"),
    rgaa42019_1_1_8(InformativeCanvasHasAltTextOrAltContentInCanvasOrAltContentLinkOrCanvasContentSwitchMechanism.class, "RGAA42019 1.1.8"),
    rgaa42019_1_2_1(DecorativeNonLegendedHas_EmptyAltAndNoAltText_Or_AriaHiddenOrRolePresentation.class, "RGAA42019 1.2.1"),
    rgaa42019_1_2_2(DecorativeAreaWithoutHrefHas_EmptyAltAndNoAltText_Or_AriaHiddenOrRolePresentation.class, "RGAA42019 1.2.2"),
    rgaa42019_1_2_3(DecorativeImageObjectWithoutLegendHasAriaHiddenTrueAndNoAltTextAndNoTextUsedAsAltText.class, "RGAA42019 1.2.3"),
    //TODO
    rgaa42019_1_3_1(InformativeImgWithAltTextHas_PertinentIfPresent_AltAndTitleAndAriaLabelAndAriaLabelledby.class, "RGAA42019 1.3.1"),
    rgaa42019_1_5_1(CaptchaRgaa4ImageHasNonGraphicAltOrOtherAccess.class, "RGAA42019 1.5.1"),
    //rgaa42019_1_5_2(Rgaa32017Rule010502.class, "RGAA42019 1.5.2"),
    //rgaa42019_1_6_1(Rgaa32017Rule010601.class, "RGAA42019 1.6.1"),
    //rgaa42019_1_6_2(Rgaa32017Rule010602.class, "RGAA42019 1.6.2"),
    //rgaa42019_1_6_3(Rgaa32017Rule010603.class, "RGAA42019 1.6.3"),
    //rgaa42019_1_6_4(Rgaa32017Rule010604.class, "RGAA42019 1.6.4"),
    //rgaa42019_1_7_2(Rgaa32017Rule010604.class, "RGAA42019 1.7.2"),
    rgaa42019_1_8_1(InformativeRgaa4ImageTextHasSwitchMechanismOrStyledTextSwitch.class, "RGAA42019 1.8.1"),


    rgaa42019_2_1_1(FrameAndIframeHasTitle.class, "RGAA42019 2.1.1"),
    rgaa42019_2_2_1(FrameAndIframeTitleIsRelevant.class, "RGAA42019 2.2.1"),

    //rgaa42019_4_1_1(Rgaa32017Rule040401.class, "RGAA42019 4.1.1"),
    //rgaa42019_4_1_2(Rgaa32017Rule040402.class, "RGAA42019 4.1.2"),
    //rgaa42019_4_1_3(Rgaa32017Rule040403.class, "RGAA42019 4.1.3"),

    rgaa42019_5_1_1(ComplexDataTableHasSummary.class, "RGAA42019 5.1.1"),
    rgaa42019_5_2_1(ComplexDataTableSummaryIsPertinent.class, "RGAA42019 5.2.1"),
    rgaa42019_5_4_1(DataTableTitleCorrectlyAssociated.class, "RGAA42019 5.4.1"),
    rgaa42019_5_5_1(DataTableTitleIdentifyContent.class, "RGAA42019 5.5.1"),
    rgaa42019_5_6_1(DataTableEachHeaderIsThAndHasRoleColumnHeader.class, "RGAA42019 5.6.1"),
    rgaa42019_5_8_1(FormattingTableHasNoDataTagAndNoDataAttributes .class, "RGAA42019 5.8.1"),

    //rgaa42019_10_1_1(Rgaa32017Rule100101.class, "RGAA42019 10.1.1"),
    //rgaa42019_10_1_1(Rgaa32017Rule100102.class, "RGAA42019 10.1.2"),

    rgaa42019_11_2_1(LabelTagUnderstandable.class, "RGAA42019 11.2.1"),
    rgaa42019_11_2_2(InputTitleUnderstandable.class, "RGAA42019 11.2.2"),
    rgaa42019_11_2_3(InputAriaLabelUnderstandable.class, "RGAA42019 11.2.3"),
    rgaa42019_11_2_4(InputAriaLabelledbyUnderstandable.class, "RGAA42019 11.2.4"),
    rgaa42019_11_3_1(LabelRepetedInPageIsConsistent.class, "RGAA42019 11.3.1"),
    rgaa42019_11_4_1(LabelRepetedInGroupOfPageIsConsistent.class, "RGAA42019 11.4.1");


    private Class ruleClass;
    private String rule;

    Rgaa42019RuleIndex(Class ruleClass, String rule){
        this.ruleClass = ruleClass;
        this.rule = rule;
    }

    public Class getRuleClass() {
        return ruleClass;
    }

    public String getRule() {
        return rule;
    }
}
