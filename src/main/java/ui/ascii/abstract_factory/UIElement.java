package ui.ascii.abstract_factory;

public abstract class UIElement {
    private String text;

    public UIElement(String text) {
        this.text = text;
    }

    public void setText(String newText) {
        this.text = newText;
    }

    public String getText() {
        return text;
    }

    public abstract void display();
}
