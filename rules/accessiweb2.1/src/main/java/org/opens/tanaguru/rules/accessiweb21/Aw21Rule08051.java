/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2012  Open-S Company
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.rules.accessiweb21;

import java.util.ArrayList;
import java.util.List;
import org.opens.tanaguru.entity.audit.ProcessRemark;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.processor.SSPHandler;
import org.opens.tanaguru.ruleimplementation.AbstractPageRuleImplementation;

/**
 *
 * @author jkowalczyk
 */
public class Aw21Rule08051 extends AbstractPageRuleImplementation {

    private static final String MESSAGE_CODE = "TitleTagMissing";

    /**
     *
     */
    public Aw21Rule08051() {
        super();
    }

    /**
     *
     * @param sspHandler
     * @return
     */
    @Override
    protected ProcessResult processImpl(SSPHandler sspHandler) {

        List<ProcessRemark> processRemarkList = new ArrayList<ProcessRemark>();
        sspHandler.beginSelection().selectDocumentNodes(NodeAndAttributeKeyStore.HEAD_NODE).
                selectChildNodes(NodeAndAttributeKeyStore.TTTLE_NODE);

        TestSolution testSolution = null;

        if (sspHandler.getSelectedElementList() != null
                && sspHandler.getSelectedElementList().size() == 1) {
            testSolution = TestSolution.PASSED;
        } else {
            testSolution = TestSolution.FAILED;
            processRemarkList.add(sspHandler.getProcessRemarkService().createProcessRemark(
                    TestSolution.FAILED,
                    MESSAGE_CODE));
        }

        ProcessResult processResult = definiteResultFactory.create(
                test,
                sspHandler.getPage(),
                testSolution,
                processRemarkList);

        return processResult;
    }
}
