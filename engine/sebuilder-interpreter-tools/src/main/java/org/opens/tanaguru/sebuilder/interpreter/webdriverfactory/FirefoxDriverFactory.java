/*
 * Copyright 2012 Sauce Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opens.tanaguru.sebuilder.interpreter.webdriverfactory;

import com.sebuilder.interpreter.webdriverfactory.WebDriverFactory;
import java.util.HashMap;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxDriverFactory implements WebDriverFactory {

    private static final String DISPLAY_PROPERTY = "display";
    
    FirefoxProfile firefoxProfile;
    public void setFirefoxProfile(FirefoxProfile firefoxProfile) {
        this.firefoxProfile = firefoxProfile;
    }
    
    /**
     * 
     * @param config
     * @return A FirefoxDriver.
     */
    @Override
    public RemoteWebDriver make(HashMap<String, String> config) {
        FirefoxBinary ffBinary = new FirefoxBinary();
        if (System.getProperty(DISPLAY_PROPERTY) != null) {
            ffBinary.setEnvironmentProperty(
                    DISPLAY_PROPERTY.toUpperCase(), 
                    System.getProperty(DISPLAY_PROPERTY));
        } else if (System.getenv(DISPLAY_PROPERTY.toUpperCase()) != null) {
            ffBinary.setEnvironmentProperty(
                    DISPLAY_PROPERTY.toUpperCase(), 
                    System.getenv(DISPLAY_PROPERTY.toUpperCase()));
        }
        return new FirefoxDriver(ffBinary, firefoxProfile);
    }
}
