package org.tanaguru.scenarioloader.factory;

import org.json.JSONException;
import org.tanaguru.scenarioloader.ScenarioFactory;
import org.tanaguru.selenese.SeleneseBuilder;

import java.util.List;

public class ScenarioFactoryImpl implements ScenarioFactory {
    @Override
    public String make(List<String> urls) {
        String scenario = "";

        try {
            scenario = SeleneseBuilder.buildFromListOfUrls("Tanaguru scenario", urls).getScenario();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return scenario;
    }

    @Override
    public String make(String url) {
        String scenario = "";

        try {
            scenario = SeleneseBuilder.buildFromUrl("Tanaguru scenario", url).getScenario();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return scenario;
    }
}
