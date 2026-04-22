import java.util.*;

class Cousin_sum {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    void sum(Node root, int key) {
        if (root == null || root.data == key) {
            System.out.println("Sum of cousins: 0");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if ((curr.left != null && curr.left.data == key) || (curr.right != null && curr.right.data == key)) {
                    found = true;
                } else {
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                }
            }
        }
        int sum = 0;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            sum += temp.data;
        }

        System.out.println("Sum of cousins of node " + key + " is: " + sum);
    }

    public static void main(String[] args) {
        Cousin_sum cs = new Cousin_sum();

        Node root = cs.new Node(1);
        root.left = cs.new Node(2);
        root.right = cs.new Node(3);
        root.left.left = cs.new Node(4);
        root.left.right = cs.new Node(5);
        root.right.left = cs.new Node(6);
        root.right.right = cs.new Node(7);

        int key = 5;
        cs.sum(root, key);
    }
}