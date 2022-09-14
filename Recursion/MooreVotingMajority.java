public class MooreVotingMajority {
    public static int majorityElement(int nums[]) {
        int majorIdx = 0;
        int count = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i]==nums[majorIdx]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                majorIdx = i;
                count = 1;
            }
        }
        // check if the element is actually majority element
        count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==nums[majorIdx]){
                count++;
            }
        }
        if(count>nums.length/2){
            return nums[majorIdx];
        }
        return -1;
    }
    public static void main(String[] args){
        int nums[] = {2,5,2,1,6,2};
        System.out.println(majorityElement(nums));
    }
}
