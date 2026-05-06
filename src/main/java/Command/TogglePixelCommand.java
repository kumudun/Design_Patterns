package Command;

public class TogglePixelCommand implements Command {

    private PixelGrid grid;
    private Cursor cursor;

    public TogglePixelCommand(PixelGrid grid, Cursor cursor) {
        this.grid = grid;
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        grid.togglePixel(cursor.getRow(), cursor.getCol());
    }
}

