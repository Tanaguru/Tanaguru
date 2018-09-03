/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2015  Tanaguru.org
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: tanaguru AT tanaguru DOT org
 */
package org.tanaguru.selenese.tools;

import com.google.gson.JsonObject;
import junit.framework.TestCase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jkowalczyk
 */
public class SeleneseBuilderTest extends TestCase {

   public SeleneseBuilderTest() {
    }

    @Override
    public void setUp() throws Exception {
    }

    @Override
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of buildScenario method, of class ScenarioBuilder.
     */
    public void testBuildScenario_String() throws JSONException {
        System.out.println("buildScenario with 1 Url");
        String url = "http://www.test.org";
        String name = "Test build scenario from string";
        SeleneseBuilder result = SeleneseBuilder.buildFromUrl(name, url);
        JSONObject scenario = result.getScenarioJson();
        assertNotNull(scenario);

        JSONArray tests = scenario.getJSONArray("tests");
        assertNotNull(tests);
        assertEquals(tests.length(), 1);

        JSONObject test = tests.getJSONObject(0);
        assertNotNull(test);

        JSONArray commands = test.getJSONArray("commands");
        assertNotNull(commands);
        assertEquals(tests.length(), 1);

        JSONObject command = commands.getJSONObject(0);
        assertNotNull(command);

        assertEquals("open", command.getString("command"));
        assertEquals(url, command.getString("target"));

        JSONArray suites = scenario.getJSONArray("suites");
        assertNotNull(suites);
        assertEquals(suites.length(), 1);

        JSONObject suite = suites.getJSONObject(0);
        assertNotNull(suite);

        JSONArray suiteTests = suite.getJSONArray("tests");
        assertNotNull(suiteTests);
        assertEquals(suiteTests.length(), 1);
        assertEquals(suiteTests.getString(0), test.getString("id"));

        assertTrue(SeleneseHelper.isScenarioValid(result.getScenario()));
    }

    /**
     * Test of buildScenario method, of class ScenarioBuilder.
     */
    public void testBuildScenario_List() throws JSONException {
        System.out.println("buildScenario with several Url");
        List<String> urlList = new LinkedList<>();
        String url1 = "http://www.test1.org";
        String url2 = "http://www.test2.org";
        String url3 = "http://www.test3.org";
        String url4 = "http://www.test4.org";
        urlList.add(url1);
        urlList.add(url2);
        urlList.add(url3);
        urlList.add(url4);

        String name = "Test build scenario from list of string";
        SeleneseBuilder result = SeleneseBuilder.buildFromListOfUrls(name, urlList);
        JSONObject scenario = result.getScenarioJson();
        assertNotNull(scenario);

        JSONArray tests = scenario.getJSONArray("tests");
        assertNotNull(tests);
        assertEquals(urlList.size(), tests.length());

        JSONObject test = tests.getJSONObject(0);
        assertNotNull(test);

        JSONArray commands = test.getJSONArray("commands");
        assertNotNull(commands);
        assertEquals(commands.length(), 1);

        for(int i = 0; i < commands.length(); i++){
            JSONObject command = commands.getJSONObject(i);
            assertNotNull(command);

            assertEquals("open", command.getString("command"));
            assertTrue(urlList.contains(command.getString("target")));
        }

        JSONArray suites = scenario.getJSONArray("suites");
        assertNotNull(suites);
        assertEquals(suites.length(), 1);

        JSONObject suite = suites.getJSONObject(0);
        assertNotNull(suite);

        JSONArray suiteTests = suite.getJSONArray("tests");
        assertNotNull(suiteTests);
        assertEquals(suiteTests.length(), urlList.size());
        assertTrue(SeleneseHelper.isScenarioValid(result.getScenario()));
    }
}
