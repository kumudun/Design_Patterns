package strategy;

import java.util.Random;

//This application demonstrates the Strategy pattern using three sorting strategies:
// 1. Bubble Sort
// 2. Insertion Sort
// 3. Merge Sort

// It generates two datasets:
//  Small array
//  Large array

// Source reference
// Adapted from: https://www.geeksforgeeks.org/bubble-sort/
// Adapted from: https://www.geeksforgeeks.org/insertion-sort/
// Adapted from: https://www.geeksforgeeks.org/merge-sort/



public class SortingStrategy {

    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;

        int[] smallData = generateRandomArray(smallSize, 0, 1000);
        int[] largeData = generateRandomArray(largeSize, 0, 1000000);

        SortStrategy[] strategies = {
                new BubbleSortStrategy(),
                new InsertionSortStrategy(),
                new MergeSortStrategy()
        };

        System.out.println("=== SMALL DATASET (" + smallSize + " elements) ===");
        testAllStrategies(smallData, strategies);

        System.out.println();
        System.out.println("=== LARGE DATASET (" + largeSize + " elements) ===");
        testAllStrategies(largeData, strategies);
    }

    private static void testAllStrategies(int[] originalData, SortStrategy[] strategies) {
        for (SortStrategy strategy : strategies) {
            int[] copy = copyArray(originalData);
            SortContext context = new SortContext(strategy);

            long startTime = System.nanoTime();
            context.sort(copy);
            long endTime = System.nanoTime();

            long elapsedNanoseconds = endTime - startTime;
            double elapsedMilliseconds = elapsedNanoseconds / 1_000_000.0;

            System.out.printf("%-15s : %12d ns (%10.3f ms)%n",
                    strategy.getName(), elapsedNanoseconds, elapsedMilliseconds);

            if (!isSorted(copy)) {
                System.out.println("ERROR: Array is not sorted correctly by " + strategy.getName());
            }
        }
    }

    private static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return array;
    }

    private static int[] copyArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}


interface SortStrategy {
    void sort(int[] array);
    String getName();
}


class SortContext {
    private SortStrategy strategy;

    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {
        strategy.sort(array);
    }
}

// Bubble Sort
class BubbleSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}

// Insertion Sort
class InsertionSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}

// Merge Sort
class MergeSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}