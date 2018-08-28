package org.tanaguru.selenese.tools;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SeleneseBuilder {

    private JSONObject scenario;

    public SeleneseBuilder(String name, String url) throws JSONException {
        scenario = new JSONObject();
        scenario.put("id", "Project-" + name);
        scenario.put("name", name);
        scenario.put("url", url);
        scenario.put("tests", new JSONArray());
        scenario.put("suites", new JSONArray());
        scenario.put("urls", new JSONArray());
        scenario.put("plugins", new JSONArray());
        scenario.put("version", "1.0");
    }

    public SeleneseBuilder(String name) throws JSONException {
            this(name, "");
    }

    public SeleneseBuilder putUrl(String url) throws JSONException {
        JSONArray urls = scenario.getJSONArray("urls");
        urls.put(url);
        scenario.put("urls", urls);
        return this;
    }

    public SeleneseBuilder putSuite(String name, boolean persistSession, boolean parallel, long timeout) throws JSONException {
        JSONArray suites = scenario.getJSONArray("suites");
        JSONObject suite = new JSONObject();

        suite.put("id", (suites.length() + 1));
        suite.put("name", name);
        suite.put("persistSession", persistSession);
        suite.put("parallel", parallel);
        suite.put("timeout", timeout);
        suite.put("tests", new JSONArray());

        suites.put(suite);
        scenario.put("suites", suites);

        return this;
    }

    public SeleneseBuilder putTest(String suiteName, String name) throws JSONException {
        JSONArray suites = scenario.getJSONArray("suites");
        for (int i = 0; i < suites.length(); i++) {
            JSONObject suite = suites.getJSONObject(i);
            if (suite.get("name").equals(suiteName)) {
                JSONArray suiteTests = suite.getJSONArray("tests");
                JSONObject test = new JSONObject();

                String id = (i + 1) + "-" + (suiteTests.length() + 1);
                test.put("id", id);
                test.put("name", name);
                test.put("commands", new JSONArray());

                suiteTests.put(id);
                suite.put("tests", suiteTests);
                suites.put(i, suite);
                scenario.put("suites", suites);

                JSONArray tests = scenario.getJSONArray("tests");
                tests.put(test);
                scenario.put("tests", tests);
                break;
            }
        }
        return this;
    }

    public SeleneseBuilder putCommand(String testName, String comment, String commandType, String target, String value, String... targets) throws JSONException {
        JSONArray tests = scenario.getJSONArray("tests");
        for (int i = 0; i < tests.length(); i++) {
            JSONObject test = tests.getJSONObject(i);
            if (test.get("name").equals(testName)) {
                JSONArray commands = test.getJSONArray("commands");
                JSONObject command = new JSONObject();
                String id = test.get("id") + "-" + (commands.length() + 1);
                command.put("id", id);
                command.put("comment", comment);
                command.put("command", commandType);
                command.put("target", target);
                JSONArray jsonTargets = new JSONArray();
                if (targets != null) {
                    for (String t : targets) {
                        jsonTargets.put(t);
                    }
                }
                command.put("targets", jsonTargets);
                command.put("value", value);

                commands.put(command);
                test.put("commands", commands);
                tests.put(i, test);
                scenario.put("tests", tests);
                break;
            }
        }
        return this;
    }

    public String getScenario() {
        return scenario.toString();
    }

    public static SeleneseBuilder buildFromListOfUrls(String name, List<String> urls) throws JSONException {
        SeleneseBuilder builder = new SeleneseBuilder(name);
        builder.putSuite("Test url", false, false, 300);
        int i = 0;
        for (String url : urls) {
            i++;
            builder.putUrl(url)
                    .putTest("Test url " + i, url)
                    .putCommand(url, "open url : " + url, "open", url, "", null);

        }
        return builder;
    }

    public static SeleneseBuilder buildFromUrl(String name, String url) throws JSONException {
        SeleneseBuilder builder = new SeleneseBuilder(name);
        builder.putSuite("Test url", false, false, 300)
                .putUrl(url)
                .putTest("Test url", url)
                .putCommand(url, "open url : " + url, "open", url, "", null);
        return builder;
    }

}
