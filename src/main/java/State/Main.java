package State;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter character name: ");
        String name = sc.nextLine();

        GameCharacter c = new GameCharacter(name);

        while (!c.isMaster()) {
            // status before each turn
            System.out.println("\n=== Character Status ===");
            System.out.println("Name: " + c.getName());
            System.out.println("Level: " + c.getLevel());
            System.out.println("XP: " + c.getExperience());
            System.out.println("HP: " + c.getHealth());

            // available actions
            System.out.println("\nChoose an action:");
            System.out.println("1) Train");

            if (c.getLevel().equals("Intermediate") || c.getLevel().equals("Expert")) {
                System.out.println("2) Meditate");
            }
            if (c.getLevel().equals("Expert")) {
                System.out.println("3) Fight");
            }

            System.out.print("Your choice: ");
            String choice = sc.nextLine().trim();

            // perform action
            if (choice.equals("1")) {
                c.train();
            } else if (choice.equals("2") && (c.getLevel().equals("Intermediate") || c.getLevel().equals("Expert"))) {
                c.meditate();
            } else if (choice.equals("3") && c.getLevel().equals("Expert")) {
                c.fight();
            } else {
                System.out.println("Invalid choice for your current level.");
            }
        }

        System.out.println("\n🎉 Congratulations " + c.getName() + "! You finished the game as MASTER!");
        sc.close();
    }
}

