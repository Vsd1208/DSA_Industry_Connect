import java.util.*;

class Tree_Array {
    private int index = 0;

    private class BST {
        int data;
        BST left, right;

        BST(int data) {
            this.data = data;
        }

        void insert(int value) {
            if (value < data) {
                if (left == null)
                    left = new BST(value);
                else
                    left.insert(value);
            } else {
                if (right == null)
                    right = new BST(value);
                else
                    right.insert(value);
            }
        }
    }

    private void inorder(BST root, int[] arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        arr[index++] = root.data;
        inorder(root.right, arr);
    }

    public static void main(String[] args) {
        Tree_Array tree = new Tree_Array();

        BST root = tree.new BST(10);
        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(7);

        int[] arr = new int[5];
        tree.index = 0;
        tree.inorder(root, arr);

        System.out.println(Arrays.toString(arr));
    }
}
