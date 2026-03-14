package chain_of_responsibility;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected String processMessage(Message message) {
        return "Contact Request Handler: Request from " + message.getSenderEmail()
                + " has been forwarded to the appropriate department for follow-up.";
    }
}
