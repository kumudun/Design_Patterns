package Facade;



import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExchangeRateDemo {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String url = "https://api.fxratesapi.com/latest";

            String ratesJson = facade.getAttributeValueFromJson(url, "rates");

            JSONParser parser = new JSONParser();
            JSONObject ratesObject = (JSONObject) parser.parse(ratesJson);

            System.out.println("Exchange Rates:");
            System.out.println("EUR: " + ratesObject.get("EUR"));
            System.out.println("GBP: " + ratesObject.get("GBP"));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

