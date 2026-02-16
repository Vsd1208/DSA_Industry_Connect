import java.util.*;
class BalancedTree {
    private class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private int height(Tree root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private boolean isBalanced(Tree root) {
        if (root == null)
            return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        BalancedTree bt = new BalancedTree();
        Tree root = bt.new Tree(1);
        root.left = bt.new Tree(2);
        root.right = bt.new Tree(3);
        root.left.left = bt.new Tree(4);
        root.left.right = bt.new Tree(5);
        System.out.println(bt.isBalanced(root));
        /*
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */
    }
}