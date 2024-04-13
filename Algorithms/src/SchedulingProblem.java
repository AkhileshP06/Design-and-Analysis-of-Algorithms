import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SchedulingProblem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of events : ");
        int n = sc.nextInt();
        int[][] events = new int[n][2];

        System.out.println("Enter the starting and ending time of each event ....");
        for(int i=0; i<n; i++)
        {
            System.out.println("Event "+(i+1)+" : ");
            events[i][0] = sc.nextInt();
            events[i][1] = sc.nextInt();
        }

        System.out.println("\nApproach a: Select shortest events first");
        int[][] shortestFirst = selectShortestFirst(events);
        System.out.println("Number of events scheduled: " + shortestFirst.length);
        System.out.println("Scheduled events:");
        printEvents(shortestFirst);

        System.out.println("\nApproach b: Select events starting earliest first");
        int[][] startEarliest = selectStartEarliest(events);
        System.out.println("Number of events scheduled: " + startEarliest.length);
        System.out.println("Scheduled events:");
        printEvents(startEarliest);

        System.out.println("\nApproach c: Select events ending earliest first");
        int[][] endEarliest = selectEndEarliest(events);
        System.out.println("Number of events scheduled: " + endEarliest.length);
        System.out.println("Scheduled events:");
        printEvents(endEarliest);
        sc.close();
    }

    // Approach a: Select shortest events first
    public static int[][] selectShortestFirst(int[][] events)
    {
        Arrays.sort(events, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        return scheduleEvents(events);
    }

    // Approach b: Select events starting earliest first
    public static int[][] selectStartEarliest(int[][] events)
    {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        return scheduleEvents(events);
    }

    // Approach c: Select events ending earliest first
    public static int[][] selectEndEarliest(int[][] events) 
    {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        return scheduleEvents(events);
    }

    // Helper function to schedule events
    public static int[][] scheduleEvents(int[][] events)
    {
        List<int[]> selected = new ArrayList<>();
        int[] prev = null;
        for(int[] event : events) {
            if(prev == null || event[0] >= prev[1]) {
                selected.add(event);
                prev = event;
            }
        }
        return selected.toArray(new int[0][]);
    }

    // Helper function to print events
    public static void printEvents(int[][] events) 
    {
        for(int[] event : events) 
        {
            System.out.println("Event ["+event[0]+", "+event[1]+"]");
        }
    }
}
