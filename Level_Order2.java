import java.util.*;

class Level_Order2 {
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

    private void levelorder(Tree root, int level, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.data);
        if (level % 2 != 0) {
            levelorder(root.left, level + 1, ans);
            levelorder(root.right, level + 1, ans);
        } else {
            levelorder(root.right, level + 1, ans);
            levelorder(root.left, level + 1, ans);
        }
    }

    public static void main(String[] args) {
        Level_Order2 obj = new Level_Order2();
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
        List<List<Integer>> ans = new ArrayList<>();
        obj.levelorder(root, 0, ans);
        System.out.println(ans);
    }
}