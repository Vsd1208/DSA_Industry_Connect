import java.util.*;

class Tree {
    int capacity = 0, count = 0;
    Tree[] child;
    int value;

    Tree(int value, int n) {
        this.capacity = n;
        child = new Tree[n];
        this.value = value;
    }

    void addchild(Tree Node) {
        if (count < capacity)
            child[count++] = Node;
        else
            System.out.println("Already Filled");
    }

    void display() {
        System.out.println(value + " ");
        for (int i = 0; i < count; i++) {
            child[i].display();
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(1, 3);
        Tree child1 = new Tree(2, 2);
        Tree child2 = new Tree(3, 2);
        root.addchild(child1);
        root.addchild(child2);
        child1.addchild(new Tree(4, 1));
        child1.addchild(new Tree(5, 1));
        root.display();
    }
}
