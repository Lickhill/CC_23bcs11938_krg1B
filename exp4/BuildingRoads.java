import java.util.*;

public class BuildingRoads {
    static List<Integer>[] g;
    static boolean[] vis;

    static void dfs(int v) {
        vis[v] = true;
        for (int to : g[v]) {
            if (!vis[to])
                dfs(to);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        g = new ArrayList[n + 1];
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        List<Integer> rep = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                rep.add(i);
                dfs(i);
            }
        }

        System.out.println(rep.size() - 1);
        for (int i = 1; i < rep.size(); i++) {
            System.out.println(rep.get(i - 1) + " " + rep.get(i));
        }
    }
}