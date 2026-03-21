package Proxy;

import java.util.HashMap;

public class Library {
    private HashMap<String, DocumentInterface> documents = new HashMap<>();

    // Add unprotected document
    public void addDocument(String id, String date, String content) {
        Document doc = new Document(id, date, content);
        documents.put(id, doc);
    }

    // Add protected document (via proxy)
    public void addProtectedDocument(String id, String date, String content) {
        Document realDoc = new Document(id, date, content);
        DocumentProxy proxy = new DocumentProxy(realDoc);
        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
