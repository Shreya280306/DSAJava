public class DivideAndConquer {
    //Divide the problem into smaller steps using recursion till the step where it can be solved easily
    // and then solve and merge the problem back(merge not join)

    public static int binarySearch(int[] arr, int start, int end, int key){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(key < arr[mid]){
                return binarySearch(arr, start, mid-1, key);
            }
            else{
                return binarySearch(arr, mid+1, end, key);
            }
    }

    private static void merge(int[]arr, int left, int mid, int right){
        //sizes
        int n1 = mid - left + 1;
        int n2 = right - mid;
        //Creating temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0; i<n1; i++){
            L[i] = arr[i+left];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[mid+j+1];
        }
        //Merging these arrays
        int i=0; int j=0; //Indices of the first and second subarrays
        int k = left; //Index of the merged sub array
        while(i < n1 && j < n2){
            if(L[i] > R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + (right-1))/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[]arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}
