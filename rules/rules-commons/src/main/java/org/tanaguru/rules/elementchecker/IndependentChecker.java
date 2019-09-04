package org.tanaguru.rules.elementchecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.entity.audit.TestSolution;
import org.tanaguru.processor.SSPHandler;
import org.tanaguru.ruleimplementation.ElementHandler;
import org.tanaguru.ruleimplementation.ElementHandlerImpl;
import org.tanaguru.ruleimplementation.TestSolutionHandler;
import org.tanaguru.ruleimplementation.TestSolutionHandlerImpl;
import org.tanaguru.service.ProcessRemarkService;

public class IndependentChecker extends NomenclatureBasedElementChecker {
	
	
	/**
     * The collection of checkers recursively called. 
     * This collection is of LinkedList type to maintain an order.
     */
    private final Collection<ElementChecker> checkers = new LinkedList<>();
    public Collection<ElementChecker> getCheckers() {
        return checkers;
    }
    public void addChecker(ElementChecker elementChecker) {
        checkers.add(elementChecker);
    }
    
    /**
     * Constructor. 
     * 
     * @param elementCheckers
     */
    public IndependentChecker(ElementChecker... elementCheckers) {
        super();
        this.checkers.addAll(Arrays.asList(elementCheckers));
    }
    
    /**
     * 
     */
    public IndependentChecker() {
        super();
    }
    
    /**
     * 
     * @param eeAttributeNameList 
     */
    public IndependentChecker(String... eeAttributeNameList) {
        super(eeAttributeNameList);
    }
    
    /**
     * 
     * @param failureSolution
     */
    public IndependentChecker(TestSolution failureSolution) {
        super();
        setFailureSolution(failureSolution);
    }
    
    /**
     * Constructor.
     * Enables to override the failure solution.
     * @param failureSolution
     * @param eeAttributeNameList 
     */
    public IndependentChecker(
            TestSolution failureSolution,
            String... eeAttributeNameList) {
        super(eeAttributeNameList);
        setFailureSolution(failureSolution);
    }
    
    @Override
    protected void doCheck(
             SSPHandler sspHandler, 
             Elements elements, 
             TestSolutionHandler testSolutionHandler) {
         setServicesToCheckers();
         ElementHandler<Element> elementHandler = new ElementHandlerImpl();
         for (Element element : elements) {
             elementHandler.clean().add(element);
             testSolutionHandler.addTestSolution(callCheckers(sspHandler, elementHandler));
         }
    }
    
    /**
     * Check the pertinence of a text by calling recursively the checkers 
     * loaded by the instance. If no checker returns failed, a sourceCodeRemark
     * is created with a manual check message. To respect the ElementChecker 
     * interface, the check method is called with an elementHandler instance as
     * argument. This instance only contains the current checked element.
     * 
     * @param sspHandler
     * @param elementHandler
     * @return the solution of the pertinence check
     */
    protected TestSolution callCheckers(
            SSPHandler sspHandler,
            ElementHandler<Element> elementHandler) {
        
        ArrayList<TestSolution> globalTestSolution = new ArrayList<TestSolution>();

        for (ElementChecker ec : checkers) {
            TestSolutionHandler testSolutionHandler = new TestSolutionHandlerImpl();
            ec.check(sspHandler, elementHandler, testSolutionHandler);

            TestSolution checkerSolution = testSolutionHandler.getTestSolution();
            
            globalTestSolution.add(checkerSolution);
        }

        return createSolutionFromCheckersResult(
                globalTestSolution, 
                sspHandler);
    }
    
    private TestSolution createSolutionFromCheckersResult(ArrayList<TestSolution> globalTestSolution,
            SSPHandler sspHandler) {
    	
    	if (globalTestSolution.isEmpty()) {
	        return TestSolution.NOT_APPLICABLE;
	    }
    	
        boolean hasPassed = false;
        boolean hasFailed = false;
        boolean hasNMI = false;
        
    	for(TestSolution ts : globalTestSolution) {
    		switch (ts)  {
	    		case NEED_MORE_INFO :
	    			hasNMI = true;
	    			break;
	    		case FAILED:
	    			hasFailed = true;
	    			break;
	    		case PASSED : 
	    			hasPassed = true;
	    			break;
				default:
    		}
    	}

    	if(hasPassed) {
    		ProcessRemarkService prs = sspHandler.getProcessRemarkService();
    		prs.resetService();
    		sspHandler.setProcessRemarkService(prs);
    		return TestSolution.PASSED;
    	}
    	if(hasNMI) {
    		return TestSolution.NEED_MORE_INFO;
    	}
    	if(hasFailed) {
    		return TestSolution.FAILED;
    	}

		return TestSolution.NOT_APPLICABLE;
	}
    
    
	/**
     * Set service to elementChecker depending on their nature.
     * @param elementChecker 
     */
    private void setServicesToCheckers() {
        for (ElementChecker el : checkers) {
            if (el instanceof NomenclatureBasedElementChecker) {
                ((NomenclatureBasedElementChecker)el).
                    setNomenclatureLoaderService(getNomenclatureLoaderService());
            }
        }
    }
}
