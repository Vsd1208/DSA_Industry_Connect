class sum_Left {

    private static int sum = 0; // global variable

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private void sum_left(Node root) {
        if (root == null)
            return;

        if (root.left != null) {
            sum += root.left.data;
        }

        sum_left(root.left);
        sum_left(root.right);
    }

    public static void main(String[] args) {
        sum_Left tree = new sum_Left();

        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        tree.sum_left(root);

        System.out.println("Sum of left nodes: " + sum);    // Output: 6 (2 + 4)
    }
}