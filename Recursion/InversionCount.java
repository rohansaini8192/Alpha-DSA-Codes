public class InversionCount {
    // Modifird merge sort
    public static int mergeSort(int arr[], int si, int ei) {
        int invCount=0;
        if(si<ei){
            int mid = si + (ei-si)/2;
            invCount = mergeSort(arr, si, mid);
            invCount += mergeSort(arr, mid+1, ei);
            invCount += merge(arr, si, mid, ei);
        }
        return invCount;
    }
    public static int merge(int arr[], int si, int mid, int ei) {
        int i=si, j=mid+1, k=0;
        int invCount = 0;
        int temp[] = new int[ei-si+1];
        while(i<=mid && j<=ei) {
            if(arr[i]>arr[j]) {    
                temp[k] = arr[j];
                j++;
                invCount += mid-i+1;    // inversions = remaining elements in left subarray
            }
            else{
                temp[k] = arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];   
        }
        return invCount;
    }
    public static int getInvCount(int arr[]){
        return mergeSort(arr, 0, arr.length-1);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,1,3,5};
        System.out.println(getInvCount(arr));
    }
}
