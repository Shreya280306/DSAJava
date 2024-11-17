public class FrequencyArray {

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

    public static int[] frequencyArr(int num) {
        int[] arr = new int[10];
        while (num > 0) {
            int mod = num % 10;
            arr[mod] += 1;
            num = num / 10;
        }
        return arr;
    }

    public static int[] charFrequencyArray(String word) {
        int[] frequencyArray = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char currentElement = word.charAt(i);
            frequencyArray[currentElement - 'a'] += 1;
        }
        return frequencyArray;
    }
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

    public static char firstNonRepeatingChar(String str) {
        int[] x = charFrequencyArray(str);
        for (int i = 0; i < str.length(); i++) {
            if (x[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return '0';
    }

    public static boolean isStringPalindromePermutation(String str){
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

    public static void intersectionOfTwoArrays(String str1, String str2){
        int[] arr1 = charFrequencyArray(str1);
        int[] arr2 = charFrequencyArray(str2);
        for (int i=0; i<arr1.length; i++){
            char ch = (char)(97+i);
            if(arr1[i] != 0 && arr2[i] != 0){
                if(arr2[i] >= arr1[i]){
                    System.out.print(ch);
                }
            }
        }
    }

    public static void elementsMoreThanHalf(String str){
        int[] arr = charFrequencyArray(str);
        int half = str.length()/2;
        for(int i=0; i<arr.length; i++){
            if (arr[i] > half){
                System.out.println(arr[i]);
            }
        }
    }

    public static void intersectionOfArrays(String string, String substring){
        int[] arr1 = charFrequencyArray(string);
        int[] arr2 = charFrequencyArray(substring);
        for(int i=0; i<arr1.length; i++){
            char ch = (char)(i+97);
            if(arr1[i]>0 && arr2[i]>0) {
                if (arr2[i] <= arr1[i]) {
                    System.out.print(ch);
                }
            }
        }
    }

    public static void duplicateElements(String str){
        int[] arr = charFrequencyArray(str);
        for (int i=0; i<arr.length; i++){
            char ch = (char)(97+i);
            if(arr[i]>1){
                System.out.print(ch);
            }
        }
    }

    public static void mostFrequentElement(String str){
        int[] arr = charFrequencyArray(str);
        int frequent = largestElementInArray(arr);
        char ch = (char)(frequent+97+1);
        System.out.println(ch);
    }

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
}
