package chain_of_responsibility;

public class Message {
    private MessageType messageType;
    private String messageContent;
    private String senderEmail;

    public Message(MessageType messageType, String messageContent, String senderEmail) {
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.senderEmail = senderEmail;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    @Override
    public String toString() {
        return "Type: " + messageType +
                "\nSender: " + senderEmail +
                "\nContent: " + messageContent;
    }
}