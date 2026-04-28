import java.io.*;
import java.util.*;

public class jan14 {

    static List<Long> res = new ArrayList<>();

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int ax = sc.nextInt();
            int ay = sc.nextInt();
            int bx = sc.nextInt();
            int by = sc.nextInt();

            int[] arrOfx = new int[n];
            int[] arrOfy = new int[n];

            for (int i = 0; i < n; i++)
                arrOfx[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arrOfy[i] = sc.nextInt();

            func(arrOfx, arrOfy, n, ax, ay, bx, by);
        }

        for (long v : res) {
            System.out.println(v);
        }
    }

    public static void func(int[] arrOfx, int[] arrOfy, int n, int ax, int ay, int bx, int by) {

        int[][] ghar = new int[n][2];
        for (int i = 0; i < n; i++) {
            ghar[i][0] = arrOfx[i];
            ghar[i][1] = arrOfy[i];
        }

        Arrays.sort(ghar, Comparator.comparingInt(a -> a[0]));

        long ans = (long) bx - ax;
        long curY = ay;

        int i = 0;
        while (i < n) {
            int j = i;
            List<Integer> ys = new ArrayList<>();
            while (j < n && ghar[j][0] == ghar[i][0]) {
                ys.add(ghar[j][1]);
                j++;
            }

            Collections.sort(ys);
            int low = ys.get(0);
            int high = ys.get(ys.size() - 1);

            if (Math.abs(curY - low) <= Math.abs(curY - high)) {
                ans += Math.abs(curY - low);
                ans += high - low;
                curY = high;
            } else {
                ans += Math.abs(curY - high);
                ans += high - low;
                curY = low;
            }
            i = j;
        }

        ans += Math.abs(curY - by);
        res.add(ans);
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
