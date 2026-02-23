import java.util.*;

class Level_Order4 {

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

    class Node {
        int data;
        int level;
        int index;
    }

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
            if (capacity == size) {
                System.out.println("Heap is full");
                return;
            }
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
            if (size == 0) {
                System.out.println("Heap is empty");
                return null;
            }

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

            if (l < size &&
                    (h[l].level < h[smallest].level ||
                            (h[l].level == h[smallest].level && h[l].index < h[smallest].index))) { // if level is same
                                                                                                    // compare index
                smallest = l;
            }

            if (r < size &&
                    (h[r].level < h[smallest].level ||
                            (h[r].level == h[smallest].level && h[r].index < h[smallest].index))) {
                smallest = r;
            }
            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }
    }

    private void levelOrderWithHeap(Tree root, Heap heap) {
        if (root == null)
            return;

        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        int globalIndex = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            Tree[] levelNodes = new Tree[size];
            for (int i = 0; i < size; i++) {
                Tree temp = q.poll();
                levelNodes[i] = temp;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (level % 2 == 0) {
                // Left to Right
                for (int i = 0; i < size; i++) {
                    Node node = new Node();
                    node.data = levelNodes[i].data;
                    node.level = level;
                    node.index = globalIndex++;
                    heap.insert(node);
                }
            } else {
                // Right to Left
                for (int i = size - 1; i >= 0; i--) {
                    Node node = new Node();
                    node.data = levelNodes[i].data;
                    node.level = level;
                    node.index = globalIndex++;
                    heap.insert(node);
                }
            }
            level++;
        }

        while (heap.size > 0) {
            Node node = heap.extractMin();
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Level_Order4 obj = new Level_Order4();
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