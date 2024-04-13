import java.util.Scanner;
public class MergeSort 
{
	  public static void mergeSort(int[] arr, int left, int right) {
		    
		    if (left < right) {
		      
		      // Find the middle point
		      int mid = (left + right) / 2;

		      // Sort first and second halves
		      mergeSort(arr, left, mid);
		      mergeSort(arr, mid + 1, right);

		      // Merge the sorted halves
		      merge(arr, left, mid, right);
		    }
		  }

		  public static void merge(int[] arr, int left, int mid, int right) {

		    // Create temporary arrays
		    int[] leftArr = new int[mid - left + 1];
		    int[] rightArr = new int[right - mid];

		    // Copy data to temporary arrays
		    for (int i = 0; i < leftArr.length; i++) {
		      leftArr[i] = arr[left + i];
		    }
		    for (int j = 0; j < rightArr.length; j++) {
		      rightArr[j] = arr[mid + 1 + j];
		    }

		    // Merge the temporary arrays
		    int i = 0, j = 0, k = left;
		    while (i < leftArr.length && j < rightArr.length) {
		      if (leftArr[i] <= rightArr[j]) {
		        arr[k] = leftArr[i];
		        i++;
		      } else {
		        arr[k] = rightArr[j];
		        j++;
		      }
		      k++;
		    }

		    // Copy remaining elements of left array if any
		    while (i < leftArr.length) {
		      arr[k] = leftArr[i];
		      i++;
		      k++;
		    }

		    // Copy remaining elements of right array if any
		    while (j < rightArr.length) {
		      arr[k] = rightArr[j];
		      j++;
		      k++;
		    }
		  }
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int a[] = new int[S.nextInt()];
		int n = a.length;
		System.out.println("Enter "+n+" values : ");
		for(int i = 0;i<n;i++)
		{
			a[i] = S.nextInt();
		}
		mergeSort(a,0,n-1);
		System.out.println("Displaying sorted elements.....");
		for(int i = 0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		S.close();
	}
}
