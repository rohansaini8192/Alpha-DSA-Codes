import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitiesSelection {
    public static void maxActivities(int start[], int end[]) {
        // 2D array to store activities
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i; // index
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        // sorting
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        
        ArrayList<Integer> maxAct = new ArrayList<>();
        int count = 0;
        // 0th activity
        maxAct.add(activities[0][0]);
        count++;
        int prevEnd = activities[0][2];
        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= prevEnd) {
                maxAct.add(activities[i][0]);
                count++;
                prevEnd = activities[i][2];
            }
        }
        System.out.println("No. of maximum activities: "+count);
        System.out.println("Performed activities are: ");
        for(int i=0; i<maxAct.size(); i++) {
            System.out.print("A"+maxAct.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        maxActivities(start, end);
    }
}