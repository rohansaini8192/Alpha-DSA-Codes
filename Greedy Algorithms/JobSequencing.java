import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job {
        char id;
        int deadline,profit;
        public Job(char id, int d, int p) {
            this.id = id;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{2,100},{1,19},{2,27},{1,25},{3,15}};
        ArrayList<Job> jobs = new ArrayList<>();
        char id = 'a';
        for(int i=0; i<jobsInfo.length; i++) {
            jobs.add(new Job(id, jobsInfo[i][0], jobsInfo[i][1]));
            id++;
        }
        Collections.sort(jobs, (a,b) -> b.profit-a.profit);  // sorting in descending order on behalf of profit
        ArrayList<Character> ans = new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++) {
            Job curr = jobs.get(i);
            if(time < curr.deadline) {
                ans.add(curr.id);
                time++;
            }
        }
        System.out.println(ans);
    }
}
