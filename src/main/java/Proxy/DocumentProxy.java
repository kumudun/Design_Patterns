package Proxy;

public class DocumentProxy implements DocumentInterface {
    private Document realDocument;

    public DocumentProxy(Document document) {
        this.realDocument = document;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate(); // No restriction
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
