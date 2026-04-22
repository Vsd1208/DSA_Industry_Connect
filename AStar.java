import java.util.*;

class AStar {

    static class Node {
        String name;
        int g;
        int h;
        int f;
        Node parent;

        Node(String name, int g, int h) {
            this.name = name;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = null;
        }
    }

    static Map<String, List<Node>> graph = new HashMap<>();

    static void addEdge(String u, String v, int cost, int h) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(new Node(v, cost, h));
    }

    static void aStar(String start, String goal) {
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Set<String> closed = new HashSet<>();

        Node startNode = new Node(start, 0, 0);
        open.add(startNode);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if (current.name.equals(goal)) {
                printPath(current);
                return;
            }

            closed.add(current.name);

            if (!graph.containsKey(current.name))
                continue;

            for (Node neighbor : graph.get(current.name)) {
                if (closed.contains(neighbor.name))
                    continue;

                int newG = current.g + neighbor.g;
                Node next = new Node(neighbor.name, newG, neighbor.h);
                next.parent = current;

                open.add(next);
            }
        }

        System.out.println("Path not found");
    }

    static void printPath(Node node) {
        List<String> path = new ArrayList<>();
        int cost = node.g;

        while (node != null) {
            path.add(node.name);
            node = node.parent;
        }

        Collections.reverse(path);
        System.out.println("Path: " + path);
        System.out.println("Total Cost: " + cost);
    }

    public static void main(String[] args) {

        addEdge("A", "B", 1, 4);
        addEdge("A", "C", 3, 2);
        addEdge("B", "D", 3, 1);
        addEdge("C", "D", 1, 1);
        addEdge("D", "E", 2, 0);
        aStar("A", "E");
    }
}