/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opens.tanaguru.rules.aria10;

import static junit.framework.Assert.assertEquals;
import org.opens.tanaguru.entity.audit.ProcessRemark;
import org.opens.tanaguru.entity.audit.ProcessResult;
import org.opens.tanaguru.entity.audit.SourceCodeRemark;
import org.opens.tanaguru.entity.audit.TestSolution;
import org.opens.tanaguru.rules.aria10.test.Aria10RuleImplementationTestCase;

/**
 *
 * @author alingua
 */
public class Aria10RuleDpAccordionTest extends Aria10RuleImplementationTestCase {

    public Aria10RuleDpAccordionTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.opens.tanaguru.rules.aria10.Aria10RuleDpAccordion");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-1Passed-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-1Passed-01.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-01.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-02.html"));
//        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-03",
//                getWebResourceFactory().createPage(
//                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-03.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-04",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-04.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-05",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-05.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-06",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-06.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-07",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-07.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-08",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-08.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-09",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-09.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-10",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-10.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-11",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-11.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-2Failed-12",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-2Failed-12.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-3NA-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-3NA-01.html"));
        getWebResourceMap().put("ARIA10.Test.Dp.Accordion-3NA-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "ARIA10/Aria10RuleDpAccordion/ARIA10.Test.Dp.Accordion-3NA-02.html"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------1Passed-01------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("ARIA10.Test.Dp.Accordion-1Passed-01");
        // check test result
        assertEquals(TestSolution.PASSED, processResult.getValue());
        // check test has no remark
        assertNull(processResult.getRemarkSet());
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());


        //----------------------------------------------------------------------
        //------------------------------2Failed-01------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-01");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(4, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(8, processResult.getElementCounter());


        //----------------------------------------------------------------------
        //------------------------------2Failed-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-02");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-04------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-04");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(2, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(18, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-05------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-05");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-06------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-06");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-07------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-07");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-08------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-08");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(2, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-09------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-09");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-10------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-10");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-11------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-11");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(1, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(9, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------2Failed-12------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-2Failed-12");
        assertEquals(TestSolution.FAILED, processResult.getValue());
        assertEquals(2, processResult.getRemarkSet().size());
        for (ProcessRemark pr : processResult.getRemarkSet()) {
            if (pr instanceof SourceCodeRemark) {
                SourceCodeRemark scr = (SourceCodeRemark) pr;
                System.out.println(scr.getTarget());
                System.out.println(scr.getMessageCode());
            }
        }
        // check number of elements in the page
        assertEquals(18, processResult.getElementCounter());

        //----------------------------------------------------------------------
        //------------------------------3NA-01------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-3NA-01");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark


        //----------------------------------------------------------------------
        //------------------------------3NA-02------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("ARIA10.Test.Dp.Accordion-3NA-02");
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check test has no remark
    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.PASSED,
                consolidate("ARIA10.Test.Dp.Accordion-1Passed-01").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-01").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-02").getValue());
//        assertEquals(TestSolution.FAILED,
//                consolidate("ARIA10.Test.Dp.Accordion-2Failed-03").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-04").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-05").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-06").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-07").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-08").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-09").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-10").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-11").getValue());
        assertEquals(TestSolution.FAILED,
                consolidate("ARIA10.Test.Dp.Accordion-2Failed-12").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("ARIA10.Test.Dp.Accordion-3NA-01").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("ARIA10.Test.Dp.Accordion-3NA-02").getValue());
    }
}
