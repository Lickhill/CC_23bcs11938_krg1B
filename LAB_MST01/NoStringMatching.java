package LAB_MST01;

class NoStringMatching {
    public int maxProduct(String[] words) {
        int n = words.length;
        boolean[][] map = new boolean[n][26];

        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                map[i][c - 'a'] = true;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean ok = true;

                for (int k = 0; k < 26; k++) {
                    if (map[i][k] && map[j][k]) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NoStringMatching obj = new NoStringMatching();

        String[] words1 = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(obj.maxProduct(words1));

        String[] words2 = { "a", "ab", "abc", "d", "cd", "bcd", "abcd" };
        System.out.println(obj.maxProduct(words2));

        String[] words3 = { "a", "aa", "aaa", "aaaa" };
        System.out.println(obj.maxProduct(words3));
    }
}