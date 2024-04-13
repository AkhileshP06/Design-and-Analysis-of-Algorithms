import java.util.Scanner;
public class selectionSort
{
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int a[] = new int[S.nextInt()];
		System.out.println("Enter "+a.length+" values : ");
		for(int i = 0;i<a.length;i++)
		{
			a[i] = S.nextInt();
		}
		int n = a.length;
		for(int i = 0;i<n-1;i++)
		{
			int minIdx = i;
			for(int j = i+1;j<n;j++)
			{
				if(a[j]<a[minIdx])
				{
					minIdx = j;
				}
			}
			int temp = a[minIdx];
			a[minIdx] = a[i];
			a[i] = temp;
		}
		System.out.println("Displaying sorted elements.....");
		for(int i = 0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		S.close();

	}
}