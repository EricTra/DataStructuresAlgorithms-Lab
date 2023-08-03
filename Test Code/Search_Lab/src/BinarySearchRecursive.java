public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] sortedArray = { 2, 5, 7, 8, 8, 5, 14, 23, 38, 43, 56, 72, 99 };
        int key =8;

        int findFirstSearch  = findFirstSearch(sortedArray, key, 0, sortedArray.length - 1);
        int findLastSearch = findLastSearch(sortedArray, key, 0, sortedArray.length - 1);

        if (findFirstSearch != -1 && findLastSearch != -1) {
            System.out.println("First Search of " + key + " at index: " + findFirstSearch);
            System.out.println("Last Search of " + key + " at index: " + findLastSearch);
        } else {
            System.out.println(key + " not found in the array.");
        }
    }

    public static int findFirstSearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == key) {
            if (mid == left || arr[mid - 1] != key) {
                return mid;
            } else {
                return findFirstSearch(arr, key, left, mid - 1);
            }
        } else if (arr[mid] < key) {
            return findFirstSearch(arr, key, mid + 1, right);
        } else {
            return findFirstSearch(arr, key, left, mid - 1);
        }
    }

    public static int findLastSearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == key) {
            if (mid == right || arr[mid + 1] != key) {
                return mid;
            } else {
                return findLastSearch(arr, key, mid + 1, right);
            }
        } else if (arr[mid] < key) {
            return findLastSearch(arr, key, mid + 1, right);
        } else {
            return findLastSearch(arr, key, left, mid - 1);
        }
    }
}
