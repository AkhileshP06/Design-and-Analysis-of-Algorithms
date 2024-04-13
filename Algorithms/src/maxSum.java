import java.util.Scanner;
public class maxSum
{
	public static int maxSubArraySum(int[] arr)
	{
		return maxSubArraySum(arr, 0, arr.length - 1);
	}

	private static int maxSubArraySum(int[] arr, int left, int right)
	{
		if (left == right) 
		{
			return arr[left];
		}
		int mid = (left + right) / 2;
		int leftMaxSum = maxSubArraySum(arr, left, mid);
		int rightMaxSum = maxSubArraySum(arr, mid + 1, right);
		int crossMaxSum = maxCrossingSubArray(arr, left, mid, right);
		return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
	}

	private static int maxCrossingSubArray(int[] arr, int left, int mid, int right)
	{
		int leftMaxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = mid; i >= left; i--) 
		{
			sum += arr[i];
			leftMaxSum = Math.max(leftMaxSum, sum);
		}
		int rightMaxSum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= right; i++)
		{
			sum += arr[i];
			rightMaxSum = Math.max(rightMaxSum, sum);
		}
		return leftMaxSum + rightMaxSum;
	}
	//iterative with N*N complexity
	public static int maxSubArraySum2(int[] arr) {
	    int n = arr.length;
	    int maxSum = Integer.MIN_VALUE;
	    for (int i = 0; i < n; i++) {
	        int sum = 0;
	        for (int j = i; j < n; j++) {
	            sum += arr[j];
	            maxSum = Math.max(maxSum, sum);
	        }
	    }
	    return maxSum;
	}
	//iterative with N*N*N
	public static int maxSubArraySum3(int[] arr) {
	    int n = arr.length;
	    int maxSum = Integer.MIN_VALUE;
	    for (int i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            int sum = 0;
	            for (int k = i; k <= j; k++) {
	                sum += arr[k];
	            }
	            maxSum = Math.max(maxSum, sum);
	        }
	    }
	    return maxSum;
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
		int res = maxSubArraySum(A);
		System.out.println("Maximum sum of sub array : "+res);
		S.close();
	}
}