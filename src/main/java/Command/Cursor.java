package Command;

public class Cursor {

    private int row = 0;
    private int col = 0;
    private int gridSize;

    public Cursor(int gridSize) {
        this.gridSize = gridSize;
    }

    public void moveUp() {
        if (row > 0) row--;
    }

    public void moveDown() {
        if (row < gridSize - 1) row++;
    }

    public void moveLeft() {
        if (col > 0) col--;
    }

    public void moveRight() {
        if (col < gridSize - 1) col++;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
