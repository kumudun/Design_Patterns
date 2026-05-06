package Facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = getJsonFromApi(urlString);
        return extractValue(json, attributeName);
    }

    private String getJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        if (status != 200) {
            throw new IOException("HTTP request failed with status code: " + status);
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        } finally {
            connection.disconnect();
        }
    }

    private String extractValue(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found.");
            }

            return value.toString();

        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing JSON: " + e.getMessage());
        }
    }
}
