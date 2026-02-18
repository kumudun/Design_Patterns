package template_method;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame extends Game {

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    private int numberOfPlayers;
    private int secretNumber;

    private int winnerPlayerIndex = -1; // 0-based index, -1 means no winner yet
    private boolean gameOver = false;

    private int maxRounds = 10; // each round = each player gets 1 turn
    private int turnsTaken = 0; // total turns taken (across all players)

    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;

        // pick a secret number between 1 and 100
        this.secretNumber = random.nextInt(100) + 1;

        this.winnerPlayerIndex = -1;
        this.gameOver = false;
        this.turnsTaken = 0;

        System.out.println("=== Guess The Number ===");
        System.out.println("Players: " + numberOfPlayers);
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxRounds + " rounds total (each player plays once per round).");
        System.out.println();
    }

    @Override
    public boolean endOfGame() {
        if (gameOver) return true;

        int maxTurns = maxRounds * numberOfPlayers;
        return turnsTaken >= maxTurns;
    }

    @Override
    public void playSingleTurn(int player) {
        if (gameOver) return;

        int playerNumber = player + 1; // for display (1..N)
        int currentRound = (turnsTaken / numberOfPlayers) + 1;

        System.out.println("[Round " + currentRound + "] Player " + playerNumber + "'s turn.");

        Integer guess = readInt("Enter your guess (1-100): ", 1, 100);
        if (guess == null) {
            // If input stream closed or something odd, just end game safely
            System.out.println("No input available. Ending game.");
            gameOver = true;
            return;
        }

        turnsTaken++;

        if (guess == secretNumber) {
            winnerPlayerIndex = player;
            gameOver = true;
            System.out.println("Correct! Player " + playerNumber + " found the number!");
        } else if (guess < secretNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }

        System.out.println();
    }

    @Override
    public void displayWinner() {
        System.out.println("=== Game Over ===");
        if (winnerPlayerIndex >= 0) {
            System.out.println("Winner: Player " + (winnerPlayerIndex + 1));
            System.out.println("Secret number was: " + secretNumber);
        } else {
            System.out.println("No one guessed the number in time.");
            System.out.println("Secret number was: " + secretNumber);
        }
    }

    // Helper: read an integer in range [min..max], keep asking until valid.
    private Integer readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);

            if (!scanner.hasNextLine()) {
                return null; // no input
            }

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Please enter a number.");
                continue;
            }

            try {
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }
}

