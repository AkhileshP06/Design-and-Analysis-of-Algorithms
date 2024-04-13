import java.util.Scanner;
import java.util.Arrays;
public class PerfectSquares 
{
    public static int numSquares(int n) 
    {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j * j <= i; j++)
            {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args)
    {
    	Scanner S = new Scanner(System.in);
        System.out.println("Enter the value : ");
        System.out.println("Least number of perfect squares that sum up : "  + numSquares(S.nextInt()));
        S.close();
    }
}
