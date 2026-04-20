
import java.util.*;

public class SegmentTree {
    static int[] tree;
    static int n;

    static void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l)
            return Integer.MIN_VALUE;
        if (l <= start && end <= r)
            return tree[node];
        int mid = (start + end) / 2;
        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        tree = new int[4 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        build(arr, 0, 0, n - 1);

        int q = sc.nextInt();

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(query(0, 0, n - 1, l, r));
        }

        sc.close();
    }
}
