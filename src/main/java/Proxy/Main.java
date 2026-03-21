package Proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create users
        User alice = new User("alice");
        User bob = new User("bob");

        // Add documents
        library.addDocument("doc1", "2026-03-21", "Public Document Content");
        library.addProtectedDocument("doc2", "2026-03-20", "Secret Document Content");

        // Grant access only to Alice for doc2
        AccessControlService acs = AccessControlService.getInstance();
        acs.grantAccess("alice", "doc2");

        // Access documents
        try {
            // Public document
            System.out.println("Alice reads doc1: " +
                    library.getDocument("doc1").getContent(alice));

            System.out.println("Bob reads doc1: " +
                    library.getDocument("doc1").getContent(bob));

            // Protected document
            System.out.println("Alice reads doc2: " +
                    library.getDocument("doc2").getContent(alice));

            // This should throw exception
            System.out.println("Bob reads doc2: " +
                    library.getDocument("doc2").getContent(bob));

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}