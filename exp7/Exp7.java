package exp7;

import java.util.*;

class Exp7 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>())
                    .add(new int[] { f[1], f[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        pq.offer(new int[] { 0, src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], node = curr[1], stops = curr[2];

            if (node == dst)
                return cost;
            if (stops > k)
                continue;

            if (!graph.containsKey(node))
                continue;

            for (int[] nei : graph.get(node)) {
                pq.offer(new int[] {
                        cost + nei[1],
                        nei[0],
                        stops + 1
                });
            }
        }

        return -1;
    }
}