class Sum_Nodes {
    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private int sum = 0;

    private void sum(Node root) {
        if (root == null)
            return;
        sum += root.data;
        sum(root.left);
        sum(root.right);
    }

    public static void main(String[] args) {
        Sum_Nodes tree = new Sum_Nodes();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);
        root.right.left = tree.new Node(6);
        root.right.right = tree.new Node(7);
        tree.sum(root);
        System.out.println("Sum of all nodes: " + tree.sum);
    }
}