class MagicalNumber {

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    public static long nthMagicalNumber(long n, long a, long b) {
        long start = 1;
        long end = n * Math.min(a, b);
        long lcm = lcm(a, b);

        while (start < end) {
            long mid = start + (end - start) / 2;

            long count = mid / a + mid / b - mid / lcm;

            if (count < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        long n = 5, a = 2, b = 3;
        System.out.println(nthMagicalNumber(n, a, b));
    }
}
