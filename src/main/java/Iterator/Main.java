package Iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        Iterator<Integer> iterator = fibonacciSequence.iterator();

        System.out.println("First 10 Fibonacci numbers:");

        for (int i = 0; i < 10; i++) {
            System.out.println(iterator.next());
        }
    }
}