package exp2;

import java.util.*;

public class DFSgraph {
    static void dfs(int v, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj.get(v)) {
            if (!visited[n])
                dfs(n, visited, adj);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int start = sc.nextInt();

        boolean[] visited = new boolean[vertices];
        dfs(start, visited, adj);
    }
}