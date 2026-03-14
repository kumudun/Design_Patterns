package chain_of_responsibility;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getMessageType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected String processMessage(Message message) {
        String content = message.getMessageContent().toLowerCase();

        if (content.contains("damaged") || content.contains("broken") || content.contains("refund")) {
            return "Compensation Claim Handler: Claim from " + message.getSenderEmail()
                    + " reviewed and APPROVED. Customer will be contacted regarding refund/compensation.";
        } else {
            return "Compensation Claim Handler: Claim from " + message.getSenderEmail()
                    + " requires manual review before approval or rejection.";
        }
    }
}
