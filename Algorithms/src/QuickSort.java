import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the size of the array: ");
		int n = sc.nextInt();

		int[] arr = new int[n];
		System.out.print("Enter array elements: ");
		for (int i = 0; i < n; i++) 
		{
			arr[i] = sc.nextInt();
		}

		System.out.println("Before sorting: ");
		printArray(arr);

		quicksort(arr, 0, n-1);

		System.out.println("After sorting: ");
		printArray(arr);
		sc.close();
	}

	public static void quicksort(int[] arr, int low, int high)
	{
		if (low < high) 
		{
			int pi = partition(arr, low, high);
			quicksort(arr, low, pi-1);
			quicksort(arr, pi+1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) 
	{
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) 
		{
			if (arr[j] <= pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		return i+1;
	}

	public static void printArray(int[] arr) 
	{
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
