package chain_of_responsibility;

public class CustomerFeedbackHandler {

    public static void main(String[] args) {
        // Build the chain
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        // Create sample messages
        Message[] messages = {
                new Message(
                        MessageType.COMPENSATION_CLAIM,
                        "I received a damaged product and would like a refund.",
                        "alice@example.com"
                ),
                new Message(
                        MessageType.CONTACT_REQUEST,
                        "Please have your sales department contact me about enterprise pricing.",
                        "bob@example.com"
                ),
                new Message(
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "It would be great to have a dark mode in the mobile app.",
                        "charlie@example.com"
                ),
                new Message(
                        MessageType.GENERAL_FEEDBACK,
                        "Your service was excellent and delivery was fast.",
                        "diana@example.com"
                ),
                new Message(
                        MessageType.COMPENSATION_CLAIM,
                        "My order was late by two weeks. I want compensation.",
                        "edward@example.com"
                )
        };

        // Process messages
        for (Message message : messages) {
            System.out.println("--------------------------------------------------");
            System.out.println("Incoming message:");
            System.out.println(message);

            String result = compensationHandler.handle(message);

            System.out.println("Handling result:");
            System.out.println(result);
        }
    }
}
