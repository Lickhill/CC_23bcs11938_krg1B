package LAB_MST01;

import java.util.*;

public class MinEnergy {

    static boolean check(int[][] tasks, int mid) {
        for (int[] temp : tasks) {
            if (mid < temp[1])
                return false;
            mid -= temp[0];
        }
        return true;
    }

    static int findMinEnergy(int[][] tasks) {
        int n = tasks.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++)
            idx[i] = i;
        Arrays.sort(idx, (a, b) -> tasks[a][1] - tasks[b][1]);

        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++)
            sorted[i] = tasks[idx[i]];

        int start = 0, end = 100000, ans = end;
        while (start <= end) {
            int mid = start - (start - end) / 2;
            if (check(sorted, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {
                { 1, 2 },
                { 2, 4 },
                { 4, 8 }
        };

        int result = findMinEnergy(tasks);
        System.out.println(result);
    }
}
