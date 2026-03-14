package memento;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class HistoryWindow {
    private final Stage stage;
    private final ListView<ModelMemento> listView;
    private final Caretaker caretaker;
    private final Consumer<ModelMemento> restoreAction;

    public HistoryWindow(Caretaker caretaker, Consumer<ModelMemento> restoreAction) {
        this.caretaker = caretaker;
        this.restoreAction = restoreAction;

        stage = new Stage();
        stage.setTitle("History");

        listView = new ListView<>();
        listView.setPrefSize(600, 400);

        listView.setCellFactory(param -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(ModelMemento item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getDisplayText());
                }
            }
        });

        listView.setOnMouseClicked(e -> {
            ModelMemento selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                restoreAction.accept(selected);
            }
        });

        VBox root = new VBox(10, new Label("Saved states:"), listView);
        root.setPadding(new Insets(10));

        stage.setScene(new Scene(root));
        refresh();
    }

    public void show() {
        refresh();
        stage.show();
        stage.toFront();
    }

    public void refresh() {
        listView.setItems(FXCollections.observableArrayList(caretaker.getHistory()));
    }
}
