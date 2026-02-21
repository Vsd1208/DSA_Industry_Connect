import java.util.*;

class Level_Order5 {

    // Tree Node
    private class Tree {
        int data;
        Tree left;
        Tree right;

        Tree(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Heap Node
    class Node {
        int data;
        int level;
        int index;
    }

    // Min Heap based on level, then index
    private class Heap {
        int size;
        int capacity;
        Node h[];

        Heap(int capacity) {
            this.capacity = capacity;
            this.h = new Node[capacity];
            size = 0;
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        int left(int i) {
            return 2 * i + 1;
        }

        int right(int i) {
            return 2 * i + 2;
        }

        void swap(int i, int j) {
            Node temp = h[i];
            h[i] = h[j];
            h[j] = temp;
        }

        void insert(Node x) {
            if (size == capacity)
                return;

            h[size] = x;
            int i = size;
            size++;

            while (i != 0 && (h[parent(i)].level > h[i].level
                    || (h[parent(i)].level == h[i].level && h[parent(i)].index > h[i].index))) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        Node extractMin() {
            if (size == 0)
                return null;

            Node min = h[0];
            h[0] = h[size - 1];
            size--;
            heapify(0);
            return min;
        }

        void heapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;

            if (l < size && (h[l].level < h[smallest].level
                    || (h[l].level == h[smallest].level && h[l].index < h[smallest].index))) {
                smallest = l;
            }

            if (r < size && (h[r].level < h[smallest].level
                    || (h[r].level == h[smallest].level && h[r].index < h[smallest].index))) {
                smallest = r;
            }

            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }
    }

    // Height of tree
    private int height(Tree root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private void collectLevel(Tree root, int targetLevel, int currentLevel, Heap heap, int[] index) {
        if (root == null)
            return;

        if (currentLevel == targetLevel) {
            Node node = new Node();
            node.data = root.data;
            node.level = targetLevel;
            node.index = index[0]++;
            heap.insert(node);
            return;
        }

        collectLevel(root.left, targetLevel, currentLevel + 1, heap, index);
        collectLevel(root.right, targetLevel, currentLevel + 1, heap, index);
    }

    // Level order using recursion
    private void levelOrderWithHeap(Tree root, Heap heap) {
        if (root == null)
            return;
        int h = height(root);
        int[] index = new int[1]; // to maintain global order
        for (int level = 0; level < h; level++) {
            collectLevel(root, level, 0, heap, index);
        }
        while (heap.size > 0) {
            Node node = heap.extractMin();
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Level_Order5 obj = new Level_Order5();

        Tree root = obj.new Tree(1);
        root.left = obj.new Tree(2);
        root.right = obj.new Tree(3);
        root.left.left = obj.new Tree(4);
        root.left.right = obj.new Tree(5);
        root.right.left = obj.new Tree(6);
        root.right.right = obj.new Tree(7);
        root.left.left.left = obj.new Tree(10);
        root.left.left.right = obj.new Tree(11);
        root.right.right.left = obj.new Tree(8);
        root.right.right.right = obj.new Tree(9);
        Heap heap = obj.new Heap(100);
        obj.levelOrderWithHeap(root, heap);
    }
}