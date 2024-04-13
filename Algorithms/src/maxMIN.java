import java.util.Scanner;
public class maxMIN
{
	static class Pair 
	{
        int min;
        int max;
    }
	//iterative approach
	public static Pair iterative(int A[])
	{
		Pair res = new Pair();
		res.max = 0;
		res.min = A[0];
		for(int i = 0;i<A.length;i++)
		{
			if(A[i]>res.max)
				res.max = A[i];
			if(A[i]<res.min)
				res.min = A[i];
		}
		return res;
	}
	//divide and conquer approach
	public static Pair findMaxMin(int[] arr, int low, int high) 
	{
        Pair result = new Pair();
        Pair leftResult = new Pair();
        Pair rightResult = new Pair();
        int mid;

        if (low == high) 
        {
            result.min = arr[low];
            result.max = arr[low];
            return result;
        }

        if (high == low + 1) 
        {
            if (arr[low] > arr[high])
            {
                result.min = arr[high];
                result.max = arr[low];
            } 
            else 
            {
                result.min = arr[low];
                result.max = arr[high];
            }
            return result;
        }

        mid = (low + high) / 2;
        leftResult = findMaxMin(arr, low, mid);
        rightResult = findMaxMin(arr, mid + 1, high);

        if (leftResult.min < rightResult.min)
        {
            result.min = leftResult.min;
        }
        else 
        {
            result.min = rightResult.min;
        }

        if (leftResult.max > rightResult.max) 
        {
            result.max = leftResult.max;
        }
        else 
        {
            result.max = rightResult.max;
        }

        return result;
    }
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int A[] = new int[S.nextInt()];
		System.out.println("Enter "+A.length+" values....");
		for(int i = 0;i<A.length;i++)
		{
			A[i] = S.nextInt();
		}
		System.out.println("Result using divide and conquer approach.....");
		Pair res = findMaxMin(A,0,A.length-1);
		System.out.println("Maximum element : "+res.max);
		System.out.println("Minimum element : "+res.min);
		System.out.println();
		System.out.println("Result using iterative approach ......");
		res = iterative(A);
		System.out.println("Maximum element : "+res.max);
		System.out.println("Minimum element : "+res.min);
		S.close();
	}
}