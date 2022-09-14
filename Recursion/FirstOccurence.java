public class FirstOccurence {
    public static int firstOccur(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        if(key==arr[i]){
            return i;
        }
        return firstOccur(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {4,3,5,6,7,5,3};
        int key = 5;
        System.out.println(firstOccur(arr, key, 0));
    }
}
