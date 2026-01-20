package rpg_map_generator;



import java.util.Scanner;

public class Game {

    // Factory method to create a map
    public static Map createMap(String type, int rows, int cols) {
        if (type == null) {
            type = "";
        }

        type = type.trim().toLowerCase();

        if (type.equals("city")) {
            return new CityMap(rows, cols);
        } else if (type.equals("wilderness") || type.equals("wild")) {
            return new WildernessMap(rows, cols);
        } else {
            // default
            return new WildernessMap(rows, cols);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Choose map type (city/wilderness): ");
        String type = sc.nextLine();

        Map map = createMap(type, 8, 12);
        System.out.println("\nGenerated Map:\n");
        map.display();

        sc.close();
    }
}

