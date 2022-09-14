public class LastOccurence {
    public static int lastOccur(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOccur(arr,key,i+1);
        if(isFound==-1 && arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String[] args) {
        int arr[] = {4,3,5,6,7,2,5,3};
        int key = 5;
        System.out.println(lastOccur(arr, key, 0));
    }
}
