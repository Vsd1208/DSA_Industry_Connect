import java.util.*;

class BinarySearch {
    private int binary_search(int[] arr, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return binary_search(arr, mid + 1, right, target);
        else
            return binary_search(arr, left, mid - 1, target);
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 7;
        int result = bs.binary_search(arr, 0, arr.length - 1, target);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: " + result);
    }
}