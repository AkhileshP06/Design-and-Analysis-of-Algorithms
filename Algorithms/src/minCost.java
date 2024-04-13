import java.util.Scanner;
public class minCost
{
    public static int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;
        
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for (int i = 2; i < n; i++)
        {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
    
    public static void main(String[] args) 
    {
    	Scanner S = new Scanner(System.in);
    	System.out.println("Enter size of cost array : ");
    	int cost[] = new int[S.nextInt()];
    	System.out.println("Enter the costs...");
    	for(int i = 0;i<cost.length;i++)
    	{
    		cost[i] = S.nextInt();
    	}
        System.out.println("Minimum cost to reach the top: " + minCostClimbingStairs(cost));
        S.close();
    }
}
