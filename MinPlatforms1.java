import java.util.*;

class MinPlatforms1 {
    static class Heap {
        int size;
        int capacity;
        int h[];

        Heap(int c) {
            capacity = c;
            h = new int[c];
            size = 0;
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return 2 * i + 1;
        }

        private int right(int i) {
            return 2 * i + 2;
        }

        private void swap(int i, int j) {
            int temp = h[i];
            h[i] = h[j];
            h[j] = temp;
        }

        public boolean insert(int k) {
            if (size == capacity)
                return false;

            h[size++] = k;
            int i = size - 1;

            while (i != 0 && h[parent(i)] > h[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
            return true;
        }

        public int getMin() {
            return size == 0 ? Integer.MAX_VALUE : h[0];
        }

        private void minHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < size && h[l] < h[smallest])
                smallest = l;
            if (r < size && h[r] < h[smallest])
                smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                minHeapify(smallest);
            }
        }

        public int extractMin() {
            if (size <= 0)
                return Integer.MAX_VALUE;
            if (size == 1)
                return h[--size];

            int root = h[0];
            h[0] = h[--size];
            minHeapify(0);
            return root;
        }
    }

    public static int findMinPlatforms(int[][] timings) {
        int n = timings.length;
        Arrays.sort(timings, (a, b) -> a[0] - b[0]);

        Heap minHeap = new Heap(n);
        minHeap.insert(timings[0][1]);
        int platforms = 1;
        for (int i = 1; i < n; i++) {
            int arrival = timings[i][0];
            if (arrival >= minHeap.getMin()) {
                minHeap.extractMin(); // reuse platform
            }
            minHeap.insert(timings[i][1]);
            platforms = Math.max(platforms, minHeap.size);
        }
        return platforms;
    }

    public static void main(String[] args) {
        int[][] timings = {
                { 900, 910 },
                { 940, 1200 }, // 1st platform reused
                { 950, 1120 }, // 2nd platform used
                { 1100, 1130 }, // 3rd platform used
                { 1500, 1900 },
                { 1800, 2000 }
        };
        int result = findMinPlatforms(timings);
        System.out.println("Minimum platforms required: " + result);
    }
}