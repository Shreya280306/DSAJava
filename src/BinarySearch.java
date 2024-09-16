public class BinarySearch {
    //Array passed in this function is sorted
    public boolean binarySearch(int[] arr, int element) {
        boolean found = false;
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while(start<end){
            if (element == arr[start] || element == arr[mid] || element == arr[end]){
                return true;
            }
            if (element > arr[start] && element < arr[mid]){
                end = mid-1;
                mid = (start + end) / 2;
            }
            else{
                start = mid+1;
                mid = (start + end) / 2;
            }
        }
        return found;
    }

}
