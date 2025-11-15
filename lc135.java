class lc135 {
    public int candy(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] c = new int[n];
        Arrays.fill(c,1);
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[i - 1])
                c[i] = c[i - 1] + 1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i])
                c[i - 1] = Math.max(c[i] + 1, c[i - 1]);
            ans += c[i - 1];
        }
        return ans + c[n - 1];
    }
}
