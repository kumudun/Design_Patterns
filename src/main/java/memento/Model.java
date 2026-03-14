package memento;

import javafx.scene.paint.Color;

public class Model {
    private Color color1;
    private Color color2;
    private Color color3;
    private boolean checked;

    public Model() {
        this.color1 = Color.RED;
        this.color2 = Color.GREEN;
        this.color3 = Color.BLUE;
        this.checked = false;
    }

    public ModelMemento saveToMemento(String description) {
        return new ModelMemento(color1, color2, color3, checked, description);
    }

    public void restoreFromMemento(ModelMemento memento) {
        this.color1 = memento.getColor1();
        this.color2 = memento.getColor2();
        this.color3 = memento.getColor3();
        this.checked = memento.isChecked();
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public Color getColor3() {
        return color3;
    }

    public void setColor3(Color color3) {
        this.color3 = color3;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}