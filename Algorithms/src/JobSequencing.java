import java.util.*;

public class JobSequencing {
    
    public static void jobSequence(int[] profits, int[] deadlines, int n) {
        
        // Sort jobs in decreasing order of profits
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (profits[i] < profits[j]) {
                    int temp = profits[i];
                    profits[i] = profits[j];
                    profits[j] = temp;
                    
                    temp = deadlines[i];
                    deadlines[i] = deadlines[j];
                    deadlines[j] = temp;
                }
            }
        }
        
        int maxDeadline = getMax(deadlines);
        int[] jobList = new int[maxDeadline];
        
        // Assign jobs to slots
        for (int i = 0; i < n; i++) {
            for (int j = deadlines[i]-1; j >= 0; j--) {
                if (j < maxDeadline && jobList[j] == 0) {
                    jobList[j] = i+1;
                    break;
                }
            }
        }
        
        // Calculate total profit
        int totalProfit = 0;
        System.out.println("Job sequence: ");
        for (int i = 0; i < maxDeadline; i++) {
            if (jobList[i] != 0) {
                System.out.print(jobList[i] + " ");
                totalProfit += profits[jobList[i]-1];
            }
        }
        
        System.out.println("\nTotal Profit: " + totalProfit);
    }
    
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of jobs: ");
        int n = sc.nextInt();
        int[] profits = new int[n];
        int[] deadlines = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit for job " + (i+1) + ": ");
            profits[i] = sc.nextInt();
            System.out.print("Enter deadline for job " + (i+1) + ": ");
            deadlines[i] = sc.nextInt();
        }
        
        jobSequence(profits, deadlines, n);
        sc.close();
    }
}
