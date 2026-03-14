package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected String processMessage(Message message) {
        return "Development Suggestion Handler: Suggestion from " + message.getSenderEmail()
                + " has been logged for product review and prioritization.";
    }
}
