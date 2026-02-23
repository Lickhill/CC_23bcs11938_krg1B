public class robinkarp {

    private final static int d = 256;
    private final static int q = 101;

    public static void search(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();

        int pHash = 0;
        int tHash = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {

            if (pHash == tHash) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < n - m) {
                tHash = (d * (tHash - text.charAt(i) * h)
                        + text.charAt(i + m)) % q;

                if (tHash < 0)
                    tHash = tHash + q;
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABCCDDAEFG";
        String pattern = "CDD";
        search(pattern, text);
    }
}