package exp3;

import java.util.*;

public class Dijkstra {

    static class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            graph.get(a).add(new Pair(b, w));
            graph.get(b).add(new Pair(a, w));
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[1] = 0;
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();
            int u = cur.node;

            for (Pair edge : graph.get(u)) {

                int v = edge.node;
                long w = edge.dist;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        if (dist[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        int cur = n;

        while (cur != 0) {
            path.add(cur);
            cur = parent[cur];
        }

        Collections.reverse(path);

        for (int x : path)
            System.out.print(x + " ");
    }
}