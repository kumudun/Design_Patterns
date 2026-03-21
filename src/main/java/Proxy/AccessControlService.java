package Proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance = new AccessControlService();

    // Store allowed (username:docId) pairs
    private Set<String> permissions = new HashSet<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        return instance;
    }

    public void grantAccess(String username, String documentId) {
        permissions.add(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return permissions.contains(username + ":" + documentId);
    }
}
