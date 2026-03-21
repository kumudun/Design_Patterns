package Visitor;

public class Main {
    public static void main(String[] args) {

        // Create files
        File file1 = new File("document.txt", 2.5);
        File file2 = new File("photo.jpg", 5.0);
        File file3 = new File("notes.txt", 1.2);
        File file4 = new File("music.mp3", 7.5);

        // Create directories
        Directory root = new Directory("root");
        Directory subDir1 = new Directory("documents");
        Directory subDir2 = new Directory("media");

        // Build file system
        subDir1.addElement(file1);
        subDir1.addElement(file3);

        subDir2.addElement(file2);
        subDir2.addElement(file4);

        root.addElement(subDir1);
        root.addElement(subDir2);


        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);

        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " MB");


        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Search Results:");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}