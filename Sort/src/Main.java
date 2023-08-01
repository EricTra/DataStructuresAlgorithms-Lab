import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arraySize = 500000;
        int[] arr = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; i++) {
            arr[i] = random.nextInt(1000); // Generating random integers between 0 and 999
        }

        // Testing Selection Sort
        int[] arr1 = arr.clone();
        long startTime = System.currentTimeMillis();
        SortingAlgorithms.selectionSort(arr1);
        long endTime = System.currentTimeMillis();

        System.out.println("Selection Sort Time: " + (endTime - startTime) + " Milisecond");


        int[] arr2 = arr.clone();
        startTime = System.currentTimeMillis();
        SortingAlgorithms.bubbleSort(arr2);
        endTime = System.currentTimeMillis();

        System.out.println("Bubble Sort Time: " + (endTime - startTime) + " Second");


        int[] arr3 = arr.clone();
        startTime = System.currentTimeMillis();
        SortingAlgorithms.insertionSort(arr3);
        endTime = System.currentTimeMillis();

        System.out.println("Insertion Sort Time: " + (endTime - startTime) + " Second");
    }
}
