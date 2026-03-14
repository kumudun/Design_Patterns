package memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Caretaker {
    private final Stack<ModelMemento> undoStack = new Stack<>();
    private final Stack<ModelMemento> redoStack = new Stack<>();
    private final List<ModelMemento> history = new ArrayList<>();

    public void save(ModelMemento memento) {
        undoStack.push(memento);
        history.add(memento);
        redoStack.clear();
    }

    public ModelMemento undo(ModelMemento currentState) {
        if (undoStack.isEmpty()) {
            return null;
        }

        redoStack.push(currentState);

        if (undoStack.size() == 1) {
            return undoStack.peek();
        }

        undoStack.pop();
        return undoStack.peek();
    }

    public ModelMemento redo(ModelMemento currentState) {
        if (redoStack.isEmpty()) {
            return null;
        }

        undoStack.push(currentState);

        ModelMemento restored = redoStack.pop();
        undoStack.push(restored);
        history.add(restored);

        return restored;
    }

    public List<ModelMemento> getHistory() {
        return history;
    }

    public void clearRedo() {
        redoStack.clear();
    }
}