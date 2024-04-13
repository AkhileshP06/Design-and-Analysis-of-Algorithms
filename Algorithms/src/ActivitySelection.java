import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ActivitySelection 
{
	public static void main(String[] args) 
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Enter number of activities : ");
		int start[] = new int[S.nextInt()];
		int finish[] = new int[start.length];
		System.out.println("Enter the starting and ending time of each activity ....");
		System.out.println();
		for(int i = 0;i<start.length;i++)
		{
			System.out.println("Activity "+(i+1)+" : ");
			start[i] = S.nextInt();
			finish[i] = S.nextInt();
		}
		// Activities are in required sorted order
		int maxActivities1 = selectActivitiesSorted(start, finish);
		System.out.println("Maximum number of activities (sorted): " + maxActivities1);

		// Activities are not in sorted order
		int maxActivities2 = selectActivitiesUnsorted(start, finish);
		System.out.println("Maximum number of activities (unsorted): " + maxActivities2);
		S.close();
	}

	public static int selectActivitiesSorted(int[] start, int[] finish) 
	{
		int n = start.length;
		int count = 1; // select the first activity
		int prevFinish = finish[0];
		for (int i = 1; i < n; i++)
		{
			if (start[i] >= prevFinish)
			{
				// select the current activity
				count++;
				prevFinish = finish[i];
			}
		}
		return count;
	}

	public static int selectActivitiesUnsorted(int[] start, int[] finish)
	{
		int n = start.length;
		Activity[] activities = new Activity[n];
		for (int i = 0; i < n; i++) 
		{
			activities[i] = new Activity(start[i], finish[i]);
		}
		Arrays.sort(activities, new Comparator<Activity>()
		{
			public int compare(Activity a1, Activity a2) 
			{
				return a1.finish - a2.finish;
			}
		}
		);
		int count = 1; // select the first activity
		int prevFinish = activities[0].finish;
		for (int i = 1; i < n; i++) 
		{
			if (activities[i].start >= prevFinish) 
			{
				// select the current activity
				count++;
				prevFinish = activities[i].finish;
			}
		}
		return count;
	}

	static class Activity 
	{
		int start;
		int finish;

		public Activity(int start, int finish)
		{
			this.start = start;
			this.finish = finish;
		}
	}
}
