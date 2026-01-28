package ui.ascii.abstract_factory;

public class Main {
    public static void main(String[] args) {

        // Choose style: default A, or pass "B" in args
        UIFactory factory;
        if (args.length > 0 && args[0].equalsIgnoreCase("B")) {
            factory = new BFactory();
        } else {
            factory = new AFactory();
        }

        // Create UI elements using factory
        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("I agree");

        // Display UI elements
        System.out.println("=== First display ===");
        button.display();
        textField.display();
        checkbox.display();

        // Change text dynamically (setText)
        button.setText("Apply");
        textField.setText("Email");
        checkbox.setText("Accept terms");

        // Display UI elements again
        System.out.println("\n=== After setText() ===");
        button.display();
        textField.display();
        checkbox.display();
    }
}

