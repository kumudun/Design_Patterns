package chain_of_responsibility;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String handle(Message message) {
        if (canHandle(message)) {
            return processMessage(message);
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        } else {
            return "No handler found for message type: " + message.getMessageType();
        }
    }

    protected abstract boolean canHandle(Message message);

    protected abstract String processMessage(Message message);
}
