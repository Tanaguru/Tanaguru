package org.tanaguru.scenarioloader;

import java.util.List;

/**
 * @author rcharre
 */
public interface ScenarioFactory {
    /**
     *
     * @param urls
     * @return the scenario
     */
    public String make(List<String> urls);

    /**
     *
     * @param url
     * @return the scenario
     */
    public String make(String url);
}
