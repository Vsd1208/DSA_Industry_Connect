import java.util.*;

class Level_Order3 {
    private class Tree {
        int data;
        Tree left, right;

        Tree(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private class Stack {
        Tree[] arr;
        int top;

        Stack(int size) {
            arr = new Tree[size];
            top = -1;
        }

        void push(Tree left) {
            arr[++top] = left;
        }

        Tree pop() {
            return arr[top--];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

    private void LevelOrder(Tree root) {
        if (root == null)
            return;
        Stack s1 = new Stack(100);
        Stack s2 = new Stack(100);
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Tree curr = s1.pop();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    s2.push(curr.left);
                if (curr.right != null)
                    s2.push(curr.right);
            }
            while (!s2.isEmpty()) {
                Tree curr = s2.pop();
                System.out.print(curr.data + " ");
                if (curr.right != null)
                    s1.push(curr.right);
                if (curr.left != null)
                    s1.push(curr.left);
            }
        }
    }

    public static void main(String[] args) {
        Level_Order3 obj = new Level_Order3();
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
        System.out.println("Level Order Traversal:");
        obj.LevelOrder(root);
    }
}