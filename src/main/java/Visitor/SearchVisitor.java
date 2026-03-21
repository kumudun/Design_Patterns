package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    private List<File> foundFiles;

    public SearchVisitor(String keyword) {
        this.keyword = keyword;
        this.foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(keyword)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Nothing to do here
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}