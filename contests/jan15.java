import java.io.*;
import java.util.*;

public class jan15 {
    static final int MOD = 676767677;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        StringBuilder out = new StringBuilder();
        while (T-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++)
                a[i] = fr.nextInt();
            long[] B = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                B[i] = a[i] - (long) (n - i + 1);
            }
            long[] beta = new long[n + 1];
            for (int i = 1; i <= n; i++)
                beta[i] = B[i] - beta[i - 1];
            long ans = 0;
            if (n % 2 == 0) {
                long S = beta[n];
                if (S < 0 || S > n) {
                    ans = 0;
                } else {
                    boolean ok = true;
                    for (int i = 1; i <= n && ok; i++) {
                        if (i % 2 == 0) {
                            if (beta[i] < 0 || beta[i] > S)
                                ok = false;
                        } else {
                            if (beta[i] > 0 || beta[i] < -S)
                                ok = false;
                        }
                    }
                    for (int i = 1; i <= n && ok; i++) {
                        long diff;
                        if (i % 2 == 1) {
                            diff = S + beta[i] - beta[i - 1];
                        } else {
                            diff = beta[i] - (S + beta[i - 1]);
                        }
                        if (diff != 0 && diff != 1)
                            ok = false;
                    }
                    ans = ok ? 1 : 0;
                }
            } else {
                if (beta[n] != 0) {
                    ans = 0;
                } else {
                    boolean signOk = true;
                    long maxEven = 0;
                    long minOdd = 0;
                    for (int i = 1; i <= n; i++) {
                        if (i % 2 == 0) {
                            if (beta[i] < 0) {
                                signOk = false;
                                break;
                            }
                            if (beta[i] > maxEven)
                                maxEven = beta[i];
                        } else {
                            if (beta[i] > 0) {
                                signOk = false;
                                break;
                            }
                            if (beta[i] < minOdd)
                                minOdd = beta[i];
                        }
                    }
                    if (signOk) {
                        long LB = Math.max(Math.max(0, maxEven), -minOdd);
                        int[] candidates = null;
                        for (int i = 1; i <= n; i++) {
                            long s1, s2;
                            if (i % 2 == 1) {
                                s1 = beta[i - 1] - beta[i];
                                s2 = s1 + 1;
                            } else {
                                s1 = beta[i] - beta[i - 1];
                                s2 = s1 - 1;
                            }
                            if (candidates == null) {
                                if (s1 == s2) {
                                    candidates = new int[] { (int) s1 };
                                } else {
                                    candidates = new int[] { (int) s1, (int) s2 };
                                }
                            } else {
                                IntArrayList next = new IntArrayList(2);
                                for (int v : candidates) {
                                    if (v == s1 || v == s2)
                                        next.add(v);
                                }
                                if (next.size() == 0) {
                                    candidates = new int[0];
                                    break;
                                }
                                candidates = next.toArray();
                            }
                        }
                        if (candidates != null) {
                            for (int v : candidates) {
                                long S = v;
                                if (S < LB || S > n)
                                    continue;
                                ans++;
                            }
                        }
                    }
                }
            }
            out.append(ans % MOD).append('\n');
        }
        System.out.print(out.toString());
    }

    static class IntArrayList {
        int[] a;
        int sz;

        IntArrayList(int cap) {
            a = new int[cap];
        }

        void add(int v) {
            for (int i = 0; i < sz; i++)
                if (a[i] == v)
                    return;
            a[sz++] = v;
        }

        int size() {
            return sz;
        }

        int[] toArray() {
            return Arrays.copyOf(a, sz);
        }
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