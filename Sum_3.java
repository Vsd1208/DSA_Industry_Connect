import java.util.*;

class Sum_3 {
    private static void findtriplets(int[] array, int target) {
        Arrays.sort(array);
        int n = array.length;
        for (int count = 0; count < n - 2; count++) {
            int left = count + 1;
            int right = n - 1;
            while (left < right) {
                int sum = array[count] + array[left] + array[right];
                if (sum == target) {
                    System.out.println("Triplet: " + array[count] + ", " + array[left] + ", " + array[right]);
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i + 1;
        }
        int target = 20;
        findtriplets(array, target);
    }
}