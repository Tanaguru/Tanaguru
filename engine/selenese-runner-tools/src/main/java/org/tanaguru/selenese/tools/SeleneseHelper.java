package org.tanaguru.selenese.tools;

import jp.vmi.selenium.selenese.*;
import jp.vmi.selenium.selenese.command.CommandFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jp.vmi.selenium.selenese.result.Result;
import jp.vmi.selenium.selenese.utils.StopWatch;
import org.apache.log4j.Logger;

public class SeleneseHelper {

    private static final Logger LOGGER = Logger.getLogger(SeleneseHelper.class);

    public static boolean isScenarioSelenese(String scenario){
        boolean result = true;
        Runner runner = new Runner();
        CommandFactory commandFactory = new CommandFactory(runner);
        InputStream input = new ByteArrayInputStream(scenario.getBytes());

        try{
            Selenese s = Parser.parse("SeleneseValidator.side", input, commandFactory);
        }catch(Exception e){
            LOGGER.error(e.getStackTrace());
            result = false;
        }

        try{
            input.close();
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }

        return result;
    }
}
