import java.util.*;

class rotate_K_Positions {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[][] k = new int[3][2];
        k[0] = new int[] { 1, 2 };
        k[1] = new int[] { 3, 10 };
        k[2] = new int[] { 15, 18 };
        rotate_K_Positions rkp = new rotate_K_Positions();
        for (int i = 0; i < k.length; i++) {
            int start = k[i][0] - 1;
            int end = k[i][1] - 1;
            rkp.rotate(arr, start, end);
        }
        System.out.println("Array after rotations: " + Arrays.toString(arr));
    }

    private void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}