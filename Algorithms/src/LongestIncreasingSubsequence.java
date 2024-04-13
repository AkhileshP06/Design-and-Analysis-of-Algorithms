import java.util.Arrays;

public class LongestIncreasingSubsequence 
{
    public static int lengthOfLIS(int[] nums) 
    {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) 
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j]) 
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLength = 0;
        for (int i = 0; i < n; i++) 
        {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) 
    {
        int[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int length = lengthOfLIS(nums);
        System.out.println("Length of the longest increasing subsequence: " + length);
    }
}
