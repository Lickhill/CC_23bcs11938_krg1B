package CC_23bcs11938_krg1B.ESTprac;

import java.util.*;

public class TopoSort {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[vertices + 1];
        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph.get(from).add(to);
            indegree[to]++;
        }

        System.out.println(topologicalSort(graph, indegree));
    }

    private static String topologicalSort(List<List<Integer>> graph, int[] indegree) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();
        int visited = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (visited > 0) {
                result.append(' ');
            }
            result.append(node);
            visited++;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (visited != graph.size()) {
            return "Cycle detected";
        }

        return result.toString();
    }
}
