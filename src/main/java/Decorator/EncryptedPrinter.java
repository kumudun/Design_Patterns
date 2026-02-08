package Decorator;

public class EncryptedPrinter implements Printer {
    private final Printer printer;

    public EncryptedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(encrypt(message));
    }

    private String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char) (c + 3)); // shift forward
        }
        return sb.toString();
    }

    // optional (not required, but proves decryptable)
    public String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char) (c - 3)); // shift back
        }
        return sb.toString();
    }
}

