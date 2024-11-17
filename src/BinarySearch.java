import java.lang.management.MonitorInfo;

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

    public static boolean elementToBeFound(int[] arr, int element){
        int start = 0;
        int end = arr.length-1;
        int middle = (start+end)/2;
        while(start<end){
            if (element == arr[start] || element == arr[end] || element == arr[middle]){
                return true;
            }
            if (element>start && element<middle){
                end = middle-1;
                middle = (start+end)/2;
            }
            else{
                start = middle+1;
                middle = (start+end)/2;
            }
        }
        return false;
    }

    public static int squareRoot(int num){
        int start = 0;
        int end = num/2;
        while(start <= end){
            int middle = (start+end)/2;
            if(num == middle*middle){
                return middle;
            }
            else if(num < middle*middle){
                end = middle-1;

            }
            else if(num > middle*middle){
                start = middle+1;
            }
        }
        return end;
    }

    public static int sortedRotatedArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int middle = (start+end)/2;
        while(start <= end){
            if(middle == start || middle == end){
                return middle;
            }
            if (arr[middle]>arr[middle-1] && arr[middle]>arr[middle+1]){
                return middle;
            }
            if(arr[start]<arr[middle]){
                //sorted-discard it
                start = middle;
                middle = (start+end)/2;
            }
            else {
                // unsorted-discard the other half
                end = middle;
                middle = (start+end)/2;
            }
        }
        return middle;
    }

    public static int missingNoInContinousArray(int[]arr){
        int start=0;
        int end=arr.length-1;
        int middle=(start+end)/2;
        while(start<end){
            if(arr[middle]-arr[middle-1]>1){
                return arr[middle]-1;
            }
            if(arr[middle+1]-arr[middle] > 1){
                return arr[middle]+1;
            }
            if(arr[end]-arr[middle]==middle+1){
                // second half is continous-discard
                end = middle;
                middle = (start+end)/2;
            }
            else{
                //first half is continous-discard
                start = middle;
                middle = (start+end)/2;
            }
        }
        return middle+1;
    }
    public static boolean sumInArray(int[]arr, int num){
        int start = 0;
        int end = arr.length-1;
        int sum = 0;
        while(start< end){
            sum = arr[start] + arr[end];
            if(sum == num){
                return true;
            }
            else if(sum > num){
                end = end-1;
            }
            else{
                start = start+1;
            }
        }
        return false;
    }

}
