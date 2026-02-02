import java.util.*;

class Sum_3Optimized {

    private static void findTriplets(int[] array, int target) {
        int n = array.length;

        for (int i = 0; i < n - 2; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int required = target - array[i] - array[j];

                if (set.contains(required)) {
                    System.out.println(
                            "Triplet: " + array[i] + ", " + array[j] + ", " + required);
                }
                set.add(array[j]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i + 1;
        }

        int target = 20;
        findTriplets(array, target);
    }
}
