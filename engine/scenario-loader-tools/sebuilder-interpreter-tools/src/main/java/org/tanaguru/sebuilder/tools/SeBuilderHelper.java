package org.tanaguru.sebuilder.tools;

import com.sebuilder.interpreter.IO;
import com.sebuilder.interpreter.factory.ScriptFactory;
import org.json.JSONException;

import java.io.IOException;

public class SeBuilderHelper {
    public static boolean isScenarioValid(String scenario){
        boolean result = true;
        try {
            IO.read(scenario);
        } catch (JSONException | IOException | ScriptFactory.SuiteException je) {
            result = false;
        }
        return result;
    }
}
