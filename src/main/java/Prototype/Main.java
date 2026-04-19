package Prototype;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final RecommendationManager manager = new RecommendationManager();

    public static void main(String[] args) {
        loadSampleData();
        runMenu();
    }

    private static void loadSampleData() {
        Recommendation teens = new Recommendation("Teen Readers");
        teens.addBook(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "Fantasy", 1997));
        teens.addBook(new Book("Suzanne Collins", "The Hunger Games", "Dystopian", 2008));

        Recommendation professionals = new Recommendation("Working Professionals");
        professionals.addBook(new Book("James Clear", "Atomic Habits", "Self-help", 2018));
        professionals.addBook(new Book("Cal Newport", "Deep Work", "Productivity", 2016));

        manager.addRecommendation(teens);
        manager.addRecommendation(professionals);
    }

    private static void runMenu() {
        while (true) {
            System.out.println("\n==== Book Recommendation System ====");
            System.out.println("1. View all recommendations");
            System.out.println("2. View recommendation details");
            System.out.println("3. Create new recommendation from scratch");
            System.out.println("4. Clone and modify recommendation");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    viewAllRecommendations();
                    break;
                case 2:
                    viewRecommendationDetails();
                    break;
                case 3:
                    createRecommendationFromScratch();
                    break;
                case 4:
                    cloneAndModifyRecommendation();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewAllRecommendations() {
        System.out.println("\n--- All Recommendation Lists ---");
        manager.displayAllRecommendations();
    }

    private static void viewRecommendationDetails() {
        manager.displayAllRecommendations();
        if (manager.getAllRecommendations().isEmpty()) {
            return;
        }

        System.out.print("Enter recommendation number: ");
        int index = readInt() - 1;

        Recommendation recommendation = manager.getRecommendation(index);
        if (recommendation == null) {
            System.out.println("Invalid recommendation number.");
            return;
        }

        System.out.println("\nTarget Audience: " + recommendation.getTargetAudience());
        System.out.println("Books:");
        recommendation.displayBooks();
    }

    private static void createRecommendationFromScratch() {
        System.out.print("Enter target audience: ");
        String audience = scanner.nextLine();

        Recommendation recommendation = new Recommendation(audience);

        while (true) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.print("Enter publication year: ");
            int year = readInt();

            recommendation.addBook(new Book(author, title, genre, year));

            System.out.print("Add another book? (y/n): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }

        manager.addRecommendation(recommendation);
        System.out.println("New recommendation list created successfully.");
    }

    private static void cloneAndModifyRecommendation() {
        manager.displayAllRecommendations();
        if (manager.getAllRecommendations().isEmpty()) {
            return;
        }

        System.out.print("Enter recommendation number to clone: ");
        int index = readInt() - 1;

        Recommendation original = manager.getRecommendation(index);
        if (original == null) {
            System.out.println("Invalid recommendation number.");
            return;
        }

        Recommendation cloned = original.clone();
        System.out.println("Recommendation cloned successfully.");

        System.out.print("Enter new target audience for cloned recommendation: ");
        String newAudience = scanner.nextLine();
        cloned.setTargetAudience(newAudience);

        while (true) {
            System.out.println("\n--- Modify Cloned Recommendation ---");
            System.out.println("1. Add book");
            System.out.println("2. Remove book by title");
            System.out.println("3. View books");
            System.out.println("4. Save cloned recommendation");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addBookToRecommendation(cloned);
                    break;
                case 2:
                    removeBookFromRecommendation(cloned);
                    break;
                case 3:
                    cloned.displayBooks();
                    break;
                case 4:
                    manager.addRecommendation(cloned);
                    System.out.println("Cloned recommendation saved successfully.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addBookToRecommendation(Recommendation recommendation) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter publication year: ");
        int year = readInt();

        recommendation.addBook(new Book(author, title, genre, year));
        System.out.println("Book added successfully.");
    }

    private static void removeBookFromRecommendation(Recommendation recommendation) {
        System.out.print("Enter title of the book to remove: ");
        String title = scanner.nextLine();

        boolean removed = recommendation.removeBookByTitle(title);
        if (removed) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
