import java.util.*;

class FamilyTree {

    static class Node {
        String husband_name;
        String wife_name;
        List<Node> children;

        public Node(String husband_name, String wife_name) {
            this.husband_name = husband_name;
            this.wife_name = wife_name;
            this.children = new ArrayList<>();
        }
    }

    public static void buildFamilyTree(Node root, int generations, Scanner sc) {
        if (generations == 0)
            return;

        System.out.print("Enter number of children for " + root.husband_name + " & " + root.wife_name + ": ");
        int numChildren = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < numChildren; i++) {
            System.out.println("Entering details for child " + (i + 1));
            System.out.print("Enter husband's name: ");
            String husband = sc.nextLine();
            System.out.print("Enter wife's name: ");
            String wife = sc.nextLine();
            Node child = new Node(husband, wife);
            root.children.add(child);
            buildFamilyTree(child, generations - 1, sc);
        }

    }

    public static void printTree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Husband: " + current.husband_name + ", Wife: " + current.wife_name + ", Children: "
                    + current.children.size());
            for (Node child : current.children) {
                queue.offer(child);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of generations: ");
        int generations = sc.nextInt();

        sc.nextLine();

        Node root = new Node("Chandraiah", "Lakshmikantamma");
        buildFamilyTree(root, generations - 1, sc);
        printTree(root);
    }
}