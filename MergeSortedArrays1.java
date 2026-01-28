import java.util.*;

class MergeSortedArrays1 {
    static class Node {
        int value;
        int arrayId;
        int index;

        Node(int value, int arrayId, int index) {
            this.value = value;
            this.arrayId = arrayId;
            this.index = index;
        }
    }

    private Node[] heap;
    private int size;
    private int capacity;

    MergeSortedArrays1(int capacity) {
        this.capacity = capacity;
        heap = new Node[capacity];
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
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(Node node) {
        if (size == capacity)
            return;
        heap[size] = node;
        int curr = size;
        size++;

        while (curr != 0 && heap[parent(curr)].value > heap[curr].value) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public Node extractMin() {
        if (size <= 0)
            return null;
        if (size == 1)
            return heap[--size];

        Node root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l].value < heap[smallest].value)
            smallest = l;
        if (r < size && heap[r].value < heap[smallest].value)
            smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        int[] a = { 1, 3, 7, 9 }; // must be sorted
        int[] b = { 2, 4, 6, 8 }; // must be sorted

        int[] merged = new int[a.length + b.length];
        int k = 0;

        // heap size = 2 (your idea)
        MergeSortedArrays1 heap = new MergeSortedArrays1(2);

        // insert first elements
        heap.insert(new Node(a[0], 0, 0));
        heap.insert(new Node(b[0], 1, 0));

        while (!heap.isEmpty()) {
            Node min = heap.extractMin();
            merged[k++] = min.value;

            // insert next element from same array
            if (min.arrayId == 0) {
                int nextIndex = min.index + 1;
                if (nextIndex < a.length) {
                    heap.insert(new Node(a[nextIndex], 0, nextIndex));
                }
            } else {
                int nextIndex = min.index + 1;
                if (nextIndex < b.length) {
                    heap.insert(new Node(b[nextIndex], 1, nextIndex));
                }
            }
        }

        System.out.println(Arrays.toString(merged));
    }
}