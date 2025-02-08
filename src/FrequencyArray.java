public class FrequencyArray {
    /**
     * Problem: Make a frequency array for a list if numbers
     * Approach: We access every digit and increase the freq counter for that particular element in the array
     * @param num
     */
    public void frequencyArray(int num) {
        int[] frequencyArray = new int[10];
        while (num > 0) {
            int mod = num % 10;
            frequencyArray[mod] += 1;
            num = num / 10;
        }
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                System.out.println("The frequency of " + i + " is: " + frequencyArray[i]);
            }
        }
    }

    /**
     * Problem: Make a frequency array for alphabets
     * Approach: We access what value each letter depicts in the freq array and then increase its counter
     * @param word
     */
    public void stringFrequencyArray(String word) {
        int[] frequencyArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        // for printing the frequency array
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                int charNum = 97 + i;
                char ch = (char) charNum;
                System.out.println("The frequency of " + ch + " is: " + frequencyArray[i]);
            }
        }
    }
// Returns the freq array
    public static int[] frequencyArr(int num) {
        int[] arr = new int[10];
        while (num > 0) {
            int mod = num % 10;
            arr[mod] += 1;
            num = num / 10;
        }
        return arr;
    }

    // Returns the freq array
    public static int[] charFrequencyArray(String word) {
        int[] frequencyArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        return frequencyArray;
    }

    /**
     * Problem: Print all elements which appear in the array
     * Approach: All elements with value in frequency array greater than 0 are printed
     * @param word
     * @return
     */
    public static int[] charFreqArrGreaterThanZero(String word) {
        int[] x = charFrequencyArray(word);
        int[] elementsWithoutZero = new int[6];
        for (int i = 0; i < word.length(); i++) {
            if (x[i] > 0) {
                elementsWithoutZero[i] = x[i];
                }
            }
        return elementsWithoutZero;
    }

    /**
     * Problem: Check if 2 strings are anagrams- rearranging the letters of one word gives the other word
     * Approach: First off if they don't have the same length they cannot be anagrams. We compare their freq arrays
     * @param str1
     * @param str2
     * @return
     */
    public static boolean ifTwoStringsAreAnagrams(String str1, String str2) {
        int[] x1 = charFrequencyArray(str1);
        int[] x2 = charFrequencyArray(str2);
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < x1.length; i++) {
            if (x1[i] != x2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Problem: Retyrn the first non-repeating character of the string
     * Approach: While traversing the frequency array, break and return as soon as we get the value of any character as 1
     * @param str
     * @return
     */

    public static char firstNonRepeatingChar(String str) {
        int[] x = charFrequencyArray(str);
        for (int i = 0; i < str.length(); i++) {
            if (x[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }


    /**
     * Problem: Find if a string is a palindrome using frequency array
     * Approach: If the length of string is two then we need to have every element of the array divisible by two for it to be a palindrome
     *           But if length is odd, if the array has more than one od frequency element then it cannot be a palindrome.
     * @param str
     * @return
     */
    public static boolean isStringPalindrome(String str){
        int[] x = charFrequencyArray(str);
        if ((str.length() % 2) == 0){
            for (int i=0; i<x.length; i++){
                if (x[i] % 2 != 0){
                    return false;
                }
            }
            return true;
        }
        else{
            int oddCount = 0;
            for (int i=0; i<x.length; i++){
                if (x[i] % 2 == 1){
                    oddCount ++;
                    if (oddCount > 1){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static int[] makingFrequencyArrayFromArray(int[] arr){
        int[] freqArray =  new int[10];
        for(int i=0; i<arr.length; i++){
            freqArray[arr[i]] += 1;
        }
        return freqArray;
    }

    public static int[] findingIntersectionOf2Arrays(int[] shorterArr, int[] longerArr){
        int[] freqArray1 = makingFrequencyArrayFromArray(shorterArr);
        int[] freqArray2 = makingFrequencyArrayFromArray(longerArr);
        int[] intersectionArr = new int[freqArray1.length];
        int intersection = 0;
        for(int i=0; i<shorterArr.length; i++){
            if(freqArray1[i] > 0 && freqArray2[i] > 0){
                intersection += 1;
                intersectionArr[intersection] = shorterArr[i];
            }
        }
        return intersectionArr;
    }

    /**
     * Problem: Find the elements that appear more than n/2 times in the array
     * Appproach: access the freq array and if the value is greater than half, print the element
     * @param str
     */
    public static void elementsMoreThanHalf(String str){
        int[] arr = charFrequencyArray(str);
        int half = str.length()/2;
        for(int i=0; i<arr.length; i++){
            if (arr[i] > half){
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * Problem: Find duplicate elements in the string
     * Approach: Access the frequency array and the elements whose frequencies are greater than 1 are duplicates
     * @param str
     */
    public static void duplicateElements(String str){
        int[] arr = charFrequencyArray(str);
        for (int i=0; i<arr.length; i++){
            char ch = (char)(97+i);
            if(arr[i]>1){
                System.out.print(ch);
            }
        }
    }
//function used in next question
    public static int largestElementInArray(int[] arr){
        int largest = arr[0];
        int counter = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] > largest){
                largest = arr[i+1];
                counter = i;
            }
        }
        return counter;
    }
    /**
     * Problem: Find the element that occurs most frequently in the string
     * Approach: Print the largest number of the freq array
     * @param str
     */
    public static void mostFrequentElement(String str){
        int[] arr = charFrequencyArray(str);
        int frequent = largestElementInArray(arr);
        char ch = (char)(frequent+97+1);
        System.out.println(ch);
    }

    public static int subarrayWithkDistinctNumbers(int[] arr, int k){
        int a = 0;
        int b = 0;
        int unique = 0;
        int substring = 0;
        int[] freqArray = new int[10];
        while(a != arr.length){
            while(b != arr.length){
                if(freqArray[arr[b]] == 0){
                    freqArray[arr[b]] += 1;
                    unique += 1;
                }
                b++;
                if(unique == k){
                    substring += 1;
                }
                if(b > (arr.length)-1 || freqArray[arr[b]] == 1){
                    break;
                }
                if(unique >= k){
                    break;
                }

            }
            a++;
            b = a;
            freqArray = new int[freqArray.length];
            unique = 0;
        }
        return substring;
    }

    public static String sortCharactersByFrequency(String word){
        int[] freqArr = charFrequencyArray(word);
        String resString = "";
        //sorting frequency array by the bubble sort method
        int temp = 0;
        for(int i=0; i<(freqArr.length)-1; i++){
            for(int j=0; j<(freqArr.length)-i-1; j++){
                if(freqArr[j] < freqArr[j+1]){
                    temp = freqArr[j];
                    freqArr[j] = freqArr[j+1];
                    freqArr[j+1] = temp;
                }
            }
        }
        for(int i=0; i< freqArr.length; i++){
            resString = resString + word.charAt(freqArr[i]);
        }
        return resString;
    }

    public static int returnIndexOfLargestElementInArray(int[]arr){
        int largest = arr[0];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static char[] sortingCharactersByFrequency(String word) {
        int[] freqArr = charFrequencyArray(word);
        char[] resArray = new char[word.length()];
        for (int i = 0; i < freqArr.length; i++) {
            int indexOfLargest = returnIndexOfLargestElementInArray(freqArr);
            char ch = (char) (97 + indexOfLargest);
            resArray[i] = ch;
            if (freqArr[indexOfLargest] == 0) {
                return resArray;
            }
            freqArr[indexOfLargest] = 0;
        }
        return resArray;
    }
}
