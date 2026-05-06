package Facade;

public class JokeFacadeDemo {

    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        try {
            String url = "https://api.chucknorris.io/jokes/random";
            String joke = facade.getAttributeValueFromJson(url, "value");

            System.out.println("Chuck Norris Joke:");
            System.out.println(joke);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
