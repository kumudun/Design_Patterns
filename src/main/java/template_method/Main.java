package template_method;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int players = 0;
        while (players < 1) {
            System.out.print("Enter number of players (>= 1): ");
            String line = sc.nextLine().trim();
            try {
                players = Integer.parseInt(line);
                if (players < 1) {
                    System.out.println("Number of players must be at least 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }

        Game game = new GuessTheNumberGame();
        game.play(players);
    }
}
