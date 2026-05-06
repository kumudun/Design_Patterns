package Command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelEditorApp extends Application {

    private static final int SIZE = 8;
    private static final int CELL_SIZE = 40;

    private PixelGrid grid = new PixelGrid(SIZE);
    private Cursor cursor = new Cursor(SIZE);

    private Rectangle[][] cells = new Rectangle[SIZE][SIZE];

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();

        // Create grid UI
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setStroke(Color.BLACK);

                cells[i][j] = rect;
                gridPane.add(rect, j, i);
            }
        }

        Button generateBtn = new Button("Generate Code");

        generateBtn.setOnAction(e -> {
            new GenerateCodeCommand(grid).execute();
        });

        VBox root = new VBox(10, gridPane, generateBtn);

        Scene scene = new Scene(root);

        // Keyboard controls
        scene.setOnKeyPressed(e -> {

            Command command = null;

            if (e.getCode() == KeyCode.UP) {
                command = new MoveCursorUpCommand(cursor);
            } else if (e.getCode() == KeyCode.DOWN) {
                command = new MoveCursorDownCommand(cursor);
            } else if (e.getCode() == KeyCode.LEFT) {
                command = new MoveCursorLeftCommand(cursor);
            } else if (e.getCode() == KeyCode.RIGHT) {
                command = new MoveCursorRightCommand(cursor);
            } else if (e.getCode() == KeyCode.SPACE) {
                command = new TogglePixelCommand(grid, cursor);
            }

            if (command != null) {
                command.execute();
                updateUI();
            }
        });

        updateUI();

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.show();
    }

    private void updateUI() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (grid.getPixel(i, j) == 1) {
                    cells[i][j].setFill(Color.BLACK);
                } else {
                    cells[i][j].setFill(Color.WHITE);
                }

                // Highlight cursor
                if (i == cursor.getRow() && j == cursor.getCol()) {
                    cells[i][j].setStroke(Color.RED);
                } else {
                    cells[i][j].setStroke(Color.BLACK);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}