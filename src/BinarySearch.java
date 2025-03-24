    public class BinarySearch {
    //Array passed in this function is sorted
   //Time complexity is O(log n)

    /**
     * Problem: Find the index of the element in an array using binary search
     * Approach: We take 3 pointers start, end, middle. If the element is equal to any of these then it returns the insdex. If its in the first half then it reduces
     *           the size of the array considering only the first half and same if element is prs=esent in the second half. This loop repeats till the element is found
     * @param arr
     * @param element
     * @return
     */
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

    /**
     * Problem: Find the square root of a given number in the array
     * Approach: Previously the element was being checked for which region it belongs in, now (middle*middle) will be compared with num to find which region it belongs in
     * @param num
     * @return
     */
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

    /**
     * Problem: Find the missing number in continous array
     * Approach: If the difference between the middle and one before is greater than 1
     *           then the number missing is between them, same for middle and element after that.
     *           Otherwise if the difference between the last and middle is equal to middle+1,
     *           the array is continous in the second part and number is missing in the first.
     *           Same applies for the first half. In this case we keep cutting the array in half
     * @param arr
     * @return
     */
    public static int missingNoInContinousArray(int[]arr){
        //Here an array with continous series of numbers is passed with one element missing
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
            if(arr[end]-arr[middle] == middle+1){
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

    /**
     * Problem: Are there any two numbers in the array whose sum is equal to the number passed
     * Approach: Keep reducing the array in half with the condition that compares sum found and number given as input. Same as the two pointer approach
     * @param arr
     * @param num
     * @return
     */
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
