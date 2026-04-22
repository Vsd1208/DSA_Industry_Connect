class sum_Left_Leaf {

    private static int sum = 0; // global variable

    private class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private void sum_left_leaf(Node root) {
        if (root == null)
            return;

        if (root.left != null && root.right != null && root.left.left == null && root.left.right == null) {
            sum += root.left.data;
        }

        sum_left_leaf(root.left);
        sum_left_leaf(root.right);
    }

    public static void main(String[] args) {
        sum_Left_Leaf tree = new sum_Left_Leaf();

        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        tree.sum_left_leaf(root);

        System.out.println("Sum of left leaf nodes: " + sum); // Output: 4 (only 4 is a left leaf node)
    }
}