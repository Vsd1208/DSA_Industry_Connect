import java.util.*;

class AVL_Tree {

    private class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    private Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.value)
            node.left = insert(node.left, key);
        else if (key > node.value)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.value) {
            System.out.println("LL Rotation at node " + node.value);
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.value) {
            System.out.println("RR Rotation at node " + node.value);
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.value) {
            System.out.println("LR Rotation at node " + node.value);
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.value) {
            System.out.println("RL Rotation at node " + node.value);
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void display() {
        preorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVL_Tree tree = new AVL_Tree();
        int[] keys = { 10, 20, 30, 40, 50, 25 };
        System.out.println("Insertion sequence:");
        for (int key : keys) {
            System.out.println("\nInserting: " + key);
            tree.insert(key);
            tree.display();
        }
    }
}