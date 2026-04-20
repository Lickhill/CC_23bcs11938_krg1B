import java.util.*;

public class MakePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(function(s));
    }

    public static String function(String s) {
        int freq[] = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        boolean oneMoreOdd = false;
        for (int e : freq) {
            if (e % 2 == 1 && oneMoreOdd) {
                return "NO";
            }
            if (e % 2 == 1 && !oneMoreOdd) {
                oneMoreOdd = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        int oddKaFreq = 0;
        String oddChar = "";
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 0) {
                for (int j = 1; j <= freq[i] / 2; j++)
                    sb.append((char) (i + 97));
            } else {
                oddKaFreq = freq[i];
                oddChar = (char) (i + 97) + "";
            }
        }
        StringBuilder res = new StringBuilder(sb);
        String temp = sb.reverse().toString();
        for (int j = 1; j <= oddKaFreq; j++)
            res.append(oddChar);
        res.append(temp);

        return res.toString();
    }
}