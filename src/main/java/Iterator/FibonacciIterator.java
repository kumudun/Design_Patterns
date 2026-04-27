package Iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int previous;
    private int current;

    public FibonacciIterator() {
        this.previous = 0;
        this.current = 1;
    }

    @Override
    public boolean hasNext() {
        // This iterator can theoretically generate an infinite sequence.
        return true;
    }

    @Override
    public Integer next() {
        int nextValue = current;
        int newCurrent = previous + current;

        previous = current;
        current = newCurrent;

        return nextValue;
    }
}