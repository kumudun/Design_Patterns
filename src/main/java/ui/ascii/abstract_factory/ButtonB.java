package ui.ascii.abstract_factory;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String t = " " + getText() + " ";
        System.out.println("+" + "-".repeat(t.length()) + "+");
        System.out.println("|" + t + "|");
        System.out.println("+" + "-".repeat(t.length()) + "+");
    }
}

