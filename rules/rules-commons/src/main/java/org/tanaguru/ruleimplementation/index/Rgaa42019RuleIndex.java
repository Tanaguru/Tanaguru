package org.tanaguru.ruleimplementation.index;

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
    rgaa42019_1_2_1(DecorativeNonLegendedHas_NoAltAndNoAltText_Or_AriaHiddenOrRolePresentation.class, "RGAA42019 1.2.1"),

    rgaa42019_2_1_1(FrameAndIframeHasTitle .class, "RGAA42019 2.1.1"),
    rgaa42019_2_2_1(FrameAndIframeTitleIsRelevant .class, "RGAA42019 2.2.1"),

    rgaa42019_5_1_1(ComplexDataTableHasSummary .class, "RGAA42019 5.1.1"),
    rgaa42019_5_2_1(ComplexDataTableSummaryIsPertinent.class, "RGAA42019 5.2.1"),
    rgaa42019_5_4_1(DataTableTitleCorrectlyAssociated.class, "RGAA42019 5.4.1"),
    rgaa42019_5_5_1(DataTableTitleIdentifyContent.class, "RGAA42019 5.5.1"),
    rgaa42019_5_6_1(DataTableEachHeaderIsThAndHasRoleColumnHeader.class, "RGAA42019 5.6.1"),
    rgaa42019_5_8_1(FormattingTableHasNoDataTagAndNoDataAttributes .class, "RGAA42019 5.8.1");



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
