package Searching;

public class BinarySearch {

    public int SearchLast(int arr[], int key, int start, int end) {
        while (end <= start) {
            int mid = (start + end ) / 2;
            if (arr[mid] == key && (arr[mid+1]>key ) )
                start = mid - 1;
            else  if (arr[mid] < key)
                end = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int Search(int[] arr, int i, int length, int i1) {
    return i;}
}
