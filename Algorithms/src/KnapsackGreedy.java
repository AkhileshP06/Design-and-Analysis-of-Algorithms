import java.util.*;

public class KnapsackGreedy 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);

		// Get the number of items and the capacity of the knapsack
		System.out.print("Enter the number of items: ");
		int n = scanner.nextInt();
		System.out.print("Enter the weight limit of the knapsack: ");
		int W = scanner.nextInt();

		// Get the weight and value of each item
		int[] weight = new int[n];
		int[] value = new int[n];
		for (int i = 0; i < n; i++)
		{
			System.out.print("Enter the weight and value of item " + (i+1) + ": ");
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}

		// Calculate the maximum value that can be obtained
		int maxValue = knapsackGreedy(n, weight, value, W);

		// Print the maximum value
		System.out.println("The maximum value that can be obtained is " + maxValue);
		scanner.close();
	}

	public static int knapsackGreedy(int n, int[] weight, int[] value, int W) 
	{
		// Calculate the value-to-weight ratios of the items
		double[] ratios = new double[n];
		for (int i = 0; i < n; i++)
		{
			ratios[i] = (double) value[i] / weight[i];
		}

		// Sort the items by their value-to-weight ratios in descending order
		for (int i = 0; i < n-1; i++)
		{
			for (int j = i+1; j < n; j++) 
			{
				if (ratios[i] < ratios[j]) 
				{
					double temp = ratios[i];
					ratios[i] = ratios[j];
					ratios[j] = temp;
					int tempWeight = weight[i];
					weight[i] = weight[j];
					weight[j] = tempWeight;
					int tempValue = value[i];
					value[i] = value[j];
					value[j] = tempValue;
				}
			}
		}

		// Fill the knapsack with items in order of their value-to-weight ratios
		int totalValue = 0;
		int totalWeight = 0;
		for (int i = 0; i < n; i++) 
		{
			if (totalWeight + weight[i] <= W) 
			{
				totalValue += value[i];
				totalWeight += weight[i];
			}
			else 
			{
				int remainingWeight = W - totalWeight;
				totalValue += (int) (remainingWeight * ratios[i]);
				break;
			}
		}

		return totalValue;
	}
}
