package Command;

public class MoveCursorRightCommand implements Command {

    private Cursor cursor;

    public MoveCursorRightCommand(Cursor cursor) {
        this.cursor = cursor;
    }

    @Override
    public void execute() {
        cursor.moveRight();
    }
}