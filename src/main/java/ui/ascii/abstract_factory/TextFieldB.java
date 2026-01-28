package ui.ascii.abstract_factory;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        String t = " " + getText() + ": ____ ";
        System.out.println("+" + "-".repeat(t.length()) + "+");
        System.out.println("|" + t + "|");
        System.out.println("+" + "-".repeat(t.length()) + "+");
    }
}
