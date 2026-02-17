import java.util.*;

public class SumBitDifferences {

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static int sumBitDifferences(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                total += countSetBits(arr[i] ^ arr[j]);
            }
        }

        return total * 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        System.out.println(sumBitDifferences(arr));
    }
}
