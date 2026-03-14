package memento;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MementoApp extends Application {

    private final Model model = new Model();
    private final Caretaker caretaker = new Caretaker();

    private Rectangle rect1;
    private Rectangle rect2;
    private Rectangle rect3;
    private CheckBox checkBox;

    private ColorPicker colorPicker1;
    private ColorPicker colorPicker2;
    private ColorPicker colorPicker3;

    private HistoryWindow historyWindow;

    @Override
    public void start(Stage primaryStage) {
        rect1 = new Rectangle(100, 100, model.getColor1());
        rect2 = new Rectangle(100, 100, model.getColor2());
        rect3 = new Rectangle(100, 100, model.getColor3());

        checkBox = new CheckBox("Enabled");
        checkBox.setSelected(model.isChecked());

        colorPicker1 = new ColorPicker(model.getColor1());
        colorPicker2 = new ColorPicker(model.getColor2());
        colorPicker3 = new ColorPicker(model.getColor3());

        Button historyButton = new Button("Open History");

        saveState("Initial state");

        historyWindow = new HistoryWindow(caretaker, this::restoreFromHistory);

        colorPicker1.setOnAction(e -> {
            saveState("Changed rectangle 1 color");
            model.setColor1(colorPicker1.getValue());
            refreshView();
        });

        colorPicker2.setOnAction(e -> {
            saveState("Changed rectangle 2 color");
            model.setColor2(colorPicker2.getValue());
            refreshView();
        });

        colorPicker3.setOnAction(e -> {
            saveState("Changed rectangle 3 color");
            model.setColor3(colorPicker3.getValue());
            refreshView();
        });

        checkBox.setOnAction(e -> {
            saveState("Changed checkbox");
            model.setChecked(checkBox.isSelected());
            refreshView();
        });

        historyButton.setOnAction(e -> historyWindow.show());

        HBox rectangles = new HBox(20, rect1, rect2, rect3);
        rectangles.setAlignment(Pos.CENTER);

        VBox controls = new VBox(
                10,
                new HBox(10, new Label("Rectangle 1:"), colorPicker1),
                new HBox(10, new Label("Rectangle 2:"), colorPicker2),
                new HBox(10, new Label("Rectangle 3:"), colorPicker3),
                checkBox,
                historyButton
        );
        controls.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(20, rectangles, controls);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 450, 350);

        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN),
                this::undo
        );

        scene.getAccelerators().put(
                new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN),
                this::redo
        );

        primaryStage.setTitle("Memento Pattern - Undo, Redo, History");
        primaryStage.setScene(scene);
        primaryStage.show();

        refreshView();
    }

    private void saveState(String description) {
        caretaker.save(model.saveToMemento(description));
        if (historyWindow != null) {
            historyWindow.refresh();
        }
    }

    private void undo() {
        ModelMemento previous = caretaker.undo(model.saveToMemento("State before undo"));
        if (previous != null) {
            model.restoreFromMemento(previous);
            refreshView();
            historyWindow.refresh();
        }
    }

    private void redo() {
        ModelMemento next = caretaker.redo(model.saveToMemento("State before redo"));
        if (next != null) {
            model.restoreFromMemento(next);
            refreshView();
            historyWindow.refresh();
        }
    }

    private void restoreFromHistory(ModelMemento memento) {
        if (memento != null) {
            saveState("Before history restore");
            caretaker.clearRedo();
            model.restoreFromMemento(memento);
            refreshView();
            historyWindow.refresh();
        }
    }

    private void refreshView() {
        rect1.setFill(model.getColor1());
        rect2.setFill(model.getColor2());
        rect3.setFill(model.getColor3());

        colorPicker1.setValue(model.getColor1());
        colorPicker2.setValue(model.getColor2());
        colorPicker3.setValue(model.getColor3());

        checkBox.setSelected(model.isChecked());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
