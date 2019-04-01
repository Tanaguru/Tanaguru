package org.tanaguru.scenarioloader.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScenarioLoaderHelper {

    public static String getSpecifiedFirefoxVersion() throws IOException, InterruptedException {
        String path = System.getProperty("webdriver.firefox.bin");;
        return getFirefoxVersion(path);
    }

    public static String getFirefoxVersion(String pathToBinary) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        String command = pathToBinary + " -v";
        Process proc = rt.exec(command);
        proc.waitFor();

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(proc.getInputStream()));

        BufferedReader stdError = new BufferedReader(new
                InputStreamReader(proc.getErrorStream()));

        // read the output from the command
        String commandResult = "";
        String s = null;
        while ((s = stdInput.readLine()) != null) {
            commandResult += s;
        }
        stdInput.close();

        // read any errors from the attempted command
        String commandError = "";
        while ((s = stdError.readLine()) != null) {
            commandError += s;
        }
        stdError.close();

        if(proc.exitValue() != 0) {
            throw new RuntimeException(commandError);
        }

        return commandResult;
    }
}
