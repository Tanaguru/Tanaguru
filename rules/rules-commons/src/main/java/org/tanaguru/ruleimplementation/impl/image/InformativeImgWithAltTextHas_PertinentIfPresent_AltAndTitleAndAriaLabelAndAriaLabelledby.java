package org.tanaguru.ruleimplementation.impl.image;

import org.jsoup.nodes.Element;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.rules.elementchecker.CompositeChecker;
import org.tanaguru.rules.elementchecker.pertinence.AttributePertinenceChecker;
import org.tanaguru.rules.elementselector.ImageElementSelector;

import static org.tanaguru.rules.keystore.AttributeStore.*;
import static org.tanaguru.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.tanaguru.rules.keystore.RemarkMessageStore.CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG;
import static org.tanaguru.rules.keystore.RemarkMessageStore.NOT_PERTINENT_ALT_MSG;
import static org.tanaguru.rules.keystore.rgaa4.Rgaa4CssLikeQueryStore.IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY;
import static org.tanaguru.rules.keystore.rgaa4.Rgaa4CssLikeQueryStore.ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY;

public class InformativeImgWithAltTextHas_PertinentIfPresent_AltAndTitleAndAriaLabelAndAriaLabelledby extends AbstractMarkerPageRuleImplementation {

    ElementHandler<Element> markedInformativeImageHandler = new ElementHandlerImpl();
    ElementHandler<Element> markedInformativeRoleImageHandler = new ElementHandlerImpl();
    ElementHandler<Element> suspectedInformativeImageHandler = new ElementHandlerImpl();
    ElementHandler<Element> suspectedInformativeRoleImageHandler = new ElementHandlerImpl();

    public InformativeImgWithAltTextHas_PertinentIfPresent_AltAndTitleAndAriaLabelAndAriaLabelledby() {
        super(  // the informative images are part of the scope
                INFORMATIVE_IMAGE_MARKER,
                // the decorative images are not part of the scope
                DECORATIVE_IMAGE_MARKER);
        setElementSelector( new ImageElementSelector(
                IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY + ", " + ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY,
                true,
                false
        ));
    }

    protected void select(SSPHandler sspHandler) {
        super.select(sspHandler);

        for (Element markedElement : getSelectionWithMarkerHandler().get()) {
            if (markedElement.is(IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY)) {
                this.markedInformativeImageHandler.add(markedElement);
            } else if (markedElement.is(ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY)) {
                this.markedInformativeRoleImageHandler.add(markedElement);
            }
        }

        for (Element suspectedElement : getSelectionWithoutMarkerHandler().get()) {
            if (suspectedElement.is(IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY)) {
                this.suspectedInformativeImageHandler.add(suspectedElement);
            } else if (suspectedElement.is(ROLE_IMG_WITH_ALTTEXT_RGAA4_CSS_LIKE_QUERY)) {
                this.suspectedInformativeRoleImageHandler.add(suspectedElement);
            }
        }
    }

    protected void check(SSPHandler sspHandler,
                         TestSolutionHandler testSolutionHandler) {

        super.check(sspHandler, testSolutionHandler);

        CompositeChecker markedInformativeImageChecker = new CompositeChecker(
                new AttributePertinenceChecker(
                        ARIA_LABELLEDBY_ATTR,
                        true,
                        null,
                        null,
                        NOT_PERTINENT_ALT_MSG,
                        CHECK_ALT_PERTINENCE_OF_INFORMATIVE_IMG_MSG,
                        ARIA_LABELLEDBY_ATTR,
                        SRC_ATTR
                )
        );
        markedInformativeImageChecker.setIsOrCombinaison(false);

    }
}
