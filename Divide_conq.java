import java.util.*;

class Divide_conq {

    private int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return search(arr, target, mid + 1, end);
        } else {
            return search(arr, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { -1, 8, 0, -7, 89, 45, 23, 67, -34, 56 };
        int target = 45;

        Arrays.sort(arr);

        Divide_conq dc = new Divide_conq();
        int ans = dc.search(arr, target, 0, arr.length - 1);
        System.out.println(ans);
    }
}
