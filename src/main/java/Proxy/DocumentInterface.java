package Proxy;

public interface DocumentInterface {
    String getId();
    String getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
