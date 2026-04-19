package Mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientController {
    private final String username;
    private final ChatMediator mediator;

    private final TextArea chatArea;
    private final TextField messageField;
    private final ComboBox<String> recipientBox;
    private final Button sendButton;

    public ChatClientController(String username, ChatMediator mediator, List<String> allUsers) {
        this.username = username;
        this.mediator = mediator;

        chatArea = new TextArea();
        chatArea.setEditable(false);
        chatArea.setWrapText(true);

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        recipientBox = new ComboBox<>();
        recipientBox.getItems().addAll(allUsers);
        recipientBox.getItems().remove(username); // can't send to self
        recipientBox.setPromptText("Select recipient");

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        VBox root = new VBox(10, new Label("Chat with:"), recipientBox, chatArea, messageField, sendButton);
        root.setPadding(new Insets(10));

        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(root, 400, 350));
        stage.show();
    }

    public String getUsername() {
        return username;
    }

    private void sendMessage() {
        String recipient = recipientBox.getValue();
        String message = messageField.getText().trim();

        if (recipient == null || recipient.isEmpty()) {
            showSystemMessage("Please select a recipient.");
            return;
        }

        if (message.isEmpty()) {
            showSystemMessage("Message cannot be empty.");
            return;
        }

        mediator.sendMessage(username, recipient, message);
        messageField.clear();
    }

    public void receiveMessage(String sender, String message) {
        chatArea.appendText(sender + " -> " + username + ": " + message + "\n");
    }

    public void showSentMessage(String recipient, String message) {
        chatArea.appendText(username + " -> " + recipient + ": " + message + "\n");
    }

    public void showSystemMessage(String message) {
        chatArea.appendText("[System] " + message + "\n");
    }
}
