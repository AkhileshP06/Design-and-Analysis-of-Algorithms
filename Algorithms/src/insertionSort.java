import java.util.Scanner;
public class insertionSort 
{
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int a[] = new int[S.nextInt()];
		System.out.println("Enter "+a.length+" values : ");
		int n = a.length;
		for(int i = 0;i<n;i++)
		{
			a[i] = S.nextInt();
		}
		for (int i = 1; i < n; i++)
		{
			int key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > key)
			{
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		}
		System.out.println("Displaying sorted elements.....");
		for(int i = 0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		S.close();
	}
}
