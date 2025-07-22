public class DivideAndConquer {
    //Divide the problem into smaller steps using recursion till the step where it can be solved easily
    // and then solve and merge the problem back(merge not join)

    public static int binarySearch(int[] arr, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key < arr[mid]) {
            return binarySearch(arr, start, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, end, key);
        }
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + ((right - left) / 2);
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            mergeMine(arr, left, mid, right);
        }
    }

    private static void mergeMine(int[] arr, int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for(int i=0; i<n1; ++i){
            l[i] = arr[left + i];
        }
        for(int j=0; j<n2; ++j){
            r[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(l[i] < r[j]){
                arr[k] = l[i];
                i++;
            }
            else{
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = l[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[]arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        int temp = 0;
        for(int j=low; j <= high-1; j++){
            if(arr[j] < pivot){
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static double calculatingPower(int base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent < 0){
            return 1 / (calculatingPower(base, -exponent));
        }
        double temp = calculatingPower(base, exponent/2);
        if(exponent % 2 == 0){
            return (temp * temp);
        }
        else{
            return (base * temp * temp);
        }
    }

    private static int[][] add(int[][]arr, int[][]brr){
        int n = arr.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = arr[i][j] + brr[i][j];
            }
        }
        return res;
    }
    public static int[][] multiplyingMatrices(int[][] arr, int[][] brr){
        int n = arr.length;

        // to store the resultant matrix
        int[][] res = new int[n][n];

        if (n == 1) {
            res[0][0] = arr[0][0] * brr[0][0];
            return res;
        }

        // construct eight submatrices
        int[][][] subMat = new int[8][n / 2][n / 2];

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                subMat[0][i][j] = arr[i][j];
                subMat[1][i][j] = arr[i][j + n / 2];
                subMat[2][i][j] = arr[i + n / 2][j];
                subMat[3][i][j] = arr[i + n / 2][j + n / 2];
                subMat[4][i][j] = brr[i][j];
                subMat[5][i][j] = brr[i][j + n / 2];
                subMat[6][i][j] = brr[i + n / 2][j];
                subMat[7][i][j] = brr[i + n / 2][j + n / 2];
            }
        }

        // create four matrices to store the result
        int[][][] resMat = new int[4][n / 2][n / 2];

        // calculate the product and add them
        resMat[0] = add(multiplyingMatrices(subMat[0], subMat[4]), multiplyingMatrices(subMat[1], subMat[6]));
        resMat[1] = add(multiplyingMatrices(subMat[0], subMat[5]), multiplyingMatrices(subMat[1], subMat[7]));
        resMat[2] = add(multiplyingMatrices(subMat[2], subMat[4]), multiplyingMatrices(subMat[3], subMat[6]));
        resMat[3] = add(multiplyingMatrices(subMat[2], subMat[5]), multiplyingMatrices(subMat[3], subMat[7]));

        // copy the result to the resultant matrix
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                res[i][j] = resMat[0][i][j];
                res[i][j + n / 2] = resMat[1][i][j];
                res[i + n / 2][j] = resMat[2][i][j];
                res[i + n / 2][j + n / 2] = resMat[3][i][j];
            }
        }
        return res;
    }

}