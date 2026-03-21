package Visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        // No size for directory itself
    }

    public double getTotalSize() {
        return totalSize;
    }
}