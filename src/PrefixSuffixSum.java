public class PrefixSuffixSum {
    //Making the prefix sum array
    public static int[] prefixSum(int[] arr){
        int sum = 0;
        int[] prefixArray = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
            prefixArray[i] = sum;
        }
        return prefixArray;
    }

    //Making the suffix sum array
    public static int[] suffixSum(int[] arr){
        int sum = 0;
        int[] suffixArray = new int[arr.length];
        int current = (arr.length)-1;
        while(current != -1){
            sum = sum + arr[current];
            suffixArray[(arr.length)-current-1] = sum;
            current--;
        }
        return suffixArray;
    }

    /**
     * Problem: Find the point in the array at which the sum before it and the sum after it is equal. If no such element exists then return -1
     * Approach: We use two variables- leftSum and rightSum and keep updating their values until they become equal and then return else return -1 if the loop just breaks
     * @param arr
     * @return
     */
    public static int findingPivotIndex(int[] arr){
        int[] pre = prefixSum(arr);
        int[] suf = suffixSum(arr);
        int sum = pre[(arr.length)-1];
        int leftSum = 0;
        int rightSum = sum - leftSum;
        for(int i = 1; i < arr.length; i++){
            leftSum = leftSum + arr[i-1];
            rightSum = sum - leftSum - arr[i];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

    /**
     * Problem: Find the sum of all elements between the two mentioned indexes
     * Approach: Find sum in prefix array till index1 and then till index2, subtract both of them and then subtract the index2 element since it gets included twice
     * @param index1
     * @param index2
     * @param arr
     * @return
     */
    public static int sumBetweenAnyTwoIndices(int index1, int index2, int[] arr){
        int[] pre = prefixSum(arr);
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i <= index1; i++){
            sum1 = sum1 + pre[i];
        }
        for(int j = 0; j <= index2; j++){
            sum2 = sum2 + pre[j];
        }
        return(sum2-sum1-pre[index2]);
    }

    /**
     * Problem: Find the sum of all the elements of all the odd length sub arrays that can be formed
     * Approach: We take two pointers a and b, access the bth term of prefix array to find the sum and then increase b by 2
     *           After b has reached the end we increase a by one and b = a, and start counting odd subarrays again adding the prefix sum element to a sum variable each time and then return that
     * @param arr
     * @return
     */
    public static int sumOfOddLengthSubarrays(int[] arr) {
        int[] pre = prefixSum(arr);
        int a = 0;
        int b = 0;
        int sum = 0;
        while (a <= arr.length) {
            while (b < arr.length) {
                if(a>0) {
                    sum = sum + pre[b] - pre[a - 1];
                    b += 2;
                }
                else{
                    sum = sum + pre[b];
                    b += 2;
                }
            }
            a++;
            b = a;
        }
        return sum;
    }

    /**
     * Problem: Find the subarray whose sum is equal to the given number
     * Approach: The sum of a sub array is the difference between the corresponding prefix element and the one before it. If it matches print the elements of the subarray
     * @param arr
     * @param num
     */
    public static void subArrayWithGivenSum(int[]arr, int num){
        int[] pre = prefixSum(arr);
        int a = 0;
        int b = 0;
        int sum = 0;
        while(a < arr.length){
            while(b < arr.length){
                if(a>0) {
                    sum = pre[b] - pre[a - 1];
                    b++;
                }
                else{
                    sum = sum + pre[b];
                    b++;
                }
                if(sum > num){
                    break;
                }
                if(sum == num){
                    for(int i=a; i<b; i++){
                        System.out.println(arr[i]);
                    }
                    return;
                }
            }
            a++;
            b = a;
        }
    }

    public static int numberOfSubarraysWithSumk(int[] arr, int k){
        int[] pre = prefixSum(arr);
        int a = 0;
        int b = 0;
        int sum = 0;
        int count = 0;
        while(a < arr.length){
            while(b < arr.length){
                if(a>0) {
                    sum = pre[b] - pre[a - 1];
                    b++;
                }
                else{
                    sum = sum + pre[b];
                    b++;
                }
                if(sum > k){
                    break;
                }
                if(sum == k){
                    count += 1;
                    }
                }
            a++;
            b = a;
            }
            return count;
        }
    }


