import java.io.*;
import java.util.*;

public class jan23C {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = fr.nextInt();

        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fr.nextInt();
            }

            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}