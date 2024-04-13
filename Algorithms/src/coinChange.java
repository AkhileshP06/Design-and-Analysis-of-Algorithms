import java.util.Scanner;
import java.util.Arrays;
public class coinChange 
{
	public static int coinChangeGreedy(int[] coins, int amount)
	{
	    Arrays.sort(coins); // sort coins in ascending order
	    int count = 0;
	    for (int i = coins.length - 1; i >= 0; i--)
	    {
	        while (amount >= coins[i]) {
	            amount -= coins[i];
	            count++;
	        }
	        if (amount == 0) {
	            break;
	        }
	    }
	    return count;
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter number of coins : ");
		int c[] = new int[S.nextInt()];
		System.out.println("Enter the coin denominations .... ");
		for(int i = 0;i<c.length;i++)
		{
			c[i] = S.nextInt();
		}
		System.out.println("Enter target amount : ");
		System.out.println("The number of coins required are : "+coinChangeGreedy(c,S.nextInt()));
		S.close();
	}
}
