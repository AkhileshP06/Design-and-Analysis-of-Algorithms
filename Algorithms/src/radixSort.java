import java.util.Arrays;
import java.util.Scanner;

public class radixSort
{
    
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        System.out.println("Original array: " + Arrays.toString(arr));
        radixSort1(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        input.close();
    }
    
    public static void radixSort1(int[] arr) 
    {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10)
        {
            countSort(arr, exp);
        }
    }
    
    public static int getMax(int[] arr) 
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void countSort(int[] arr, int exp) 
    {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        
        for (int i = 0; i < n; i++) 
        {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        
        for (int i = 1; i < 10; i++) 
        {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) 
        {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        for (int i = 0; i < n; i++) 
        {
            arr[i] = output[i];
        }
    }
}
