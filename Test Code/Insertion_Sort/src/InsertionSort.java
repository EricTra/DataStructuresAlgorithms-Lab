public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7};

        System.out.println("Unsorted Array:");
        printArray(arr);

        insertionSort(arr);

        System.out.println("\nSorted Array:");
        printArray(arr);
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
