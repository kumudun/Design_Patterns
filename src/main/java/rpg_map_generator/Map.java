package rpg_map_generator;


import java.util.Random;

public abstract class Map {

    protected final int rows;
    protected final int cols;
    protected final Tile[][] tiles;
    protected final Random random;

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];
        this.random = new Random();
        generate();
    }

    protected abstract Tile createTile();

    private void generate() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                tiles[r][c] = createTile();
            }
        }
    }

    public void display() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(tiles[r][c].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}



