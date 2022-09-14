public class Majority {
    public static int majorityElement(int nums[], int si, int ei) {
        if(si==ei){        // Base Case: if there is single element it is majority element.
            return nums[si];
        }
        int mid = si + (ei-si)/2;
        int left = majorityElement(nums, si, mid);      // left majority element
        int right = majorityElement(nums, mid+1, ei);   // right majority element
        // if both majority elements are same then return it.
        if(left==right){
            return left;
        }
        // otherwise, count them and return the winner.
        int leftCount = countInRange(nums, left, si, ei);
        int rightCount = countInRange(nums, right, si, ei);

        return leftCount > rightCount ? left : right;
    }
    public static int countInRange(int nums[], int num, int si, int ei) {
        int count = 0;
        for(int i=si; i<ei; i++){
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args){
        int nums[] = {2,2,4,5,2,6};
        System.out.println(majorityElement(nums,0,nums.length-1));
    }
}
