public class SlidingWindow {
    // used mainly for a sub array or sub string

    /**
     * Problem: Find the max Avg for k elements in an array
     * Approach: b moves ahead after every iteration but a moves ahead when we get the average of the three elements and keep track of current and max averages
     * @param arr
     * @param k
     * @return
     */
    public static int largestAverage(int[] arr, int k) {
        int a = 0;
        int b = k-1;
        int currentAvg = 0;
        int maxAvg = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(b >= arr.length){
                break;
            }
            for(int ok=0; ok < k; ok++){
                sum = sum + arr[i + ok];
            }
            currentAvg = sum/k;
            if (currentAvg > maxAvg) {
                maxAvg = currentAvg;
                }
            a++;
            b++;
            sum = 0;
        }
        return maxAvg;
    }

    /**
     * Problem: If string2 is a substring of string1 return true otherwise false
     * Approach: b is moved after every iteration but a is moved after we compare str2 with letters the same length as str2 in str1 and return true if it matches
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isSubstring(String str1, String str2){
        int k = str2.length();
        int a = 0;
        int b = k-1;
        String str="";
        for(int i=0; i<str1.length(); i++){
            if(b >= str1.length()){
                break;
            }
            for(int ok=0; ok < k; ok++){
                str = str + str1.charAt(i + ok);
            }
            if(str.equals(str2)){
                return true;
            }
            a++;
            b++;
            str = "";
        }
        return false;
    }

    /**
     * Problem: Find minimum length of a contiguous subarray where sum is greater than or equal to k
     * Approach: b moves after every iteration and a moves after we get the sum of k elements, maintain the current and max sum
     * @param arr
     * @param k
     * @return
     */
    public static int sumGreaterThank(int[] arr, int k){
        int a = 0;
        int b = 0;
        int sum = 0;
        int currentLength = 0;
        int minLength = arr.length;
        for(int i=0; i<arr.length; i++) {
            while (sum < k) {
                if(b >= arr.length){
                    return minLength;
                }
                currentLength++;
                sum = sum + arr[b];
                b++;
            }
            if (currentLength < minLength) {
                minLength = currentLength;
            }
            a++;
            b = a;
            currentLength = 0;
            sum = 0;
        }
        return minLength;
    }

    /**
     * Problem: Find the max profit we can get by buying and selling the stocks on different days and the transactions can be done multiple times
     * Approach: We check for the slope of the imagined graph. If we have an increasing slope we want to buy at the bottom pt and sell on the top and vice versa for decreasing slope
     *           So we access every element increasing b at every iteration and once we reach an end point only then do we move a
     * @param arr
     * @return
     */
    public static int maxProfitInStocks(int[] arr){
        int start = 0;
        int end = 0;
        int profit = 0;
        for(int i=0; i<arr.length-1; i++) {
            if(end >= arr.length){
                return profit;
            }
            if(arr[i+1] < arr[i]){ // decreasing slope
                start++;
                end++;
            }
            else{
                end++;
                profit = profit + arr[end] - arr[start];
                start++;
            }
        }
        return profit;
    }

    /**
     * Problem: Find the longest continous subarray with difference less than or equal to k
     * Approach: In each subarray we find the largest and smallest number and keep track of that difference as current difference and largest difference. Also need to keep track of current length and max length
     * @param arr
     * @param k
     * @return
     */
    public static int diffLessThank(int[] arr, int k){
        int a = 0;
        int b = 0;
        int largestNum = arr[0];
        int smallestNum = arr[0];
        int currentLength = 1;
        int maxLength = 0;
        int result[] = {};
        for(int i = 0; i<arr.length; i++){
            while(largestNum - smallestNum < k) {
                if(b >= arr.length-1){
                    return maxLength;
                }
                b++;
                currentLength += 1;
                if (arr[b] > largestNum) {
                    largestNum = arr[b];
                }
                if (arr[b] < smallestNum) {
                    smallestNum = arr[b];
                }
            }
            if(currentLength > maxLength){
                maxLength = currentLength;
            }
            currentLength = 1;
            a++;
            smallestNum = arr[a];
            largestNum = arr[a];
            b = a;
        }
        return maxLength;
    }

    /**
     * Problem: Check if the given strings are anagrams
     * Approach: We just use frequency array and compare each of their elements, used this function in the next question
     * @param s
     * @param p
     * @return
     */
    public static boolean isStringAnagram(String s, String p){
        int[] frequencyArrays = new int[26];
        for (int i = 0; i < s.length(); i++) { //Making the first freqArray
            char currentElement = s.charAt(i);
            frequencyArrays[currentElement - 'a'] += 1;
        }
        int[] frequencyArrayp = new int[26];
        for (int i = 0; i < p.length(); i++) { //Making the second freqArray
            char currentElement = p.charAt(i);
            frequencyArrayp[currentElement - 'a'] += 1;
        }
        for(int i=0; i<p.length(); i++){
            if(frequencyArrays[i] != frequencyArrayp[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * Problem: In two strings s and p, find all start indices of p's anagrams in s
     * Approach: We take a window of length of s and check if those chracters in p are anagrams and then move a to the next window
     * @param s
     * @param p
     * @return
     */
    public static int[] allAnagrams(String s, String p){
        int b = 0;
        String substring = "";
        int[] arr = new int[s.length()-1];
        int arrayCounter = 0;
        for(int a = 0; a < s.length(); a++){
            if(b >= s.length()-1){
                return arr;
            }
            b = a + p.length()-1;
            for(int counter = a;  counter <= b; counter++){
                substring = substring + s.charAt(counter);
            }
            boolean x = isStringAnagram(substring, p);
            if(x == true){
                arr[arrayCounter] = a;
                arrayCounter += 1;
            }
            substring = "";
        }
        return arr;
    }

    /**
     * Problem: Longest substring without repeating characters
     * Approach: If the value in frequency array crosses 1 then stop b and check the length between a and b, maintain current length and max length
     * @param str
     * @return
     */
    public static int longestSubstringWithoutRepeatingCharacters(String str){
        int a = 0;
        int b = 0;
        int currentLength = 1;
        int maxLength = 0;
        int[] freqArray = new int[26];
        for(int i=0; i<str.length(); i++){
            while(freqArray[str.charAt(b) - 'a'] == 0){
                if(b >= str.length()-1){
                    if(currentLength > maxLength){
                        maxLength = currentLength;
                    }
                    return maxLength;
                }
                freqArray[str.charAt(b) - 'a'] += 1;
                b++;
                currentLength += 1;
            }
            freqArray[str.charAt(b) - 'a'] += 1;
            if(currentLength-1 > maxLength){
                maxLength = currentLength-1;
            }
            for(int counter=0; counter<freqArray.length; counter++){
                if(freqArray[counter] > 1){
                    a = counter+1;
                    break;
                }
            }
            b = a;
            currentLength = 1;
            freqArray = new int[26];
        }
        return maxLength;
    }

    /**
     * Problem: Input is an array representing the different types of fruits, return total number of fruits we can store in two baskets which can only contain one type of fruit
     * Approach: Find out the largest and second-largest number in the frequency array and then add them. Since one element in the array represents only one type of fruits we don't count different kinds of fruits while taking the sum
     * @param arr
     * @return
     */
    public static int fruitsInBaskets(int[] arr){
        int[] freqArray = new int[arr.length];
        int[] resFreqArray = new int[arr.length];
        int counter = 0;
        for(int i=0; i<arr.length; i++){ //making frequency array
            freqArray[arr[i]] += 1;
        }
        for(int i=0; i<freqArray.length; i++){
            if(freqArray[i] != 0){
                resFreqArray[counter] = freqArray[i]; //seperating out the fruits present
                counter++;
            }
        }
        int largest = resFreqArray[0];
        int secondLargest = resFreqArray[0];
        for(int i=0; i<arr.length; i++) {
            if (resFreqArray[i] == 0) {
                break;
            }
            if(resFreqArray[i] > largest && resFreqArray[i] > secondLargest){
                secondLargest = largest;
                largest = resFreqArray[i];
            }
            else if(resFreqArray[i] > largest && resFreqArray[i] < secondLargest){
                secondLargest = resFreqArray[i];
            }
        }
        return largest+secondLargest;
    }

    public static int subarraysWithkDifferentIntegers(int[] arr, int k){
        int a = 0;
        int b = 0;
        int unique = 0;
        int counter = 0;
        int[] freqArray = new int[10];
        while (a != arr.length) {
            while(b != arr.length){
                if(freqArray[arr[b]] != 0){
                    break;
                }
                else{
                    freqArray[arr[b]] += 1;
                    unique += 1;
                    if(unique == k){
                        counter += 1;
                        break;
                    }
                    b++;
                }
            }
            a++;
            b = a;
            freqArray = new int[freqArray.length];
            unique = 0;
        }
        return counter;
    }
}
