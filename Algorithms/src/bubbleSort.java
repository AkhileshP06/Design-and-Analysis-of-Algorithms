import java.util.Scanner;
public class bubbleSort 
{
	public static void main(String args[])
	{
		Scanner S = new Scanner (System.in);
		System.out.println("Enter array length : ");
		int a[] = new int[S.nextInt()];
		System.out.println("Enter "+a.length+" values... ");
		for(int i = 0;i<a.length;i++)
		{
			a[i] = S.nextInt();
		}
		//Bubble Sort starts here....
		int n = a.length;
		for (int i = 0;i<n-1;i++)
		{
			for(int j = 0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		//printing result..
		System.out.println("Displaying sorted array .....");
		for(int i = 0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		S.close();
	}
}
