import java.util.*;

public class CountSmaller {
    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int index, int delta) {
            while (index < bit.length) {
                bit[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int value : sorted) {
            if (!rank.containsKey(value)) {
                rank.put(value, r++);
            }
        }

        Fenwick fenwick = new Fenwick(rank.size());
        int[] counts = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int currentRank = rank.get(nums[i]);
            counts[i] = fenwick.query(currentRank - 1);
            fenwick.update(currentRank, 1);
        }

        return counts;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = countSmaller(nums);

        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result[i]);
        }
        System.out.println();

        sc.close();
    }
}
