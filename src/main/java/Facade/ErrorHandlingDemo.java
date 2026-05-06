package Facade;

public class ErrorHandlingDemo {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        // Invalid URL case
        try {
            facade.getAttributeValueFromJson("https://invalid-url", "value");
        } catch (Exception e) {
            System.out.println("Invalid URL Test:");
            System.out.println(e.getMessage());
        }

        // Missing attribute case
        try {
            String url = "https://api.chucknorris.io/jokes/random";
            facade.getAttributeValueFromJson(url, "wrongKey");
        } catch (Exception e) {
            System.out.println("\nMissing Attribute Test:");
            System.out.println(e.getMessage());
        }
    }
}