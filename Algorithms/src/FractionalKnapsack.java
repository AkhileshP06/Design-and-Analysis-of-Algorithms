import java.util.Scanner;

public class FractionalKnapsack
{

	public static void main(String[] args) 
	{

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of items: ");
		int n = scanner.nextInt();

		int[] weight = new int[n];
		int[] value = new int[n];

		for (int i = 0; i < n; i++) 
		{
			System.out.print("Enter weight and value for item " + (i+1) + ": ");
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}

		System.out.print("Enter the weight limit of the knapsack: ");
		int W = scanner.nextInt();

		double maxValue = getMaxValue(n, weight, value, W);
		System.out.println("Maximum value we can obtain = " + maxValue);

		scanner.close();
	}

	public static double getMaxValue(int n, int[] weight, int[] value, int W)
	{
		ItemValue[] itemValue = new ItemValue[n];

		for (int i = 0; i < n; i++)
		{
			itemValue[i] = new ItemValue(weight[i], value[i], i);
		}

		// Sort items by decreasing order of value-to-weight ratio
		java.util.Arrays.sort(itemValue, (a, b) -> b.cost.compareTo(a.cost));

		double totalValue = 0d;

		for (ItemValue i : itemValue)
		{

			int currentWeight = (int) i.weight;
			int currentValue = (int) i.value;

			if (W - currentWeight >= 0) 
			{
				// take all of the current item
				W = W - currentWeight;
				totalValue += currentValue;
			} 
			else 
			{
				// take a fraction of the current item
				double fraction = ((double) W) / ((double) currentWeight);
				totalValue += (currentValue * fraction);
				W = (int) (W - (currentWeight * fraction));
				break;
			}
		}

		return totalValue;
	}

	static class ItemValue 
	{

		Double cost;
		double weight, value, index;

		public ItemValue(int weight, int value, int index) 
		{
			this.weight = weight;
			this.value = value;
			this.index = index;
			cost = (double) value / (double) weight;
		}
	}
}
