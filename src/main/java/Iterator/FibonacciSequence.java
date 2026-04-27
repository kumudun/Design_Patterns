package Iterator;

import java.util.Iterator;

public class FibonacciSequence implements Sequence {

    /*
     * This class represents the Fibonacci sequence as a computed sequence.
     *
     * Decision:
     * The calculation state is NOT stored in this class.
     * Instead, the state is stored inside FibonacciIterator.
     *
     * Rationale:
     * If the state were stored here, multiple iterators created from the same
     * FibonacciSequence object would share state and interfere with each other.
     * By keeping the state inside FibonacciIterator, each iterator is independent.
     */

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }
}
