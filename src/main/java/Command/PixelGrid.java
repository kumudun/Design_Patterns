package Command;

public class PixelGrid {

    private int[][] grid;

    public PixelGrid(int size) {
        grid = new int[size][size];
    }

    public void togglePixel(int row, int col) {
        grid[row][col] = (grid[row][col] == 0) ? 1 : 0;
    }

    public int getPixel(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return grid.length;
    }

    public int[][] getGrid() {
        return grid;
    }
}

