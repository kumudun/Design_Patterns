package Mediator;

import java.util.HashMap;
import java.util.Map;

public class ChatRoomMediator implements ChatMediator {
    private final Map<String, ChatClientController> clients = new HashMap<>();

    @Override
    public void registerClient(ChatClientController client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String sender, String recipient, String message) {
        ChatClientController receiver = clients.get(recipient);
        ChatClientController senderClient = clients.get(sender);

        if (receiver != null) {
            receiver.receiveMessage(sender, message);
            if (senderClient != null) {
                senderClient.showSentMessage(recipient, message);
            }
        } else {
            if (senderClient != null) {
                senderClient.showSystemMessage("User '" + recipient + "' not found.");
            }
        }
    }
}
