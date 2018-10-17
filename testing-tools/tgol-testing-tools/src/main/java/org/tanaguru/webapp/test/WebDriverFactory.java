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

package org.tanaguru.webapp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.tanaguru.webdriver.driver.TanaguruDriver;
import org.tanaguru.webdriver.factory.ProfileFactoryImpl;

/**
 * WebDriverFactory that guarantees that only one instance of webdriver is used 
 * for a whole campaign.
 * 
 * @author jkowalczyk
 */
public class WebDriverFactory {

    private WebDriver webDriver;
    
    /**
     * The holder that handles the unique instance of WebDriverFactory
     */
    private static class WebDriverFactoryHolder {
        private static final WebDriverFactory INSTANCE = new WebDriverFactory();
    }
    
    /**
     * Private constructor
     */
    private WebDriverFactory() {}
    
    /**
     * Singleton pattern based on the "Initialization-on-demand 
     * holder idiom". See @http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom
     * @return the unique instance of WebDriverFactory
     */
    public static WebDriverFactory getInstance() {
        return WebDriverFactoryHolder.INSTANCE;
    }
    
    /**
     * This methods creates a firefoxDriver instance and set a DISPLAY 
     * environment variable
     * @return an instance of firefoxDriver 
     */
    public WebDriver getFirefoxDriver() {
        if (webDriver == null) {
            FirefoxBinary ffBinary = new FirefoxBinary();

            ProfileFactoryImpl pf = ProfileFactoryImpl.getInstance();
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.setBinary(ffBinary);
            ffOptions.setProfile(pf.getOnlineProfile());
            ffOptions.setHeadless(true);

            webDriver = new TanaguruDriver(ffOptions);
            webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            webDriver.manage().timeouts().pageLoadTimeout(310, TimeUnit.SECONDS);
        }
        return webDriver;
    }
    
}
