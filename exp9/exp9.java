class exp9
{
public
    String shortestCommonSupersequence(String str1, String str2)
    {
        StringBuilder ans = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++)
        {
            for (int j = 1; j <= n2; j++)
            {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n1, j = n2;

        while (i > 0 && j > 0)
        {
            if (str1.charAt(i - 1) == str2.charAt(j - 1))
            {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i][j - 1] > dp[i - 1][j])
            {
                ans.append(str2.charAt(j - 1));
                j--;
            }
            else
            {
                ans.append(str1.charAt(i - 1));
                i--;
            }
        }

        while (i > 0)
        {
            ans.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0)
        {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }
}