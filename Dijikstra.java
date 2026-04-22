import java.util.*;

class Dijikstra {

    public int[] dijkstra(int V, List<List<int[]>> graph, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);

        dist[src] = 0;
        pq.offer(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (d > dist[node])
                continue;

            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int weight = nei[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[] { next, dist[next] });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // edges: u -> v (weight)
        graph.get(0).add(new int[] { 1, 2 });
        graph.get(0).add(new int[] { 2, 4 });
        graph.get(1).add(new int[] { 2, 1 });
        graph.get(1).add(new int[] { 3, 7 });
        graph.get(2).add(new int[] { 4, 3 });
        graph.get(3).add(new int[] { 4, 1 });

        Dijikstra obj = new Dijikstra();
        int src = 0;

        int[] result = obj.dijkstra(V, graph, src);

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + result[i]);
        }
    }
}