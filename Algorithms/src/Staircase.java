import java.util.Scanner;
public class Staircase 
{
    public static int climbStairs(int n) 
    {
        if (n <= 2) 
        {
            return n;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) 
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) 
    {
    	Scanner S = new Scanner(System.in);
    	System.out.println("Enter number of stairs : ");
        System.out.println("Number of distinct ways to climb steps: " + climbStairs(S.nextInt()));
        S.close();
    }
}
