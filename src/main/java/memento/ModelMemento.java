package memento;

import javafx.scene.paint.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelMemento implements MementoMetadata {
    private final Color color1;
    private final Color color2;
    private final Color color3;
    private final boolean checked;
    private final LocalDateTime timestamp;
    private final String description;

    public ModelMemento(Color color1, Color color2, Color color3, boolean checked, String description) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.checked = checked;
        this.timestamp = LocalDateTime.now();
        this.description = description;
    }

    public Color getColor1() {
        return color1;
    }

    public Color getColor2() {
        return color2;
    }

    public Color getColor3() {
        return color3;
    }

    public boolean isChecked() {
        return checked;
    }

    @Override
    public String getFormattedTimestamp() {
        return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDisplayText() {
        return getFormattedTimestamp() + " - " + description
                + " [R1=" + toHex(color1)
                + ", R2=" + toHex(color2)
                + ", R3=" + toHex(color3)
                + ", Checked=" + checked + "]";
    }

    private String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
