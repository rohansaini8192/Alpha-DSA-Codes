public class MergeSort {
    public static void mergeSort(int arr[], int si, int ei) {
        if(si>=ei){        // Base Case
            return;
        }
        int mid = si + (ei-si)/2;    // (si+ei)/2
        mergeSort(arr, si, mid);     // left 
        mergeSort(arr, mid+1, ei);   // right 
        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si;     // iterator for left sorted part
        int j = mid+1;  // iterator for right sorted part     
        int k = 0;      // iterator for temp array
        
        // merge left and right
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // remaining left part
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // remaining right part
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        // copy temp array to original array
        for(k=0, i=si; k<temp.length; k++, i++ ) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {9,5,7,3,6,2};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}