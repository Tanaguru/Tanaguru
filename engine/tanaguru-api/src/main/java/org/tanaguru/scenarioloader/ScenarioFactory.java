package org.tanaguru.scenarioloader;


import org.tanaguru.scenarioloader.ScenarioRunner;

import java.util.List;

/**
 * @author rcharre
 */
public interface ScenarioFactory {
    /**
     *
     * @param urls
     * @param scenarioRunner
     * @return the scenario
     */
    public String make(List<String> urls, ScenarioRunner scenarioRunner);

    /**
     *
     * @param url
     * @param scenarioRunner
     * @return the scenario
     */
    public String make(String url, ScenarioRunner scenarioRunner);
}
