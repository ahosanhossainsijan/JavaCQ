package Utility;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {

    public static String getConfigData(String key) {
        String jsonFilePath = ".//src//Data//config.json";
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONObject testData = new JSONObject(jsonData);
            return testData.optString(key, null);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}