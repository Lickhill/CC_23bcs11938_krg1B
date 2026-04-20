import java.util.*;

class Edge {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }
}

public class Bellmanford {

    static void bellmanFord(int V, int E, List<Edge> edges, int source) {

        int[] dist = new int[V + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 1; i <= V - 1; i++) {
            for (Edge edge : edges) {

                int u = edge.src;
                int v = edge.dest;
                int w = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (Edge edge : edges) {

            int u = edge.src;
            int v = edge.dest;
            int w = edge.weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 1; i <= V; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 5;
        int E = 6;

        List<Edge> edges = new ArrayList<>();

        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(2, 5, 5));
        edges.add(new Edge(2, 3, 4));
        edges.add(new Edge(1, 4, 1));
        edges.add(new Edge(4, 3, 3));
        edges.add(new Edge(3, 5, 1));

        bellmanFord(V, E, edges, 1);
    }
}