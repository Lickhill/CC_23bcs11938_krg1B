import java.util.Scanner;

public class mar1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        function(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void function(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 == 0)
                continue;
            int num = arr[i];
            int min = Integer.MAX_VALUE;
            while (num > 0) {
                min = Math.min(min, num % 10);
                num /= 10;
            }
            arr[i] = min;
        }
    }
}