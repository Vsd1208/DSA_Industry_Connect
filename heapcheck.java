import java.util.*;

class heapcheck {

    static class binarytree {
        int data;
        binarytree left;
        binarytree right;

        binarytree(int data) {
            this.data = data;
        }
    }

    private static boolean checkheap(binarytree root) {
        if (root == null)
            return true;

        if (root.left != null && root.data > root.left.data)
            return false;

        if (root.right != null && root.data > root.right.data)
            return false;

        return checkheap(root.left) && checkheap(root.right);
    }

    public static void main(String[] args) {
        binarytree root = new binarytree(10);
        root.left = new binarytree(20);
        root.right = new binarytree(100);
        root.left.left = new binarytree(5);
        root.left.right = new binarytree(50);
        if (checkheap(root))
            System.out.println("Is a heap");
        else
            System.out.println("Not a heap");
    }
}