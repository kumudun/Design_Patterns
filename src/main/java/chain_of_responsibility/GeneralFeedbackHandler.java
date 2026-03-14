package chain_of_responsibility;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected String processMessage(Message message) {
        return "General Feedback Handler: Feedback from " + message.getSenderEmail()
                + " has been analyzed and a thank-you response has been prepared.";
    }
}