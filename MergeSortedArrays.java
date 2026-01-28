import java.util.*;

class MergeSortedArrays {
    
    public static void main(String[] args) {
  
        int[] a = { 5, 1, 9, 3 };
        int[] b = {8, 2, 6, 4};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : a) {
            minHeap.add(x);
        }
        for (int x : b) {
            minHeap.add(x);
        }
        int[] merged = new int[a.length + b.length];
        int index = 0;
        while (!minHeap.isEmpty()) {
            merged[index++] = minHeap.poll();
        }
        System.out.println(Arrays.toString(merged));
    }
}