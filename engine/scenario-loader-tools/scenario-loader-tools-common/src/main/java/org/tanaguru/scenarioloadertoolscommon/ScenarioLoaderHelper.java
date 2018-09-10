package org.tanaguru.scenarioloadertoolscommon;

import org.tanaguru.scenarioloader.ScenarioFactory;
import org.tanaguru.scenarioloader.ScenarioRunner;

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

    public static ScenarioRunner chooseScenarioRunner(String firefoxVersion) {
        ScenarioRunner result = ScenarioRunner.INVALID;
        String[] cleanFirefoxVersion = firefoxVersion.split(" ");
        //We only use mozilla firefox
        if (cleanFirefoxVersion[0].toLowerCase().equals("mozilla")) {
            //Parsing version
            String parsedFirefoxVersion = cleanFirefoxVersion[cleanFirefoxVersion.length - 1];
            String[] splitedFirefoxVersion = parsedFirefoxVersion.split("\\.");
            int[] integerSplitedFirefoxVersion = new int[splitedFirefoxVersion.length];
            for (int i = 0; i < splitedFirefoxVersion.length; i++) {
                integerSplitedFirefoxVersion[i] = Integer.parseInt(splitedFirefoxVersion[i]);
            }

            //Choose SE builder for
            if (integerSplitedFirefoxVersion[0] >= 45) {
                result = ScenarioRunner.SELENESE;
            }
        }
        return result;
    }
}
