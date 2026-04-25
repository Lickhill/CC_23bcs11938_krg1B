package CC_23bcs11938_krg1B.ESTprac;

import java.util.Scanner;

public class SingleNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer ^= sc.nextInt();
        }

        System.out.println(answer);
    }
}
